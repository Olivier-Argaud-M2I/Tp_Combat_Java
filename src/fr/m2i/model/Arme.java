package fr.m2i.model;

public class Arme {
    private String nom = "épé";
    private Integer force = 3;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Arme() {
    }

    public Arme(String nom, Integer force) {
        this.nom = nom;
        this.force = force;
    }

}
