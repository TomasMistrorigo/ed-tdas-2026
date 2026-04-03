package ar.edu.uns.cs.ed.tdas.tdapila;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyStackException;

//TP 3 ejercicio 1

public class Pila<E> implements Stack<E> {
    private int tamanio;
    private E[] pila;

    public Pila(){
        tamanio=0;
        pila= (E[]) new Object[20];
    }

    @Override
    public int size(){return tamanio;}

    @Override
    public boolean isEmpty(){return tamanio==0;}

    @Override
    public E top(){
        if(tamanio!=0)
            return pila[tamanio-1];
        else
            throw new EmptyStackException("Pila vacia");
    }

    @Override
    public void push(E element){
        if(size()==pila.length){
            E[] nuevaPila=(E[])new Object[tamanio*2];
            for(int i=0;i<pila.length;i++){
                nuevaPila[i]=pila[i];
            }
            pila=nuevaPila;
        }
        pila[tamanio]=element;
        tamanio++;
    }

    @Override
    public E pop(){
        if(isEmpty())
            throw new EmptyStackException("Pila vacia");
        else{
            E rta= pila[tamanio-1];
            tamanio--;
            return rta;
        }
    }

}
