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
    private JPanel Panel;
    private JTextField textField;
    private Container ctn;
    private String nick;

    // Constructor
    send_Btn_Action(JFrame actionFrame, JPanel cPanel,
                    JTextField txt, Container c, String Nickname)
    {
        frame = actionFrame;
        Panel = cPanel;
        textField = txt;
        ctn = c;
        nick = Nickname;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JPanel linePanel = new JPanel();
        JLabel chatLab   = new JLabel();
        String text = textField.getText();

        if (text.equals("")) return ;

        CHAT_PARSE chatParse = new CHAT_PARSE();
        text = chatParse.Parse_string(text);

        chatLab.setText("<html>&nbsp&nbsp[<i>" + nick + "</i>] : " + text + "</html>");
        chatLab.setHorizontalAlignment(SwingConstants.LEFT);
        chatLab.setFont(new Font("Consolas", Font.PLAIN, 14));
        //linePanel.add(chatLab);

        chatLab.setPreferredSize(new Dimension(600, 30));
        chatLab.setBackground(Color.gray);

        Panel.add(chatLab);

        //JScrollPane scrollSingle = new JScrollPane(Panel);
        //scrollSingle.setPreferredSize(new Dimension(600, 500));

        textField.setText("");
        frame.setVisible(true);
    }
}