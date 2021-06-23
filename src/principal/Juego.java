package src.principal;

import static src.dado.Dado.tirarDado;
import src.personajes.*;
import java.util.Scanner;

public class Juego {

    private Heroes[] ejercitoHeroes;
    private Bestias[] ejercitoBestias;
    private final int TAMANIO_EJERCITO =5;
    Scanner teclado = new Scanner(System.in);


    public Juego(){
        ejercitoHeroes = new Heroes[TAMANIO_EJERCITO];
        ejercitoBestias = new Bestias[TAMANIO_EJERCITO];
        iniciarHeroes();
        iniciarBestias();
        bienvenida();
        iniciarJuego();
        System.out.println("Presione ENTER para SALIR");


    }

    public void iniciarJuego(){
        String ganador ="";
        System.out.println("\nVAMOS A EMPEZAR CON LAS PELEAS");
        System.out.println("Quien Ganara?");
        System.out.println("ENTER para continuar");
        teclado.nextLine();

        for(int i=0;i<TAMANIO_EJERCITO;i++){
            System.out.println("\n\n"+(i+1)+" PELEA\n\n");
            pelea(ejercitoHeroes[i], ejercitoBestias[i]);
            ganador(ejercitoHeroes[i], ejercitoBestias[i]);
            System.out.println("Ganador" + ganador(ejercitoHeroes[i], ejercitoBestias[i]));
            teclado.nextLine();

            ganador= elegirGanador(ejercitoHeroes[i], ejercitoBestias[i]);

        }

        //System.out.println("El ejercito ganador es " +ganador);

    }

    public void bienvenida(){
        System.out.println("****************************************************");
        System.out.println("*BIENVENIDO A LA AVENTURA DEL SENIOR DE LOS ANILLOS*");
        System.out.println("****************************************************");
        System.out.println("\n\n");
        System.out.println("Disfrutaras peleas entre 4 de los 5 Ejercitos");
        System.out.println("Hombres se unen a elfos para combatir contra bestias");
        System.out.println("Presiona ENTER para continuar");
        teclado.nextLine();
        iniciarHeroes();
        iniciarBestias();
        System.out.println("Presentando a nuestros HEROES \n\n");
        presentarHeroes();
        System.out.println("ENTER para continuar");
        teclado.nextLine();
        System.out.println("\n\nPresentando a las bestias\n\n");
        presentarBestias();
    }




   /* public void inicioYPresentacion(){
        presentarHeroes();
        presentarBestias();
    }*/

    /*Metodo para crear a los Heroes, se utiliza el random de la clase dado
    y se inicializa cada uno segun el numero

     */
    public void iniciarHeroes(){
        int random=0;
        for (int i = 0; i <TAMANIO_EJERCITO; i++) {
            random = tirarDado(0,2,1);

            switch(random){
                case 0:
                ejercitoHeroes[i] = new Elfo("Elfo "+i);
                break;

                case 1:
                ejercitoHeroes[i] = new Hobbit("Frodo "+i);
                break;

                case 2:
                ejercitoHeroes[i] = new Humano("Humano " +i);
                break;

                default:
                ejercitoHeroes[i] = new Humano("El Bicho "+i);
                break;
            }

        }
    }

    public void presentarHeroes(){
        for (Heroes heroes : ejercitoHeroes) {
            System.out.println(heroes.toString());

        }
    }

    //Inicializamos a las bestias de la misma manera con un for y un random
    public void iniciarBestias(){
        int random=0;
        for (int i = 0; i <TAMANIO_EJERCITO; i++) {
            random = tirarDado(0,1,1);

            switch(random){
                case 0:
                ejercitoBestias[i] = new Orcos("Orco "+i);
                break;

                case 1:
                ejercitoBestias[i] = new Trasgos("Trasgo "+i);
                break;

                default:
                ejercitoBestias[i] = new Orcos("Giamma "+i);
                break;
            }

        }
    }

    public void presentarBestias(){
        for (Bestias bestias : ejercitoBestias) {
            System.out.println(bestias.toString());

        }
    }

    //Metodo que nos sirve para la pelea, aqui se llaman a otros metodos que se explicaran

