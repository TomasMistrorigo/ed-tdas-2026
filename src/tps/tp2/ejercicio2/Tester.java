package tp2.ejercicio2;

import java.util.LinkedList;
import java.util.Queue;

public class Tester {
    public static void main(String[] args){
        Queue<Integer> prueba=new LinkedList<>();
        prueba.add(1);
        prueba.add(2);
        prueba.add(3);
        prueba.add(4);
        prueba.add(5);
        
        System.out.println("Cola completa...");
        System.out.println(prueba);

        System.out.println();
        System.out.println("Cola de impares...");
        System.out.println(Utilidad.colaImpar(prueba));
    }
}
