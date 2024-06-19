import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VueAppliJO extends Application {

    private Scene mainScene;
    
    private Scene Accueil;
    private BorderPane rootAccueil;
    private Scene pageConnexion;
    private BorderPane rootConnexion;

    private Scene pageInscription;
    private BorderPane rootInscription; 

    private Scene pageAccueilAdmin;
    private BorderPane rootAAdmin;

    private Scene pageAdmin;
    private BorderPane rootAdmin;
    
    private Scene pageJournaliste;
    private BorderPane rootJournaliste;

    private Scene pageJAthlete;
    private BorderPane rootJAthlete;
    
    private Scene pageJEpreuve;
    private BorderPane rootJEpreuve;

    private Scene pageJIAthlete;
    private BorderPane rootJIAthlete;
    
    private Scene pageJIEpreuve;
    private BorderPane rootJIEpreuve;
    
    private Scene pageJIPays;
    private BorderPane rootJIPays;
  
    private Scene pageJISport;
    private BorderPane rootJISport;

    private Scene pageJPays;
    private BorderPane rootJPays;

    private Scene pageJSport;
    private BorderPane rootJSport;

    private Scene pageOrganisateur;
    private BorderPane rootOrganisateur;

    private Scene pageOrganisateurAcceuil;
    private BorderPane rootOrganisateurAcceuil;

    private Stage stageVue;
    private BorderPane root;
    private FXMLLoader loader;

    private ConnexionMySQL connexionMySQL;
    private OutilsRequete outils;
    private String role=null;
    
    @Override
    public init(){
        ControleurBoutonAccueil crtlBA = new ControleurBoutonAccueil(this);
        //ControleurConnexion crtlCo = new ControleurConnexion(this);
        ControleurDeconnexion crtlDeco = new ControleurDeconnexion(this);
        ControleurBoutonJournaliste crtlBJ = new ControleurBoutonJournaliste(this);
        ControleurRetour crtlRetour = new ControleurRetour(this);
        ControleurInscription crtlIn = new ControleurInscription(this);
        ControleurOrganisateur crtlOrga = new ControleurOrganisateur(this);
        ControleurHome crtlHome = new ControleurHome(this);

        this.connexionMySQL=new ConnexionMySQL();
        this.outils=new OutilsRequete(connexionMySQL);
    }

    public VueAppliJO() {
        super();
    }

    public String getRole() {
        return this.role;
    }

    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
  
    public void pageAccueil() {
        this.stageVue.setScene(mainScene);
    }

    public void pageConnexion() {
        this.stageVue.setScene(pageConnexion);
    }

    public void pageInscription() {
        this.stageVue.setScene(pageInscription);
    }

    public void pageOrganisateur() {
        this.stageVue.setScene(pageOrganisateurAcceuil);
        this.role = "Organisateur";
    }

    @Override
    public void start(Stage stage) throws Exception{
        this.stageVue = stage;


        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAccueil.fxml"));
        this.rootAccueil = loader.load();
        this.mainScene = new Scene(rootAccueil); 

        Button bPageC = (Button) mainScene.lookup("#page_connexion");
        Button bPageI = (Button) mainScene.lookup("#page_inscription");
        bPageC.setOnAction(crtlBA);
        bPageI.setOnAction(crtlBA);

        this.loader = new FXMLLoader(this.getClass().getResource("page_connexion.fxml"));
        this.rootConnexion = loader.load();
        this.pageConnexion = new Scene(rootConnexion);

        Button bRetourC = (Button) pageConnexion.lookup("#retour");
        Button bConnexion = (Button) pageConnexion.lookup("#connexion");

        bRetourC.setOnAction(crtlRetour);
        // bConnexion.setOnAction(crtlCo);

        this.loader = new FXMLLoader(this.getClass().getResource("page_inscription.fxml"));
        this.rootInscription = loader.load();
        this.pageInscription = new Scene(rootInscription);

        Button bRetourI = (Button) pageInscription.lookup("#retour");
        Button bInscription = (Button) pageInscription.lookup("#inscription");

        bRetourI.setOnAction(crtlRetour);
        bInscription.setOnAction(crtlIn);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAdministrateur.fxml"));
        this.rootAdmin = loader.load();
        this.pageAdmin = new Scene(rootAdmin);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournaliste.fxml"));
        this.rootJournaliste = loader.load();
        this.pageJournaliste = new Scene(rootJournaliste);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteAthlete.fxml"));
        this.rootJAthlete = loader.load();
        this.pageJAthlete = new Scene(rootJAthlete);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoAthlete.fxml"));
        this.rootJIAthlete = loader.load();
        this.pageJIAthlete = new Scene(rootJIAthlete);


        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteEpreuve.fxml"));
        this.rootJEpreuve = loader.load();
        this.pageJEpreuve = new Scene(rootJEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoEpreuve.fxml"));
        this.rootJIEpreuve = loader.load();
        this.pageJIEpreuve = new Scene(rootJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalistePays.fxml"));
        this.rootJPays = loader.load();
        this.pageJPays = new Scene(rootJPays);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoPays.fxml"));
        this.rootJIPays = loader.load();
        this.pageJIPays = new Scene(rootJIPays);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteSport.fxml"));
        this.rootJSport = loader.load();
        this.pageJSport = new Scene(rootJSport);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoSport.fxml"));
        this.rootJISport = loader.load();
        this.pageJISport = new Scene(rootJISport);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaOrganisateur.fxml"));
        this.rootOrganisateur = loader.load();
        this.pageOrganisateur = new Scene(rootOrganisateur);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaOrganisateurAccueil.fxml"));
        this.rootOrganisateurAcceuil = loader.load();
        this.pageOrganisateurAcceuil = new Scene(rootOrganisateurAcceuil);

        Button bdeco = (Button) pageOrganisateurAcceuil.lookup("#deconnexion");
        Button bhomeOrga = (Button) pageOrganisateurAcceuil.lookup("#home");
        //Button bfiltre = (Button) pageOrganisateurAcceuil.lookup("#filtre");
        //Button brecherche = (Button) pageOrganisateurAcceuil.lookup("#recherche");

        bdeco.setOnAction(crtlDeco);
        bhomeOrga.setOnAction(crtlHome);

        this.stageVue.setScene(pageOrganisateurAcceuil);
        this.stageVue.setTitle("- Jeux IUT'Olympiques -");
        this.stageVue.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}