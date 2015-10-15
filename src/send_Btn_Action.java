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
    private JFrame frame;
    private JPanel Panel;
    private JTextField textField;
    private Container ctn;

    // Constructor
    send_Btn_Action(JFrame actionFrame, JPanel cPanel,
                    JTextField txt, Container c)
    {
        frame = actionFrame;
        Panel = cPanel;
        textField = txt;
        ctn = c;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();

        if (text.equals("")) return ;

        CHAT_PARSE chatParse = new CHAT_PARSE();
        text = chatParse.Parse_string(text);

        textField.setText("");
    }
}