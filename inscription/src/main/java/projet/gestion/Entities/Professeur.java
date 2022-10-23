package projet.gestion.Entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private static int nbre;
    private int id;
    private String nci;
    private String nomComplet;
    private String grade;
    private List<Classe>classe=new ArrayList<>();

    public Professeur(int id, String nci, String nomComplet, String grade) {
        this.id = id;
        this.nci = nci;
        this.nomComplet = nomComplet;
        this.grade = grade;
    }

    public Professeur() {
        nbre++;
        id= nbre;
    }

    public Professeur(String nci, String nomComplet, String grade) {
        this.nci = nci;
        this.nomComplet = nomComplet;
        this.grade = grade;
        id++;
        nbre= id;
    }

    

    public static int getNbre() {
        return nbre;
    }

    public static void setNbre(int nbre) {
        Professeur.nbre = nbre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Classe> getClasse() {
        return classe;
    }

    public void setClasse(List<Classe> classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Professeur [id=" + id + ", nci=" + nci + ", nomComplet=" + nomComplet + ", grade=" + grade + "]";
    }

}
