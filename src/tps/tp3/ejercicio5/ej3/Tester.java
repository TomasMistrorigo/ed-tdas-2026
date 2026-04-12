package tp3.ejercicio5.ej3;

import tp3.ejercicio1.Pila;;

public class Tester {
    public static void main(String[]args){
        Pila<Integer> p1=new Pila<>();
        Pila<Integer> p2=new Pila<>();

        p1.push(1);
        p1.push(2);
        p1.push(3);

        p2.push(4);
        p2.push(5);
        p2.push(6);

        System.out.println("Primer ejemplo...");
        System.out.println("Pila 1: "+p1);
        System.out.println("Pila 2: "+p2);
        System.out.println("Pila intercalada: "+IntercaladorPilas.intercalar(p1, p2));
        
        
        p1.push(1);
        p1.push(2);
        p1.push(3);

        p2.push(4);
        p2.push(5);
        p2.push(6);
        p2.push(1);

        System.out.println("Segundo ejemplo...");
        System.out.println("Pila 1: "+p1);
        System.out.println("Pila 2: "+p2);
        System.out.println("Pila intercalada: "+IntercaladorPilas.intercalar(p1, p2));

    }
}
