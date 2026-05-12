package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;

public class ejB {
    public static <K,V> boolean contenido(Map<K,V> M1,Map<K,V> M2){
        boolean rta=true;
        for(Entry<K,V> E1:M1.entries()){
            if(M2.get(E1.getKey())==null){
                rta=false;
                break;
            }
        }
        return rta;
    }    
}

//CONSULA: ES CORRECTO COMO VERIFICO SI ESTA LA CLAVE, (ELEMENTOS CON VALUE NULL)

/*
Escriba un método que, dados dos mapeos M1 y M2, determine si todas las claves de M1 están contenidas
en M2.
 */