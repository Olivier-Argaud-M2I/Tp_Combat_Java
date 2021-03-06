package fr.m2i.model;

import fr.m2i.util.Affichage;
import fr.m2i.util.FrontColor;

public class Guerrier extends Personnage{

    private Arme arme;

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }


    public Guerrier(Integer id) {
        super("Barbare","Conan",100,0);
        this.setArme(new Arme());
        this.setId(id);
    }

    public Guerrier(String nom, String prenom) {
        super(nom, prenom, 100,0);
        this.setArme(new Arme());
    }

    @Override
    public void recuperation() {
        this.setPtnAction(this.getPtnAction()+this.getArme().getForce());
        Affichage.formatLigne(this.getNom()+ " "+ this.getPrenom()+" recupere " +FrontColor.EMMERAUDE.getValue()+this.getArme().getForce()+ FrontColor.RESET.getValue() +" points d'action");
    }

    @Override
    public void perteAction(){
        this.setPtnAction(Math.max(this.getPtnAction() - 5, 0));
    }


    public void attaquer(Personnage cible) {
        super.attaquer(cible);
        if(this.getPtnAction()>3){
            attaqueBonus(cible);
            this.perteAction();
        }
    }

    private void attaqueBonus(Personnage cible){
        int degat = (int)(Math.random()*5)+1;
        cible.ptnVie -= degat;
        Affichage.formatLigne(this.getNom() + " " +this.getPrenom() + " inflige " + FrontColor.ROUGE.getValue() + degat +FrontColor. RESET.getValue() + " supplementaire avec "+this.getArme().getNom());
    }



}
