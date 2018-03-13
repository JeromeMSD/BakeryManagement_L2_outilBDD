/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author jmddu_000
 */
public class MainWindowController implements Initializable {
    
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
    
    
    @FXML
    private ListView cmdList;
    @FXML
    private ListView fourList;
    @FXML
    private ListView clientList;
    @FXML
    private ListView ingList;
    @FXML
    private ListView prodList;
    
    
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
    public void addCmd() throws Exception{

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
        //Fournisseur f = fourList.getSelectionModel().getSelectedItem();
        //DELETE FROM FOURNISSEUR WHERE id_fournisseur=f.getId();
        
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
        //Client c = clientList.getSelectionModel().getSelectedItem();
        //DELETE FROM PERSONNE WHERE id_personne=c.getId();
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
        //Ingredient i = ingList.getSelectionModel().getSelectedItem();
        //DELETE FROM INGREDIENT WHERE id_ingredientt=i.getId();
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
        //Produit p = prodList.getSelectionModel().getSelectedItem();
        //DELETE FROM PRODUIT WHERE id_produit=p.getId();
    }
    // </editor-fold>
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
