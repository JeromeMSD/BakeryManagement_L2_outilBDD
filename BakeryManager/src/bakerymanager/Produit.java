package bakerymanager;

/**
 *
 * @author Nicolas
 */
//Classe Produit, mais j'ai pas voulu modifié ton taff 
public class Produit {
    private int idProduit;
    public static int compteurProd = 0;
    private String nomProd;
    private float prix;
    private int qte;

    public Produit (String nomProd, float prix, int qte){
        compteurProd ++;
        this.idProduit = compteurProd;
        this.nomProd = nomProd;
        this.prix=prix;
        this.qte=qte;
    }

    public Produit(int idProduit, String nomProduit, float prixProduit, int qteProduit) {
        this.idProduit = idProduit;
        this.nomProd = nomProduit;
        this.prix = prixProduit;
        this.qte = qteProduit;
    }
    
    @Override
    public String toString () {
        return this.idProduit+": "+this.nomProd+"("+this.qte+") ->"+this.prix;
    }

    public String getCreationQuery() {
        return "INSERT INTO PRODUIT VALUES("+this.getId()+",'"+this.nomProd+"',"+this.prix+","+this.qte+");";
    }
    
    public int getId() {
        return this.idProduit;
    }

    public int getQuantite() {
        return this.qte;
    }
}
