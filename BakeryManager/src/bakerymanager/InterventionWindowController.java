/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.omg.CosNaming.NamingContextPackage.NotFound;

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
    private Groupe<Personne> gc = new Groupe<>("Client");
    private Groupe<Fournisseur> ga = new Groupe<>("Adherent");
    
    private String nonSelectionne = new String("----------");
    private Stage stage;
        
    
    public InterventionWindowController(Groupe gc, Groupe ga, Groupe<Intervention> li){
        this.ga = ga;
        this.gc = gc;
        this.gi = li;
    }
    
    
    public void showClientExist(){
        ce.setSelected(true);       
    }
        
    public void showNewClient() throws IOException{
        nc.setSelected(true);
        NewClientFXMLController nCC = new NewClientFXMLController(gc);
        
        FXMLLoader fl = new FXMLLoader(getClass().getResource("/fxml/NewClientFXML.fxml"));
        fl.setController(nCC);
        
        Parent root = fl.load();
        
        Stage stage = new Stage();
        Scene scene = new Scene(root, 300, 450);
        
        stage.setTitle("ADHER Service - Nouveau Client");
        stage.setScene(scene);
        stage.showAndWait();
        
        refresh();
        ce.setSelected(true);
    }
    
    public void validBtn() throws Exception{
        Date debut = null;
        Date fin = null;
        Personne c = null;
        Fournisseur a = null;
        // Si un client a été selectionner
            if(!client.getSelectionModel().getSelectedItem().equals("----------"))
                c = gc.getPersonne((String) client.getSelectionModel().getSelectedItem());
                // Si Un adherent à été selectionner
                if(!adherent.getSelectionModel().getSelectedItem().equals("----------"))
                    a = ga.getPersonne((String) adherent.getSelectionModel().getSelectedItem());
                    if(dateDeb.getChronology() != null && dateFin.getChronology() != null)
                        debut = new Date(dateDeb.getValue().toEpochDay());
                        fin = new Date(dateFin.getValue().toEpochDay());
                        if(debut.before(fin)) {
                            //Ajouter l'intervention au registre
                            gi.addToGroupe(new Intervention(c, a, debut, fin, new SecteurGeographique(sec.getText()), (Activité) act.getSelectionModel().getSelectedItem()));
                            stage = (Stage) valid.getScene().getWindow();
                            stage.close();
                        }
    }
    
    public void resetBtn(){
        client.getSelectionModel().select(nonSelectionne);
    }
    
    public void clientC() throws Exception{
        try{
            Personne c = gc.getPersonne((String) client.getSelectionModel().getSelectedItem());
            sec.setText(c.getSecteurGeographique().toString());
        }catch (NotFound n){
            ;
        }
         
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
        client.setItems(FXCollections.observableArrayList(gc.getStringList()));
        adherent.setItems(FXCollections.observableArrayList(ga.getDisponnible()));
    }

    
}
