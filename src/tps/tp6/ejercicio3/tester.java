package tp6.ejercicio3;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp6.ejercicio1.Arbol;

public class tester {
    public static void main(String[]args){
        Tree<Character> t=new Arbol<>();
        t.createRoot('a');

        Map<Character,Integer> m=ej3.cantidadRepeticiones(t);
        for(Entry<Character,Integer> e:m.entries()){
            System.out.print("("+e.getKey()+","+e.getValue()+"), ");
        }

        t.addFirstChild(t.root(), 'b');
        t.addFirstChild(t.root(), 'c');
        t.addFirstChild(t.root(), 'b');
        t.addFirstChild(t.root(), 'd');
        t.addFirstChild(t.root(), 'c');

        System.out.println();
        m=ej3.cantidadRepeticiones(t);
        for(Entry<Character,Integer> e:m.entries()){
            System.out.print("("+e.getKey()+","+e.getValue()+"), ");
        }

    } 
}
