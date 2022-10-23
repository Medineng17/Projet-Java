package projet.gestion.Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mydb implements BaseDonnee {
    protected Connection conn;
    protected PreparedStatement ps;

    @Override
    public void connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gojo", "root", "");

            System.out.println("Connexion reussie");

        } catch (Exception e) {
            System.out.println("Echec de connexion");
            
        }
        
    }

    @Override
    public void deconnexion() {
        if(conn!=null){
            try {
               
                 conn.close();
                
            } catch (SQLException e) {

                 e.printStackTrace();
            }
        }
      }
     
        
        
    }

    

