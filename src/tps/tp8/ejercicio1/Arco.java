package tp8.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;

public class Arco<V,E> implements Edge<E> {
    private E rotulo;
    private Vertice<V,E> v1,v2;
    private Position<Arco<V,E>> posicionEnArcos;
    private Position<Arco<V,E>> posicionEnlv1, posicionEnlv2;

    public Arco(E rotulo, Vertice<V,E> v1, Vertice<V,E> v2){
        this.rotulo=rotulo;
        this.v1=v1;
        this.v2=v2;
    }

    //Getters
    @Override
    public E element(){return rotulo;}
    public Vertice<V,E> getV1(){return v1;}
    public Vertice<V,E> getV2(){return v2;}
    public Position<Arco<V,E>> getPosicionEnArcos(){return posicionEnArcos;}
    public Position<Arco<V,E>> getPosicionEnlv1(){return posicionEnlv1;}
    public Position<Arco<V,E>> getPosicionEnlv2(){return posicionEnlv2;}

    //Setters
    public void setRotulo(E rotulo){this.rotulo=rotulo;}
    public void setPosicionEnArcos(Position<Arco<V,E>> p){posicionEnArcos=p;}
    public void setPosicionEnlv1(Position<Arco<V,E>> p){posicionEnlv1=p;}
    public void setPosicionEnlv2(Position<Arco<V,E>> p){posicionEnlv2=p;}
}

