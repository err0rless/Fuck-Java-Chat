/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Gui maker class
 *  .get-nickname window
 *  .chatting window
 *  .exit confirm window
 */

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    // Get nickname GUI
    private JFrame nickFrame = new JFrame("Input Your Nickname");
    private JPanel nickPanel = new JPanel();

    // Chatting GUI
    private JFrame mainFrame = new JFrame("Fuck-Java-Chat");
    private JPanel chatPanel = new JPanel();
    private JPanel sidePanel = new JPanel();
    private JPanel textPanel = new JPanel();

    // Constructors
    GUI() { init(); }
    GUI(String nick) { CHATTING_GUI_init(nick); }

    public void init() { GET_NICKNAME_init();  }

    // get nickname gui
    private void GET_NICKNAME_init()
    {
        JTextField nickTxt = new JTextField();
        JButton nickBtn = new JButton("send");
        JLabel nickLabel = new JLabel("Nickname");

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        nickTxt.setFont(new Font("Consolas", Font.ITALIC, 18));
        nickLabel.setFont(new Font("Consolas", Font.BOLD, 14));

        nickPanel.setLayout(new GridBagLayout());

        nickTxt.setPreferredSize(new Dimension(200, 40));
        nickBtn.setPreferredSize(new Dimension(80, 40));
        nickLabel.setPreferredSize(new Dimension(200, 120));

        nickLabel.setHorizontalAlignment(0);

        nickPanel.setBackground(Color.white);

        addGridBagLayout(nickPanel, c, nickLabel, 0, 0, 1, 1, 1, 1);
        addGridBagLayout(nickPanel, c, nickTxt, 1, 0, 1, 1, 1, 1);
        addGridBagLayout(nickPanel, c, nickBtn, 0, 1, 2, 1, 1, 1);
        nickFrame.add(nickPanel);

        nickTxt.addActionListener(new GetNickname_Action(nickTxt, nickFrame));
        nickBtn.addActionListener(new GetNickname_Action(nickTxt, nickFrame));

        nickFrame.setSize(600, 160);
        nickFrame.setResizable(false); // no maximize button
        nickFrame.setVisible(true);    // Visible
        nickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // chatting gui
    private void CHATTING_GUI_init(String nickname)
    {
        JLabel nickLab = new JLabel();
        JPanel nickPan = new JPanel();

        JButton sendBtn = new JButton("send");

        JTextField txt = new JTextField();
        Container ctn = mainFrame.getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        // set size
        mainFrame.setSize(800, 550);
        nickLab.setPreferredSize(new Dimension(20, 150));
        chatPanel.setPreferredSize(new Dimension(440, 470));
        textPanel.setPreferredSize(new Dimension(440, 50));
        txt.setPreferredSize(new Dimension(520, 40));
        sendBtn.setPreferredSize(new Dimension(70, 40));

        txt.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt, ctn));
        sendBtn.addActionListener(new send_Btn_Action(mainFrame, chatPanel, txt, ctn));

        // set background color
        sidePanel.setBackground(new Color(0xff-40, 0xff-40, 0xff-40));
        chatPanel.setBackground(new Color(0xff, 0xff, 0xff));
        textPanel.setBackground(new Color(0xff-30, 0xff-30, 0xff-30));

        // set font
        txt.setFont(new Font("Consolas", Font.BOLD, 14));

        // set layout
        ctn.setLayout(new GridBagLayout());
        chatPanel.setLayout(new FlowLayout());
        sidePanel.setLayout(new FlowLayout());

        // add
        nickLab.setText(nickname);
        nickLab.setFont(new Font("Consolas", Font.ITALIC, 12));
        nickLab.setBackground(new Color(0xff, 0x42, 0x32));
        sidePanel.add(nickLab);

        addGridBagLayout(ctn, c, sidePanel, 0, 0, 1, 2, 1, 1);
        addGridBagLayout(ctn, c, chatPanel, 1, 0, 1, 1, 1, 1);
        addGridBagLayout(ctn, c, textPanel, 1, 1, 1, 1, 1, 1);
        addGridBagLayout(textPanel, c, txt,     0, 0, 1, 1, 1, 1);
        addGridBagLayout(textPanel, c, sendBtn, 0, 0, 1, 1, 1, 1);


        // settings
        mainFrame.setResizable(false); // no maximize button
        mainFrame.setVisible(true);    // Visible
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
}