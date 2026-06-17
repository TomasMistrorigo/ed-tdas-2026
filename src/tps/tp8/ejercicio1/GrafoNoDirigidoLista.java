package tp8.ejercicio1;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEdgeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class GrafoNoDirigidoLista<V,E> implements Graph<V,E>{
    protected PositionList<Vertice<V,E>> nodos;
    protected PositionList<Arco<V,E>> arcos;
    public GrafoNoDirigidoLista(){
        nodos=new ListaDoblementeEnlazada<Vertice<V,E>>();
        arcos=new ListaDoblementeEnlazada<Arco<V,E>>();
    }

    @Override
    public Iterable<Vertex<V>> vertices(){
        PositionList<Vertex<V>> lista=new ListaDoblementeEnlazada<>();
        for(Vertex<V> v:nodos)
            lista.addLast(v);
        return lista;
    }

    @Override
    public Iterable<Edge<E>> edges(){
        PositionList<Edge<E>> lista=new ListaDoblementeEnlazada<>();
        for(Edge<E> e:arcos)
            lista.addLast(e);
        return lista;
    }

    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> v){
        PositionList<Edge<E>> lista=new ListaDoblementeEnlazada<>();
        Vertice<V,E> vert=checkVertex(v);
        for(Edge<E> e: vert.getAdyacentes())
            lista.addLast(e);
        return lista;
    }

    private Vertice<V,E> checkVertex(Vertex<V> v){
        if(v==null) throw new InvalidVertexException("Vertice nulo");
        if(nodos.isEmpty()) throw new InvalidVertexException("No existen vertices");
        Vertice<V,E> rta;
        try {
            rta=(Vertice<V,E>) v;
        } catch (ClassCastException e) {
            throw new InvalidVertexException("Vertice invalido");
        }
        return rta;
    }

    private Arco<V,E> checkEdge(Edge<E> e){
        if(e==null) throw new InvalidEdgeException("Arco nulo");
        if(arcos.isEmpty()) throw new InvalidEdgeException("No existen arcos");
        Arco<V,E> rta;
        try{
            rta=(Arco<V,E>) e;
        } catch(ClassCastException c){
            throw new InvalidEdgeException("Arco invalido");
        }
        return rta;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e){
        Arco<V,E> arco=checkEdge(e);
        Vertice<V,E> vertice=checkVertex(v);
        Vertex<V> rta=null;
        if(arco.getV1().equals(vertice))
            rta=arco.getV2();
        else{
            if(arco.getV2().equals(vertice))
                rta=arco.getV1();
        }
        if(rta==null) throw new InvalidVertexException("v no coincide con ningun vertice de e");
        return rta;
    }

    @Override
    public Vertex<V> [] endvertices(Edge<E> e){
        Arco<V,E> arco=checkEdge(e);
        Vertex<V>[] rta=(Vertex<V>[]) new Vertex[2];
        rta[0]=arco.getV1();
        rta[1]=arco.getV2();
        return rta;
    }

    @Override
    public boolean areAdjacent(Vertex<V> v,Vertex<V> w){
        Vertice<V,E> v1=checkVertex(v);
        Vertice<V,E> v2=checkVertex(w);
        boolean rta=false;
        for(Edge<E> e:incidentEdges(v1)){
            if(opposite(v1,e).equals(v2)){
                rta=true;
                break;
            }
        }
        return rta;
    }

    @Override
    public V replace(Vertex<V> v, V x){
        
    }
}
