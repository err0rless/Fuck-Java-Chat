/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Gui maker class
 *  .get nickname window
 *  .chatting window
 *  .exit windows(if we can)
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI extends JFrame
{
    private String chat;

    GUI(String str)
    {
        chat = str;
        GUI_init();
    }

    private void GUI_init()
    {
        JFrame mainFrame = new JFrame("Fuck-Java-Chat");
        JPanel sizePanel = new JPanel();
        JPanel chatPanel = new JPanel();
        JPanel textPanel = new JPanel();

        JTextArea txt = new JTextArea();

        txt.setSize(400, 50);

        mainFrame.setSize(800, 550);

        chatPanel.setBackground(Color.white);
        textPanel.setBackground(Color.lightGray);

        chatPanel.setLayout(new BorderLayout());


        Container ctn = mainFrame.getContentPane();

        sizePanel.setPreferredSize(new Dimension(180, 0));
        textPanel.setPreferredSize(new Dimension(180, 50));
        textPanel.setLayout(new BorderLayout());

        txt.setPreferredSize(new Dimension(540, 20));

        ctn.add(sizePanel, BorderLayout.WEST);
        ctn.add(chatPanel, BorderLayout.CENTER);
        chatPanel.add(textPanel, BorderLayout.SOUTH);
        textPanel.add(txt, BorderLayout.WEST);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}