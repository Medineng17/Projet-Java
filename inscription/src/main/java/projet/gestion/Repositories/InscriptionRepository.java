package projet.gestion.Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projet.gestion.Core.Mydb;
import projet.gestion.Entities.Etudiant;
import projet.gestion.Entities.Inscription;




public class InscriptionRepository extends Mydb implements Iinscription{
    
    private final String  SQL_INSERT_INS="insert into inscription(date_inscription,classe_id,user_id) values(?,?,?)";
     ///private final String SQL_INSCR_ANNEE= "SELECT * FROM inscription` WHERE `date_inscription` LIKE ?";
    private final String SQL_INSCR_ANNEE="select e.* from utilisateurs e,inscription i  where e.id=i.user_id and i.date_inscription=?";
    private final String SQL_INSCR_AN_CLASSE="select e.* from utilisateurs e,inscription i  where e.id=i.user_id and i.date_inscription=? and i.classe_id=?";


    IEtudiant etudiantRepository=new EtudiantRepository();
    IProfesseur professeurRepository=new ProfesseurRepository();
    IClasse classeRepository=new ClasseRepository(professeurRepository);
   

    @Override
    public Inscription inscrireEtudiant(Inscription inscription) {
       
        this.connexion();
        try {
            ps=conn.prepareStatement(SQL_INSERT_INS,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,inscription.getDate());
            ps.setInt(2,inscription.getClasse().getId());
            ps.setInt(3, inscription.getEtudiant().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                inscription.setId(rs.getInt(1));
            }
        // System.out.println("ajout top");
        
        }catch (SQLException e) {
            
                e.printStackTrace();
            }
       
       this.deconnexion();
        return inscription;
    }


    @Override
        public List<Etudiant> listerEtudiantInscrit(String annee) {
        List<Etudiant>  listetudiant=new ArrayList<>();
            this.connexion();
        try {
              ps=conn.prepareStatement(SQL_INSCR_ANNEE) ;
              ps.setString(1, annee); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                Etudiant etudiant  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nom_complet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiant.add(etudiant);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.deconnexion();
            return listetudiant;
    }


    @Override
    public List<Etudiant> listerEtudiantInscritAN_Classe(String annee, int id) {
        List<Etudiant>  listetudiantclasse=new ArrayList<>();
            this.connexion();
        try {
              ps= conn.prepareStatement(SQL_INSCR_AN_CLASSE) ;
              ps.setString(1, annee); 

              ps.setInt(2, id); 
              
              
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){

                
                
                Etudiant etudiants  =new Etudiant
                (rs.getInt("id"),
                rs.getString("nomComplet"),
                rs.getString("tuteur"),
                rs.getString("matricule"));


                listetudiantclasse.add(etudiants);
                       
                 }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.deconnexion();
        return listetudiantclasse;
    }


    


    
    }


    // @Override
    // public List<Inscription> listerEtudiantInscrit(String a) {

    //     List<Inscription> inscriptionAn = new ArrayList<>();

    //     this.ouvertureConnexion();
    //     try {
            
    //        ps = conn.prepareStatement(SQL_INSCR_ANNEE);
    //        ps.setString(1, a+"%");
    //        ResultSet rs = ps.executeQuery();

    //        while(rs.next()){

    //         Inscription inscription = new Inscription(rs.getInt("id"),
    //         rs.getString("date_inscription"),

    //        classeRepository.rechercherClassebyid(rs.getInt("classe_id")),

    //        etudiantRepository.filterEtudiantParId(rs.getInt("user_id"))
    //        );

    //            inscriptionAn.add(inscription);
    //    }
    //     } catch (SQLException e) {
    //     e.printStackTrace();
    //     }

    //         this.fermetureConnexion();
    //     return inscriptionAn;
        
    // }
    

