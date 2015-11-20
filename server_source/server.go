package main

import (
	"net"
	"bufio"
	"log"
)

const (
	CONN_PORT = "8080"
	CONN_TYPE = "tcp"
	CONN_HOST = "0.0.0.0"
)

func main() {
	ClientCnt := 0
	newConnections := make(chan net.Conn)
	//for new user
	deadConnections := make(chan net.Conn)
	//kill connection
	allClients := make(map[net.Conn]int)
	//net.Conn save map client session
	messages := make(chan string)

	listen, err := net.Listen(CONN_TYPE, CONN_HOST+":"+CONN_PORT)
	checkErr(err, "error in listen")
	log.Print(CONN_HOST + " : " + CONN_PORT + " is now listening")
	
	go func() {
		for {
			connection, err := listen.Accept()
			checkErr(err, "error in accept")
			newConnections <- connection
		}
	}()
	
	for {
		select {
			case conn := <-newConnections:
				log.Print("Hello! " + conn.RemoteAddr().String())
				allClients[conn] = ClientCnt
				ClientCnt ++
			
				go func(conn net.Conn, clientId int) {
					reader := bufio.NewReader(conn)
					for {
						incoming, err := reader.ReadString('\n')
						if err != nil {
							log.Print(conn.RemoteAddr().String() + "is disconnected by error")
							deadConnections <- conn
							return ;
						}
						messages <- incoming
					}
				}(conn, allClients[conn])
			
			//new msg recv
			case message := <-messages:
				for conn, _ := range allClients {
					go func(conn net.Conn, message string) {
						_, err := conn.Write([]byte(message))
						if err != nil {
							log.Print(conn.RemoteAddr().String() + "is disconnected by error")
							deadConnections <- conn
						}
					}(conn, message)
				}
				log.Printf("New msg : %s", message)
				
			case conn := <- deadConnections:
				log.Print("Client %d disconnected", allClients[conn])
				delete(allClients, conn)
		}
	}
}

func checkErr(err error, msg string) {
	if err != nil {
		log.Fatalln(msg, err)
	}
}