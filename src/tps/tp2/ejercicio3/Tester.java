package tp2.ejercicio3;

import java.util.Stack;

public class Tester {
    public static void main(String[]args){
        Stack<Integer> p1=new Stack<>();
        Stack<Integer> p2=new Stack<>();

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
