package tp5.ejercicio2;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class MapeoHashAbierto<K,V> implements Map<K,V>{
    protected PositionList<Entry<K,V>>[]A;
    protected int entradas;
    protected int buckets=13;

    public MapeoHashAbierto(){
        entradas=0;
        A=(PositionList<Entry<K,V>>[]) new PositionList[buckets];
        for(int i=0;i<buckets;i++)
            A[i]=new ListaDoblementeEnlazada<Entry<K,V>>();
    }

    @Override
    public int size(){return entradas;}

    @Override
    public boolean isEmpty(){return entradas==0;}

    private int hash(K valor){
        return Math.abs(valor.hashCode()%buckets);
    }

    @Override
    public V get(K key){
        if(key==null) throw new InvalidKeyException("Clave nula");
        
        int hCode=hash(key);
        V rta=null;
        for(Entry<K,V> e: A[hCode]){
            if(e.getKey().equals(key)){
                rta=e.getValue();
                break;
            }
        }

        return rta;
    }

    @Override
    public V put(K key,V value){
        if(key==null) throw new InvalidKeyException("Clave nula");

        int hCode=hash(key);
        V rta=null;

        //Busco si existe uno viejo
        for(Entry<K,V> e: A[hCode]){
            if(e.getKey().equals(key)){
                rta=e.getValue();
                ((Entrada<K,V>) e).setValue(value);
                break;
            }
        }

        //Si no existe inserto el nuevo
        if(rta==null){
            A[hCode].addLast(new Entrada(key,value));
            entradas++;
        }

        return rta;
    }

    @Override
    public V remove(K key){
        if(key==null) throw new InvalidKeyException("Clave nula");

        int hCode=hash(key);
        V rta=null;
        for(Position<Entry<K,V>> p: A[hCode].positions()){
            Entry<K,V> e=p.element();
            if(e.getKey().equals(key)){
                rta=e.getValue();
                A[hCode].remove(p);
                entradas--;
                break;
            }
        }
        return rta;
    }

    @Override
    public Iterable<K> keys(){
        PositionList<K> rta=new ListaDoblementeEnlazada<>();
        for(int i=0; i<buckets;i++){
            for(Entry<K,V> e:A[i]){
                rta.addLast(e.getKey());
            }
        }
        return rta;
    }

    @Override 
    public Iterable<V> values(){
        PositionList<V> rta=new ListaDoblementeEnlazada<>();
        for(int i=0; i<buckets;i++){
            for(Entry<K,V> e:A[i]){
                rta.addLast(e.getValue());
            }
        }
        return rta;
    }

    @Override
    public Iterable<Entry<K,V>> entries(){
        PositionList<Entry<K,V>> rta=new ListaDoblementeEnlazada<>();
        for(int i=0;i<buckets;i++){
            for(Entry<K,V> e:A[i]){
                rta.addLast(e);
            }
        }
        return rta;
    }
}
