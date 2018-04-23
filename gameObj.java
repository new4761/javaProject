

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class gameObj extends JFrame   {

    public gameObj() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(405, 800);

        setTitle("JavaRacing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(() -> {
            gameObj ex = new gameObj();
            ex.setVisible(true);
        });
    }
}