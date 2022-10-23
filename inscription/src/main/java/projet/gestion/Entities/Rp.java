package projet.gestion.Entities;

public class Rp extends Users {

    

    public Rp(String login, String password, RoleUser roleUser) {
        super(login, password);
    }

    public Rp(int id, String login, String password, RoleUser roleUser) {
        super(id, login, password, roleUser);
    }

    

    public Rp(){
        roleUser=RoleUser.Rp;
    }
    
}
