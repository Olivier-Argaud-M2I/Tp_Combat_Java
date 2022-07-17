package fr.m2i.model;

import fr.m2i.util.Affichage;
import fr.m2i.util.FrontColor;

import static fr.m2i.util.FonctionUtil.*;

public class Healer extends Personnage{


    private final Integer pvMax = 80;


    public Healer(Integer id) {
        super("La Blanc","Gandalf",80,8);
        this.setId(id);
    }

    public Healer(String nom, String prenom) {
        super(nom, prenom, 80,8);
    }

    @Override
    public void recuperation() {
        int recup = randomMaison(0,2);
        this.setPtnVie(Math.min(this.getPtnVie()+recup,pvMax));
        Affichage.formatLigne(this.getNom()+ " "+ this.getPrenom()+" recupere "+ FrontColor.VERT.getValue() +recup +FrontColor.RESET.getValue()+" point de vie");
    }

    @Override
    public void perteAction() {

    }


    public void attaquer(Personnage cible) {
        super.attaquer(cible);
    }

    public void heal(){
        System.out.println("je soigne");
    }



}
