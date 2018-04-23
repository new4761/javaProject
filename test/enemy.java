package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;

class  enemy  extends JPanel {

	public  enemy() {
		 numberofenemy() ;
	}


private static void numberofenemy(){
     //int [][]area  = new int[6][9];
	 int numberofrock = 0;
	 Random rock = new Random();
	 int n = rock.nextInt(10)+1;
	  if(n==1){numberofrock=4;areaofenemy(numberofrock);}
       else if(n<=3&&n!=1){numberofrock=3;areaofenemy(numberofrock);}
        else if(n<=6&&n>3){numberofrock=2;areaofenemy(numberofrock);}
         else if(n<=10&&n>6){numberofrock=1;areaofenemy(numberofrock);}

}


private static void areaofenemy(int n){
       int trun = 1;
      int [][]area  = new int[9][6];
      for(int i = 1 ; i<=n ; i++ ){
	    Random rock = new Random();
          int a = rock.nextInt(4)+1;
          area[trun][a]=1;

	  }
      trun++;

      numberofenemy2(trun,area);
}



private static void numberofenemy2(int trun,int [][]area){
     if(trun==9){
	      for(int i=1;i<=8;i++){
			  for(int j = 1;j<=5;j++){
                        area[i][j]=0;
			  }
		  }
		  areaofenemy(1);
	}
	else{ int numberofrock = 0;
	 Random rock = new Random();
	 int n = rock.nextInt(10)+1;
	  if(n==1){numberofrock=4;areaofenemy2(numberofrock,trun,area);}
       else if(n<=3&&n!=1){numberofrock=3;areaofenemy2(numberofrock,trun,area);}
        else if(n<=6&&n>3){numberofrock=2;areaofenemy2(numberofrock,trun,area);}
         else if(n<=10&&n>6){numberofrock=1;areaofenemy2(numberofrock,trun,area);}

	}
}

private static void areaofenemy2(int n,int trun,int [][]area){
	  int error[] =new int[9];
	  for(int j =1 ; j<=6 ;j++ ){
	  if(area[1][j]==1){area[trun][j]=area[1][j];
	                     error[j]=1   ;              }
	  }




      for(int i = 1 ; i<=n ; i++ ){
	    Random rock = new Random();
          int a = rock.nextInt(4)+1;
         if(error[i]!=a) {a=checkerror(error,a);}
		  area[1][a]=1;

	  }
      trun++;

      numberofenemy2(trun,area);
}



private static int checkerror(int[]error,int a){

       if(a>5){return 0 ;}


	   return a+1;
}
}


	
		
