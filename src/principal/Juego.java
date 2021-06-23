package src.principal;

import personajes.*;

/**
 *
 * @author randysmc
 */
public class Juego {

    private Heroes[] ejercitoHeroes;
    private Bestias[] ejercitoBestias;


    public static void main(String[] args) {
        Juego j = new Juego();
    }
    public Juego(){
        Orcos orco1 = new Orcos("Jose");


        System.out.println("Armadura: " +orco1.getArmadura());
        System.out.println("Ataque: "+orco1.getAtaque());
        System.out.println(orco1.toString());


    }

}

