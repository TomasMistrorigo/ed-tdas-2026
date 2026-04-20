package tp4.ejercicio4;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class tester {
    public static void main(String[]args){
        PositionList<Character> l=new ListaDoblementeEnlazada<>();
        l.addLast('a');
        l.addLast('b');
        l.addLast('c');
        l.addLast('d');

        for(Character c:l){
            System.out.print(c+" ");
        }

        System.out.println();

        for(Character c:repetidor.elementos(l)){
            System.out.print(c+" ");
        }
    }
}
