package tp4.ejercicio4;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class repetidor {
    public static <E> PositionList<E> elementos(PositionList<E> l){
        PositionList<E> lNueva = new ListaDoblementeEnlazada<E>();
        for(E element:l){
            lNueva.addLast(element);
            lNueva.addLast(element);
        }
        return lNueva;
    }
}

/*
Escriba un método tal que dada una PositionList<E> l, retorne una nueva lista que tenga los elementos de l en el
mismo orden pero repetidos. Por ejemplo:
Si l=[a, b, c, d] el método deberá retornar lNueva=[a, a, b, b, c, c, d, d]
Para resolver este ejercicio deberá utilizar la sentencia for-each.
 */
