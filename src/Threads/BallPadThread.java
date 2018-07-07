/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 *
 * @author MMont
 */
public class BallPadThread extends Thread{
    Label ball;
    Scene scene;
    Label leftPad;
    

    public BallPadThread() {
        
    }

    public BallPadThread(Label ball,  Label leftPad, Scene scene) {
        this.ball = ball;
        this.scene = scene;
        this.leftPad = leftPad;
    }

    @Override
    public void run() {
  
        while(true){
            double minXball= ball.getLayoutX();
            double maxXball= ball.getLayoutX()+ball.getWidth();
            
            double minYball= ball.getLayoutY();
            double maxYball= ball.getLayoutY()+ball.getHeight(); 
        
            double minXpad= leftPad.getLayoutX();
            double maxXpad= leftPad.getLayoutX()+leftPad.getWidth();
            
            double minYpad= leftPad.getLayoutY();
            double maxYpad= leftPad.getLayoutX()+leftPad.getHeight();
            
            
            //Si Hay Colision Con el Left Pad
            if((maxYball>=minYpad)&&(minYball<=minYpad)&&(maxXball>=minXpad)&&(minXball<=maxXpad)){
                //BallThread.velocityY =-100;
                BallThread.time=.25;
                System.out.println("collision");
                int exp = ((int)(Math.random()*2)+1);
                BallThread.velocityX = (int) Math.pow(exp, -1) * ((int)(Math.random()*50)+50);
                
                if(PadThread.hitLeft==true)BallThread.velocityY = -150;
                if(PadThread.hitLeft==false)BallThread.velocityY = -75;
                
                
            }
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(BallPadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
}
