import ar.edu.uns.cs.ed.tdas.tdalista.*;
import ar.edu.uns.cs.ed.tdas.*;
import java.util.Iterator;
import tp4.ejercicio1.ListaDoblementeEnlazada;

//Primer ejemplo de clase teorica

public class EjListas {
    public static void main(String[]args){
        PositionList<Integer> lista=new ListaDoblementeEnlazada<>(); //Implementado en tp4 ejercicio 1
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);

        EjListas ejLista = new EjListas();
        int result= ejLista.ejercicio1(2,lista);

        System.out.println(result);
    }
    public <E> int ejercicio1(E elem, PositionList<E> lin){
        int result=0;
        if(elem==null){
            System.out.println("No funciona con nulos. Devuelvo 0");
        }else{
            for(E e:lin){
                if(elem.equals(e)){
                    result++;
                }
            }
        }
        return result;
    }
}
