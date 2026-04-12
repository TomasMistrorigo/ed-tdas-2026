package tp2.ejercicio1;
import java.util.Stack;

public class ArregloPersona {

    public static void invertir(Persona[] A){
        Stack<Persona> pila=new Stack<>();
        
        for(int i=0;i<A.length && A[i]!=null;i++){
            pila.push(A[i]);
        }

        for(int i=0;i<A.length && !pila.empty();i++){
            A[i]=pila.pop();
        }

    }
    
}

//Suponiendo que posee la clase Persona, implemente un método Invertir(A) que reciba un arreglo de personas y utilice
//una pila para invertir el contenido del arreglo A.