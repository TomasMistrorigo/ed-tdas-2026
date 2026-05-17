package tp6.ejercicio5;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import tp6.ejercicio1.Arbol;

public class tester{
    public static void main(String[]args){
        Tree<Character> t=new Arbol<>();
        t.createRoot('T');
        t.addLastChild(t.root(),'t' );
        t.addLastChild(t.root(), 'o');
        t.addLastChild(t.root(), 't');
        t.addLastChild(t.root(), 'm');
        t.addLastChild(t.root(), 'á');
        t.addLastChild(t.root(), 's');

        System.out.println(ej5.cantEliminados(t, 't'));
        for(Character c:t){
            System.out.print(c+", ");
        }
    }
}