/**
 * Created by jen6 on 2015-11-19.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Socket
 * -send msg
 * -recv msg
 */
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Socket {
    public static final int SERVER_PORT = 8080;
    public static final java.lang.String SERVER_ADDR = "127.0.0.1";
    public static final String FONT = "Consolas";

    private static final int NICKIDX = 0;
    private static final int MSGIDX = 1;

    private java.net.Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String UserNick;
    private String msg;

    //for add chat panel
    private JFrame frame;
    private JPanel Panel;
    private JTextField textField;
    private Container ctn;

//닉네임 표시를 위한 html
    private String nickHtml(String text, String nick) {
        return "<html>&nbsp&nbsp[<i>" + nick + "</i>] : " + text + "</html>";
    }

    public Socket()
    {

    }

    public void init(JFrame actionFrame, JPanel cPanel, JTextField txt, Container c, String usernick) {
        this.frame = actionFrame;
        this.Panel = cPanel;
        this.textField = txt;
        this.ctn = c;
        this.UserNick = usernick;
    }

    public void connect() {
        try {
            socket = new java.net.Socket(SERVER_ADDR, SERVER_PORT);
            //소켓 열기
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            //소켓으로부터 input, output stream 열기(입력 출력)
            if (socket.isConnected())
            {
                System.out.print("fuck connect");
            }
            else {
               throw new IOException("fuck not connect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //소켓에서 값 읽어오는 쓰레드 생성
        Thread t = new Reader(in);
        //시작
        t.start();
    }

    //메세지 보내는 함수
    public void sendMessage(String msg2) {
        try {
            out.writeUTF(UserNick + " " + msg2+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Reader extends Thread{
        private DataInputStream in;
        public Reader(DataInputStream in)
        {
            this.in = in;
        }

        //스레드를 상속받은후 오버라이딩 해줘야하는 함수
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while(in!=null) {
                try {
                    //input stream 에서 메세지를 읽어옴
                    msg = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String[] parsed = parseNick(msg);
                makePanne(parsed[NICKIDX], parsed[MSGIDX]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private String[] parseNick(String packet)
        {
            int nickIdx = packet.indexOf(' ');
            String Nick = packet.substring(0, nickIdx);
            String msg = packet.substring(nickIdx);
            String[] arr;
            arr = new String[]{ Nick, msg };
            return arr;
        }
        //메세지를 추가시켜줌
        private void makePanne(String nick, String msg) {
            JLabel chatLab   = new JLabel();
            String message = msg;

            if (message.equals("")) return ;

            CHAT_PARSE chatParse = new CHAT_PARSE();
            message = chatParse.Parse_string(message);

            chatLab.setText(nickHtml(message, nick));
            chatLab.setHorizontalAlignment(SwingConstants.LEFT);
            chatLab.setFont(new Font(FONT, Font.PLAIN, 14));

            chatLab.setPreferredSize(new Dimension(600, 30));
            chatLab.setBackground(Color.gray);

            Panel.add(chatLab);

            textField.setText("");
            frame.setVisible(true);
        }
    }
}