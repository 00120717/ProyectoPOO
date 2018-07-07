/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

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
public class PadThread extends Thread{
    Label leftPad=null;
    Label rightPad=null;
    Scene scene=null;
    public static boolean hitLeft=false;
    public static boolean hitRight=false;

    public PadThread(Label left,Scene scene, Label right) {
        this.leftPad=left;
        this.scene=scene;
        this.rightPad=right;
        
    }
    
    @Override
    public void run(){
        
        while(true){
            
            if(hitLeft==true){

                for (int i =1;i<4;i++){
                    leftPad.setRotate(-22.5*i);
                    try {
                        sleep(75);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PadThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                for (int i =1;i<4;i++){
                    leftPad.setRotate(-90+22.5*i);
                    try {
                        sleep(75);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PadThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                hitLeft=false;
                
            }
            else if(hitRight == true){
                 for (int i =1;i<4;i++){
                    rightPad.setRotate(22.5*i);
                    try {
                        sleep(75);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PadThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                for (int i =1;i<4;i++){
                    rightPad.setRotate(90-22.5*i);
                    try {
                        sleep(75);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PadThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                hitRight=false;
                
            }
            
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(PadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    }
    
}
