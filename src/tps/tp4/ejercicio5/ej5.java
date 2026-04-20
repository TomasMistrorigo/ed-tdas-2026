package tp4.ejercicio5;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class ej5 {
    public static Iterator<Character> eliminados(PositionList<Character> l1, PositionList<Character> l2){
        PositionList<Character> eliminados=new ListaDoblementeEnlazada<>();
        if(l1!=null && l2!=null){
            for(Character elementL1:l1){
                for(Position<Character> elementL2:l2.positions()){
                    if(elementL1==elementL2.element()){
                        eliminados.addLast(elementL1);
                        l2.remove(elementL2);
                    }
                }
            }
        }
        return eliminados.iterator();
    }
}

/*
Escriba un método tal que dadas dos PositionList<Character> l1 y l2 elimine de l2 todos los elementos que también
están en l1. Este método debe retornar un iterable con todos los elementos eliminados.
 */