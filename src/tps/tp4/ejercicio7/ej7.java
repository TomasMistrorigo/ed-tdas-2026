package tp4.ejercicio7;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;;

public class ej7 {
    public static <E> void eliminar(PositionList<E> L1,PositionList<E> L2){
        if(L1!=null && L2!=null){
            for(Position<E> posl1:L1.positions()){
                Iterator<E> itl2=L2.iterator();
                boolean esta=false;
                while(itl2.hasNext() && !esta){
                    if(posl1.element()==itl2.next()){
                        L1.remove(posl1);
                        esta=true;
                    }
                }
            }
        } 
        if(L2!=null){
            Position<E> inicio=L2.last();
            Position<E> fin=L2.first();
            while(inicio!=null){
                L1.addLast(inicio.element());
                inicio= (inicio==fin) ?
                        null : L2.prev(inicio);
            }
        }   

    }
}
/*
Implemente un método eliminar(L1,L2), que modifique la lista L1 de la siguiente manera: primero deberá eliminar de
la misma todas las apariciones de los elementos contenidos en L2, luego deberá insertar al final de la misma todos
los elementos de L2 pero en orden inverso al que aparecen en L2. Puede considerar que L2 no tiene elementos
repetidos. No se debe modificar el estado interno de la lista L2.
 */