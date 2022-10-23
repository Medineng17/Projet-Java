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
import projet.gestion.Core.Fabrique;
import projet.gestion.Entities.Classe;

//Chaque vue est assossié à un controller
public class ClasseController implements Initializable {
    @FXML
    TableView<Classe> tableclasse=new TableView<>();
    @FXML
    TableColumn<Classe,Integer> tableC1=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tableC2=new TableColumn<>();
    @FXML
    TextField libelleid;

    //tableview ne prend pas d'objet de types listes===>mais de type ObservableList
    private  ObservableList obClasses=FXCollections.observableList(Fabrique.getService().selectClasse());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableC1.setCellValueFactory(new PropertyValueFactory<>("id"));
       tableC2.setCellValueFactory(new PropertyValueFactory<>("libelle"));

       tableclasse.setItems(obClasses);
    }
    //Gestion du bouton sur Classe.fxml
    public void buttonCreerClasse(){
        String libelle=libelleid.getText().trim();
        Classe classe = Fabrique.getService().insertClasse(new Classe(libelle));
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion (inscription)");
        alert.setContentText("Reussie");
        alert.show();
        obClasses.add(classe);
        libelleid.clear();
    
}
}
