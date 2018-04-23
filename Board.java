

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private playerCar player;
    private Timer timer;
    private List<Rock> rock;
    private final int DELAY = 25;
    private Image roadLeft, roadRight, roadCenter, road;
    private final int DELAY_game = 13;
    private int stepDrawmap, difGame, gamespeed = 25;
    private int score = 0;
    public static boolean ingame = false, gameover = false;
    private int stepSpawnrock;

    private int mapDesign[][] = {
            {0, 1, 1, 1, 3},
            {0, 1, 2, 1, 3},
            {0, 1, 1, 1, 3},
            {0, 1, 2, 1, 3},
            {0, 1, 1, 1, 3},
            {0, 1, 2, 1, 3},
            {0, 1, 1, 1, 3},
            {0, 1, 2, 1, 3},
    };


    private final int[] pos = {
            210, 20, 110, 300
    };


    public Board() {
        setFocusable(true);
        setDoubleBuffered(true);
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        player = new playerCar();
        setBackground(Color.black);
        setFocusable(true);
        setDoubleBuffered(true);
        loadImages();
        initrock();
        timer = new Timer(DELAY_game, this);
        timer.start();
    }

    public void initrock() {

        rock = new ArrayList<>();

    }

    public void loadImages() {
        // loadimg for game
        roadLeft = new ImageIcon("src/roadLeft.png").getImage();
        roadRight = new ImageIcon("src/Roadright.png").getImage();
        roadCenter = new ImageIcon("src/roadcenter.png").getImage();
        road = new ImageIcon("src/road.png").getImage();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!ingame&&!gameover) drawMenu(g);
        drawMap(g);
        drawPlayer(g);
        spawnRock();
        drawRock(g);
        drawScore(g);
        if (gameover == true) drawGameOver(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawMenu(Graphics g) {
        Font f = new Font("Comic Sans MS", Font.BOLD, 60);
        g.setFont(f);
        g.setColor(Color.white);
        String textscore = Integer.toString(score);
        g.drawString("Java Racing", 30, 300);
        Font d = new Font("Comic Sans MS", Font.ITALIC, 20);
        g.setFont(d);
        g.drawString("Prees 'SPACEBAR' to Start  ", 70, 400);
        Font t = new Font("Comic Sans MS", Font.PLAIN, 18);
        g.setFont(t);
        g.drawString("How To Play  ", 150, 500);
        g.drawString("Use 'Shift' to Speedup ", 110, 550);
        g.drawString(" Use 'up/down/left/right' to move ", 60, 580);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.2f));
        g2d.setColor(Color.black);
        g2d.fill3DRect(0, 0, 405, 800, true);
        if (ingame) g.clearRect(0, 0, getWidth(), getHeight());


    }

    private void drawGameOver(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.6f));
        g2d.setColor(Color.black);
        g2d.fill3DRect(0, 0, 405, 800, true);
        Font f = new Font("Comic Sans MS", Font.BOLD, 60);
        g.setFont(f);
        g.setColor(Color.white);
        String textscore = Integer.toString(score);
        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1.0f));
        g.drawString("Gameover", 70, 400);
        Font d = new Font("Comic Sans MS", Font.BOLD, 30);
        g.setFont(d);
        g.drawString("Your Score is : " + textscore, 70, 450);
        Font b= new Font("Comic Sans MS", Font.ITALIC, 15);
        g.setFont(b);
        g.drawString("Try again 'Press SPACEBAR'" , 100, 500);
        if (ingame) g.clearRect(0, 0, getWidth(), getHeight());

    }

    private void drawMap(Graphics g) {

        int mapx = 0, mapy = 0;

        for (int i = 0; i < 8; i++, mapy += 100) {
            mapx = 0;
            for (int j = 0; j < 5; j++) {

                if (mapDesign[i][j] == 0) {
                    g.drawImage(roadLeft, mapx, mapy, null);
                } else if (mapDesign[i][j] == 3) {
                    g.drawImage(roadRight, mapx, mapy, null);
                } else if (mapDesign[i][j] == 2) {
                    g.drawImage(roadCenter, mapx, mapy, null);
                } else {
                    g.drawImage(road, mapx, mapy, null);
                }

                mapx += 80;
            }
        }


    }

    private void drawPlayer(Graphics g) {

        g.drawImage(player.getImage(), player.getX(),
                player.getY(), this);
    }

    private void spawnRock() {


        if (stepSpawnrock == (gamespeed * 5)) {
            Random rand = new Random();
            int n = rand.nextInt(4);
            rock.add(new Rock(pos[n], 0));
            stepSpawnrock = 0 + difGame;
            score += 10;
            if (score % 200 == 0) {
                difGame += 2;
     //           System.out.println("gameishard");
            }
        }
    }


    private void drawRock(Graphics g) {
        for (Rock rocks : rock) {
            {
                g.drawImage(rocks.getImage(), rocks.getX(), rocks.getY(), this);
            }
        }
    }

    public void delayMap() {
        if (stepDrawmap == gamespeed) {
            for (int k = 0; k <= 7; k++) {
                if (mapDesign[k][2] == 2) {
                    mapDesign[k][2] = 1;

                } else if (mapDesign[k][2] == 1) {
                    mapDesign[k][2] = 2;

                }
            }
            stepDrawmap = 0 + difGame;
            ;
            repaint();
        }
    }

    public void drawScore(Graphics g) {
        Font f = new Font("Comic Sans MS", Font.BOLD, 20);
        g.setFont(f);
        g.setColor(Color.white);
        String textscore = Integer.toString(score);
        g.drawString("Score:" + textscore, 10, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        step();
        updaterock();
        delayMap();
        stepDrawmap++;
        stepSpawnrock++;
        checkCollisions();
        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        } else timer.start();
    }

    private void step() {

        player.move();


    }

    private void updaterock() {


        for (int i = 0; i < rock.size(); i++) {

            Rock a = rock.get(i);

            if (a.getY() > 800) {
                a.move();
                rock.remove(i);
            } else {
                a.move();
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = player.getBounds();

        for (Rock rocks : rock) {

            Rectangle r2 = rocks.getBounds();

            if (r3.intersects(r2)) {

                ingame = false;
                gameover = true;
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                if (!gameover) {
                    ingame = true;
                    gameover=false;
                    repaint();
                    timer.start();
                }
                else {
                    ingame = true;
                    gameover=false;
                    rock.clear();
                    score=0;
                    player.x=190;
                    player.y=700;
                    repaint();
                    timer.start();

                }
            }
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}











