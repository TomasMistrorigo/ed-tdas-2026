import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp6.ejercicio1.TNodo;
import tp5.ejercicio2.MapeoHashAbierto;

public class Problema2<E> {
    //Dentro del arbol
    public Map<Position<E>, Integer> mapSizeSubArboles(){
        TNodo<E> nodo=root;
        Map<Position<E>,Integer> m=new MapeoHashAbierto<>();
        if(root!=null){
            mapSizeSubArbolCont(nodo,m);
        }

        return m;
    }

    private int mapSizeSubArbolCont(TNodo<E> nodo,Map<Position<E>,Integer> m){
        int resultado=1;
        for(TNodo<E> hijo:nodo.getChildren()){
            resultado=resultado+mapSizeSubArbolCont(hijo,m);
        }
        m.put(nodo,resultado);
        return resultado;
    }
}
