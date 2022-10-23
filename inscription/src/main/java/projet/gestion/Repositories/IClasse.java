package projet.gestion.Repositories;

import java.util.List;

import projet.gestion.Entities.Classe;

public interface IClasse {
    public Classe ajouterClasse(Classe classe);
    public List<Classe> listerClasse();
    public Classe rechercherClasse(int id);
    public List <Classe> filtrerProfParClasse(int id);

    

    
}
