package projet.gestion. Entities;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private static int nbre;
    private int id;
    private String libelle;
    private List<Etudiant> etudiants=new ArrayList<>();
    private List<Professeur> professeurs=new ArrayList<>();

   
    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public Classe() {
        nbre++;
        id=nbre;
        
    }
    public Classe(String libelle) {
        this.libelle = libelle;
        nbre++;
        id=nbre;
        
    }
    public static int getNbre() {
        return nbre;
    }
    public static void setNbre(int nbre) {
        Classe.nbre = nbre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    public List<Professeur> getProfesseurs() {
        return professeurs;
    }
    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }
    @Override
    public String toString() {
        return "Classe [id=" + id + ", libellé=" + libelle + "]";
    }

    
    

    

    
    
    
}
