/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author MMont
 */
public class Gui_Swing extends JFrame{
    JLabel lbl1,lbl2,lbl3;
    JTextField txt1;
    JButton btn1;
    
    public Gui_Swing (){
        super("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800,650);
        
        lbl1 = new JLabel("Ingrese Su Nombre:");
        lbl1.setBounds(300,200,250,25);
        txt1 = new JTextField();
        txt1.setBounds(250,250,250,25);
        btn1 = new JButton("Iniciar");
        btn1.setBounds(250,350,250,50);
        
        Container container = getContentPane();
        container.add(lbl1);
        container.add(txt1);
        container.add(btn1);
        
        
    }
    
    public static void main (String [] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
            new Gui_Swing().setVisible(true);
            }
            
        });
    }    
}
