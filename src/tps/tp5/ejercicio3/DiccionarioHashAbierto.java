package tp5.ejercicio3;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEntryException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;
import tp5.ejercicio2.Entrada;

public class DiccionarioHashAbierto<K,V> implements Dictionary<K,V>{
    protected PositionList<Entry<K,V>>[]A;
    protected int entradas;
    protected int buckets=13;

    public DiccionarioHashAbierto(){
        entradas=0;
        A=(PositionList<Entry<K,V>>[]) new PositionList[buckets];
        for(int i=0;i<buckets;i++){
            A[i]=new ListaDoblementeEnlazada<Entry<K,V>>();
        }
    }

    @Override
    public int size(){return entradas;}

    @Override 
    public boolean isEmpty(){return entradas==0;}

    private int hash(K valor){
        return Math.abs(valor.hashCode()%buckets);
    }

    @Override
    public Entry<K,V> find(K key){
        if(key==null) throw new InvalidKeyException("Clave nula");

        Entry<K,V> rta=null;
        int hCode=hash(key);
        for(Entry<K,V> e:A[hCode]){
            if(e.getKey().equals(key)){
                rta=e;
                break;
            }
        }
        return rta;
    }

    @Override
    public Iterable<Entry<K,V>> findAll(K key){
        if(key==null) throw new InvalidKeyException("clave nula");

        PositionList<Entry<K,V>> rta=new ListaDoblementeEnlazada<>();
        int hCode=hash(key);
        for(Entry<K,V> e:A[hCode]){
            if(e.getKey().equals(key)){
                rta.addLast(e);
            }
        }
        return rta;
    }

    @Override
    public Entry<K,V> insert(K key,V value){
        if(key==null) throw new InvalidKeyException("Clave nula");

        int hCode=hash(key);
        Entry<K,V>rta=new Entrada<K,V>(key,value);
        A[hCode].addLast(rta);
        entradas++;

        if((double)entradas/buckets>=0.75) rehash();

        return rta;
    }

    private void rehash(){
        PositionList<Entry<K,V>>[]viejo=A;
        buckets=buckets*2;
        entradas=0;
        A=(PositionList<Entry<K,V>>[]) new PositionList[buckets];
        for(int i=0;i<buckets;i++){
            A[i]=new ListaDoblementeEnlazada<Entry<K,V>>();
        }

        for(int i=0;i<viejo.length;i++){
            for(Entry<K,V> e:viejo[i]){
                insert(e.getKey(),e.getValue());
            }
        }
    }

    @Override
    public Entry<K,V> remove(Entry<K,V> e){
        if(e==null || e.getKey()==null || e.getValue()==null) throw new InvalidEntryException("Entrada invalida");

        boolean encontrada=false;
        int hCode=hash(e.getKey());
        for(Position<Entry<K,V>> cursor:A[hCode].positions()){
            if(e.getKey().equals(cursor.element().getKey()) && e.getValue().equals(cursor.element().getValue())){
                encontrada=true;
                A[hCode].remove(cursor);
                entradas--;
                break;
            }
        }
        if(!encontrada) throw new InvalidEntryException("La entrada no esta en el diccionario");

        return e;
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
