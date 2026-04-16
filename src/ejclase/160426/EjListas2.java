import ar.edu.uns.cs.ed.tdas.tdalista.*;
import ar.edu.uns.cs.ed.tdas.*;
import java.util.Iterator;
import tp4.ejercicio1.ListaDoblementeEnlazada;

//Segundo ejemplo de clase teorica
public class EjListas2 {
    public static void main(String[]args){
        PositionList<Integer> lista=new ListaDoblementeEnlazada<>(); //Implementado en tp4 ejercicio 1
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);

        EjListas2 ejLista = new EjListas2();
        boolean result= ejLista.ejercicio2(20,lista);

        System.out.println(result);
    }
    public <E> boolean ejercicio2(E elem, PositionList<E> lin){
        boolean result=false;
        if(elem==null){
            System.out.println("No funciona con nulos. Devuelvo false");
        }else{
            for(E e:lin){
                if(elem.equals(e)){
                    result=true;
                    return result;
                }
            }
        }
        return result;
    }

}
