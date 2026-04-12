package tp2.ejercicio4;

import java.util.LinkedList;
import java.util.Queue;

public class Tester {
    public static void main(String[]args){
        Queue<Integer> cola=new LinkedList<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);

        System.out.println("Probando 1er ejemplo...");
        System.out.println();
        System.out.println("Cola antes de buscar el mayor elemento: "+cola);
        System.out.println("Mayor elemento: "+mayorCola.mayorValor(cola));
        System.out.println("Cola despues de buscar el mayor elemento: "+cola);

        cola.add(10);
        cola.add(5);
        cola.add(10);
        cola.add(1);

        System.out.println();
        System.out.println();
        System.out.println("Probando 2do ejemplo...");
        System.out.println();
        System.out.println("Cola antes de buscar el mayor elemento: "+cola);
        System.out.println("Mayor elemento: "+mayorCola.mayorValor(cola));
        System.out.println("Cola despues de buscar el mayor elemento: "+cola);

    }
}
