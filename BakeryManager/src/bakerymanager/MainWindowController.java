/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
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
import org.omg.CosNaming.NamingContextPackage.NotFound;


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
    private RadioButton ra;
    @FXML
    private RadioButton cs;
    @FXML
    private RadioButton la;
    @FXML
    private RadioButton ls;
    
    
    // <editor-fold defaultstate="collapsed" desc="Registre Appel FXML">
    @FXML
    private ChoiceBox clientA;
    @FXML
    private FlowPane flowH;
    @FXML
    private FlowPane flowClient;
    @FXML
    private FlowPane flowTelC;
    @FXML
    private FlowPane flowHr;
    @FXML
    private FlowPane flowDem;
    @FXML
    private FlowPane flowAt;
    @FXML
    private FlowPane flowAc;
    @FXML
    private Label res;
    @FXML
    private TextField telCli;
    @FXML
    private DatePicker datepicker;
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Contrat Service FXML">
    
    @FXML
    private FlowPane flowDateDebut;
    @FXML
    private FlowPane flowNomRais;
    @FXML
    private FlowPane flowAddr;
    @FXML
    private FlowPane flowResp;
    @FXML
    private FlowPane flowSec;
    @FXML
    private FlowPane flowTarif;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Intervention List FXML">
    @FXML
    private VBox vboxDemL;
    @FXML
    private VBox vboxIntC;
    @FXML
    private ListView demandeL;
    @FXML
    private ListView interventionsList;
    @FXML
    private Button rmInter;
    @FXML
    private Button nInter;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List FXML">
    @FXML
    private ListView activityList;
    @FXML
    private ListView secGeoList;
    @FXML
    private VBox vboxAct;
    @FXML
    private VBox vboxSec;
    @FXML
    private VBox vboxAl;
    @FXML
    private VBox vboxCl;
    @FXML
    private ListView clientL;
    @FXML
    private ListView adherentL;
    
    // </editor-fold>
    
    
    @FXML
    private Button reset;
    @FXML
    private Button valid;
    @FXML
    private ToggleGroup addOption;
    @FXML
    private RowConstraints row;
    @FXML
    private ColumnConstraints col;
    @FXML
    private RadioButton ce;
    @FXML
    private RadioButton nc;
    
    @FXML
    private VBox vboxAFCL;
    @FXML
    private ListView adherentFCL;
    @FXML
    private Button ok;

    @FXML
    private TextField nom;
    @FXML
    private TextField numRue;  
    @FXML
    private TextField NomVoie;
    @FXML
    private TextField cdeVille; 
    @FXML
    private TextField ville; 
    @FXML
    private ChoiceBox actCb;
    @FXML
    private TextField tel; 
    @FXML
    private TextField nomResp;
    @FXML
    private TextField tarifHT;
    @FXML
    private TextField tarifTTC;
    @FXML
    private DatePicker dateDebut;

          
    @FXML
    private Spinner hours;
    @FXML
    private Spinner minutes;
    @FXML
    private TextArea demande;
    
    
    // <editor-fold defaultstate="collapsed" desc="Affichage composant FXML">
    public void cleanScreen(){
        subtitle.setText("");
        flowH.setVisible(false);
    
        flowClient.setVisible(false);
        flowTelC.setVisible(false);
        flowHr.setVisible(false);
        flowDem.setVisible(false);
        
        flowDateDebut.setVisible(false);
        flowNomRais.setVisible(false);
        flowAddr.setVisible(false);
        flowResp.setVisible(false);
        flowSec.setVisible(false);
        
        vboxDemL.setVisible(false);
        interventionsList.setVisible(false);
        nInter.setVisible(false);
        rmInter.setVisible(false);
        
        vboxAct.setVisible(false);
        vboxSec.setVisible(false);
        vboxAl.setVisible(false);
        vboxCl.setVisible(false);
        
        vboxAFCL.setVisible(false);
        vboxIntC.setVisible(false);
        
        reset.setVisible(false);
        valid.setVisible(false);
        refresh();
    }
    
    
    @FXML
    public void showRegistreAppel(){
        if(ra.isSelected() == false)
            ra.selectedProperty().set(true);
        cleanScreen();
        subtitle.setText("Registre d'appel");
        flowH.setVisible(true);
        flowClient.setVisible(true);
        flowTelC.setVisible(true);
        flowHr.setVisible(true);
        flowDem.setVisible(true);
        reset.setVisible(true);
        valid.setVisible(true);
    }
    @FXML
    public void showContratService(){
        cleanScreen();
        if(cs.isSelected() == false)
            cs.selectedProperty().set(true);
        subtitle.setText("Contrat Service");

        reset.setVisible(true);
        valid.setVisible(true);
        
               
        flowDateDebut.setVisible(true);
        flowNomRais.setVisible(true);
        flowAddr.setVisible(true);
        flowResp.setVisible(true);
        flowSec.setVisible(true);
    } 
    public void showListeInterventions(){
        cleanScreen();
        if(ls.isSelected() == false)
            ls.selectedProperty().set(true);
        subtitle.setText("Liste intervention");
        vboxDemL.setVisible(true);
        vboxIntC.setVisible(true);
        interventionsList.setVisible(true);
        nInter.setVisible(true);
        rmInter.setVisible(true);
    }
    public void showGestionListe(){
        cleanScreen();
        if(la.isSelected() == false)
            la.selectedProperty().set(true);
        subtitle.setText("Gestion des liste");
        
        vboxAct.setVisible(true);
        vboxSec.setVisible(true);
        
        vboxAl.setVisible(true);
        vboxCl.setVisible(true);
    }
    
    //</editor-fold>
    
    
    
    
    //Non FXML attribut
    public Groupe<Client> groupeClient = new Groupe("Groupe Client");
    public Groupe<Adherent> groupeAdherent = new Groupe("Groupe Adherent");
    public Groupe<Intervention> groupeInter = new Groupe("Groupe Intervention");
    public Groupe<Demande> groupeDem = new Groupe("Groupe Demande");
    
    
    private Activité enumActivite = Activité.Alarme;
    
    private ObservableList<String> listeActivites = FXCollections.observableArrayList();
    private ObservableList<String> listeSecteurGeographique = FXCollections.observableArrayList();

    
    public void validBtn() throws Exception{
        groupeClient.addToGroupe(new Client("Michel","Le brezil", "0202020202", "rue des fenetres", new SecteurGeographique("100-Les Velux")));
        groupeAdherent.addToGroupe(new Adherent("bob", "le bricoleur", "rue des clou", new Date(1000), new Date(1000),new SecteurGeographique("100-Les Velux"),Activité.Electricité));
        if(ra.isSelected()){
            //Validation registre d'appel
            ajouterDemande();
        }else if(cs.isSelected()){
            ajouterAdherent();
        }
    }
    public void resetBtn() throws Exception{
        if(ra.isSelected()){
            clientA.getSelectionModel().select(0);
            hours.getValueFactory().setValue(12);
            minutes.getValueFactory().setValue(30);
        }else if(cs.isSelected()){
            resetAdherent();
        }
        refresh();
    }

    
    
    public void newIntervention() throws IOException{
        Stage stage = new Stage();
        
        FXMLLoader fl = new FXMLLoader(getClass().getResource("/fxml/InterventionWindow.fxml"));
        InterventionWindowController iwc = new InterventionWindowController(groupeClient, groupeAdherent,groupeInter);
        fl.setController(iwc);
        
        Parent root = fl.load();

        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("ADHER Service - Nouvelle Intervention");
        stage.setScene(scene);
        stage.showAndWait();
        refresh();
        
    }
    
    public void rmIntervention(){
       String s = (String) interventionsList.getSelectionModel().getSelectedItem();
       groupeInter.rm(s);
       refresh();
    }
    
    public void ajouterClient() throws IOException{
        NewClientFXMLController nCC = new NewClientFXMLController(groupeClient);
        
        FXMLLoader fl = new FXMLLoader(getClass().getResource("/fxml/NewClientFXML.fxml"));
        fl.setController(nCC);
        
        Parent root = fl.load();
        
        Stage stage = new Stage();
        Scene scene = new Scene(root, 300, 450);
        
        stage.setTitle("ADHER Service - Nouveau Client");
        stage.setScene(scene);
        stage.showAndWait();
        refresh();
    }
    
    public void supprimerClient() throws Exception{
        String client_s = (String) clientL.getSelectionModel().getSelectedItem();
        groupeClient.removeFromGroupe(groupeClient.getPersonne(client_s));
        refresh();
    }


    public void ajouterAdherent(){
        DatePicker dp = new DatePicker(dateDebut.getValue());
        Date dd = new Date();
        Date df = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        df = c.getTime();
        
        SecteurGeographique s = new SecteurGeographique(cdeVille.getText() + "-" + ville.getText());
        Adherent e = new Adherent( nom.getText(), nomResp.getText(), numRue.getText()+" "+NomVoie.getText(), dd, df, s,(Activité) actCb.getSelectionModel().getSelectedItem());
        groupeAdherent.addToGroupe(e);
        listeSecteurGeographique.add(s.toString());
        refresh();
    }

    public void supprimerAdherent() throws Exception {
        String adherent_s = (String) adherentL.getSelectionModel().getSelectedItem();
        groupeAdherent.removeFromGroupe(groupeAdherent.getPersonne(adherent_s));
        refresh();
    }
    
    public void resetAdherent(){
        /// remise a zero des champs interface
        String value = "";
        nom.setText(value);
        numRue.setText(value);
        NomVoie.setText(value);
        cdeVille.setText(value);
        ville.setText(value);
        nomResp.setText(value);
        tel.setText(value);
        actCb.getSelectionModel().select(0);
        dateDebut.setAccessibleText(value);
        tarifHT.setText(value);
        tarifTTC.setText(value);
    }
    
    public void renouvellementAdherent() {
        ArrayList<Adherent> l = groupeAdherent.getList();
        ArrayList<Adherent> afc = new ArrayList<>();
        
        for( Adherent a : l)
            if(a.getDateSortie().compareTo(new Date()) < 0) {
                System.out.println(a.toString()+" : fin de contrat");
                afc.add(a);
            }
        
        if(!afc.isEmpty()){
            cleanScreen();
            vboxAFCL.setVisible(true);
            adherentFCL.setItems(FXCollections.observableArrayList(afc));
        }
    }
    
    public void ok(){
        cleanScreen();
        showRegistreAppel();
    }
    
    public void ajouterDemande() throws Exception{
        if(!clientA.equals("----------") && clientA.getSelectionModel().getSelectedItem() != null && clientA.getSelectionModel().getSelectedIndex() != 0){
            Client a = groupeClient.getPersonne(clientA.getSelectionModel().getSelectedItem().toString());
            int h = (int)hours.getValue();
            int m = (int)minutes.getValue();
            Demande dem = new Demande(a, new Date(),h, m, demande.getText());
            groupeDem.addToGroupe(dem);
        }
        refresh();
    }
    
    public void supprimerDemande() throws Exception{
        String demande_s = (String) demandeL.getSelectionModel().getSelectedItem();
        groupeDem.removeFromGroupe(groupeDem.getPersonne(demande_s));
        refresh();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        cleanScreen();
        showRegistreAppel();
        
        listeActivites.addAll(enumActivite.getActivites());
        activityList.setItems(listeActivites);
        
        refresh();
        renouvellementAdherent();
        clientA.getSelectionModel().selectFirst();
    }    
    
    
    public void refresh(){
        clientA.setItems(FXCollections.observableArrayList(groupeClient.getStringList()));
        clientL.setItems(FXCollections.observableArrayList(groupeClient.getStringList()));
        adherentL.setItems(FXCollections.observableArrayList(groupeAdherent.getStringList()));
        interventionsList.setItems(FXCollections.observableArrayList(groupeInter.getStringList()));
        demandeL.setItems(FXCollections.observableArrayList(groupeDem.getStringList()));
        actCb.setItems(FXCollections.observableArrayList(Activité.values()));
        secGeoList.setItems(FXCollections.observableArrayList(groupeAdherent.getSecteurs()));
    }

    void save() {
        System.out.println("Sauvegarde des différentes Instances.");
        saveAndLoad.save(groupeClient, groupeAdherent, groupeInter,groupeDem);
    }

    void load(){
        System.out.println("Chargement de la Base de Donnée..");

        groupeClient.addList(saveAndLoad.loadClients());
        groupeAdherent.addList(saveAndLoad.loadAdherents());
        groupeInter.addList(saveAndLoad.loadInterventions(groupeClient,groupeAdherent));
        groupeDem.addList(saveAndLoad.loadDemandes(groupeClient));
        
        System.out.println("Base de Donnée chargé !");
    }
}
