/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * process actions
 *  .button clicks
 *  .press enter key
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class send_Btn_Action implements ActionListener
{
    private JFrame frame = new JFrame();
    private JPanel Panel = new JPanel();
    private JTextField textField = new JTextField();

    // Constructor
    send_Btn_Action(JFrame actionFrame, JPanel cPanel, JTextField txt)
    {
        frame = actionFrame;
        Panel = cPanel;
        textField = txt;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();

        if (text.equals("")) return ;

        CHAT_PARSE chatParse = new CHAT_PARSE();
        text = chatParse.Parse_string(text);


        JOptionPane.showMessageDialog(frame, text);
        textField.setText("");
    }
}