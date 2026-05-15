import ar.edu.uns.cs.ed.tdas.Position;
import tp6.ejercicio1.TNodo;

public class Problema1<E> {

    //Lo siguiente iria dentro del arbol
    public int sizeSubarbol(Position<E> p){
        TNodo<E> nodo=checkPosition(p);

        return sizeSubArbolCont(nodo);
    }
    private int sizeSubArbolCont(TNodo<E> nodo){
        int resultado=1;

        for(TNodo<E> hijo:nodo.getHijos()){
            resultado= resultado+sizeSubArbolCont(hijo);
        }

        return resultado;
    }
}
