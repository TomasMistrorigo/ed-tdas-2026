import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp6.ejercicio1.TNodo;

public class Problema3<E> {
    //Dentro del arbol
    public int podarArbol(Position<E> p){
        TNodo<E> nodo=checkPosition(p);
        int resultado;
        
        if(nodo==root){
            resultado=size;
            resultado=size;
            size=0;
            root=null;
        }else{
            resultado=sizeSubArbol(nodo);   //Problema 1
            buscarYEliminar(nodo);
            size=size-resultado;
        }

        return resultado;
    }
    private void buscarYEliminar(TNodo<E> nodo){
        TNodo<E> padre=nodo.getPadre();
        PositionList<TNodo<E>>listaHijos=padre.getHijos();
        Iterator<Position<TNodo<E>>> iteradorPorHijos=listaHijos.positions().iterator();
        boolean encontre=false;
        Position<TNodo<E>> pos=null;
        while(!encontre && iteradorPorHijos.hasNext()){
            pos=iteradorPorHijos.next();
            if(nodo==pos.element()){
                encontre=true;
            }
        }
        if(!encontre) throw new InvalidPositionException("Arbol roto");
        listaHijos.remove(pos);
    }
}
