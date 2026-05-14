package tp6.ejercicio1;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
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

        TNodo<E> rta=null;
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
        TNodo<E> pos=checkPosition(v);
        if(pos.equals(raiz)) throw new BoundaryViolationException("La raiz no tiene padre");
        return pos.getPadre();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v){
        TNodo<E> pos=checkPosition(v);
        PositionList<Position<E>> rta=new ListaDoblementeEnlazada<>();
        for(TNodo<E> e:pos.getHijos()){
            rta.addLast(e);
        }
        return rta;
    }

    @Override
    public boolean isInternal(Position<E> v){
        TNodo<E> pos=checkPosition(v);
        return !pos.getHijos().isEmpty();
    }

    @Override
    public boolean isExternal(Position<E> v){
        TNodo<E> pos=checkPosition(v);
        return pos.getHijos().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v){
        TNodo<E> pos=checkPosition(v);
        return pos.equals(raiz);
    }

    @Override
    public void createRoot(E e){
        if(!isEmpty()) throw new InvalidOperationException("El arbol ya tiene raiz");
        TNodo<E> rta=new TNodo<E>(e);
        raiz=rta;
        size++;
    }

    @Override
    public Position<E> addFirstChild(Position<E> p,E e){
        TNodo<E> pos=checkPosition(p);
        TNodo<E> primerHijo=new TNodo<E>(e,pos);
        pos.getHijos().addFirst(primerHijo);
        size++;
        return primerHijo;
    }

    @Override
    public Position<E> addLastChild(Position<E> p,E e){
        TNodo<E> pos=checkPosition(p);
        TNodo<E> ultimoHijo=new TNodo<E>(e, pos);
        pos.getHijos().addLast(ultimoHijo);
        size++;
        return ultimoHijo;
    }

    @Override
    public Position<E> addBefore(Position<E> p,Position<E> rb,E e){
        TNodo<E> nodo=checkPosition(p);
        TNodo<E> hijo=checkPosition(rb);
        TNodo<E> nuevoHijo=new TNodo<E>(e,nodo);
        Position<TNodo<E>> posrb=nodo.getHijos().first();
        boolean encontre=false;
        while(posrb!=null && !encontre){
            if(hijo==posrb.element())
                encontre=true;
            else
                posrb=(posrb!=nodo.getHijos().last() ? nodo.getHijos().next(posrb):null);
        }
        if(!encontre) throw new InvalidPositionException("rb no es hijo de p");
        nodo.getHijos().addBefore(posrb, nuevoHijo);
        size++;
        return nuevoHijo;
    }

    @Override
    public Position<E> addAfter(Position<E> p, Position<E> lb, E e){
        TNodo<E> nodo=checkPosition(p);
        TNodo<E> hijo=checkPosition(lb);
        TNodo<E> nuevoHijo=new TNodo<E>(e,nodo);
        Position<TNodo<E>> poslb=nodo.getHijos().first();
        boolean encontre=false;
        while(poslb!=null && !encontre){
            if(hijo==poslb.element())
                encontre=true;
            else
                poslb=(poslb!=nodo.getHijos().last() ? nodo.getHijos().next(poslb):null);
        }
        if(!encontre) throw new InvalidPositionException("rb no es hijo de p");
        nodo.getHijos().addAfter(poslb, nuevoHijo);
        size++;
        return nuevoHijo;
    }

    @Override
    public void removeExternalNode(Position<E> p){
        TNodo<E> pos=checkPosition(p);
        if(!isExternal(pos)) throw new InvalidPositionException("La posicion no es externa");
        
        //Por si solo es raiz
        if ( p == root() ) { raiz = null; size = 0; pos.setElement(null); return; }
        
        Position<TNodo<E>> posP=pos.getPadre().getHijos().first();
        boolean encontre=false;
        while(posP!=null && !encontre){
            if(posP==pos.element()) 
                encontre=true;
            else
                posP=(posP!=pos.getPadre().getHijos().last() ? pos.getPadre().getHijos().next(posP) : null);
        }
        if(!encontre) throw new InvalidPositionException("No encontre pos de p en la lista de su padre");
        pos.getPadre().getHijos().remove(posP);
        pos=null;
        size--;
    }

    @Override
    public void removeInternalNode(Position<E> p){
        TNodo<E> pos=checkPosition(p);
        if(!isInternal(pos)) throw new InvalidPositionException("La posicion no es Interna");
        if(p==root()){
            if(raiz.getHijos().size()!=1) throw new InvalidPositionException("La posicion es raiz y tiene más de un hijo");
            else{
                TNodo<E> nuevaRaiz=raiz.getHijos().first().element();
                nuevaRaiz.setPadre(null);
                raiz=nuevaRaiz;
                size--;
                return;
            }
        } 
        
        TNodo<E> padre = pos.getPadre();
        PositionList<TNodo<E>> hijosPadre =padre.getHijos();
        Position<TNodo<E>> posNodo = null;
        for(Position<TNodo<E>> e:hijosPadre.positions()){
            if(e.element() == pos){
                posNodo = e;
                break;
            }
        }
        for(TNodo<E> hijo : pos.getHijos()){
            hijo.setPadre(padre);
            hijosPadre.addBefore(posNodo, hijo);
        }
        hijosPadre.remove(posNodo);
        size--;
    }

    @Override
    public void removeNode(Position<E> p){
        if(isExternal(p)) removeExternalNode(p);
        if(isInternal(p)) removeInternalNode(p);
    }
}
