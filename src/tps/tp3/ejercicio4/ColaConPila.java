
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import java.util.Stack;

public class ColaConPila<E> implements Queue<E>{
    private int cant;
    private E[] colaPila;

    public ColaConPila(){
        cant=0;
        colaPila=(E[]) new Object[20];
    }

    @Override
    public int size(){return cant;}

    @Override
    public boolean isEmpty(){return cant==0;}

    @Override
    public E front(){

    }

    @Override
    public void enqueue(E element){

    }

    @Override
    public E dequeue(){
        
    }
}

//Programe una clase llamada ColaConPila que implemente la interfaz Queue<E> provista por la cátedra utilizando una
//pila (java.util.Stack). Ejecute el test JUnit correspondiente para verificar que la funcionalidad de la clase sea correcta.
//Utilice la interface Queue<E> y el test distribuido por la cátedra.
