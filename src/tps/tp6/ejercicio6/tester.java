package tp6.ejercicio6;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import tp6.ejercicio1.Arbol;

public class tester {
    public static void main(String[]args){
        Tree<Integer> t=new Arbol<>();
        t.createRoot(1);
        t.addLastChild(t.root(), 1);
        t.addLastChild(t.root(), 3);
        t.addLastChild(t.root(), 0);
        t.addLastChild(t.root(), 2);
        t.addLastChild(t.root(), 3);
        t.addLastChild(t.root(), 7);

        System.out.println(ej6.pertenece(t, 0));
        System.out.println(ej6.pertenece(t, 6));
    }
}
