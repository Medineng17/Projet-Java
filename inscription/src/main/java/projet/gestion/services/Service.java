package projet.gestion.services;

import java.util.List;

import projet.gestion.Entities.Classe;
import projet.gestion. Entities.Etudiant;
import projet.gestion.Entities.Inscription;
import projet.gestion. Entities.Professeur;
import projet.gestion.Entities.Users;
import projet.gestion.Repositories.ClasseRepository;
import projet.gestion. Repositories.EtudiantRepository;
import projet.gestion.Repositories.IClasse;
import projet.gestion.Repositories.IEtudiant;
import projet.gestion.Repositories.Iinscription;
import projet.gestion.Repositories.IProfesseur;
import projet.gestion.Repositories.IUsers;
import projet.gestion.Repositories.ProfesseurRepository;

public class Service implements IService{
    
    IClasse classeRepository;
    IEtudiant etudiantRepository;
   Iinscription inscriptionRepository;
    IProfesseur professeurRepository;
    IUsers userRepository;
    

    public Service(IClasse classeRepository, IEtudiant etudiantRepository,IProfesseur professeurRepository,IUsers userRepository)
             {
        this.classeRepository = classeRepository;
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
        this.userRepository = userRepository;
        this.inscriptionRepository= inscriptionRepository;
    }

    @Override
    public Classe insertClasse(Classe classe) {
        return classeRepository.ajouterClasse(classe);
    }

    @Override
    public List<Classe> selectClasse() {
        return classeRepository.listerClasse();
        
    }
    @Override
    public Classe rechercheClasse(int id) {
       
        return classeRepository.rechercherClasse(id);
    }
    // public Professeur insertProfesseur(Professeur professeur){
    // return professeurRepository.insert(professeur);
    // }

    @Override
    public List<Etudiant> selectEtudiant() {

        return etudiantRepository.listerEtudiant();
    }

    @Override
    public List<Professeur> listeProfesseur() {
        return professeurRepository.listerProfesseur();
    }

    @Override
    public Etudiant insertEtudiant(Etudiant etudiant) {
        return etudiantRepository.ajouterEtudiant(etudiant);
        
    }
    @Override
    public Users seConnecter(String login, String password) {
        return userRepository.seConnecter(login,password); 
    }
    @Override
    public void affecterClasseProf(Professeur professeur,Classe classe) {
        professeurRepository.affecterClasseProfesseur(professeur, classe);
        
    }
    @Override
    public Professeur ajouterProfesseur(Professeur professeur) {
        return professeurRepository.ajouteProfesseur(professeur);
    }

    @Override
    public Professeur filtreProfesseur(int id) {
        
        return professeurRepository.filtrerProfesseur(id);
    }

    @Override
    public List<Classe> filtreProfClass(int id) {
        //
        return classeRepository.filtrerProfParClasse(id);
    }

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
        
        return inscriptionRepository.inscrireEtudiant(inscription);
    }

    @Override
    public Etudiant filtreEtudiant(int id) {

        return etudiantRepository.filtrerEtudiant(id);
    }

    @Override
    public Etudiant filtrerEtudiantParNom(String nomComplet) {
       
        return etudiantRepository.filterEtudiantParNom(nomComplet);
    }

    @Override
    public List<Etudiant> listeEtudiantInscrit(String annee) {
        
        return inscriptionRepository.listerEtudiantInscrit(annee);
    }

    @Override
    public List<Etudiant> listeEtudiantInscritAN_Classe(String annee, int id) {

        return inscriptionRepository.listerEtudiantInscritAN_Classe(annee, id);
    }

}
