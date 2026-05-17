package tp6.ejercicio4;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class ej4 {
    public static Iterable<Position<String>> itPosString(Tree<String> a, String s){
        PositionList<Position<String>> rta=new ListaDoblementeEnlazada<>();
        if(a!=null && !a.isEmpty()){
            itStringPostOrden(a, rta, a.root(), s);
        }
        return rta;
    }

    private static void itStringPostOrden(Tree<String> t, PositionList<Position<String>> l, Position<String> p, String s){
        for(Position<String> e:t.children(p)){
            itStringPostOrden(t, l, e, s);
        }
        
        if(p.element().equals(s))
            l.addLast(p);
    }
}

/*
Dado un árbol a de Strings y un String s, programe un método tal que retorne un Iterable con las
posiciones del árbol en las que aparece el String s. Para resolver este problema implemente un recorrido en
postorden.
 */