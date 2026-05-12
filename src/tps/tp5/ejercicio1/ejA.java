package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp4.ejercicio1.ListaDoblementeEnlazada;
import tp5.ejercicio2.Entrada;

public class ejA {
    public static PositionList<Entry<Integer,Integer>> KCoincidentesVDesiguales(Map<Integer,Integer> M1,Map<Integer,Integer> M2){
        PositionList<Entry<Integer,Integer>> L=new ListaDoblementeEnlazada<>();
        if(M1!=null && M2!=null){
            for(Entry<Integer,Integer> E1:M1.entries()){
                Integer E2=M2.get(E1.getKey());
                if(E1.getValue()==E2){
                    Entry<Integer,Integer> agregarE2=new Entrada<Integer,Integer>(E1.getKey(), E2);
                    L.addLast(E1);
                    L.addLast(agregarE2);
                }
            }
        }
        return L;
    }
}

//CONSULTA: ES CORRECTO COMO AGREGO ELEMENTOS, PAIR EN JAVA?

/*
Escriba un método que reciba dos mapeos M1 y M2 de enteros en enteros (números de libreta - nota
materia) que devuelva una PositionList<Pair<Integer,Integer>> L con aquellos elementos E1 de M1 y E2 de
M2 que coincidan en la clave, pero tengan un valor diferente. Por ejemplo, si E1= (LU: 29303, Nota: 8)
pertenece a M1 y E2= (LU:29303, Nota: 7) pertenece a M2, entonces E1 y E2 deben estar en L. Puede usar la
clase java.util.Pair de Java.
 */