/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    
    private final Connection connection;

    MainWindowController(Connection conn) {
        this.connection = conn;
            
        //Pour faire marcher les id incremental
        Statement s = null;
        try {
            s = connection.createStatement();
            s.executeUpdate("DELETE FROM ADRESSE;");
            s.executeUpdate("DELETE FROM FOURNISSEUR;");
            s.executeUpdate("DELETE FROM PERSONNE;");
        } catch (SQLException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                s.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
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
        Stage stage = new Stage();
        List<TextField> list = new ArrayList<>();
        
        stage.setTitle("Fournisseur");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 0, 0, 0));

        
        Text scenetitle = new Text("Nouveau fournisseur");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 4, 1);
        scenetitle.setId("title");
        
        
        Label nameL = new Label("Nom :");
        grid.add(nameL, 0, 2);

        TextField name = new TextField();
        grid.add(name, 1, 2,3, 1);
        list.add(name);
        
        Label telL = new Label("Tel :");
        grid.add(telL, 0, 3);

        TextField tel = new NumberField();
        grid.add(tel, 1, 3,3, 1);
        list.add(tel);
        
        Label adresseTitle = new Label("Adresse");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        HBox hbAdr = new HBox(10);
        hbAdr.setAlignment(Pos.CENTER);
        hbAdr.getChildren().add(adresseTitle);
        grid.add(hbAdr, 0, 5, 4, 1);
        
        Label numAdrL = new Label("Numero :");
        grid.add(numAdrL, 0, 6);

        TextField numAdr = new NumberField();
        grid.add(numAdr, 1, 6);
        list.add(numAdr);
        
        Label libAdrL = new Label("Rue :");
        grid.add(libAdrL, 0, 7);

        TextField libAdr = new TextField();
        grid.add(libAdr, 1, 7,3, 1);
        list.add(libAdr);
        
        Label cdeAdrL = new Label("Code Postal :");
        grid.add(cdeAdrL, 0, 8);

        TextField cdeAdr = new NumberField();
        grid.add(cdeAdr, 1, 8);
        list.add(cdeAdr);
        
        Label villeAdrL = new Label("Ville :");
        grid.add(villeAdrL, 0, 9);

        TextField villeAdr = new TextField();
        grid.add(villeAdr, 1, 9,3,1);
        list.add(villeAdr);
       
        
        
        Button cancelBtn = new Button("Annuler");        
        Button validBtn = new Button("Valider");
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 11,2,1);
        actiontarget.setId("actiontarget");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(validBtn);
        grid.add(hbBtn, 3, 11);
        grid.add(cancelBtn, 0, 11);

        
        validBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int cpt = 0;
                Statement stmt = null; 
                
                
                for (TextField t : list)
                    if(t.getText().isEmpty()){
                        cpt++;
                        t.setStyle("-fx-border-color: firebrick;");
                    }else{
                        t.setStyle("-fx-border-color: white;");
                    }
                    
                if(cpt == 0){
                    try {
                        Adresse adr = new Adresse(Integer.parseInt(numAdr.getText()), libAdr.getText(), Integer.parseInt(cdeAdr.getText()), villeAdr.getText());
                        Fournisseur fournisseur = new Fournisseur(name.getText(), Integer.parseInt(tel.getText()), adr);
                        
                        stmt = connection.createStatement();
                        stmt.executeUpdate(adr.getCreationQuery());
                        stmt.executeUpdate(fournisseur.getCreationQuery());
                        stage.close();
                        
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                        actiontarget.setText("Echec à l'insertion SQL");
                        actiontarget.setFill(Color.FIREBRICK);
                    }finally {
                        if (stmt != null) { 
                            try {
                                stmt.close();
                            } catch (SQLException ex) {
                                System.err.println(ex.getMessage());
                            }
                        }
                    }
                }else{
                    actiontarget.setText("Certain champs sont vide");
                    actiontarget.setFill(Color.FIREBRICK);
                }
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        
        
        Scene scene = new Scene(grid, 400, 400);
        scene.getStylesheets().add(Login.class.getResource("/css/MainCss.css").toExternalForm());
        stage.setScene(scene);
        
        stage.showAndWait();
        refreshList();
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
        Stage stage = new Stage();
        List<TextField> list = new ArrayList<>();
        
        stage.setTitle("Client");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 0, 0, 0));

        
        Text scenetitle = new Text("Nouveau client");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 4, 1);
        scenetitle.setId("title");
        
        
        Label name = new Label("Nom :");
        grid.add(name, 0, 2);

        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 2,3, 1);
        list.add(nameTextField);
        
        Label tel = new Label("Tel :");
        grid.add(tel, 0, 3);

        TextField telTextField = new TextField();
        grid.add(telTextField, 1, 3,3, 1);
        list.add(telTextField);
        
        Label adresseTitle = new Label("Adresse");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        HBox hbAdr = new HBox(10);
        hbAdr.setAlignment(Pos.CENTER);
        hbAdr.getChildren().add(adresseTitle);
        grid.add(hbAdr, 0, 5, 4, 1);
        
        Label numAdrL = new Label("Numero :");
        grid.add(numAdrL, 0, 6);

        TextField numAdr = new TextField();
        grid.add(numAdr, 1, 6);
        list.add(numAdr);
        
        Label libAdrL = new Label("Rue :");
        grid.add(libAdrL, 0, 7);

        TextField libAdr = new TextField();
        grid.add(libAdr, 1, 7,3, 1);
        list.add(libAdr);
        
        Label cdeAdrL = new Label("Code Postal :");
        grid.add(cdeAdrL, 0, 8);

        TextField cdeAdr = new TextField();
        grid.add(cdeAdr, 1, 8);
        list.add(cdeAdr);
        
        Label villeAdrL = new Label("Ville :");
        grid.add(villeAdrL, 0, 9);

        TextField villeAdr = new TextField();
        grid.add(villeAdr, 1, 9,3,1);
        list.add(villeAdr);
       
        
        
        Button cancelBtn = new Button("Annuler");        
        Button validBtn = new Button("Valider");
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 11,2,1);
        actiontarget.setId("actiontarget");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(validBtn);
        grid.add(hbBtn, 3, 11);
        grid.add(cancelBtn, 0, 11);

        
        validBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int cpt = 0;
                
                for (TextField t : list)
                    if(t.getText().isEmpty()){
                        cpt++;
                        t.setStyle("-fx-border-color: firebrick;");
                    }else{
                        t.setStyle("-fx-border-color: white;");
                    }
                    
                if(cpt == 0){
                    //fin + query
                }
                
                actiontarget.setText("Certain champs sont vide");
                actiontarget.setFill(Color.FIREBRICK);
                
            }
        });
        
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        
        Scene scene = new Scene(grid, 400, 400);
        scene.getStylesheets().add(Login.class.getResource("/css/MainCss.css").toExternalForm());
        stage.setScene(scene);
        
        stage.showAndWait();
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
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Ingredients">
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
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Produit">
    @FXML
    public void addProd() throws Exception{
    
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
    
    
    
    public ObservableList<String> selectAllPersonne(){
        
        ObservableList<String> lPersonne = FXCollections.observableArrayList();
        
        String query = "SELECT id_personne, nom_personne, tel_personne FROM PERSONNE";
        
        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Personne p  = new Personne(rs.getInt("id_personne"),rs.getString("nom_personne"), rs.getInt("tel_personne"));
                lPersonne.add(p.toString());
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return lPersonne;
    }  
    public ObservableList<String> selectAllFournisseur(){
        
        ObservableList<String> l = FXCollections.observableArrayList();
        
        String query = "SELECT id_fournisseur, nom_fournisseur, tel_fournisseur FROM FOURNISSEUR";
        
        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Fournisseur f  = new Fournisseur(rs.getInt("id_fournisseur"),rs.getString("nom_fournisseur"), rs.getInt("tel_fournisseur"));
                l.add(f.toString());
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return l;
    }  
    
    
    public void refreshList(){
        ObservableList<String> lCommande = FXCollections.observableArrayList();
        ObservableList<String> lPersonne = selectAllPersonne();
        ObservableList<String> lFournisseur = selectAllFournisseur();
        ObservableList<String> lIngredient = FXCollections.observableArrayList();
        ObservableList<String> lProduit = FXCollections.observableArrayList();
        
        cmdList.setItems(lCommande);
        fourList.setItems(lFournisseur);
        clientList.setItems(lPersonne);
        ingList.setItems(lIngredient);
        prodList.setItems(lProduit);
        
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
}
