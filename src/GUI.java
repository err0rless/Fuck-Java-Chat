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

        // set sizes
        mainFrame.setSize(800, 550);
        txt.setSize(400, 50);

        // set colors
        sidePanel.setBackground(Color.red);
        chatPanel.setBackground(Color.black);
        textPanel.setBackground(Color.blue);

        // set layout types
        ctn.setLayout(new GridBagLayout());
        textPanel.setLayout(new GridBagLayout());

        // set sizes -> setPreferredSize
        //sidePanel.setPreferredSize(new Dimension(180, 0));
        //textPanel.setPreferredSize(new Dimension(180, 40));
        //txt.setPreferredSize(new Dimension(500, 19));


        // add
        //              (                   x, y, w, h,  wx,  wy)
        c.fill = GridBagConstraints.NONE;
        addGridBagLayout(ctn, c, sidePanel, 0, 0, 3, 0, 1, 1);
        c.fill = GridBagConstraints.NONE;
        addGridBagLayout(ctn, c, chatPanel, 0, 0, 1, 1, 1, 1);
        c.fill = GridBagConstraints.NONE;
        addGridBagLayout(ctn, c, textPanel, 0, 0, 1, 1,  1, 1);

        /*
        addGridBagLayout(textPanel, c, txt,     0, 0, 1, 1, 0.2, 0.2);
        addGridBagLayout(textPanel, c, sendBtn, 1, 0, 1, 1, 0.1, 0.1);
        */
        txt.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt));
        sendBtn.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt));

        // settings
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}