package tp5.ejercicio1;

import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import tp5.ejercicio3.DiccionarioHashAbierto;

public class testC {
    public static void main(String[]args){
        Dictionary<Integer,Character> d=new DiccionarioHashAbierto<>();
        d.insert(1, 'a');
        d.insert(2,'b');
        d.insert(3,'a');
        d.insert(2,'c');
        d.insert(1,'d');
        d.insert(4,'b');

        Dictionary<Integer,Character> rta=ejC.acomodar(d);
        for(Entry<Integer,Character> e:rta.entries()){
            System.out.print("("+e.getKey()+","+e.getValue()+"), ");
        }
    }           
}
