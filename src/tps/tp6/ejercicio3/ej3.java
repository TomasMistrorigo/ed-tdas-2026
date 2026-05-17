package tp6.ejercicio3;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp5.ejercicio2.MapeoHashAbierto;

public class ej3 {
    public static Map<Character, Integer> cantidadRepeticiones(Tree<Character> t){
        Map<Character,Integer> rta=new MapeoHashAbierto<>();
        if(t!=null && !t.isEmpty()){
            mapeoPreOrden(rta,t,t.root());
        }
        return rta;
    }

    private static void mapeoPreOrden(Map<Character,Integer> m,Tree<Character> t, Position<Character> p){
        if(m.get(p.element())==null){
            m.put(p.element(),1);
        } else{
            m.put(p.element(),m.get(p.element())+1);
        }
        
        for(Position<Character> e:t.children(p)){
            mapeoPreOrden(m,t,e);
        }
    }
}

/*
Programe un método con la siguiente signatura: public Map<Character, Integer>
cantidadRepeticiones(Tree<Character> t). Este método deberá retornar un mapeo con cada uno de los
caracteres del árbol y la cantidad de veces que aparece cada carácter en el árbol. Resuelva este problema utilizando
un recorrido en preorden.
 */