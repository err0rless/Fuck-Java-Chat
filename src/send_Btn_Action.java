/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Action Processor - send_Btn_Action.java
 *  process Send Button in CHATTING_GUI_init
 *  get text and create chatting-box
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class send_Btn_Action implements ActionListener
{
    private JFrame frame;
    private JTextField textField;
    private String nick;
    private Socket sock;

    // Constructor
    send_Btn_Action(JFrame actionFrame, JTextField txt, String Nickname, Socket sock)
    {
        frame = actionFrame;
        textField = txt;
        nick = Nickname;
        this.sock = sock;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();
        sock.sendMessage(text);
        textField.setText("");
        frame.setVisible(true);
    }
    //텍스트필드에서 글자를 가져와서 소켓을 통해 보냄
}