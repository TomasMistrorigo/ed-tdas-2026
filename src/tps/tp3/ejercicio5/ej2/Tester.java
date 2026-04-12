package tp3.ejercicio5.ej2;

import tp3.ejercicio2.Cola;
import tp3.ejercicio5.ej2.Utilidad;

public class Tester {
    public static void main(String[] args){
        Cola<Integer> prueba=new Cola<>();
        prueba.enqueue(1);
        prueba.enqueue(2);
        prueba.enqueue(3);
        prueba.enqueue(4);
        prueba.enqueue(5);
        
        System.out.println("Cola completa...");
        System.out.println(prueba);

        System.out.println();
        System.out.println("Cola de impares...");
        System.out.println(Utilidad.colaImpar(prueba));
    }
}
