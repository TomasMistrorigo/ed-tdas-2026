package tp3.ejercicio5.ej2;
import tp3.ejercicio2.Cola;

public class Utilidad {
    public static Cola<Integer> colaImpar(Cola<Integer> q){
        Cola<Integer> rta=new Cola<>();
        while(!q.isEmpty()){
            if(q.front()%2!=0){
                rta.enqueue(q.dequeue());
            }
            else q.dequeue();
        }
        return rta;
    }    
}

//Implemente un método que dada una cola de números enteros retorne una nueva cola que contenga sólo los
//elementos impares de la cola recibida por parámetro. Puede modificar el estado interno de la cola recibida por
//parámetro.