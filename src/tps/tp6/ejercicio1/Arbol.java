package tp6.ejercicio1;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class Arbol<E> implements Tree<E>{
    protected TNodo<E> raiz;
    protected int size;

    public Arbol(){
        raiz=null;
        size=0;
    }

    @Override
    public int size(){return size;}

    @Override
    public boolean isEmpty(){return size==0;}

    @Override
    public Iterator<E> iterator(){
        PositionList<E> rta=new ListaDoblementeEnlazada<>();
        if(!isEmpty()){
            preOrden(raiz,rta);
        }
        return rta.iterator();
    }

    private void preOrden(TNodo<E> elem,PositionList<E> l){
        l.addLast(elem.element());
        for(TNodo<E> e:elem.getHijos()){
            preOrden(e,l);
        }
    }

    @Override
    public Iterable<Position<E>> positions(){
        PositionList<E> rta=new ListaDoblementeEnlazada<>();
        if(!isEmpty()){
            preOrden(raiz,rta);
        }
        return rta.positions();
    }

    @Override
    public E replace(Position<E> v,E e){
        TNodo<E> pos=checkPosition(v);
        E rta=pos.element();
        pos.setElement(e);
        return rta;
    }

    private TNodo<E> checkPosition(Position<E> p){
        if(p==null) throw new InvalidPositionException("Posicion nula");
        if(size==0) throw new InvalidPositionException("Arbol vacio");

        TNodo<E> rta;
        try {
            rta=(TNodo<E>) p;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Posicion invalida");
        }
        return rta;
    }

    @Override
    public Position<E> root(){
        if(isEmpty()) throw new EmptyTreeException("Arbol vacio");
        return raiz;
    }

    @Override
    public Position<E> parent(Position<E> v){
        
    }
}
