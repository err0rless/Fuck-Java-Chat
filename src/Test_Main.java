/**
 * Created by err0rless on 2015-10-13.
 *
 * Main class for testing
 */
import javax.swing.*;
import java.awt.*;

public class Test_Main
{
    void addGridBagLayout1(Container ctn, GridBagConstraints c,
                                  Component o, int x, int y, int w, int h,
                                  double wx, double wy)
    {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = wx;
        c.weighty = wy;
        ctn.add(o, c);
    }

    public static void main(String args[])
    {
        //new GUI();
        JFrame f = new JFrame();
        f.setSize(800, 550);

        JButton b1 = new JButton ();
        JButton b2 = new JButton ();
        JButton b3 = new JButton ();

        Container ctn = f.getContentPane();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        ctn.setLayout(new GridBagLayout());

        addGridBagLayout1

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}