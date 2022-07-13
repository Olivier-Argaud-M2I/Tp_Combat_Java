package fr.m2i;

import fr.m2i.model.Guerrier;
import fr.m2i.model.Healer;
import fr.m2i.model.Personnage;
import fr.m2i.model.Sorcier;

import static fr.m2i.util.FonctionUtil.*;

public class Combat {

    private static Integer id = 0;

    public Combat(){

        Personnage perso1 = creationPerso();
        Personnage perso2 = creationPerso();

        do{

            int choix  = randomMaison(0,1);
            System.out.println("  ");
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


        }while(perso1.getPtnVie()>=0 && perso2.getPtnVie()>=0);


        if(perso1.getPtnVie()<=0){
            perso2.crierVictoire();
            perso1.pleurerDefaite();
        }
        else{
            perso1.crierVictoire();
            perso2.pleurerDefaite();
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
