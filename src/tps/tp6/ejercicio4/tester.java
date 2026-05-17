package tp6.ejercicio4;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import tp6.ejercicio1.Arbol;

public class tester {
    public static void main(String[]args){
        Tree<String> t=new Arbol<>();
        t.createRoot("TM");
        t.addFirstChild(t.root(), "TMN");
        t.addFirstChild(t.root(), "no");
        t.addFirstChild(t.root(), "TM");
        t.addFirstChild(t.root(), "T");

        for(Position<String> i:ej4.itPosString(t, "TM")){
            System.out.println(i.element());
        }
    }
}
