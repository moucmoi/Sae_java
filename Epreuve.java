import java.util.List;
import java.util.ArrayList;

public class Epreuve {
    private String nomEpreuve;
    private boolean homme;
    private boolean individuel;
    private Sport sport;

    public Epreuve(String nomEpreuve, boolean homme, boolean individuel){
        this.nomEpreuve = nomEpreuve;
        this.homme = homme;
        this.individuel = individuel;
        this.sport = new ArrayList<>();
    }

    public String getNom(){
        return this.nomEpreuve;
    }

    public boolean getHomme(){
        return this.homme;
    }

    public boolean getIndividuel(){
        return this.individuel;
    }

    public Sport getSport(){
        return this.sport;
    } 

    @Override

    public String toString(){
        return "Epreuve :" + this.nomEpreuve + "homme :" + this.homme + "/n" + "individuel" + 
            this.individuel + "sport :" + this.sport;
    }
}
