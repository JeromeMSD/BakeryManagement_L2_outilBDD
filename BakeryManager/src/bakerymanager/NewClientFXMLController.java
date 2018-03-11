/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import fxml.other.NumberField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jmddu
 */
public class NewClientFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label subtitle;
    @FXML
    private TextField nomCli;
    @FXML
    private TextField prenomCli;
    @FXML
    private NumberField telCli;
    @FXML
    private TextField libRue;
    @FXML
    private TextField villeCli;
    @FXML
    private NumberField cdeVCli;
    @FXML
    private Button valid;
    
    
    
    private Groupe gc;
    private Stage stage;
                                 
    
    public NewClientFXMLController(Groupe gc){
        this.gc = gc;
    }
    
    public void validBtn(){
    }
    
    public void resetBtn(){
        nomCli.setText("");
        prenomCli.setText("");
        telCli.setText("");
        libRue.setText("");
        villeCli.setText("");
        cdeVCli.setText("");
        subtitle.setText("Nouveau Client");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
