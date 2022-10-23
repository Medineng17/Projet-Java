package projet.gestion.Core;


import projet.gestion.Repositories.ClasseRepository;
import projet.gestion.Repositories.EtudiantRepository;
import projet.gestion.Repositories.IClasse;
import projet.gestion.Repositories.IEtudiant;
import projet.gestion.Repositories.IProfesseur;
import projet.gestion.Repositories.IUsers;
import projet.gestion.Repositories.ProfesseurRepository;
import projet.gestion.Repositories.UsersRepository;
import projet.gestion.services.IService;
import projet.gestion.services.Service;

public class Fabrique {
    public static IService getService(){

    

    
       IProfesseur professeurRepository=new  ProfesseurRepository();
       IClasse classeRepository=new ClasseRepository(professeurRepository);
       IEtudiant etudiantRepository=new  EtudiantRepository();
       IUsers userRepository= new UsersRepository();
       return new Service(classeRepository,etudiantRepository,professeurRepository,userRepository);
}
}
