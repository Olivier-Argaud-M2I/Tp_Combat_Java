package fr.m2i.model;

public class Sorcier extends Personnage{

    private Pouvoir pouvoir;

    public Pouvoir getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(Pouvoir pouvoir) {
        this.pouvoir = pouvoir;
    }

    public Sorcier() {
        super("Le Gris","Gandalf",80,8);
        this.setPouvoir(new Pouvoir());
    }

    public Sorcier(Integer id) {
        super("Le Gris","Gandalf",80,8);
        this.setPouvoir(new Pouvoir());
        this.setId(id);
    }

    public Sorcier(String nom, String prenom) {
        super(nom, prenom, 80,8);
        this.setPouvoir(new Pouvoir());
    }

    @Override
    public void recuperation() {
        this.setPtnAction(this.getPtnAction()+this.getPouvoir().getForce());
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
        System.out.println(this.getNom() + " " +this.getPrenom() + " inflige " + degat + " supplementaire avec "+this.getPouvoir().getNom());
    }

    public void perteAction(){
        this.setPtnAction(Math.max(this.getPtnAction() - 5, 0));
    }

}
