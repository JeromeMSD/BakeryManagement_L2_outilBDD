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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jeromem
 */
public class Login extends Application {

    Connection c;
    
    
    public Connection getConnection() {
        return c;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Connection");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        Text scenetitle = new Text("Bienvenue");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        scenetitle.setId("welcome-text");
        
        
        Label userName = new Label("Username:");
        grid.add(userName, 0, 2);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 2);

        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 3);
        
        Button btn = new Button("Log in");
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);
        
        pwBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode().equals(KeyCode.ENTER))
                    btn.fire();
            }
        });
        
        userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode().equals(KeyCode.ENTER))
                    pwBox.requestFocus();
            }
        });
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 4,3,1);
        actiontarget.setId("actiontarget");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                try {
                    c = new Connector(userTextField.getText(),pwBox.getText()).getConnection();
                } catch (SQLException ex) {
                    
                }
                if (c == null){
                    actiontarget.setText("Access denied");
                    System.err.println("Access denied !");
                }else{
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Access granted !");
                    System.out.println("Access granted !");
                    stage.close();
                }
            }
        });

        
        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(Login.class.getResource("/css/Login.css").toExternalForm());
        stage.setScene(scene);
        
        stage.setOnCloseRequest((WindowEvent we) -> {
            System.exit(0);
        });
        
        stage.showAndWait();
    }
}
