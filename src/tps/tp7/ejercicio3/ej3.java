package tp7.ejercicio3;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class ej3 {
    public Iterable<Character> expresionAritmetica(BinaryTree<Character> A){
        PositionList<Character> rta=new ListaDoblementeEnlazada<>();
        if(A!=null && !A.isEmpty())
            infija(rta,A,A.root());
        return rta;
    }

    private void infija(PositionList<Character> l,BinaryTree<Character> a, Position<Character> p){
        if(a.hasLeft(p))
            infija(l,a,a.left(p));
        l.addLast(p.element());
        if(a.hasRight(p))
            infija(l,a,a.right(p));
    }
}

/*
Dado un árbol binario A que representa una expresión aritmética, escriba un método
recursivo (es decir, no puede usar los iteradores) que retorne un iterable de caracteres
con la notación infija de la expresión que el árbol representa.
 */