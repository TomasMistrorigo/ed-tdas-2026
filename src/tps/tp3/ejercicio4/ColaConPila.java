package tp3.ejercicio4;

import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import java.util.Stack;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;;

public class ColaConPila<E> implements Queue<E>{
    private Stack<E> ingreso;
    private Stack<E> salida;

    public ColaConPila(){
        ingreso = new Stack<>();
        salida = new Stack<>();
    }

    @Override
    public int size(){
        int cont=0;
        while(!ingreso.empty()){
            salida.push(ingreso.pop());
            cont++;
        }
        while(!salida.empty())
            ingreso.push(salida.pop());
        return cont;
    }

    @Override
    public boolean isEmpty(){
        return ingreso.empty();
    }

    @Override
    public E front(){
        if(ingreso.empty())
            throw new EmptyQueueException("Cola Vacia");
        E rta=null;
        while(!ingreso.empty()){
            salida.push(ingreso.pop());
        }
        rta=salida.peek();
        while(!salida.empty())
            ingreso.push(salida.pop());
        return rta;
    }

    @Override
    public void enqueue(E element){
        ingreso.push(element);
    }

    @Override
    public E dequeue(){
        if(ingreso.empty())
            throw new EmptyQueueException("Cola Vacia");
        E rta=null;
        while(!ingreso.empty()){
            salida.push(ingreso.pop());
        }
        rta=salida.pop();
        while(!salida.empty())
            ingreso.push(salida.pop());
        return rta;        
    }
}

//Programe una clase llamada ColaConPila que implemente la interfaz Queue<E> provista por la cátedra utilizando una
//pila (java.util.Stack). Ejecute el test JUnit correspondiente para verificar que la funcionalidad de la clase sea correcta.
//Utilice la interface Queue<E> y el test distribuido por la cátedra.
