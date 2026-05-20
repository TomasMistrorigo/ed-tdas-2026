package tp5.ejercicio2;

import ar.edu.uns.cs.ed.tdas.Entry;

public class Entrada<K,V> implements Entry<K,V> {
    private K clave;
    private V valor;

    public Entrada(K clave, V valor){
        this.clave=clave;
        this.valor=valor;
    }

    //Getters
    @Override
    public K getKey(){return clave;}
    @Override
    public V getValue(){return valor;}

    //Setters
    public void setKey(K clave){this.clave=clave;}
    public void setValue(V valor){this.valor=valor;}

    //Para mostrar entradas
    public String toString(){
        return "(" + getKey() + "," + getValue() + ")";
    }
}
