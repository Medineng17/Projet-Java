package projet.gestion.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projet.gestion.App;
import projet.gestion.Core.Fabrique;
import projet.gestion.Entities.Users;

public class ConnexionController implements Initializable{
    public static Users user;
    @FXML
Text lblError;
    @FXML
TextField txtlogin;
    @FXML
PasswordField txtpassword;
    


@Override
    public void initialize(URL location, ResourceBundle resources) {
        lblError.setVisible(false);
    }

public void ButtonConnexion() throws IOException{
    String login =txtlogin.getText().trim(); 
        String password =txtpassword.getText().trim();
    lblError.setVisible(true);
     user= Fabrique.getService().seConnecter(login, password);

    if(user==null){
        lblError.setVisible(true);
    }

    else{
        lblError.setVisible(false);
        App.setRoot("Acceuil");
    }

    


}

}