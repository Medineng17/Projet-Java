package projet.gestion.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import projet.gestion.Core.Mydb;
import projet.gestion.Entities.RoleUser;
import projet.gestion.Entities.Users;

public class UsersRepository extends Mydb implements IUsers{
    private final String SQL_CONNECT="SELECT * FROM user WHERE login like ? and password like ?";

    @Override
    public Users seConnecter(String login, String password) {
        Users user= null;
        this.connexion();
        try{
            ps= conn.prepareStatement(SQL_CONNECT) ;
            ps.setString(1, login); 
            ps.setString(2, password); 
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user=new Users(
                    rs.getInt("id"),  
                    rs.getString("login"),
                     rs.getString("password"),
                     rs.getString("role").compareTo("Ac")==0? RoleUser.Ac:RoleUser.Rp
                     );
            
        }

  } catch (SQLException e) {
      
      e.printStackTrace();
  }

  this.deconnexion();
  return user;

}
}

    

