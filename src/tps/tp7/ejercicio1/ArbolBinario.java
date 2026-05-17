package tp7.ejercicio1;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class ArbolBinario<E> implements BinaryTree<E> {
    BTNodo<E> raiz;
    int size;

    public ArbolBinario(){
        raiz=null;
        size=0;
    }

    private BTNodo<E> checkPosition(Position<E> p){
        if(p==null) throw new InvalidPositionException("Posicion nula");
        if(size==0) throw new InvalidPositionException("Arbol Binario vacio");
        BTNodo<E> pos=null;
        try {
            pos=(BTNodo<E>) p;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Posicion invalida");
        }
        return pos;
    }

    @Override
    public Position<E> left(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        if(pos.getHijoIzq()==null) throw new BoundaryViolationException("v no tiene hijo izquierdo");
        return pos.getHijoIzq();
    }

    @Override
    public BTNodo<E> right(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        if(pos.getHijoDer()==null) throw new BoundaryViolationException("v no tiene hijo izquierdo");
        return pos.getHijoDer();
    }

    @Override
    public boolean hasLeft(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        return pos.getHijoIzq()!=null;
    }

    @Override
    public boolean hasRight(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        return pos.getHijoDer()!=null;
    }

    @Override
    public Position<E> addLeft(Position<E> v, E r){
        BTNodo<E> padre=checkPosition(v);
        if(padre.getHijoIzq()!=null) throw new InvalidOperationException("v ya tiene un hijo izquierdo");
        BTNodo<E> nuevo=new BTNodo<>(r,padre);
        padre.setIzquierdo(nuevo);
        size++;
        return nuevo;
    }

    @Override
    public Position<E> addRight(Position<E> v, E r){
        BTNodo<E> padre=checkPosition(v);
        if(padre.getHijoDer()!=null) throw new InvalidOperationException("v ya tiene hijo derecho");
        BTNodo<E> nuevo=new BTNodo<>(r,padre);
        padre.setDerecho(nuevo);
        size++;
        return nuevo;
    }

    @Override
    public void attach(Position<E> r, BinaryTree<E> T1, BinaryTree<E> T2){
        BTNodo<E> hoja=checkPosition(r);
        if(hoja.getHijoIzq()!=null || hoja.getHijoDer()!=null) throw new InvalidPositionException("r no es hoja");
        
        if(T1!=null && !T1.isEmpty()){
            ArbolBinario<E> t1=(ArbolBinario<E>)T1;
            BTNodo<E> izquierdo=t1.checkPosition(t1.root());
            hoja.setIzquierdo(izquierdo);
            izquierdo.setPadre(hoja);
            size=size+t1.size();
            /*t1.raiz=null;
            t1.size=0;*/
        }
        if(T2!=null && !T2.isEmpty()){
            ArbolBinario<E> t2=(ArbolBinario<E>)T2;
            BTNodo<E> derecho=t2.checkPosition(t2.root());
            hoja.setDerecho(derecho);
            derecho.setPadre(hoja);
            size=size+t2.size();
            /*t2.raiz=null;
            t2.size=0;*/
        }
    }

    @Override
    public int size(){return size;}

    @Override
    public boolean isEmpty(){return size==0;}

    @Override
    public Iterator<E> iterator(){
        PositionList<E> rta=new ListaDoblementeEnlazada<>();
        if(size>0){
            preOrdenElem(rta,raiz);
        }
        return rta.iterator();
    }

    private void preOrdenElem(PositionList<E> l,BTNodo<E> n){
        l.addLast(n.element());
        if(n.getHijoIzq()!=null)
            preOrdenElem(l,n.getHijoIzq());
        if(n.getHijoDer()!=null)
            preOrdenElem(l,n.getHijoDer());
    }

    @Override
    public Iterable<Position<E>> positions(){
        PositionList<Position<E>> rta=new ListaDoblementeEnlazada<>();
        if(size>0){
            preOrdenPos(rta,raiz);
        }
        return rta;
    }

    private void preOrdenPos(PositionList<Position<E>> l,BTNodo<E> n){
        l.addLast(n);
        if(n.getHijoIzq()!=null)
            preOrdenPos(l, n.getHijoIzq());
        if(n.getHijoDer()!=null)
            preOrdenPos(l,n.getHijoDer());
    }

    @Override
    public E replace(Position<E> v, E e){
        BTNodo<E> nodo=checkPosition(v);
        E rta=nodo.element();
        nodo.setElement(e);
        return rta;
    }

    @Override
    public Position<E> root(){
        if(size==0) throw new EmptyTreeException("Arbol Binario vacio");
        return raiz;
    }

    @Override
    public Position<E> parent(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        if(pos.equals(raiz)) throw new BoundaryViolationException("La raiz no tiene padre");
        return pos.getPadre();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v){
        BTNodo<E> padre=checkPosition(v);
        PositionList<Position<E>> hijos=new ListaDoblementeEnlazada<>();
        if(padre.getHijoIzq()!=null)
            hijos.addLast(padre.getHijoIzq());
        if(padre.getHijoDer()!=null)
            hijos.addLast(padre.getHijoDer());
        return hijos;
    }

    @Override
    public boolean isInternal(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        return pos.getHijoIzq()!=null || pos.getHijoDer()!=null;
    }

    @Override
    public boolean isExternal(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        return pos.getHijoIzq()==null && pos.getHijoDer()==null;
    }

    @Override
    public boolean isRoot(Position<E> v){
        BTNodo<E> pos=checkPosition(v);
        return pos.equals(raiz);
    }

    @Override
    public void createRoot(E e){
        if(size>0) throw new InvalidOperationException("Raiz ya existe");
        raiz=new BTNodo<E>(e);
        size=1;
    }

    @Override
    public Position<E> addFirstChild(Position<E> p, E e){
        return addLeft(p, e);
    }

    @Override
    public Position<E> addLastChild(Position<E> p,E e){
        return addRight(p, e);
    }

    @Override
    public Position<E> addBefore(Position<E> p, Position<E> rb, E e){
        BTNodo<E> padre=checkPosition(p);
        BTNodo<E> hijoDerecho=checkPosition(rb);
        if(padre.getHijoDer()==null || !padre.getHijoDer().equals(hijoDerecho))
            throw new InvalidPositionException("rb no es hijo de p");
        BTNodo<E> izquierdo=new BTNodo<E>(e,padre);
        padre.setIzquierdo(izquierdo);
        size++;
        return izquierdo;
    }

    @Override 
    public Position<E> addAfter(Position<E> p,Position<E> lb,E e){
        BTNodo<E> padre=checkPosition(p);
        BTNodo<E> hijoIzquierdo=checkPosition(lb);
        if(padre.getHijoIzq()==null || !padre.getHijoIzq().equals(hijoIzquierdo))
            throw new InvalidPositionException("lb no es hijo de p");
        BTNodo<E> derecho= new BTNodo<E>(e,padre);
        padre.setDerecho(derecho);
        size++;
        return derecho;
    }

    @Override
    public void removeExternalNode(Position<E> p){
        BTNodo<E> nodo=checkPosition(p);
        if(!isExternal(nodo)) throw new InvalidPositionException("p no es un nodo externo");
        if(nodo.equals(raiz)){
            raiz=null;
            size=0;
            return;
        }
        BTNodo<E> padre=nodo.getPadre();
        if(padre.getHijoIzq()!=null && padre.getHijoIzq().equals(nodo)){
            padre.setIzquierdo(null);
        } else padre.setDerecho(null);
        nodo.setPadre(null);
        nodo.setElement(null);
        size--;
    }
    
    @Override
    public void removeInternalNode(Position<E> p){
        BTNodo<E> nodo=checkPosition(p);
        if(!isInternal(nodo)) throw new InvalidPositionException("p no es un nodo interno");
        if(nodo.getHijoDer()!=null && nodo.getHijoIzq()!=null) throw new InvalidPositionException("p tiene dos hijos no puede ser removido");
        
        //busco cual hijo es el no nulo
        BTNodo<E> reemplazo;
        if(nodo.getHijoIzq()!=null){
            reemplazo=nodo.getHijoIzq();
            nodo.setIzquierdo(null);
        }else {
            reemplazo=nodo.getHijoDer();
            nodo.setDerecho(null);
        }
        //caso que sea raiz
        if(nodo.equals(raiz)){
            if(nodo.getHijoIzq()!=null){
                nodo.getHijoIzq().setPadre(null);
            }else nodo.getHijoDer().setPadre(null);
            raiz=reemplazo;
            reemplazo.setPadre(null);
            size--;
            return;
        }
        //caso general
        BTNodo<E> padre=nodo.getPadre();
        if(padre.getHijoDer()!=null && padre.getHijoDer().equals(nodo)){
            padre.setDerecho(reemplazo);
        } else padre.setIzquierdo(reemplazo);
        reemplazo.setPadre(padre);
        nodo.setPadre(null);
        nodo.setElement(null);
        size--;
    }

    @Override
    public void removeNode(Position<E> p){
        if(isExternal(p)) removeExternalNode(p);
        else if(isInternal(p)) removeInternalNode(p);
    }
}
