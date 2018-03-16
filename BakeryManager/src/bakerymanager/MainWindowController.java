/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
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
        Stage stage = new Stage();
        Login l = new Login();
        l.start(stage);
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
        Stage stage = new Stage();
        stage.setTitle("Produit");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        Text scenetitle = new Text("Nouveau client");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        scenetitle.setId("welcome-text");
        
        
        Label prodName = new Label("Designation :");
        grid.add(prodName, 0, 2);

        TextField prodTextField = new TextField();
        grid.add(prodTextField, 1, 2,3, 1);
        
        Label prix = new Label("Prix (en €):");
        grid.add(prix, 0, 3);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 3,3, 1);

        
        Button cancelBtn = new Button("Cancel");        
        Button validBtn = new Button("Apply");
        
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 4,3,1);
        actiontarget.setId("actiontarget");

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(validBtn);
        grid.add(hbBtn, 3, 4);
        grid.add(cancelBtn, 0, 4);

        
        validBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.err.println("coucou");
            }
        });

        
        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add(Login.class.getResource("/css/Login.css").toExternalForm());
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
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
