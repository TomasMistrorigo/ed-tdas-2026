package tp4.ejercicio7;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class test {
    public static void main(String[]args){
        PositionList<Integer> l1=new ListaDoblementeEnlazada<>();
        PositionList<Integer> l2=new ListaDoblementeEnlazada<>();

        l1.addLast(0);
        l1.addLast(1);
        l1.addLast(10);
        l1.addLast(0);
        l1.addLast(2);

        l2.addLast(4);
        l2.addLast(0);
        l2.addLast(10);
        l2.addLast(3);

        for(Integer e:l1){
            System.out.print(e+" ");
        }
        System.out.println();

        ej7.eliminar(l1, l2);
        for(Integer e:l1){
            System.out.print(e+" ");
        }

        System.out.println();
        for(Integer e:l2){
            System.out.print(e+" ");
        }
    }
}
