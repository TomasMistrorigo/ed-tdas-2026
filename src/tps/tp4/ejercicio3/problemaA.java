package tp4.ejercicio3;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class problemaA {
    public static <E> boolean esta(PositionList<E> l,E e1){
        Iterator<E> it=l.iterator();
        boolean rta=false;
        while(it.hasNext() && !rta && e1!=null){
            E buscador=it.next();
            if(buscador!=null && e1.equals(buscador))
                rta=true;
        }
        return rta;
    }
}

/* Utilizando el iterador programado en el TDALista:
Dada una PositionList<E> l y un elemento genérico e1, escriba un método tal que determine si e1 se
encuentra en la lista l. Compare los elementos por equivalencia.
 */