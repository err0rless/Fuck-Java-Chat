/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * process actions
 *  .button clicks
 *  .press enter key
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class process_Action implements ActionListener
{
    private JFrame frame = new JFrame();
    private JPanel Panel = new JPanel();
    private JTextField textField = new JTextField();

    // Constructor
    process_Action(JFrame actionFrame, JPanel cPanel, JTextField txt)
    {
        frame = actionFrame;
        Panel = cPanel;
        textField = txt;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String text = textField.getText();
        JLabel lab  = new JLabel();

        CHAT_PARSE chatParse = new CHAT_PARSE();
        text = chatParse.Parse_string(text);

        JOptionPane.showMessageDialog(frame, text);
        textField.setText("");
        lab.setText(text);
        lab.setLocation(500, 400);
        lab.setBounds(0, 60, 200, 50);
        Panel.add(lab);
    }
}
