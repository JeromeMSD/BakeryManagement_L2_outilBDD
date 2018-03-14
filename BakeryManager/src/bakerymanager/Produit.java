/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jeromem
 */
public class Produit extends Application{

    private Connection c;
    private String operation = "... Produit";
    private String query;
    
    public Produit(Connection c){
        this.c = c;
    }
    
    
    
    
    public String getQuery(){
        return query;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Produit");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        Text scenetitle = new Text(operation);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        scenetitle.setId("welcome-text");
        
        
        Label prodName = new Label("Designation :");
        grid.add(prodName, 0, 2);

        TextField prodTextField = new TextField();
        grid.add(prodTextField, 1, 2,3, 1);
        
        Label prix = new Label("Prix (en €):");
        grid.add(prix, 0, 3);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 3,3, 1);

        
        Button cancelBtn = new Button("Cancel");        
        Button validBtn = new Button("Apply");
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 4,3,1);
        actiontarget.setId("actiontarget");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(validBtn);
        grid.add(hbBtn, 3, 4);
        grid.add(cancelBtn, 0, 4);

        
        validBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                if (c == null){
                    actiontarget.setText("Access denied");
                    System.err.println("Access denied !");
                }else{
                    System.out.println("Sql command executed !");
                    stage.close();
                }
            }
        });

        
        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add(Login.class.getResource("/css/Login.css").toExternalForm());
        stage.setScene(scene);
        
        stage.showAndWait();

    }

}
