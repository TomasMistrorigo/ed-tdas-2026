import ar.edu.uns.cs.ed.tdas.tdacola.*;
import ar.edu.uns.cs.ed.tdas.tdapila.*;
import tp3.ejercicio1.Pila;

public class ej2 {
    public static void pilaCola(Stack<Character>p,Queue<Character>q){
        Stack<Character> guardado=new Pila<>();
        while(p.size()>0){
            guardado.push(p.pop());
        }
        Stack<Character> colaInversa=new Pila<>();
        while(q.size()>0){
            colaInversa.push(q.dequeue());
        }
        while(colaInversa.size()>0){
            p.push(colaInversa.pop());
        }
        while(guardado.size()>0){
            p.push(guardado.pop());
        }
    }
}
