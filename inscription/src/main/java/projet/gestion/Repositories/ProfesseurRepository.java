package projet.gestion.Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet.gestion.Core.Mydb;
import projet.gestion.Entities.Classe;
import projet.gestion.Entities.Professeur;

public class ProfesseurRepository extends Mydb implements IProfesseur {
    private final String SQL_SELECT="SELECT * from professeur"; 
    private final String SQL_INSERT="INSERT INTO professeur(nci,nomComplet,grade)values(?,?,?)";
    private final String SQL_FILTRER="SELECT* FROM professeur where id=?";
    private final String SQL_AFFECT="INSERT INTO professeurclasse (professeurId,classeId)values(?,?)";
    
    // private List<Professeur>professeurs= new ArrayList<>();

   List<Professeur>listProfesseur= new ArrayList<>();
    @Override
    public List<Professeur> listerProfesseur() {
        this.connexion();

        try {
            //Recuperation de la requette preparer à cause de "?"
        ps= conn.prepareStatement(SQL_SELECT);
        
             ResultSet rs=ps.executeQuery();
            // tant qu'il existe des lignes dans la bd, 
            //on peut continuer à inserer
            while(rs.next()){
                Professeur professeur =new Professeur(rs.getInt("id"), rs.getString("nci"),rs.getString("nomComplet"),rs.getString("grade"));
                listProfesseur.add(professeur);
            }
}catch (SQLException e) {
    e.printStackTrace();
}
this.deconnexion();
        return listProfesseur;
    }

    
    @Override
    public Professeur ajouteProfesseur(Professeur professeur) {
        this.connexion();
        try {
            //Recuperation de la requette preparer à cause de "?"
        ps= conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        // Recuperation des donnes necessaires 
             ps.setString(1,professeur.getNci());
             ps.setString(2,professeur.getNomComplet());
             ps.setString(3,professeur.getGrade());
              //Resultset methode de bd permet de renvoyer les elements d'une table de bd
             ps.executeUpdate();
             ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                professeur.setId(rs.getInt(1));
            }
           

}catch (SQLException e) {
    e.printStackTrace();
}
this.deconnexion();
        return professeur;   
    }


    @Override
    public Professeur filtrerProfesseur(int id) {
        this.connexion();
            Professeur professeur=null;
            try {
             
               //Recuperation de la requette preparer à cause de "?"
           ps= conn.prepareStatement(SQL_FILTRER);
           ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();
               // tant qu'il existe des lignes dans la bd, 
               //on peut continuer à inserer
               if(rs.next()){
                    professeur =new Professeur(rs.getInt("id"),
                   rs.getString("nci"),rs.getString("nomComplet"),rs.getString("grade"));
                   
               }
       }catch (SQLException e) {
       e.printStackTrace();
       }
       this.deconnexion();
       
               
               return professeur;
           }


    @Override
    public void affecterClasseProfesseur(Professeur professeur, Classe classe) {
        this.connexion();
            
        try {
            //Recuperation de la requette preparer à cause de "?"
        ps= conn.prepareStatement(SQL_AFFECT, PreparedStatement.RETURN_GENERATED_KEYS);
        // Recuperation des donnes necessaires 
             ps.setInt(1,professeur.getId());
             ps.setInt(2,classe.getId());
              //Resultset methode de bd permet de renvoyer les elements d'une table de bd
             ps.executeUpdate();
            

}catch (SQLException e) {
    e.printStackTrace();
}
this.deconnexion();
          
    }
        
    }

    
        
    

       



   

   



    
