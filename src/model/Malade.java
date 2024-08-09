
package model;


public class Malade {
    private String nom,prenom,adresse,nationalite,genre;
    private int malCh, id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMalCh() {
        return malCh;
    }

    public void setMalCh(int ID) {
        this.malCh = malCh;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Malade(String nom, String prenom, String adresse, String nationalite, String genre, int chamb)
    {
        
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.nationalite=nationalite;
        this.genre=genre;
        this.malCh=malCh;
    }
    public Malade()
    {
    }
    
}
