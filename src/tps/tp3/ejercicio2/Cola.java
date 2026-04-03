package tp3.ejercicio2;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;

//TP 3 ejercicio 2

public class Cola<E> implements Queue<E>{
    private int cantidad;
    private E[] cola;

    public Cola(){
        cola=(E[]) new Object[20];
        cantidad=0;
    }

    @Override
    public int size(){return cantidad;}

    @Override
    public boolean isEmpty(){return cantidad==0;}

    @Override
    public E front(){
        if(cantidad==0)
            throw new EmptyQueueException("Cola vacia");
        else
            return cola[0];
    }

    @Override
    public void enqueue(E element){
        if(cantidad==cola.length){
            E[] colaAmpliada=(E[]) new Object[cantidad*2];
            for(int i=0;i<cantidad;i++){
                colaAmpliada[i]=cola[i];
            }
            cola=colaAmpliada;
        }
        cola[cantidad]=element;
        cantidad++;
    }

    @Override
    public E dequeue(){
        if(cantidad==0)
            throw new EmptyQueueException("Cola vacia");
        else{
            E rta=cola[0];
            for(int i=0;i<cola.length && cola[i+1]!=null;i++){
                cola[i]=cola[i+1];
            }
            cantidad--;
            return rta;
        }
    }
}

//Implemente todas las clases e interfaces necesarias para programar el TDCola utilizando un arreglo
//genérico de tipo E. Tenga en cuenta que la cola nunca se puede llenar. Ejecute el correspondiente tester JUnit probar
//su correctitud.