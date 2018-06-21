/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dao.JugadorDao;
import Modelo.Jugador;
import Threads.BallThread;
import Threads.PadThread;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MMont
 */
public class Gui extends Application {
    private Jugador jugador1= null;
    
  // public static boolean hitSpace=false;
    
    Button btn;
    TextField txt1;
    Label lbl1;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        btn = new Button();
        btn.setText("Entrar");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                showGame();
            }
        });
        
        lbl1 = new Label("Nombre Del Jugador: ");
        
        txt1 = new TextField();
        txt1.setPrefWidth(200);
        
        
        GridPane layout = new GridPane();
        layout.setHgap(20);
        layout.setVgap(20);
     
        
        
        layout.add(lbl1,2,0);
        layout.add(txt1,2,1);
        layout.add(btn,2,2);
        
        
        Scene scene = new Scene(layout, 600, 600);
        
        primaryStage.setTitle("Ventana Principal");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void showGame(){
      
                Group grid2 = new Group();
                Scene scene2 = new Scene(grid2,600,600);
                Stage newStage = new Stage();
                newStage.setTitle("Juego");
                newStage.setScene(scene2);
                
                Label label1 = new Label();
                label1.setLayoutX(200);
                label1.setLayoutY(300);
                
                Image image = new Image(getClass().getResourceAsStream("ball.png"));
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(70);
                imageView.setFitWidth(75);
                label1.setGraphic(imageView);
                
                Label label2 = new Label();
               
                
                Image leftPad = new Image(getClass().getResourceAsStream("Pad Left.png"));
                ImageView imageView2 = new ImageView(leftPad);
                imageView2.setFitHeight(75);
                imageView2.setFitWidth(100);
                label2.setGraphic(imageView2);
                label2.setLayoutX(150);
                label2.setLayoutY(500);
                
                BallThread ballChecker = new BallThread(label1,scene2);
                ballChecker.start();
                
                
                PadThread padChecker = new PadThread(label2,scene2);
                padChecker.start();
                
               
                grid2.getChildren().addAll(label1,label2);

                newStage.show();

            }
    
}
