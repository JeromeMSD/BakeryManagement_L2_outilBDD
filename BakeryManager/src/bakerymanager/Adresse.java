/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

/**
 *
 * @author jeromem
 */
public class Adresse {
    private int numRue;
    private String libRue;
    private int codePostal;
    private String ville;

    public Adresse(int numRue, String libRue, int codePostal, String ville) {
        this.numRue = numRue;
        this.libRue = libRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
    public Adresse(String libRue, int codePostal, String ville) {
        this(1,libRue,codePostal, ville);
    }
    
    
    public Adresse(int numRue, String libRue, String ville) {
        this(numRue,libRue,0, ville);
    }

    public Adresse(String libRue, String ville) {
        this(1,libRue,0,ville);
    }
    
    
    
}
