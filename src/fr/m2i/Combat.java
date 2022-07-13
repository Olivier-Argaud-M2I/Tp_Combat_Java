package fr.m2i;

import fr.m2i.model.Guerrier;
import fr.m2i.model.Healer;
import fr.m2i.model.Personnage;
import fr.m2i.model.Sorcier;
import fr.m2i.util.Affichage;

import static fr.m2i.util.FonctionUtil.*;

public class Combat {

    private static Integer id = 0;

    public Combat(){

//        Personnage perso1 = creationPerso();
//        Personnage perso2 = creationPerso();

        Personnage perso1 = CreationPerso.createPerso();
        Personnage perso2 = CreationPerso.createPerso();


        do{
            Affichage.separateur();
            Affichage.espace();
            int choix  = randomMaison(0,1);
            if(choix ==0 ){
                perso1.attaquer(perso2);
            }
            else{
                perso2.attaquer(perso1);
            }

            perso1.recuperation();
            perso2.recuperation();
            perso1.status();
            perso2.status();

            Affichage.espace();

        }while(perso1.getPtnVie()>=0 && perso2.getPtnVie()>=0);

        Affichage.separateur();
        Affichage.espace();

        if(perso1.getPtnVie()<=0){
            perso1.pleurerDefaite();
            perso2.crierVictoire();
        }
        else{
            perso2.pleurerDefaite();
            perso1.crierVictoire();
        }



    }


    public Personnage creationPerso(){
        id++;
        Personnage perso;
        switch (randomMaison(0,2)){

            case 1:
                perso = new Guerrier(id);
                break;
            case 2:
                perso = new Sorcier(id);
                break;
            default:
                perso =new Healer(id);
        }
        return perso;
    }

}
