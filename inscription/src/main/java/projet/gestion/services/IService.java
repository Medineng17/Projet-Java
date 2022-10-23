package projet.gestion.services;

import java.util.List;

import projet.gestion.Entities.Classe;
import projet.gestion.Entities.Etudiant;
import projet.gestion.Entities.Inscription;
import projet.gestion. Entities.Professeur;
import projet.gestion.Entities.Users;

public interface IService {
    public Classe insertClasse(Classe classe);
    public List<Classe> selectClasse();
    public Classe rechercheClasse(int id);
    public List<Etudiant> selectEtudiant();
    public Etudiant insertEtudiant(Etudiant etudiant);
    public List<Professeur> listeProfesseur();
    public Users seConnecter(String login, String password);
    public void affecterClasseProf(Professeur professeur,Classe classe);
    public Professeur ajouterProfesseur(Professeur professeur);
    public Professeur filtreProfesseur(int id);
    public List<Classe>filtreProfClass(int id);
    public Inscription inscrireEtudiant(Inscription inscription);
    public Etudiant filtreEtudiant(int id);
    public Etudiant filtrerEtudiantParNom(String nomComplet);
    public List<Etudiant> listeEtudiantInscrit(String annee);
    public List<Etudiant> listeEtudiantInscritAN_Classe(String annee,int id);


    
    
}
