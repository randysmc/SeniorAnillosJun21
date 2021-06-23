package src.personajes;

import static src.dado.Dado.tirarDado;


public class Heroes extends Personaje{

    private static int ataqueMinimo =0;
    private static int ataqueMaximo =100;
    private static final int ARMADURA_MINIMA =50;
    private static int armaduraMax = 70;
    private static int cantDados =2;

    public Heroes(String nombre, int vida) {

        super(nombre, vida, 100, 60, 2, true);
    }

    //@Override
    public int getAtaqueTurno() {
        ataque = tirarDado(Heroes.ataqueMinimo, Heroes.ataqueMaximo, Heroes.cantDados);
        return ataque;
    }

    //@Override
    public int getArmaduraTurno() {
        armadura = tirarDado(Heroes.ARMADURA_MINIMA,Heroes.armaduraMax,Heroes.cantDados);
        return armadura;
    }






}
