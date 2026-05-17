package tp6.ejercicio5;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

public class ej5 {
    public static <E> int cantEliminados(Tree<E> a,E e){
        int rta=0;
        if(a!=null && !a.isEmpty() && e!=null){
            for(Position<E> p: a.positions()){
                if(p.element().equals(e)){
                    rta++;
                    a.removeNode(p);
                }
            }
        }
        return rta;
    }
}

/*
Escriba un método tal que dado un árbol genérico a y un elemento e, elimine de a todas las apariciones de e.
Compare los elementos por equivalencia. El método debe retornar la cantidad de eliminaciones realizadas
 */