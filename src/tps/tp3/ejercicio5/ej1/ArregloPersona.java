package tp3.ejercicio5.ej1;
import tp3.ejercicio1.Pila;;

public class ArregloPersona {

    public static void invertir(Persona[] A){
        Pila<Persona> pila=new Pila<>();
        
        for(int i=0;i<A.length && A[i]!=null;i++){
            pila.push(A[i]);
        }

        for(int i=0;i<A.length && !pila.isEmpty();i++){
            A[i]=pila.pop();
        }

    }
    
}

//Suponiendo que posee la clase Persona, implemente un método Invertir(A) que reciba un arreglo de personas y utilice
//una pila para invertir el contenido del arreglo A.