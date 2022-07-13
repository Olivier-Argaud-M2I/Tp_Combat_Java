package fr.m2i.model;

public class Pouvoir {
    private String nom = "boule de feux";
    private Integer force = 2;

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

    public Pouvoir() {
    }

    public Pouvoir(String nom, Integer force) {
        this.nom = nom;
        this.force = force;
    }
}
