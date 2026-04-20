package tp4.ejercicio3;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class testA {
    public static void main(String[]args){
        PositionList<Integer> l1=new ListaDoblementeEnlazada<>();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);

        Integer e=2;

        System.out.println(problemaA.esta(l1, e));

        System.out.println(problemaA.esta(l1,4));

        System.out.println(problemaA.esta(l1, null));

    }
}
