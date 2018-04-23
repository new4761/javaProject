package javaProject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author petch
 */
public class Carplayer  extends JPanel{

    /**
     * @param args the command line arguments
     */
    
    final int BoardX = 6;
    final int BoardY = 9;
    int curX = 8;
    int curY = 2;

    public Carplayer ()

    {


        }

    private boolean tryMove(int newX, int newY)
    {
//        for (int i = 0; i < 4; ++i) {
            int x = newX; //+ curX;
            int y = newY; //- curY;
            if (x < 0 || x >= BoardX || y < 0 || y >= BoardY)
                return false;
//        }

        curX = newX;
        curY = newY;
        return true;
    }
    
     public void keyInput(String key) {
         switch (key) {
             case "a":
                 tryMove(curX - 1, curY);
                 break;
             case "d":
                 tryMove(curX + 1, curY);
                 break;
             case "w":
                 tryMove(curX, curY+1);
                 break;
             case "s":
                 tryMove(curX, curY-1);
                 break;
         }
     }
    
    
     public  void keyPressed(KeyEvent e) {
//
//             if (!isStarted || curPiece.getShape() == Tetrominoes.NoShape) {  
//                 return;
//             }

             int keycode = e.getKeyCode();
//
//             if (keycode == 'p' || keycode == 'P') {
//                 pause();
//                 return;
//             }
//
//             if (isPaused)
//                 return;

             switch (keycode) {
             case KeyEvent.VK_LEFT:
                 tryMove(curX - 1, curY);
                 break;
             case KeyEvent.VK_RIGHT:
                 tryMove(curX + 1, curY);
                 break;
             case KeyEvent.VK_DOWN:
                 tryMove(curX, curY+1);
                 break;
             case KeyEvent.VK_UP:
                 tryMove(curX, curY-1);
                 break;
                 
                 
//             case KeyEvent.VK_SPACE:
//                 dropDown();
//                 break;
//             case 'd':
//                 oneLineDown();
//                 break;
//             case 'D':
//                 oneLineDown();
//                 break;
             //}

         }
     }
     
     public static void main(String[] args) {
        // TODO code application logic here
        int[][] areaofCar = new int[9][6];
//        for (int i = 1; i < 9; i++) {
//            for (int j = 1; j < 6; j++) {
//                areaofCar[i][j] = j;
//                System.out.print(" "+areaofCar[i][j] );
//            }
//            System.out.println("");            
//        }
        System.out.println("--------------------");
        int dy = 8;
        int dx = 2;
        areaofCar[dy][dx] = 8;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 6; j++) {
//                areaofCar[i][j] = j;
                if(areaofCar[i][j] == 0){
                System.out.print("  ");
                }
                else{
                    System.out.print(" 0" );
                }
                    
            }
            System.out.println("");            
        }
        
        System.out.println("Input Move :");
        Scanner sc = new Scanner (System.in);
        String key = sc.next();
        System.out.println("key :"+key);
        //keyInput(key);
        
    }
     
}
    
//    public static void score() {
//
//	}
//   