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
        initIds();
    }
    
    public void hardResetTable(){
        Stage stage = new Stage();
        stage.setTitle("Connection");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        Text scenetitle = new Text("Attention!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        scenetitle.setId("welcome-text");
        
        
        Label question = new Label("Voulez-vous vraiment supprimer toutes les lignes de la Base de Données ?");
        question.setWrapText(true);
        grid.add(question, 0, 1,3,3);

        Button btn = new Button("Oui");
        

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 2, 5);
        Button abortBtn = new Button("Non");
        grid.add(abortBtn, 0, 5);
        abortBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Statement s = null;
                try {
                    s = connection.createStatement();
                    

                    s.executeUpdate("DELETE FROM FOURNISSEUR;");
                    s.executeUpdate("DELETE FROM PERSONNE;");
                    s.executeUpdate("DELETE FROM ADRESSE;");
                    
                    s.executeUpdate("DELETE FROM PRODUIT;");
                    s.executeUpdate("DELETE FROM INGREDIENT;");
                    s.executeUpdate("DELETE FROM COMMANDE;");
                    s.executeUpdate("DELETE FROM FOURNIR;");
                    s.executeUpdate("DELETE FROM NECESSITER;");
                    s.executeUpdate("DELETE FROM CONSTITUER;");
                    
                    stage.close();
                    refreshList();
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
        });

        
        Scene scene = new Scene(grid, 325, 200);
        scene.getStylesheets().add(Login.class.getResource("/css/Login.css").toExternalForm());
        stage.setScene(scene);
        
        stage.showAndWait();
        
    }
    public void initIds(){
        try {
            // RECUPERER Le nombre maximum des tuples et l'ajouter l'ajout dans chacune des classe
            Statement s = connection.createStatement();
            
            /* Compteur Personne */
            int maxIdPersonne = 0;

            ResultSet rs = s.executeQuery("SELECT MAX(id_personne) AS id FROM PERSONNE;");

            if(!rs.next()){
                rs.beforeFirst();
                maxIdPersonne = rs.getInt("id");
            }
            
            System.out.println("Max id_personne = "+ maxIdPersonne);
        
            rs = s.executeQuery("SELECT MAX(id_fournisseur) AS id FROM FOURNISSEUR;");

            if(!rs.next()){
                rs.beforeFirst();
                if(rs.getInt("id") > maxIdPersonne)
                    maxIdPersonne = rs.getInt("id");
            }
            
            System.out.println("max id keeped : " + maxIdPersonne);
            Personne.compteurPers = maxIdPersonne; // Peut etre remplacer par methode de classe ?
            
            rs = s.executeQuery("SELECT MAX(id_commande) AS n FROM COMMANDE;");
            if(!rs.next()){
                rs.beforeFirst();
                Commande.compteurCom = rs.getInt("n");
            }
            
            rs = s.executeQuery("SELECT MAX(id_produit) AS n FROM PRODUIT;");
            if(!rs.next()){
                rs.beforeFirst();
                Produit.compteurProd = rs.getInt("n");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Commandes">
    @FXML
    public void addCmd(){
        refreshList();
    }
    
    @FXML
    public void modCmd(){
        refreshList();
    }
    
    @FXML
    public void delCmd(){
        String s = (String) cmdList.getSelectionModel().getSelectedItem();
        if(s != null){
            s = s.split(":")[0];
            Statement stmt = null;

            try{
                stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM COMMANDE WHERE id_commande="+s);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }finally{
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        refreshList();
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
        
        refreshList();
    }
    
    @FXML
    public void delFour(){
        String s = (String) fourList.getSelectionModel().getSelectedItem();
        if(s != null){
            s = s.split(":")[0];
            Statement stmt = null;

            try{
                stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM FOURNISSEUR WHERE id_fournisseur="+s);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }finally{
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        refreshList();
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
                        Personne fournisseur = new Personne(name.getText(), Integer.parseInt(tel.getText()), adr);
                        
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
    public void modClient(){
        refreshList();
    }
    
    @FXML
    public void delClient(){
        String s = (String) clientList.getSelectionModel().getSelectedItem();
        if(s != null){
            s = s.split(":")[0];
            Statement stmt = null;

            try{
                stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM PERSONNE WHERE id_personne="+s);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }finally{
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        refreshList();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Ingredients">
    @FXML
    public void addIng(){
        refreshList();
    }
    
    @FXML
    public void modIng(){
        refreshList();
    }
    
    @FXML
    public void delIng(){
        String s = (String) ingList.getSelectionModel().getSelectedItem();
        if(s != null){
            s = s.split(":")[0];
            Statement stmt = null;

            try{
                stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM INGREDIENT WHERE id_ingredient="+s);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }finally{
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        refreshList();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Fonction pour les Produit">
    @FXML
    public void addProd(){
        refreshList();
    }
    
    @FXML
    public void modProd(){
        refreshList();
    }
    
    @FXML
    public void delProd(){
        String s = (String) prodList.getSelectionModel().getSelectedItem();
        if(s != null){
            s = s.split(":")[0];
            Statement stmt = null;

            try{
                stmt = connection.createStatement();
                stmt.executeUpdate("DELETE FROM PRODUIT WHERE id_produit="+s);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }finally{
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        refreshList();
    }
    // </editor-fold>
    
    
    
    public ObservableList<String> selectAllPersonne(){
        
        ObservableList<String> lPersonne = FXCollections.observableArrayList();
        
        String query = "SELECT id_personne, nom_personne, tel_personne FROM PERSONNE";
        
        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Personne p  = new Personne(rs.getInt("id_personne"),rs.getString("nom_personne"), rs.getInt("tel_personne"),new Adresse(rs.getInt("num_rue"),rs.getString("lib_rue"),rs.getInt("cde_postal"),rs.getString("ville")));
                lPersonne.add(p.toString());
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return lPersonne;
    }  
    
    public ObservableList<String> selectAllFournisseur(){
        
        ObservableList<String> l = FXCollections.observableArrayList();
        
        String query = "SELECT id_fournisseur, nom_fournisseur, tel_fournisseur,num_rue,lib_rue,cde_postal,ville FROM FOURNISSEUR";
        
        try (Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Fournisseur f  = new Fournisseur(rs.getInt("id_fournisseur"),rs.getString("nom_fournisseur"), rs.getInt("tel_fournisseur"),new Adresse(rs.getInt("num_rue"),rs.getString("lib_rue"),rs.getInt("cde_postal"),rs.getString("ville")));
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
        refreshList();
    }    
    
    
}
