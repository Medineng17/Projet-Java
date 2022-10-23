package projet.gestion. Entities;

public class Inscription {
    private static int nbre;
    private int id;
    private String date;
    private Classe classe;
    private Etudiant etudiant;
    

    public Inscription() {
        id++;
        nbre= id;
    }

    public Inscription(String date, Classe classe, Etudiant etudiant) {
        this.date = date;
        this.classe = classe;
        this.etudiant = etudiant;
        id++;
        nbre= id;
    }

    

    public static int getNbre() {
        return nbre;
    }



    public static void setNbre(int nbre) {
        Inscription.nbre = nbre;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getDate() {
        return date;
    }



    public void setDate(String date) {
        this.date = date;
    }



    public Classe getClasse() {
        return classe;
    }



    public void setClasse(Classe classe) {
        this.classe = classe;
    }



    public Etudiant getEtudiant() {
        return etudiant;
    }



    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }



    @Override
    public String toString() {
        return "Inscription [id=" + id + ", date=" + date + "]";
    }

   
    

   

    



    

    

    

    
    
}
