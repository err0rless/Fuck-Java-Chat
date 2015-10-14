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
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame
{
    private String chat;
    private JFrame mainFrame = new JFrame("Fuck-Java-Chat");
    private JPanel sidePanel = new JPanel();
    private JPanel chatPanel = new JPanel();
    private JPanel textPanel = new JPanel();

    // Constructor
    GUI()
    {
        GUI_init();
    }

    // init interfaces
    private void GUI_init()
    {
        JButton sendBtn = new JButton("send");

        JTextField txt = new JTextField();
        Container ctn = mainFrame.getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        // set sizes
        mainFrame.setSize(800, 550);
        txt.setSize(400, 50);

        // set colors
        chatPanel.setBackground(Color.WHITE);
        textPanel.setBackground(Color.LIGHT_GRAY);

        // set layout types
        chatPanel.setLayout(new BorderLayout());
        textPanel.setLayout(new GridBagLayout());

        // set sizes -> setPreferredSize
        sidePanel.setPreferredSize(new Dimension(180, 0));
        textPanel.setPreferredSize(new Dimension(180, 40));
        txt.setPreferredSize(new Dimension(500, 19));

        // adds
        ctn.add(sidePanel, BorderLayout.WEST);
        ctn.add(chatPanel, BorderLayout.CENTER);
        chatPanel.add(textPanel, BorderLayout.SOUTH);

        addGridBagLayout(textPanel, c, txt,     0, 0, 1, 1, 0.2, 0.2);
        addGridBagLayout(textPanel, c, sendBtn, 1, 0, 1, 1, 0.1, 0.1);

        sendBtn.addActionListener(new process_Action(mainFrame, chatPanel, txt));

        // settings
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addGridBagLayout(JPanel p, GridBagConstraints c,
                                  Component o, int x, int y, int w, int h,
                                  double wx, double wy)
    {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = wx;
        c.weighty = wy;
        p.add(o, c);
    }
}