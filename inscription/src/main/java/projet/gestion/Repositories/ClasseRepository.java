package projet.gestion.Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet.gestion.Core.Mydb;
import projet.gestion.Entities.Classe;

public class ClasseRepository extends Mydb implements IClasse{
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`) VALUES (?);";
    private final String SQL_SELECT="SELECT * FROM classe";
    private final String sQL_FILTRER="SELECT * FROM classe where id=?";
    private static final String SQL_FILTERPROFPARCLASSE="select c.* from classe c,professeurclasse pc  where c.id=pc.classeId and pc.professeurId=?";
    
    @Override
    public Classe ajouterClasse(Classe classe) {
        this.connexion();
            
        try {
            //Recuperation de la requette preparer à cause de "?"
        ps= conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        // Recuperation des donnes necessaires 
             ps.setString(1,classe.getLibelle());
              //Resultset methode de bd permet de renvoyer les elements d'une table de bd
             ps.executeUpdate();
             ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                classe.setId(rs.getInt(1));
            }
           

}catch (SQLException e) {
    e.printStackTrace();
}
this.deconnexion();
        return classe;   
    }


    List<Classe> listerClasses=new ArrayList<>();
    @Override
    public List<Classe> listerClasse() {
        this.connexion();

        try {
            //Recuperation de la requette preparer à cause de "?"
        ps= conn.prepareStatement(SQL_SELECT);
        
             ResultSet rs=ps.executeQuery();
            // tant qu'il existe des lignes dans la bd, 
            //on peut continuer à inserer
            while(rs.next()){
                Classe classe =new Classe(rs.getInt("id"),
                rs.getString("libelle"));
                listerClasses.add(classe);
            }
}catch (SQLException e) {
    e.printStackTrace();
}
this.deconnexion();
        return listerClasses;
    }

    @Override
    public Classe rechercherClasse(int id) {
     this.connexion();
     Classe classe=null;
     try {
      
        //Recuperation de la requette preparer à cause de "?"
    ps= conn.prepareStatement(sQL_FILTRER);
    ps.setInt(1, id);
         ResultSet rs=ps.executeQuery();
        // tant qu'il existe des lignes dans la bd, 
        //on peut continuer à inserer
        if(rs.next()){
             classe =new Classe(rs.getInt("id"),
            rs.getString("libelle"));
            
        }
}catch (SQLException e) {
e.printStackTrace();
}
this.deconnexion();

        
        return classe;
    }

    @Override
    public List<Classe> filtrerProfParClasse(int id) {
        List<Classe>  listclasse=new ArrayList<>();
        this.connexion();
    try {
          ps= conn.prepareStatement(SQL_FILTERPROFPARCLASSE) ;
          ps.setInt(1, id); 
          
          
          ResultSet rs=ps.executeQuery();
          Classe classe;

          while(rs.next()){

                
            classe=new Classe(rs.getInt("id"),rs.getString("libelle"));

               listclasse.add(classe);
               
         }
} catch (SQLException e) {
    
    e.printStackTrace();
}

this.deconnexion();
    return listclasse;

}


IProfesseur professeurRepository;
      //Injection de Dependance
      public ClasseRepository(IProfesseur professeurRepository) {
          this.professeurRepository = professeurRepository;
      }



    }
    


 


    