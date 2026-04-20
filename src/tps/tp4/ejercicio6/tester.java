package tp4.ejercicio6;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class tester {
    public static void main(String[]args){
        PositionList<Integer> l1=new ListaDoblementeEnlazada<>();
        PositionList<Integer> l2=new ListaDoblementeEnlazada<>();

        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);

        l2.addLast(0);
        l2.addLast(0);

        for(Integer element:ejA.intercalador(null, l2)){
            System.out.print(element+" ");
        }
    }
}
