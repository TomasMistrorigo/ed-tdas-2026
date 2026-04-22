import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.DNodo;
import tp4.ejercicio1.ElementIterator;

public class ej1 <E> implements PositionList<E>{
    protected DNodo<E> head;
    protected DNodo<E> tail;
    protected int cantElems;

    public ej1(){
        head=new DNodo<E>(null);
        tail=new DNodo<E>(null);
        head.setNext(tail);
        tail.setPrev(head);
        cantElems=0;
    }

    public PositionList<E> dividirLista(Position<E> pos){
        PositionList<E> rta=new ej1<>();
        if(cantElems==0)
            throw new EmptyListException("Lista Vacia");
        else{
            pos=checkPosition(pos);
            boolean corte=false;
            DNodo<E> n= tail.getPrev();
            while(!corte){
                if(n!=pos.element()){
                    rta.addFirst(n.element());
                    n=n.getPrev();
                }
                if(n==pos.element()){
                    rta.addFirst(n.element());
                    corte=true;
                }
            }
        }
        return rta;
    }

    private Position<E> checkPosition(Position<E> p){
        Position<E> n;
        if(p==null)
            throw new InvalidPositionException("Posicion Nula");
        if(cantElems==0)
            throw new EmptyListException("Lista vacia");
        try{
            n=(DNodo<E>) p;
        }catch(ClassCastException e){
            throw new InvalidPositionException("Posicion invalida");
        }
        if(n==head || n==tail)
            throw new InvalidPositionException("Posicion invalida(centinelas)");
        return n;
    }

    public void addFirst(E e){
        if(e!=null){
            DNodo<E> primero=new DNodo<>(e);
            primero.setPrev(head);
            primero.setNext(head.getNext());
            head.getNext().setPrev(primero);
            head.setNext(primero);
            cantElems++;
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new ElementIterator<E>(this);
    }

}
