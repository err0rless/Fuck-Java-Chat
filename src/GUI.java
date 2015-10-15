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

public class GUI extends JFrame
{
    private String chat;
    private JFrame mainFrame = new JFrame("Fuck-Java-Chat");
    private JPanel sidePanel = new JPanel();
    private JPanel chatPanel = new JPanel();
    private JPanel textPanel = new JPanel();

    // Constructor
    GUI() { GUI_init(); }

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

    private void addGridBagLayout(Container p, GridBagConstraints c,
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

    // init GUI
    private void GUI_init()
    {
        JButton sendBtn = new JButton("send");

        JTextField txt = new JTextField();
        Container ctn = mainFrame.getContentPane();

        GridBagConstraints c = new GridBagConstraints();

        mainFrame.setSize(800, 550);
        mainFrame.setResizable(false); // no maximize button

        // set background color
        sidePanel.setBackground(new Color(0xff-40, 0xff-40, 0xff-40));
        chatPanel.setBackground(new Color(0xff, 0xff, 0xff));
        textPanel.setBackground(new Color(0xff-30, 0xff-30, 0xff-30));

        // set preferred size
        chatPanel.setPreferredSize(new Dimension(440, 470));
        textPanel.setPreferredSize(new Dimension(440, 50));
        txt.setPreferredSize(new Dimension(520, 40));
        sendBtn.setPreferredSize(new Dimension(70, 40));

        // set font
        txt.setFont(new Font("Consolas", Font.BOLD, 13));

        // set layout
        ctn.setLayout(new GridBagLayout());
        chatPanel.setLayout(new GridLayout());

        // add
        c.fill = GridBagConstraints.BOTH;
        addGridBagLayout(ctn, c, sidePanel, 0, 0, 1, 2, 1, 1);
        addGridBagLayout(ctn, c, chatPanel, 1, 0, 1, 1, 1, 1);
        addGridBagLayout(ctn, c, textPanel, 1, 1, 1, 1, 1, 1);

        c.fill = GridBagConstraints.WEST;
        addGridBagLayout(textPanel, c, txt,     0, 0, 2, 2, 2, 2);
        c.fill = GridBagConstraints.WEST;
        addGridBagLayout(textPanel, c, sendBtn, 0, 0, 1, 1, 2, 2);

        txt.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt, ctn));
        sendBtn.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt, ctn));

       // chatPanel.add(new JButton("hi"), ctn);

        // settings
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}