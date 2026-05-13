package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp5.ejercicio2.MapeoHashAbierto;
import tp5.ejercicio3.DiccionarioHashAbierto;

public class ejC {
    public static <K,V> Dictionary<K,V> acomodar (Dictionary<K,V> d){
        Map<K,V> aux=new MapeoHashAbierto<>();
        Dictionary<K,V> rta=new DiccionarioHashAbierto<>();
        if(d!=null){
            for(Entry<K,V> e:d.entries()){
                aux.put(e.getKey(), e.getValue());
            }
            for(Entry<K,V> e:aux.entries()){
                rta.insert(e.getKey(), e.getValue());
            }
        }
        return rta;
    }
}

/*
Escriba un método cuya signatura sea: public Dictionary<K,V> acomodar (Dictionary<K,V> d) que reciba un
diccionario d, y que retorne un nuevo diccionario igual a d pero sin claves repetidas. De esta manera, el
diccionario resultante de este procedimiento no tendrá entradas con claves iguales. Utilice un mapeo auxiliar
para resolver este ejercicio.
Por ejemplo: Si d = {(1,a), (2,b), (3,a), (2,c), (1,d), (4,b)}, entonces el diccionario resultante es dRes = {(1,d),
(2,c), (3,a) (4,b)}.
 */