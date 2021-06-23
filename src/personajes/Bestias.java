package src.personajes;

import static src.dado.Dado.tirarDado;

//import src.dado.*;

public class Bestias  extends Personaje{

    private static int ataqueMinimo =0;
    private static int ataqueMaximo =90;
    private static final int ARMADURA_MINIMA =50;
    private static int armaduraMax = 70;
    private static int cantDados =1;


    public Bestias(String nombre, int vida) {
        super(nombre, vida, Bestias.ataqueMaximo, Bestias.armaduraMax, Bestias.cantDados, false);
    }



    public int getArmaduraTurno() {
        armadura = tirarDado(Bestias.ARMADURA_MINIMA,Bestias.armaduraMax,Bestias.cantDados);
        return armadura;
    }


    public int getAtaqueTurno() {
        ataque = tirarDado(Bestias.ataqueMinimo, Bestias.ataqueMaximo,Bestias.cantDados);
        return ataque;
    }








}
