package tp6.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class TNodo<E> implements Position<E>{
    private E elem;
    private TNodo<E> padre;
    private PositionList<TNodo<E>> hijos;

    public TNodo(E e,TNodo<E> p){
        elem=e;
        padre=p;
        hijos=new ListaDoblementeEnlazada<TNodo<E>>();
    }

    public TNodo(E e){this(e,null);}

    //getters
    @Override
    public E element(){return elem;}
    
    public TNodo<E> getPadre(){return padre;}
    public PositionList<TNodo<E>> getHijos(){return hijos;}

    //setters
    public void setElement(E e){elem=e;}
    public void setPadre(TNodo<E> p){padre=p;}
}
