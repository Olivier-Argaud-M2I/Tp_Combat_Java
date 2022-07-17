package fr.m2i.util;


public class Affichage {


    public static void afficheMenuSelection(){
        separateur();
        formatLigne("                Choissez un type de combatant        ");
        formatLigne("                "+FrontColor.EMMERAUDE.getValue()+"1"+FrontColor.RESET.getValue()+" : Guerrier                                      ");
        formatLigne("                "+FrontColor.EMMERAUDE.getValue()+"2"+FrontColor.RESET.getValue()+" : Sorcier                                       ");
        formatLigne("                "+FrontColor.EMMERAUDE.getValue()+"3"+FrontColor.RESET.getValue()+" : Soigneur                                      ");
    }

    /**
     * affiche un separateur dans la console
     */
    public static void separateur(){
        System.out.println(String.format( FrontColor.JAUNE.getValue()+"/*********************************************************************/"+FrontColor.RESET.getValue()));
    }

    /**
     * affiche un espace dans la console
     */
    public static void espace(){
        formatLigne("");
    }

    /**
     * Met en forme le text passé en parametre avec seprateur et saut de ligne
     * @param message String a mettre en forme
     */
    public static void formatAffichage(String message){
        separateur();
        espace();
        formatLigne(message);
        espace();
    }

    /**
     *  Met en forme sur une ligne le message passsé en parametre
     * @param message String a mettre en forme
     */
    public static void formatLigne(String message ){
        System.out.println(FrontColor.JAUNE.getValue()+"/   "+FrontColor.RESET.getValue()+String.format("%-66s",message) + FrontColor.JAUNE.getValue()+"/"+FrontColor.RESET.getValue());
    }


}
