package tp7.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Position;

public class BTNodo<E> implements Position<E> {
    private E elem;
    private BTNodo<E> padre;
    private BTNodo<E> hi;
    private BTNodo<E> hd;

    public BTNodo(E e,BTNodo<E> p){
        elem=e;
        padre=p;
        hi=null;
        hd=null;
    }
    public BTNodo(E e){ this(e,null);}

    //getters
    @Override
    public E element(){return elem;}
    public BTNodo<E> getPadre(){return padre;}
    public BTNodo<E> getHijoIzq(){return hi;}
    public BTNodo<E> getHijoDer(){return hd;}

    //setters
    public void setElement(E e){elem=e;}
    public void setPadre(BTNodo<E> p){padre=p;}
    public void setIzquierdo(BTNodo<E> i){hi=i;}
    public void setDerecho(BTNodo<E> d){hd=d;}
}
