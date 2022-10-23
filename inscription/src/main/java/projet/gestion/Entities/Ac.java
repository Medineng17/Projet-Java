package projet.gestion.Entities;

public class Ac extends Users{


    public Ac(String login, String password, RoleUser roleUser) {
        super(login, password);
    }

    public Ac(int id, String login, String password, RoleUser roleUser) {
        super(id, login, password, roleUser);
    }

    public Ac(){
        roleUser=RoleUser.Ac;

    }
}
