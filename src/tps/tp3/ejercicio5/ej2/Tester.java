package tp3.ejercicio5.ej2;

import tp3.ejercicio2.Cola;

public class Tester {
    public static void main(String[] args){
        Cola<Integer> prueba=new Cola<>();
        prueba.enqueue(1);
        prueba.enqueue(2);
        prueba.enqueue(3);
        prueba.enqueue(4);
        prueba.enqueue(5);

        System.out.println("Cola de impares...");
        Cola<Integer> impares= Utilidad.colaImpar(prueba);
        while(impares.size() > 0){
            System.out.println(impares.dequeue());
        }
    }
}
