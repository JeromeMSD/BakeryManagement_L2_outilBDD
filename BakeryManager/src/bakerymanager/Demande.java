/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.util.converter.DateTimeStringConverter;

/**
 *
 * @author Nicolas
 */
public class Demande extends ObjectE {
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    private Client client;
    private int heureAppel;
    private int minAppel;
    private String demande;
    private Date jourAppel;
            
    
    public Demande (Client client, Date jourAppel, int heureAppel, int minAppel, String demande){
        this.client=client;
        this.heureAppel=heureAppel;
        this.minAppel=minAppel;
        this.demande=demande;
        this.jourAppel=jourAppel;
    }
    
    public Client getClient(){
        return this.client;
    }
    
    public int getHeureAppel(){
        return this.heureAppel;
    }
    
    public int getMinAppel(){
        return this.minAppel;
    }
    
    public String getDemande(){
        return demande;
    }
    
    @Override
    public String toString(){
        return this.client.toString()+"|"+format.format(jourAppel)+"|"+this.heureAppel+"|"+this.minAppel+"|"+this.demande;
    }
    
    public String toSave(){
        return this.client.toString()+";"+format.format(jourAppel)+";"+this.heureAppel+";"+this.minAppel+";"+this.demande;
    }
}

