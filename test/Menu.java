

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Menu extends JPanel
        implements ActionListener {

        protected JButton Bstart, Bscore, Bexit,tett1,test2;
    public Menu() {

        JPanel pane = new JPanel(new GridBagLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        Bstart = new JButton("GAME - START");
        Bstart.setVerticalTextPosition(AbstractButton.CENTER);

        Bstart.setMnemonic(KeyEvent.VK_D);
        Bstart.setActionCommand("start");


        Bscore = new JButton("High-Score");
        Bscore.setVerticalTextPosition(AbstractButton.CENTER);

        Bscore.setMnemonic(KeyEvent.VK_D);
        Bscore.setActionCommand("score");


        Bexit = new JButton("Exit");
        Bexit.setVerticalTextPosition(AbstractButton.CENTER);

        Bexit.setMnemonic(KeyEvent.VK_D);
        Bexit.setActionCommand("exit");


        tett1 = new JButton("test pac");
        tett1.setVerticalTextPosition(AbstractButton.CENTER);

        tett1.setMnemonic(KeyEvent.VK_D);
        tett1.setActionCommand("pac");

        test2 = new JButton("test net");
        test2.setVerticalTextPosition(AbstractButton.CENTER);

        test2.setMnemonic(KeyEvent.VK_D);
        test2.setActionCommand("net");

        add(Bstart,gbc);
        add(Bscore,gbc);
        add(Bexit,gbc);
        add(tett1,gbc);
        add(test2,gbc);


        tett1.addActionListener(this);
        test2.addActionListener(this);
        Bstart.addActionListener(this);
        Bscore.addActionListener(this);
        Bexit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if ("start".equals(e.getActionCommand())) {
            setVisible(false);

            Board Board= new Board();
            new Board().setVisible(true);
            System.out.println("start");

        }
        else if("score".equals(e.getActionCommand()))
        {

        }
   /*       else if("net".equals(e.getActionCommand()))
        {
            enemy second = new enemy();
            setVisible(false); // Hide current frame
            second.setVisible(true);
            System.out.println("net");
        }
        else if("pac".equals(e.getActionCommand()))
        {
          Carplayer second = new Carplayer();
            setVisible(false); // Hide current frame
            second.setVisible(true);
            System.out.println("pac");
        }
        else { System.exit(0);        }*/
    }
    @Override
    public void paintComponent(Graphics g) {

        draw(g);
    }

    private void draw(Graphics g) {
        Font font = g.getFont().deriveFont( 55.0f );
        g.setFont( font );
        g.drawString("Java Racing",35,220);

    }

}
