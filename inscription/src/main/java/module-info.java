//Chargements des dependances

module projet.gestion {
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires de.jensd.fx.glyphs.commons;
    requires transitive javafx.graphics;
    requires transitive javafx.controls; 

    opens projet.gestion.Controllers to javafx.fxml;
    opens projet.gestion to javafx.fxml;
    //toutes les classes se trouvant dans le dossier 
    //projet gestion, faudrait les charger avec 
    exports projet.gestion;
    exports projet.gestion.Entities;
}
