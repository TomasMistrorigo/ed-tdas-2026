package tp4.ejercicio1;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import java.util.Iterator;
import tp4.ejercicio1.*;

public class ListaDoblementeEnlazada<E> implements PositionList<E>{
    protected DNodo<E> head;
    protected DNodo<E> tail;
    protected int tamanio;

    public ListaDoblementeEnlazada(){
        head=new DNodo(null);
        tail=new DNodo(null);
        head.setNext(tail);
        tail.setPrev(head);
        tamanio=0;
    }

    @Override
    public int size(){return tamanio;}

    @Override
    public boolean isEmpty(){return tamanio==0;}

    @Override
    public Position<E> first(){
        if(head.getNext()==tail)
            throw new EmptyListException("Lista vacia");
        return head.getNext();
    }

    @Override
    public Position<E> last(){
        if(tail.getPrev()==head)
            throw new EmptyListException("Lista vacia");
        return tail.getPrev();
    }

    private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
        DNodo<E> n;
        try{
            n=(DNodo<E>) p;
        } catch(ClassCastException e){
            throw new InvalidPositionException("Posicion invalida");
        }
        return n;
    }

    @Override
    public Position<E> next(Position<E> p){
        DNodo<E> n=checkPosition(p);
        if(n==tail.getPrev())
            throw new BoundaryViolationException("El elemento es el ultimo de la lista, no tiene siguiente");
        return n.getNext();
    }

    @Override
    public Position<E> prev(Position<E> p){
        DNodo<E> n=checkPosition(p);
        if(n==head.getNext())
            throw new BoundaryViolationException("El elemento es el primero de la lista, no tiene previo");
        return n.getPrev();
    }

    @Override
    public void addFirst(E element){
        DNodo<E> primero=new DNodo<E>(element);
        primero.setPrev(head);
        primero.setNext(head.getNext());
        head.setNext(primero);
        primero.getNext().setPrev(primero);
        tamanio++;
    }

    @Override
    public void addLast(E element){
        DNodo<E> ultimo=new DNodo<E>(element);
        ultimo.setNext(tail);
        ultimo.setPrev(tail.getPrev());
        tail.setPrev(ultimo);
        ultimo.getPrev().setNext(ultimo);
        tamanio++;
    }

    @Override
    public void addAfter(Position<E> p,E element){
        DNodo<E> pos= checkPosition(p);
        DNodo<E> af=new DNodo<E>(element);
        af.setPrev(pos);
        af.setNext(pos.getNext());
        pos.getNext().setPrev(af);
        pos.setNext(af);
        tamanio++;
    }

    @Override
    public void addBefore(Position<E> p, E element){
        DNodo<E> pos=checkPosition(p);
        DNodo<E> bf=new DNodo<E>(element);
        bf.setPrev(pos.getPrev());
        bf.setNext(pos);
        pos.getPrev().setNext(bf);
        pos.setPrev(bf);
        tamanio++;
    }

    @Override
    public E remove(Position<E> p){
        DNodo<E> pos=checkPosition(p);
        pos.getNext().setPrev(pos.getPrev());
        pos.getPrev().setNext(pos.getNext());
        tamanio--;
        return pos.element();
    }

    @Override
    public E set(Position<E> p,E element){
        DNodo<E> pos=checkPosition(p);
        E rta=pos.element();
        pos.setElement(element);
        return rta;
    }

    @Override
    public Iterator<E> iterator(){
        return new ElementIterator<E>(this);
    }

    @Override
    public Iterable<Position<E>> positions(){
        PositionList<Position<E>> pl=new ListaDoblementeEnlazada<Position<E>>();
        if(tamanio!=0){
            DNodo<E> n= head.getNext();
            while(n!=tail){
                pl.addLast(n);
                n=n.getNext();
            }
        }
        return pl;
    }
}
