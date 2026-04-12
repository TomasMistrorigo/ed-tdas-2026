package tp3.ejercicio5.ej3;
import tp3.ejercicio1.Pila;;

public class IntercaladorPilas {
    public static <E> Pila<E> intercalar(Pila<E> p1, Pila<E> p2){
        Pila<E> rta= new Pila<>();
        while(!p1.isEmpty() || !p2.isEmpty()){
            if(!p1.isEmpty())
                rta.push(p1.pop());
            if(!p2.isEmpty())
                rta.push(p2.pop());
        }
        return rta;
    }
}

//Implemente un método tal que reciba por parámetro dos pilas genéricas p1 y p2 y retorne una nueva pila producto de
//intercalar el contenido de las pilas p1 y p2. Tenga en cuenta que luego de ejecutarse este método ambas pilas quedarán
//vacías. Las pilas pueden tener distintos tamaños