package projet.gestion.Repositories;

import java.util.List;

import projet.gestion.Entities.Etudiant;

public interface IEtudiant {
    public List<Etudiant> listerEtudiant();
    public Etudiant ajouterEtudiant(Etudiant etudiant);
    public Etudiant filtrerEtudiant(int id);
    public Etudiant filterEtudiantParNom(String nomComplet);
    
    
}
