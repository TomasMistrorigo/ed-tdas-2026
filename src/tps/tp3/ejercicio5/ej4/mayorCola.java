package tp3.ejercicio5.ej4;
import tp3.ejercicio1.Pila;
import tp3.ejercicio2.Cola;

public class mayorCola {
    public static int mayorValor(Cola<Integer> q){
        Cola<Integer> copia=new Cola<>();
        Pila<Integer> mayor=new Pila<>();
        
        copia.enqueue(q.front());
        mayor.push(q.dequeue());

        while(!q.isEmpty()){    
            if(q.front()>mayor.top())
                mayor.push(q.front());
            copia.enqueue(q.dequeue());
        }
        while(!copia.isEmpty())
            q.enqueue(copia.dequeue());

        return mayor.top();
    }
}

//Implemente un método tal que reciba una cola de enteros q y retorne el mayor valor que se encuentre en q. Al finalizar
//el método, el contenido de q debe ser exactamente el mismo que antes de iniciarlo. Resuelva este ejercicio utilizando
//únicamente pilas y colas. Utilice las estructuras auxiliares que crea necesarias.