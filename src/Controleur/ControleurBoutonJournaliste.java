package src.Controleur;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import src.Modele.*;
import src.Vue.*;

public class ControleurBoutonJournaliste implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurBoutonJournaliste(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        /* textBouton = this.vueJO.getSource().getText();
        if (textBouton.equals("....")) {
            
        }
        */
    }
}