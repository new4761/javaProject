
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.*;

public class playerCar {
    private int dx;
    private int dy;
    public int x = 190;
    public int y = 700;
    private int w;
    private int h;
    private Image car;


    public playerCar() {
        //System.out.println("playerCar");
        loadImage();
    }

    private void loadImage() {

        car = new ImageIcon("src/car.png").getImage();


        w = car.getWidth(null);
        h = car.getHeight(null);
    }

    public void move() {

        x += dx;
        y += dy;
      /*  System.out.println("x:" + x);
        System.out.println("y:" + y);*/
    }

    public int getX() {
        if (x >= 360) {
            x = 360;
        } else if (x <= 20) {
            x = 20;
        }
        return x;
    }

    public int getY() {
        if (y>= 700) {
           y = 700;
        } else if (y <= -2) {
            y = -2;
        }
        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return car;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
    int speed = 3;
    int speed_current = speed;

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {

            speed_current = speed +3;
            if (key == KeyEvent.VK_LEFT) {
                dx = -speed_current;
            }

            if (key == KeyEvent.VK_RIGHT) {
                dx = speed_current;
            }

            if (key == KeyEvent.VK_UP) {
                dy = -speed_current;
            }

            if (key == KeyEvent.VK_DOWN) {
                dy = speed_current;
            }
        }
        else {
            if (key == KeyEvent.VK_LEFT) {
                dx = -speed_current;
            }

            if (key == KeyEvent.VK_RIGHT) {
                dx = speed_current;
            }

            if (key == KeyEvent.VK_UP) {
                dy = -speed_current;
            }

            if (key == KeyEvent.VK_DOWN) {
                dy = speed_current;
            }
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SHIFT) {
            speed_current = speed;

           // System.out.println("speeddown");
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
