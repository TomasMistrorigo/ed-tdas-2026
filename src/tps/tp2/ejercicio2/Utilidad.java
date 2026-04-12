package tp2.ejercicio2;
import java.util.LinkedList;
import java.util.Queue;

public class Utilidad {
    public static Queue<Integer> colaImpar(Queue<Integer> q){
        Queue<Integer> rta=new LinkedList<>();
        while(!q.isEmpty()){
            if(q.peek()%2!=0){
                rta.add(q.poll());
            }
            else q.poll();
        }
        return rta;
    }    
}

//Implemente un método que dada una cola de números enteros retorne una nueva cola que contenga sólo los
//elementos impares de la cola recibida por parámetro. Puede modificar el estado interno de la cola recibida por
//parámetro.