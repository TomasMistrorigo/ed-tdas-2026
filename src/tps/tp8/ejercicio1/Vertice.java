package tp8.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class Vertice<V,E> implements Vertex<V>{
    private V rotulo;
    private PositionList<Arco<V,E>> adyacentes;
    private Position<Vertice<V,E>> posicionEnNodos;

    public Vertice(V rotulo){
        this.rotulo=rotulo;
        adyacentes=new ListaDoblementeEnlazada<Arco<V,E>>();
    }

    //Setters
    public void setRotulo(V nuevoRotulo){rotulo=nuevoRotulo;}
    public void setPosicionEnNodos(Position<Vertice<V,E>> p){
        posicionEnNodos=p;
    }

    //Getters
    @Override
    public V element(){return rotulo;}
    public PositionList<Arco<V,E>> getAdyacentes(){return adyacentes;}
    public Position<Vertice<V,E>> getPosicionEnNodos(){return posicionEnNodos;}
}
