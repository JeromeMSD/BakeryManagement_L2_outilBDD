/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jeromem
 */
public class BakeryManager extends Application{

    public void start(Stage primaryStage) throws Exception {
        MainWindowController mWC = new MainWindowController();
 
        FXMLLoader fl = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        fl.setController(mWC);
        
        Parent root = fl.load();
        
        Scene scene = new Scene(root, 800, 700);

        primaryStage.setTitle("Bakery Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            System.out.println("Stage is closing");
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
