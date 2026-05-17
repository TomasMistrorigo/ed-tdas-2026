package tp6.ejercicio6;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

public class ej6 {
    public static boolean pertenece(Tree<Integer> a, int n){
        boolean esta=false;
        if(a!=null && !a.isEmpty()){
            for(int i:a){
                if(i==n){
                    esta=true;
                    break;
                }
            }
        }
        return esta;
    }
}

/*
Dado un árbol de enteros a y un entero n, escriba un método que determine si n pertenece al árbol a. Para
resolver este método utilice el iterador del árbol.
 */