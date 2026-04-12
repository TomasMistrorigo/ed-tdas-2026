package tp2.ejercicio4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class mayorCola {
    public static int mayorValor(Queue<Integer> q){
        Queue<Integer> copia=new LinkedList<>();
        Stack<Integer> mayor=new Stack<>();
        
        copia.add(q.peek());
        mayor.push(q.poll());

        while(!q.isEmpty()){    
            if(q.peek()>mayor.peek())
                mayor.push(q.peek());
            copia.add(q.poll());
        }
        while(!copia.isEmpty())
            q.add(copia.poll());

        return mayor.peek();
    }
}

//Implemente un método tal que reciba una cola de enteros q y retorne el mayor valor que se encuentre en q. Al finalizar
//el método, el contenido de q debe ser exactamente el mismo que antes de iniciarlo. Resuelva este ejercicio utilizando
//únicamente pilas y colas. Utilice las estructuras auxiliares que crea necesarias.