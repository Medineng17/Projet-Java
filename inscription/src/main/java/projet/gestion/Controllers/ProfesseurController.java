package projet.gestion.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import projet.gestion.Core.Fabrique;
import projet.gestion.Entities.Classe;
import projet.gestion.Entities.Professeur;

//Chaque vue est assossié à un controller
public class ProfesseurController implements Initializable {
    @FXML
    TableView<Professeur> tableid=new TableView<>();
    
    @FXML 
    TableColumn<Professeur,Integer> id1=new TableColumn<>();
    
    @FXML
    TableColumn<Professeur,String> id2=new TableColumn<>();

    @FXML
    TableColumn<Professeur,String> id3=new TableColumn<>();
    @FXML
    TableColumn<Professeur,String> id4=new TableColumn<>();


    @FXML
    TextField nciid;
    @FXML
    TextField nomCompletid;
    @FXML
    TextField gradeid ;
// // tableview ne prend pas d'objet de types listes===>mais de type ObservableList
private  ObservableList obProfesseur=FXCollections.observableList(Fabrique.getService().listeProfesseur());

@Override
public void initialize(URL location, ResourceBundle resources) {
    id1.setCellValueFactory(new PropertyValueFactory<>("id"));
    id2.setCellValueFactory(new PropertyValueFactory<>("Nci"));
    id3.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
    id4.setCellValueFactory(new PropertyValueFactory<>("grade"));
    tableid.setItems(obProfesseur);
}
  
public void ajouter(){
        String nci=nciid.getText().trim();
        String nomcomplet=nomCompletid.getText().trim();
        String grade=gradeid.getText().trim();
        Professeur professeur = Fabrique.getService().ajouterProfesseur(new Professeur(nci,nomcomplet,grade));
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Inscription(Professeur)");
        alert.setContentText("Ajout Reussie");
        alert.show();
        obProfesseur.add(professeur);
        nciid.clear();
        nomCompletid.clear();
        gradeid.clear();
    }

    @FXML
     TableColumn<Classe,Integer> id11;
    @FXML
     TableColumn<Classe,String> id21;
    
     @FXML
     TextField idclasse;

    @FXML
    TextField idprof;
    @FXML
    TableView<Classe> tableid1;

    @FXML
   public void affecter() {
    String entrerprofid=idprof.getText().trim();
    String entrerclasseid=idclasse.getText().trim();
    int resultatprofid = Integer.parseInt(entrerprofid);
    int resultatclasseid = Integer.parseInt(entrerclasseid);
    Professeur profid= Fabrique.getService().filtreProfesseur(resultatprofid);
    Classe classeid= Fabrique.getService().rechercheClasse(resultatclasseid);
    Fabrique.getService().affecterClasseProf(profid, classeid);

    Alert alert=new Alert(AlertType.INFORMATION);
    alert.setTitle("Gestion Inscription(Professeur)");
    alert.setContentText("Affection Reussie");
    alert.show();
    idprof.clear();
    idclasse.clear();
}

    

    @FXML
    Pane pane1,pane2;
    @FXML
    TextField a1,a2; 
    
    public void rechercheridclasse() {
        String clacla =idclasse.getText().trim();
        // convertion id
        int resultatclasseid = Integer.parseInt(clacla);
        Classe cl =Fabrique.getService().rechercheClasse(resultatclasseid);
       if(cl!=null){
          pane2.setDisable(true);
          a2.setText(cl.getLibelle());
       }else{
          pane2.setDisable(false);
          Alert alert=new Alert(AlertType.INFORMATION);
          alert.setTitle("Gestion Inscription(Classe)");
    alert.setContentText("Cet id n'existe pas");
          alert.show();
       }

    }
    @FXML
    public void rechercheridprof() {
        String id =idprof.getText().trim();
        // convertion id
        int resultatprofid = Integer.parseInt(id);
        Professeur prof =Fabrique.getService().filtreProfesseur(resultatprofid);
       if(prof!=null){
        medine(resultatprofid);
          pane1.setDisable(true);
          a1.setText(prof.getNomComplet());
       }else{
          pane1.setDisable(false);
          Alert alert=new Alert(AlertType.INFORMATION);
          alert.setTitle("Gestion Inscription(Classe)");
          alert.setContentText("Cet id n'existe pas?");
          alert.show();
       }
    }
    //Affecter Classe
    public void medine(int id){

     ObservableList obProfesseur=FXCollections.observableList(Fabrique.getService().filtreProfClass(id));

     id11.setCellValueFactory(new PropertyValueFactory<>("id"));
     id21.setCellValueFactory(new PropertyValueFactory<>("libelle"));

     tableid1.setItems(obProfesseur);
    }

}



 

   
    

