package tp2.ejercicio3;
import java.util.Stack;

public class IntercaladorPilas {
    public static <E> Stack<E> intercalar(Stack<E> p1, Stack<E> p2){
        Stack<E> rta= new Stack<>();
        while(!p1.empty() || !p2.empty()){
            if(!p1.empty())
                rta.push(p1.pop());
            if(!p2.empty())
                rta.push(p2.pop());
        }
        return rta;
    }
}

//Implemente un método tal que reciba por parámetro dos pilas genéricas p1 y p2 y retorne una nueva pila producto de
//intercalar el contenido de las pilas p1 y p2. Tenga en cuenta que luego de ejecutarse este método ambas pilas quedarán
//vacías. Las pilas pueden tener distintos tamaños