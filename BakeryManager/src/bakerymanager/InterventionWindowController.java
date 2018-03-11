/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jmddu
 */
public class InterventionWindowController implements Initializable {
    
    @FXML
    private RadioButton ce;
    @FXML
    private RadioButton nc;
    @FXML
    private FlowPane exist; 
    @FXML
    private ChoiceBox client;
    @FXML
    private ChoiceBox adherent;
    @FXML
    private Button valid;
    @FXML
    private DatePicker dateDeb;
    @FXML
    private DatePicker dateFin;
    @FXML
    private TextField sec;
    @FXML
    private ChoiceBox act;
  
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    private Groupe<Intervention> gi = new Groupe<>("Intervention");

    private String nonSelectionne = new String("----------");
    private Stage stage;
        
    
    
    public void showClientExist(){
        ce.setSelected(true);       
    }
        
    public void validBtn() throws Exception{

    }
    
    public void resetBtn(){
        client.getSelectionModel().select(nonSelectionne);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showClientExist();
        refresh();
        client.getSelectionModel().selectFirst();
        adherent.getSelectionModel().selectFirst();
        act.setItems(FXCollections.observableArrayList(Activité.values()));
        
        // TODO
    }    
    
    public void refresh(){
    }

    
}
