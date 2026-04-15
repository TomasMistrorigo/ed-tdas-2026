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

        
        System.out.println("Pila intercalada 1: ");
        Pila<Integer> intercaladas=IntercaladorPilas.intercalar(p1, p2);
        while(intercaladas.size()>0){
            System.out.println(intercaladas.pop());
        }
        
        
        p1.push(1);
        p1.push(2);
        p1.push(3);

        p2.push(4);
        p2.push(5);
        p2.push(6);
        p2.push(1);

        System.out.println("Pila intercalada 2: ");
        intercaladas=IntercaladorPilas.intercalar(p1, p2);
        while(intercaladas.size()>0){
            System.out.println(intercaladas.pop());
        }

    }
}
