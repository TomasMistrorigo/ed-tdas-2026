package tp4.ejercicio1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class ElementIterator<E> implements Iterator<E>{
    protected PositionList<E> list;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> l){
        list=l;
        if(list.isEmpty())
            cursor=null;
        else
            cursor=list.first();
    }
    
    @Override
    public boolean hasNext(){
        return cursor!=null;
    }

    @Override
    public E next(){
        if(cursor==null)
            throw new NoSuchElementException("No existe un siguiente elemento");
        E rta=cursor.element();
        cursor=(cursor==list.last()) ?
                null : list.next(cursor);
        return rta;
    }
}
