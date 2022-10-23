package projet.gestion.Entities;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private static int nbre;
    private int id;
    private String matricule;
    private String nomComplet;
    private String tuteur;
    private List <Classe> Classe = new ArrayList<>();
    private List<Inscription> Inscription= new ArrayList<>();


    public Etudiant(int id, String matricule, String nomComplet, String tuteur, String string) {
        this.id = id;
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
       
    }

    public Etudiant() {
        id++;
        nbre=id;
    }
    public Etudiant(String matricule, String nomComplet, String tuteur) {
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
    }

    public Etudiant(int id, String matricule, String nomComplet, String tuteur) {
        this.id = id;
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
    }

    public static int getNbre() {
        return nbre;
    }

    public static void setNbre(int nbre) {
        Etudiant.nbre = nbre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public List<Classe> getClasse() {
        return Classe;
    }

    public void setClasse(List<Classe> classe) {
        Classe = classe;
    }

    public List<Inscription> getInscription() {
        return Inscription;
    }

    public void setInscription(List<Inscription> inscription) {
        Inscription = inscription;
    }

    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", matricule=" + matricule + ", nomComplet=" + nomComplet + ", tuteur=" + tuteur
                + "]";
    }

    

    
   

    
    
}
