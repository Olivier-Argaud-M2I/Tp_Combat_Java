package fr.m2i.model;

import fr.m2i.util.Affichage;
import fr.m2i.util.CharArt;

public abstract class Personnage {

    protected String nom;
    protected String prenom;
    protected Integer ptnVie;
    protected Integer ptnAction;
    protected Integer id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getPtnVie() {
        return ptnVie;
    }

    public void setPtnVie(Integer ptnVie) {
        this.ptnVie = ptnVie;
    }

    public Integer getPtnAction() {
        return ptnAction;
    }

    public void setPtnAction(Integer ptnAction) {
        this.ptnAction = ptnAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personnage() {
    }


    public Personnage(String nom, String prenom, Integer ptnVie, Integer ptnAction) {
        this.nom = nom;
        this.prenom = prenom;
        this.ptnVie = ptnVie;
        this.ptnAction = ptnAction;
    }

    public void attaquer(Personnage cible){
        cible.ptnVie -= 5;
        Affichage.formatLigne(this.getPrenom() +" " +this.getNom() + " attaque " + cible.getNom() + " " + cible. getPrenom() +" et lui inflige 5 degats");
    };

    public void status(){
        Affichage.formatLigne(this.getPrenom() +" " +this.getNom()+ " a " + this.getPtnVie()
                +" pdv et " +this.getPtnAction() + " pa");
//        System.out.println(this.getPrenom() +" " +this.getNom()+ this.getId() + " a " + this.getPtnVie()
//                +" pdv et " +this.getPtnAction() + " pa");
    }

    public void crierVictoire(){
        Affichage.formatLigne(this.getNom()+" "+this.getPrenom()+" a gagné  :D");
//        System.out.println(this.getNom()+" "+this.getPrenom()+this.getId()+" a gagné  :D");
        new CharArt("VICTOIRE " +getPrenom().toUpperCase());
    }

    public void pleurerDefaite(){
        Affichage.formatLigne(this.getNom()+" "+this.getPrenom()+" a perdu");
//        System.out.println(this.getNom()+" "+this.getPrenom()+this.getId()+" a perdu");
    }

    public abstract void recuperation();
    public abstract void perteAction();

}
