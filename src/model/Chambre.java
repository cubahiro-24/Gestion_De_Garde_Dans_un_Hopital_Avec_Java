
package model;


public class Chambre {
    private String service,categorie, maladech;
    private int prix, ID, numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public String getIdchambre() {
        return service+" "+categorie+" "+prix;
    }
    public Chambre(int numero, String service, String categorie, int prix)
    {
        this.numero=numero;
        this.service=service;
        this.categorie=categorie;
        this.prix=prix;
        this.maladech= maladech;
    }
    public Chambre()
    {
    }
    
}
