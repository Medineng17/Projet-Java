package projet.gestion.Repositories;

import java.util.List;

import projet.gestion.Entities.Etudiant;
import projet.gestion.Entities.Inscription;

// import java.util.List;



public interface Iinscription{

    public Inscription inscrireEtudiant(Inscription inscription);

    // public List<Inscription> listerEtudiantInscrit(String annee);

    public List<Etudiant> listerEtudiantInscrit(String annee);

    public List<Etudiant> listerEtudiantInscritAN_Classe(String annee,int id);





}