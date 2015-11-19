/**
 * Created by err0rless on 2015-10-17.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Action Processor - GetNickname_Action.java
 *  pass the nickname to CHATTING_GUI_init
 *  close - GET_NICKNAME_init window.
 *  open - CHATTING_GUI_init window.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetNickname_Action implements ActionListener
{
    JTextField txt;
    JFrame frame;

    GetNickname_Action(JTextField nickTxt, JFrame nickFrame, String n)
    {
        txt = nickTxt;
        frame = nickFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (txt.getText().equals("") || txt.getText().indexOf(" ") != -1 || txt.getText().length() > 10)
        {
            txt.setText("no gad and 0 < length < 10");
            return ;
        }

        new GUI(txt.getText());
        frame.setVisible(false);
        frame.dispose();
    }
}