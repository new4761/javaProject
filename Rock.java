import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Rock {





        private int Spawn = 670;
        private int x;
        private int y;
        private int w;
        private int h;
        private Image rock;
        private int count;

        public Rock(int x, int y) {
        //    System.out.println("rockspwan");
            this.x = x;
            this.y = y;
            loadImage();
        }

        private void loadImage() {

            rock = new ImageIcon("src/rock.png").getImage();


            w = rock.getWidth(null);
            h = rock.getHeight(null);
        }

        public void move() {
            if (y < 0) {
                y = Spawn;
            }
            y += 1;
        }

        public int getX() {
            if (x >= 320) {
                x = 320;
            } else if (x <= 4) {
                x = 4;
            }
            return x;
        }

        public int getY() {

            return y;
        }

        public int getWidth() {

            return w;
        }

        public int getHeight() {

            return h;
        }

        public Image getImage() {

            return rock;
        }
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    }

