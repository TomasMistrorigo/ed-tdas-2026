package tp4.ejercicio3;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class problemaB {
    public static <E> int cantVeces(PositionList<E> l, E e1){
        Iterator<E> it= l.iterator();
        int cant=0;
        while(it.hasNext() && e1!=null){
            E buscador=it.next();
            if(buscador!=null && e1.equals(buscador))
                cant++;
        }
        return cant;
    }
}

/* Utilizando el iterador programado en el TDALista:
Dada una PositionList<E> l y un elemento genérico e1, escriba un método tal que retorne la cantidad de
veces que e1 se encuentra en la lista l. Compare los elementos por equivalencia.
 */