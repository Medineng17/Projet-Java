package projet.gestion. Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet.gestion.Core.Mydb;
import projet.gestion.Entities.Etudiant;

public class EtudiantRepository extends Mydb implements IEtudiant {
    // private List<Etudiant>etudiants=new ArrayList<>();
        private final String SQL_SELECT="SELECT * FROM etudiant";
        private final String SQL_INSERT="INSERT INTO etudiant('matricule','nomComplet','tuteur') values(???)";
        private final String SQL_FILTER="SELECT* FROM etudiant where id=?";
        private static final String SQL_SELECT_BY_NOM="select * from etudiant where nomComplet=? ";

        @Override
        public List<Etudiant> listerEtudiant() {
            this.connexion();
            
            try {
                //Recuperation de la requette preparer à cause de "?"
            ps= conn.prepareStatement(SQL_SELECT);
            
                 ResultSet rs=ps.executeQuery();
                // tant qu'il existe des lignes dans la bd, 
                //on peut continuer à inserer
                while(rs.next()){
                    Etudiant etudiant =new Etudiant(rs.getInt("id"),
                    rs.getString("matricule"),rs.getString("nomComplet"),rs.getString("tuteur"),rs.getString("classe"));
                    listerEtudiant().add(etudiant);
                }
    }catch (SQLException e) {
        e.printStackTrace();
    }
    this.deconnexion();
            return listerEtudiant();
        

           
        }

        @Override
        public Etudiant ajouterEtudiant(Etudiant etudiant) {
            this.connexion();

            try {
                //Recuperation de la requette preparer à cause de "?"
            ps= conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            // Recuperation des donnes necessaires 
                 ps.setString(1,etudiant.getMatricule());
                  //Resultset methode de bd permet de renvoyer les elements d'une table de bd
                 ps.executeUpdate();
                 ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    etudiant.setId(rs.getInt(1));
                }
               
    
    }catch (SQLException e) {
        e.printStackTrace();
    }
    this.deconnexion();
            return etudiant;   
        }

        @Override
        public Etudiant filtrerEtudiant(int id) {
            this.connexion();
            Etudiant etudiant=null;
            try {
             
               //Recuperation de la requette preparer à cause de "?"
           ps= conn.prepareStatement(SQL_FILTER);
           ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();
               // tant qu'il existe des lignes dans la bd, 
               //on peut continuer à inserer
               if(rs.next()){
                    etudiant =new Etudiant(rs.getInt("id"),
                   rs.getString("matricule"),rs.getString("nomComplet"),rs.getString("tuteur"));
                   
               }
       }catch (SQLException e) {
       e.printStackTrace();
       }
       this.deconnexion();
       
               
               return etudiant;
           }

          


    // methode Sup

    @Override
    public Etudiant filterEtudiantParNom(String nomComplet) {
        Etudiant etudiantUser=null;
        this.connexion();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NOM);
            ps.setString(1,nomComplet);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                etudiantUser=new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nomComplet"),
                    rs.getString("tuteur"),
                    rs.getString("matricule"));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        this.deconnexion();
        return etudiantUser;
    }

   

    
    }
            
        


    

    

    
    

