/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author jmddu_000
 */
public class MainWindowController implements Initializable {
    private DAO saveAndLoad = new DAO();
    
    @FXML
    private Label title;
    @FXML
    private Label subtitle;
    
    @FXML
    private RadioButton cmd;
    @FXML
    private RadioButton stk;
    @FXML
    private RadioButton lst;
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Affichage composant FXML">
    public void cleanScreen(){
        subtitle.setText("");
    
    }
    
    
    @FXML
    public void showCommande(){
        if(cmd.isSelected() == false)
            cmd.selectedProperty().set(true);
        cleanScreen();
        subtitle.setText("Liste des commandes");
    }
    @FXML
    public void showStock(){
        if(stk.isSelected() == false)
            stk.selectedProperty().set(true);
        cleanScreen();
        subtitle.setText("Stocks");

    }
    @FXML
    public void showListe(){
        cleanScreen();
        if(lst.isSelected() == false)
            lst.selectedProperty().set(true);
        subtitle.setText("Listes");
    }
    
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Commandes">
    @FXML
    public void addCmd(){
        
    }
    
    @FXML
    public void modCmd(){
        
    }
    
    @FXML
    public void delCmd(){
        
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Fournisseurs">
    @FXML
    public void addFour(){
        
    }
    
    @FXML
    public void modFour(){
        
    }
    
    @FXML
    public void delFour(){
        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les CLient">
    @FXML
    public void addClient(){
        
    }
    
    @FXML
    public void modClient(){
        
    }
    
    @FXML
    public void delClient(){
        
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les ingredients">
    @FXML
    public void addIng(){
        
    }
    
    @FXML
    public void modIng(){
        
    }
    
    @FXML
    public void delIng(){
        
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les produit">
    @FXML
    public void addProd(){
        
    }
    
    @FXML
    public void modProd(){
        
    }
    
    @FXML
    public void delProd(){
        
    }
    // </editor-fold>
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
