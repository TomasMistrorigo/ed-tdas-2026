package tp4.ejercicio3;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class testC {
    public static void main(String[]args){
        PositionList<Integer> l=new ListaDoblementeEnlazada<>();
        l.addLast(1);
        l.addLast(1);
        l.addLast(1);
        l.addLast(0);
        l.addLast(0);

        System.out.println(problemaC.estaNveces(l,1,3));
        System.out.println(problemaC.estaNveces(l,1,2));
        System.out.println(problemaC.estaNveces(l,1,4));
        System.out.println(problemaC.estaNveces(l,2,3));
        
    }
}
