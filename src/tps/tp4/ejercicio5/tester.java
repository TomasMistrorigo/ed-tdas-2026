package tp4.ejercicio5;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class tester {
    public static void main(String[]args){
        PositionList<Character> l1=new ListaDoblementeEnlazada<>();
        PositionList<Character> l2=new ListaDoblementeEnlazada<>();

        l1.addLast('a');
        l1.addLast('b');
        l1.addLast('c');
        l1.addLast('a');
        l1.addLast('b');

        l2.addLast('c');
        l2.addLast('c');
        l2.addLast('d');
        l2.addLast('e');
        l2.addLast('a');

        Iterator<Character> it=ej5.eliminados(l1,l2);
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