    public void pelea(Heroes heroe, Bestias bestia){
        System.out.println("\n");
        boolean hayGanador = false;
        int contador =1; //var contador para llevar un conteo de los ciclos
        int ataquePot = especialidadAtaque(heroe, bestia); //aqui almaceno si el ataque del heroe va a estar potenciado segun el metodo
        System.out.println("\n");
        System.out.println("Heroe: "+ heroe.getNombre()+" vida: " +heroe.getVida());
        System.out.println("Contra \nBestia: " +bestia.getNombre()+ " vida: " +bestia.getVida());


            //ciclo while que termina cuando la condicion de que uno de los dos tiene vida menor a cero
            while(!hayGanador){
                System.out.println("\n\n");
                System.out.println("Round: "+contador);
                //llamamos al metodo calcular potencia que nos sirve para saber el ataaque de cada heroe
                int ataqueHeroe = calcularPotenciaOfensiva((heroe.getAtaqueTurno()+ataquePot), bestia.getArmaduraTurno());
                //System.out.println("Ataque del heroe especialidad "+ataqueHeroe);
                int ataqueBestia = calcularPotenciaOfensiva(bestia.getAtaqueTurno(),heroe.getArmaduraTurno());
                System.out.println("Ataque heroe: " +heroe.getNombre()+"= "+ataqueHeroe);
                System.out.println("Ataque Bestia: "+bestia.getNombre()+"= "+ataqueBestia);
                System.out.println("\n");


                //con el setVida cambiamos el valor, le restamos el atque que obtuvimos a la vida del personaje
                heroe.setVida(heroe.getVida()-ataqueBestia);
                bestia.setVida(bestia.getVida() -ataqueHeroe);
                System.out.println("Vida Heroe: "+heroe.getNombre()+" es: " +heroe.getVida() );
                System.out.println("Vida Bestia: "+bestia.getNombre()+ " es: " +bestia.getVida());


                //condicion que nos va a ayudar a determinar si ya hay ganador, si ninguno tiene la vida
                //menor a cero entonces el ciclo continua
                if(heroe.getVida() <0 || bestia.getVida() <0){
                    hayGanador = true;
                }
            contador++;
            teclado.nextLine();
            }

            //ganador(heroe, bestia);


    }


    //Metodo que nos va a imprimir el ganador y nos devuelve el personaje

    public Personaje ganador(Heroes heroe, Bestias bestia){
        if(heroe.getVida()>= bestia.getVida()){
            System.out.println("Heroe:" +heroe.getNombre()+ " Ganador!!");
            heroe.setGanados(heroe.getGanados()+1);
            eliminarPersonaje(bestia);
            return heroe;

            }else{
            System.out.println("La bestia: "+bestia.getNombre() + "GANO");
            bestia.setGanados(bestia.getGanados()+1);
            eliminarPersonaje(heroe);
            return bestia;

            }

    }


    public void eliminarPersonaje(Personaje personaje){
        personaje = null;

    }

    //Este metodo nos ayuda a calcular la potencia ofensiva en cada turno de nuestros personajes


    public int calcularPotenciaOfensiva(int ataque, int defensa){

        //System.out.println("Ataque "+ataque+ ", defensa: "+defensa);

        if(ataque >= defensa){
            ataque = ataque - defensa;
        }else
            ataque =0;

        return ataque;
    }

    //Este metodo nos devuelve un entero con el valor de si existe aumento o decremento
    //de fuerza de un personaje segun su

    public int especialidadAtaque(Heroes heroe, Bestias bestia){
        int disminucion = (int)(heroe.getArmadura()*0.10);
        int ataque =0;

        if(heroe instanceof Elfo && bestia instanceof Orcos){
            System.out.println("Elfo odia a Orcos, elfo incrementa su fuerza");
            //heroe.setAtaque(heroe.getAtaque()+10);
            ataque =10;
            //heroe.setArmadura(heroe.getArmadura()-disminucion);
        }
        if(heroe instanceof Hobbit && bestia instanceof Trasgos){
            System.out.println("Hobbit teme a trasgos, decremento mi fuerza");
            //heroe.setAtaque(heroe.getAtaque()-5);
            ataque=-5;
        }
        if(bestia instanceof Orcos){
            System.out.println("Peleo contra un orco, mi armadura disminuye");
            heroe.setArmadura(heroe.getArmadura() -disminucion);
        }


        return ataque ;

    }

    public String elegirGanador(Heroes heroe, Bestias bestia){
        if(heroe.getGanados() > bestia.getGanados()){
            System.out.println("Ejercito de Heroes ha Ganado");
            return "Puntuacion de " +heroe.getGanados()+ " a: " +bestia.getGanados();
        }else{
            return "Las Bestias han Ganado";
        }

    }


}
