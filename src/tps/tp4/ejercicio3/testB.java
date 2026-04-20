package tp4.ejercicio3;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class testB {
    public static void main(String[]args){
        PositionList<Integer> l=new ListaDoblementeEnlazada<>();
        l.addLast(1);
        l.addLast(0);
        l.addLast(1);
        l.addLast(0);
        l.addLast(1);

        System.out.println(problemaB.cantVeces(l, null));
        System.out.println(problemaB.cantVeces(l, 1));
        System.out.println(problemaB.cantVeces(l, 0));
        System.out.println(problemaB.cantVeces(l, 3));

    }
}
