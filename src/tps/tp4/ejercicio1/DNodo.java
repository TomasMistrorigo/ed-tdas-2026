package tp4.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Position;
public class DNodo<E> implements Position<E>{
    protected E element;
    protected DNodo<E> next;
    protected DNodo<E> prev;

    public DNodo(E e){
        element=e;
        next=null;
        prev=null;
    }

    public E getElement(){return element;}
    public void setElement(E element){
        this.element=element;
    }

    public DNodo<E> getNext(){return next;}
    public void setNext(DNodo<E> e){
        next=e;
    }

    public DNodo<E> getPrev(){return prev;}
    public void setPrev(DNodo<E> e){
        prev=e;
    }

    @Override
    public E element(){return element;}
}
