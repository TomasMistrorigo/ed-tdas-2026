import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdapila.Stack;
import tp3.ejercicio1.*;
import tp3.ejercicio2.*;
public class testEj2 {
    public static void main(String[]args){
        Stack<Character> p=new Pila<>();
        Queue<Character> q=new Cola<>();

        p.push('a');
        p.push('b');
        p.push('c');

        q.enqueue('h');
        q.enqueue('g');
        q.enqueue('f');
        q.enqueue('d');

        ej2.pilaCola(p, q);

        while(!p.isEmpty()){
            System.out.println(p.pop());
        }
    }
}
