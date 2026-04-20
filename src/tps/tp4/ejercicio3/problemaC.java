package tp4.ejercicio3;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class problemaC {
    public static <E> boolean estaNveces(PositionList<E> l, E x, int n){
        int cant=0;
        Iterator<E> it=l.iterator();
        while(it.hasNext() && cant<=n){
            E buscador=it.next();
            if(buscador==x)
                cant++;
        }
        return cant>=n;
    }
}

/* Utilizando el iterador programado en el TDALista:
Dada una PositionList<E> l, un elemento genérico x y un entero n, retorne verdadero si y sólo si el elemento x
se encuentra en la lista l al menos n veces. Compare los elementos por identidad.
*/