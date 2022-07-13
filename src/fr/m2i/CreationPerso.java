package fr.m2i;

import fr.m2i.model.Guerrier;
import fr.m2i.model.Healer;
import fr.m2i.model.Personnage;
import fr.m2i.model.Sorcier;
import fr.m2i.util.Affichage;
import fr.m2i.util.SaisieConsole;

public class CreationPerso {

    public static Personnage createPerso(){
       Personnage perso = null;

        SaisieConsole saisie = new SaisieConsole();
        Integer choix = null;
        String nom;
        String prenom;

        // on affiche le menu de selection
        Affichage.afficheMenuSelection();
        // on appel la method entier() de notre instance saisie jusqu'a avoir une saisie valide
        while(choix==null || choix<1 || choix>4){
            choix = saisie.entier();
            if(choix==null || choix<1 || choix>4){
                Affichage.formatLigne("saisie non valide ( entre 1 et 3 )");
            }
        }

        Affichage.formatLigne("Veuillez entrer le Nom de votre personnage");
        nom = saisie.text();

        Affichage.formatLigne("Veuillez entrer le Prenom de votre personnage");
        prenom = saisie.text();

        switch (choix){
            case 1:
                perso = new Guerrier(nom, prenom);
                break;
            case 2:
                perso = new Sorcier(nom, prenom);
                break;
            case 3:
                perso = new Healer(nom, prenom);
                break;
        }

        return perso;
    }
}
