package projet.gestion.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import projet.gestion.App;
import projet.gestion.Entities.RoleUser;

//Chaque vue est assossié à un controller
public class AcceuilController implements Initializable  {
   
    public void buttonDeconnexion(){
        try {
            App.setRoot("Connexion");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
}
@FXML
    AnchorPane AnchorePanecontent;

    @FXML
      Button idc;

    @FXML
     Button ide;

    @FXML
     Button idp;


    private void  loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        AnchorePanecontent.getChildren().clear();
        AnchorePanecontent.getChildren().add(root);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(ConnexionController.user.getRoleUser()==RoleUser.Rp) {
            RP();
        
      }
      else{
        AC();
      }
        
    }
    public void buttonVueClasse() throws IOException{
        this.loadView("Classe");
    }

    

    public void buttonVueEtudiant() throws IOException{
        this.loadView("Etudiant");
       

    }

    public void buttonVueProfesseur() throws IOException{
        this.loadView("Professeur");

    }
    public void AC(){
        ide.setDisable(false);
    }
    public void RP(){
        idc.setDisable(false);
        idp.setDisable(false);

    }

    

}
