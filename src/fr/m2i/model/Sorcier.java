package fr.m2i.model;

import fr.m2i.util.Affichage;
import fr.m2i.util.FrontColor;

public class Sorcier extends Personnage{

    private Pouvoir pouvoir;

    public Pouvoir getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(Pouvoir pouvoir) {
        this.pouvoir = pouvoir;
    }


    public Sorcier(Integer id) {
        super("Le Gris","Gandalf",80,0);
        this.setPouvoir(new Pouvoir());
        this.setId(id);
    }

    public Sorcier(String nom, String prenom) {
        super(nom, prenom, 80,0);
        this.setPouvoir(new Pouvoir());
    }

    @Override
    public void recuperation() {
        this.setPtnAction(this.getPtnAction()+this.getPouvoir().getForce());
        Affichage.formatLigne(this.getNom()+ " "+ this.getPrenom()+" recupere " +FrontColor.EMMERAUDE.getValue()+this.getPouvoir().getForce()+ FrontColor.RESET.getValue() +" points d'action");
    }


    public void attaquer(Personnage cible) {
        super.attaquer(cible);
        if(this.getPtnAction()>3){
            attaqueBonus(cible);
            this.perteAction();
        }
    }

    private void attaqueBonus(Personnage cible){
        int degat = (int)(Math.random()*10)+1;
        cible.ptnVie -= degat;
        Affichage.formatLigne(this.getNom() + " " +this.getPrenom() + " inflige " + FrontColor.ROUGE.getValue() + degat +FrontColor. RESET.getValue() + " supplementaire avec "+this.getPouvoir().getNom());
    }

    public void perteAction(){
        this.setPtnAction(Math.max(this.getPtnAction() - 5, 0));
    }

}
