package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class testD {
    public static void main(String[]args){
        PositionList<Character> p=new ListaDoblementeEnlazada<>();
        p.addLast('a');
        p.addLast('b');
        p.addLast('a');
        p.addLast('c');
        p.addLast('d');
        p.addLast('b');

        Map<Character,Integer> rta=ejD.cantApariciones(p);
        for(Entry<Character,Integer> e:rta.entries()){
            System.out.print("("+e.getKey()+","+e.getValue()+"), ");
        }
    }
}
