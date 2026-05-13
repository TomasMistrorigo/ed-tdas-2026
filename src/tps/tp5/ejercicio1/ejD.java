package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp5.ejercicio2.MapeoHashAbierto;

public class ejD {
    public static Map<Character,Integer> cantApariciones(PositionList<Character> p){
        Map<Character,Integer> rta=new MapeoHashAbierto<>();
        if(p!=null){
            for(Character e:p){
                if(rta.get(e)!=null){
                    rta.put(e,rta.get(e)+1);
                } else rta.put(e,1);
            }
        }
        return rta;
    }
}

/*
Escriba un método tal que reciba una PositionList<Character> y retorne un mapeo cuyas claves sean cada
uno de los caracteres que aparecen en la lista y el valor la cantidad de veces que aparecen los caracteres en
la lista. Por ejemplo: Si l = <a, b, a, c, d, b>, entonces el mapeo resultante es mRes = {(a,2), (b,2), (c,1) (d,1)}.
 */