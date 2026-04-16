import ar.edu.uns.cs.ed.tdas.tdalista.*;
import ar.edu.uns.cs.ed.tdas.*;
import java.util.Iterator;
import tp4.ejercicio1.ListaDoblementeEnlazada;

//Segundo ejemplo de clase teorica
public class EjListas3 {
    public static void main(String[]args){
        PositionList<Integer> lista=new ListaDoblementeEnlazada<>(); //Implementado en tp4 ejercicio 1
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);

        EjListas3 ejLista = new EjListas3();
        PositionList<Integer> lista2=new ListaDoblementeEnlazada<>(); //Implementado en tp4 ejercicio 1
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);

        boolean result= ejLista.ejercicio3(lista,lista2);

        System.out.println(result);
    }
    public <E> boolean ejercicio3(PositionList<E> lin, PositionList<E> lan){
        boolean result=true;

        if(lin.size()!=lan.size()){
            result=false;
        }
        else{
            if(!(lin.isEmpty() && lan.isEmpty())){
                Iterator<E> itLin=lin.iterator();
                Iterator<E> itLan=lan.iterator();
                E elementLin;
                E elementLan;
                while(itLin.hasNext() && result){
                    elementLin=itLin.next();
                    elementLan=itLan.next();
                    if(!elementLin.equals(elementLan))
                        result=false;
                }
            }
        }
        return result;
    }
}
