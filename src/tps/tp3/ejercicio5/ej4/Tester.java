package tp3.ejercicio5.ej4;

import tp3.ejercicio2.Cola;

public class Tester {
    public static void main(String[]args){
        Cola<Integer> cola=new Cola<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);

        System.out.println("Probando 1er ejemplo...");
        System.out.println();
        System.out.println("Mayor elemento: "+mayorCola.mayorValor(cola));
        System.out.println("Cola despues de buscar el mayor elemento: ");
        while(cola.size()>0){
            System.out.print(cola.dequeue());
        }

        cola.enqueue(10);
        cola.enqueue(5);
        cola.enqueue(10);
        cola.enqueue(1);

        System.out.println();
        System.out.println();
        System.out.println("Probando 2do ejemplo...");
        System.out.println();
        System.out.println("Mayor elemento: "+mayorCola.mayorValor(cola));
        System.out.println("Cola despues de buscar el mayor elemento: ");
        while(cola.size()>0){
            System.out.print(cola.dequeue());
        }
    }
}
