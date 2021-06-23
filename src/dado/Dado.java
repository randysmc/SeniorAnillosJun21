package src.dado;

public class Dado {


    public Dado(){

    }

    public static int tirarDado(int valorMenor, int valorMayor, int cantidadDados ){
        int dado = valorMenor;
        int resultado = valorMenor;
        for (int i = 1; i <= cantidadDados; i++) {
            dado =(int) (Math.random()*(valorMayor-valorMenor+1)+valorMenor);
            //System.out.println(dado);

            if (resultado < dado)
                resultado = dado;
        }
        /*if (cantidadDados > 1)
            //if (mostrarMensaje)
            System.out.println("El resultado mayor de los "+cantidadDados + " lanzados es: "+resultado);*/
        return resultado;
    }





}


