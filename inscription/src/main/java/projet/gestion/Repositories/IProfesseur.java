package projet.gestion.Repositories;

import java.util.List;

import projet.gestion.Entities.Classe;
import projet.gestion. Entities.Professeur;

public interface IProfesseur {
    public Professeur ajouteProfesseur(Professeur professeur);
    public List<Professeur> listerProfesseur();
    public Professeur filtrerProfesseur(int id);
    public void affecterClasseProfesseur(Professeur professeur, Classe classe);
   

    
}
