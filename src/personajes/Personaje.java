package src.personajes;

public class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int armadura;
    protected int dados;
    protected boolean esHeroe;
    protected int ganados;

    public Personaje(String nombre, int vida, int ataque, int armadura, int dados, boolean esHeroe) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
        this.dados = dados;
        this.esHeroe = esHeroe;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }



    @Override
    public String toString() {
        return "Personaje " + "nombre: " + nombre + "\tvida: " + vida + " ataque= " + ataque + ", armadura: " + armadura +  " esHeroe:" + esHeroe;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int atatque) {
        this.ataque = ataque;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getDados() {
        return dados;
    }

    public void setDados(int dados) {
        this.dados = dados;
    }

    public boolean isEsHeroe() {
        return esHeroe;
    }

    public void setEsHeroe(boolean esHeroe) {
        this.esHeroe = esHeroe;
    }




}
