package tp7.ejercicio4;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;

public class ej4 {
    public static <E> void completarDerechos(E r,BinaryTree<E> t){
        if(t==null || t.isEmpty()) throw new EmptyTreeException("t esta vacio");
        derechos(t.root(),r,t);
    }
    
    private static <E> void derechos(Position<E> p, E e, BinaryTree<E> t){
        if(t.hasLeft(p))
            derechos(t.left(p),e,t);
        if(t.hasRight(p))
            derechos(t.right(p),e,t);
        if(t.hasLeft(p) && !t.hasRight(p))
            t.addRight(p,e);
    }
}
/*
Escriba un método cuya signatura sea: public void completarDerechos(E r, BinaryTree<E> t)
tal que agregue como hijos derechos (de aquellos nodos que solo tengan hijo izquierdo) nodos con rótulos r.
Este método deberá lanzar EmptyTreeException en caso de que el árbol t se encuentre vacío.
 */