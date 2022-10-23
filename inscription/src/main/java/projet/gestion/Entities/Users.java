package projet.gestion.Entities;

public class Users {
    protected int id;
    protected String login;
    protected String password;
    protected RoleUser roleUser;

    
    public Users(String login, String password) {
        this.login = login;
        this.password = password;
        roleUser = RoleUser.Rp;
    }

    public Users(int id, String login, String password, RoleUser roleUser) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleUser=roleUser;
    }

    public Users() {
        roleUser=RoleUser.Rp;
    }


    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public RoleUser getRoleUser() {
        return roleUser;
    }
    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

   
    


    
}
