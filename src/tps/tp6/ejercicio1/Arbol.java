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
        PositionList<Position<E>> rta=new ListaDoblementeEnlazada<>();
        if(!isEmpty()){
            preOrdenPosiciones(raiz,rta);
        }
        return rta;
    }

    private void preOrdenPosiciones(TNodo<E> elem,PositionList<Position<E>> l){
        l.addLast(elem);
        for(TNodo<E> e:elem.getHijos()){
            preOrdenPosiciones(e,l);
        }
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
        TNodo<E> n = checkPosition( p );
        TNodo<E> hd = checkPosition( rb );
        TNodo<E> nuevo = new TNodo<E>( e, n ); // Conecto el nodo nuevo con el padre
        PositionList<TNodo<E>> hijos = n.getHijos();
        if(hijos.isEmpty()) throw new InvalidPositionException("rb no es hijo de p, p no tiene hijos"); //Excepsion si es que p no tiene hijos
        // Buscar dónde está rb en la lista de hijos de p
        boolean encontre = false;
        Position<TNodo<E>> pp = hijos.first();
        while( pp != null && !encontre ){
        // Testeo si el elemento corriente de la lista de hijos de p es rb
            if( hd == pp.element() ) encontre = true; // Sí, es! => terminé el bucle
            else pp = (pp != hijos.last() ? hijos.next(pp) : null); // No es => avanzo
        }
        if( !encontre ) // => Hay un problema con los argumentos
            throw new InvalidPositionException( "p no es padre de rb" );
        hijos.addBefore( pp, nuevo ); // Inserto al nodo nuevo delante de rb
        size++; // Incremento el tamaño del árbol
        return nuevo; // Retorno el nodo creado
    }

    @Override
    public Position<E> addAfter(Position<E> p, Position<E> lb, E e){
        TNodo<E> padre=checkPosition(p);
        TNodo<E> hi=checkPosition(lb);
        TNodo<E> nuevo=new TNodo<E>(e,padre);
        PositionList<TNodo<E>> hijos=padre.getHijos();
        if(hijos.isEmpty()) throw new InvalidPositionException("p no tiene hijos");

        boolean encontre=false;
        Position<TNodo<E>> pp=hijos.first();
        while(pp!=null && !encontre){
            if(pp.element()==hi) encontre=true;
            else pp=(pp!=hijos.last() ? hijos.next(pp) : null);
        }
        if(!encontre) throw new InvalidPositionException("p no es padre de lb");
        hijos.addAfter(pp, nuevo);
        size++;
        return nuevo;
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
            if(posP.element()==pos) 
                encontre=true;
            else
                posP=(posP!=pos.getPadre().getHijos().last() ? pos.getPadre().getHijos().next(posP) : null);
        }
        if(!encontre) throw new InvalidPositionException("No encontre pos de p en la lista de su padre");
        pos.getPadre().getHijos().remove(posP);
        pos.setPadre(null);
        size--;
    }

    @Override
    public void removeInternalNode(Position<E> p){
        TNodo<E> pos=checkPosition(p);
        if(!isInternal(pos)) throw new InvalidPositionException("La posicion no es Interna");
        
        if(p==raiz){
            if(raiz.getHijos().size()!=1) throw new InvalidPositionException("La posicion es raiz y tiene más de un hijo");
            TNodo<E> nuevaRaiz=raiz.getHijos().first().element();
            nuevaRaiz.setPadre(null);
            raiz=nuevaRaiz;
            size--;
            return;
        } 
        
        TNodo<E> padre = pos.getPadre();
        PositionList<TNodo<E>> hijosPadre=padre.getHijos();
        Position<TNodo<E>> posNodo = null;
        for(Position<TNodo<E>> e:hijosPadre.positions()){
            if(e.element() == pos){
                posNodo = e;
                break;
            }
        }
        while(!pos.getHijos().isEmpty()){
            TNodo<E> hijo=pos.getHijos().first().element();
            pos.getHijos().remove(pos.getHijos().first());
            hijo.setPadre(padre);
            hijosPadre.addBefore(posNodo, hijo);
        }
        hijosPadre.remove(posNodo);
        pos.setPadre(null);
        pos.setElement(null);
        size--;
    }

    @Override
    public void removeNode(Position<E> p){
        if(isExternal(p)) removeExternalNode(p);
        if(isInternal(p)) removeInternalNode(p);
    }
}
