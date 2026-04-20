package tp4.ejercicio6;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;


public class ejA {
    public static <E> PositionList<E> intercalador(PositionList<E> L1,PositionList<E> L2){
        PositionList<E> rta=new ListaDoblementeEnlazada<>();
        
        if(L1==null || L2==null){
            throw new NullPointerException("No puedo intercalar con una lista vacia");
        }
        
        Iterator<E> it1=L1.iterator();
        Iterator<E> it2=L2.iterator();
        while(it1.hasNext() || it2.hasNext()){
            if(it1.hasNext())
                rta.addLast(it1.next());
            if(it2.hasNext())
                rta.addLast(it2.next());
        }
        return rta;
    }
}

/*
Escriba un método que tenga como entrada dos listas genéricas L1 y L2 y retorne una nueva lista resultante de la
intercalación de ambas.
Tener en cuenta que las listas pueden tener distintas longitudes
 */