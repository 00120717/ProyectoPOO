/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Gui.Gui;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author MMont
 */
public class BallThread extends Thread{
    Label ball;
    Scene scene;
    boolean hitSpace=false;
    
    double time= 0.0;
    double gravity= 15;
    double velocityY=0;
    double inicialPosY=0;

    double velocityX=50;
    
    public BallThread(Label ball, Scene scene) {
        this.ball=ball;
        this.inicialPosY=ball.getLayoutY();
        this.scene=scene;
        
        scene.setOnKeyPressed(new EventHandler <KeyEvent>(){
                    @Override
                    public void handle(KeyEvent event) {
                        
                        if(event.getCode()==KeyCode.SPACE){
                            hitSpace=true;  
                            System.out.println("presiono space");
                        }
                        if(event.getCode()==KeyCode.A){
                            PadThread.hitLeft=true;  
                            System.out.println("Presiono a");
                        }
                    }
                    
                 });
    }
    
    @Override
    public void run(){
        while(true){
            if(ball.getLayoutX()<=0){
                velocityX= velocityX*-1;
                
            }
            if(ball.getLayoutX()>=scene.getWidth()-ball.getWidth()){
                velocityX= velocityX*-1;
            }
            if(hitSpace == true){
                this.velocityY =-50;
                time=.25;
                hitSpace=false;
            }else if(ball.getLayoutY()<=0){
                this.velocityY = this.velocityY*-1;
                ball.setLayoutY(ball.getLayoutY()+((velocityY*time)+(.5*gravity*time*time)));
            }else if(ball.getLayoutY()>=scene.getHeight()-ball.getHeight()){
                ball.setLayoutY(scene.getHeight()-ball.getHeight());
                System.err.println("Perdistes!");
                break;
                
            }
            else{
                if(ball.getLayoutX()+(velocityX*time)<0){
                    ball.setLayoutX(0);
                }
                if(ball.getLayoutX()+(velocityX*time)>scene.getWidth()){
                ball.setLayoutX(scene.getHeight());
                }
                
                else{
                ball.setLayoutX(ball.getLayoutX()+(velocityX*time));
                }
                
                ball.setLayoutY(ball.getLayoutY()+((velocityY*time)+(.5*gravity*time*time)));
                time+=.005;
                velocityY+=gravity*time;
                
                


                    try {
                        sleep(50);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BallThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
                }
                
                
                
            }
        
        
    }
    
}
