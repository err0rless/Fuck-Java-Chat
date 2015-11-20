/**
 * Created by err0rless on 2015-10-14.
 * github.com/err0rless/Fuck-Java-Chat
 *
 * Gui maker
 *  .get-nickname window
 *  .chatting window
 *  .exit confirm window
 */

import javax.swing.*;
import java.awt.*;

//gui관리 클래스
public class GUI extends JFrame
{
    public static final String DEFAULT_FONT = "Consolas";
    // Get nickname GUI
    private JFrame nickFrame = new JFrame("Input Your Nickname");
    private JPanel nickPanel = new JPanel();
    public  String nickn     = "";

    // Chatting GUI
    private JFrame mainFrame = new JFrame("Fuck-Java-Chat");
    private JPanel chatPanel = new JPanel();
    private JPanel textPanel = new JPanel();

    private MainGUI gui;

    // Constructors
    GUI() {
        init();
    }
    GUI(String nick) { CHATTING_GUI_init(nick); }

    public void init() { GET_NICKNAME_init(); }

    private void GET_NICKNAME_init()
    {
        new GetNameGUI().invoke();
    }

    // chatting gui
    private void CHATTING_GUI_init(String nickname)
    {
        gui = new MainGUI(nickname);
        gui.invoke();
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

    public void Connect() {
        gui.Connect();
    }

    //처음 닉네임 가져오는 gui
    private class GetNameGUI {
        public void invoke() {
            JTextField nickTxt = new JTextField();
            JButton nickBtn = new JButton("send");
            JLabel nickLabel = new JLabel("Nickname");

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;

            nickTxt.setFont(new Font(DEFAULT_FONT, Font.ITALIC, 18));
            nickLabel.setFont(new Font(DEFAULT_FONT, Font.BOLD, 14));

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

            nickTxt.addActionListener(new GetNickname_Action(nickTxt, nickFrame, nickn));
            nickBtn.addActionListener(new GetNickname_Action(nickTxt, nickFrame, nickn));

            nickFrame.setSize(600, 160);
            nickFrame.setResizable(false); // no maximize button
            nickFrame.setVisible(true);    // Visible
            nickFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }

    //채팅창 gui
    private class MainGUI {
        private String nickname;
        private Socket sock;

        public void Connect() {sock.connect();}

        public MainGUI(String nickname) {
            this.nickname = nickname;
            sock = new Socket();
        }

        public void invoke() {
            JButton sendBtn = new JButton("send");

            JTextField txt = new JTextField();
            Container ctn = mainFrame.getContentPane();

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;

            // set size
            mainFrame.setSize(600, 500);
            chatPanel.setPreferredSize(new Dimension(550, 370));
            textPanel.setPreferredSize(new Dimension(550, 30));
            txt.setPreferredSize(new Dimension(500, 40));
            sendBtn.setPreferredSize(new Dimension(70, 40));

            //sock init
            sock.init(mainFrame, chatPanel, txt, ctn, nickname);

            txt.addActionListener(new send_Btn_Action(mainFrame, txt, nickname, sock));
            sendBtn.addActionListener(new send_Btn_Action(mainFrame, txt, nickname, sock));

            // set background color
            chatPanel.setBackground(new Color(0xff, 0xff, 0xff));
            textPanel.setBackground(new Color(0xff-30, 0xff-30, 0xff-30));

            // set font
            txt.setFont(new Font(DEFAULT_FONT, Font.BOLD, 14));

            // set layout
            ctn.setLayout(new GridBagLayout());
            chatPanel.setLayout(new FlowLayout());

            addGridBagLayout(ctn, c, chatPanel, 1, 0, 1, 1, 1, 1);
            addGridBagLayout(ctn, c, textPanel, 1, 1, 1, 1, 1, 1);
            addGridBagLayout(textPanel, c, txt,     0, 0, 1, 1, 1, 1);
            addGridBagLayout(textPanel, c, sendBtn, 0, 0, 1, 1, 1, 1);

            // settings
            mainFrame.setResizable(false); // no maximize button
            mainFrame.setVisible(true);    // Visible
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}