package tp4.ejercicio6;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import tp4.ejercicio1.ListaDoblementeEnlazada;

public class ejB {
    public static PositionList<Integer> intercaladosOrdenados(PositionList<Integer> L1,PositionList<Integer> L2){
        PositionList<Integer> rta=new ListaDoblementeEnlazada<>();
        if(L1==null || L2==null){
            if(L1==null)
                rta=L2;
            else rta=L1;
        }else{
            Iterator<Integer> itL1=L1.iterator();
            Iterator<Integer> itL2=L2.iterator();
            while(itL1.hasNext() || itL2.hasNext()){
                if(itL1.hasNext() && itL2.hasNext()){
                    Integer elementL1=itL1.next();
                    Integer elementL2=itL2.next();
                    if(elementL1==elementL2){
                        if(rta.size()>0){
                            if(rta.last().element()!=elementL1){
                                if(rta.last().element()>elementL1)
                                    rta.addBefore(rta.last(), elementL1);
                                else
                                    rta.addLast(elementL1);
                            }
                        } else rta.addLast(elementL1);
                    }else{
                        if(rta.size()>0){
                            if(elementL1<elementL2){
                                if(rta.last().element()!=elementL1){
                                    if(rta.last().element()>elementL1)
                                        rta.addBefore(rta.last(), elementL1);
                                    else
                                        rta.addLast(elementL1);
                                }
                                if(rta.last().element()!=elementL2){
                                    if(rta.last().element()>elementL2)
                                        rta.addBefore(rta.last(), elementL2);
                                    else
                                        rta.addLast(elementL2);
                                }
                            }else{
                                if(rta.last().element()!=elementL2){
                                    if(rta.last().element()>elementL2)
                                        rta.addBefore(rta.last(), elementL2);
                                    else
                                        rta.addLast(elementL2);
                                }
                                if(rta.last().element()!=elementL1){
                                    if(rta.last().element()>elementL1)
                                        rta.addBefore(rta.last(), elementL1);
                                    else
                                        rta.addLast(elementL1);
                                }
                            }    
                        } else{
                            if(elementL1<elementL2){
                                rta.addLast(elementL1);
                                rta.addLast(elementL2);
                            }else{
                                rta.addLast(elementL2);
                                rta.addLast(elementL1);
                            }
                        }
                    }
                }else{
                    if(itL1.hasNext()){
                        Integer elementL1=itL1.next();
                        if(rta.last().element()!=elementL1){
                            if(rta.last().element()>elementL1)
                                rta.addBefore(rta.last(), elementL1);
                            else rta.addLast(elementL1);
                        }
                    }else{
                        Integer elementL2=itL2.next();
                        if(rta.last().element()!=elementL2){
                            if(rta.last().element()>elementL2)
                                rta.addBefore(rta.last(), elementL2);
                            else rta.addLast(elementL2);
                        }
                    }
                }
                  
            }
        }
        return rta;
    }
}
/*
Dadas dos listas de enteros ordenadas L1 y L2, se desea obtener una tercera lista ordenada producto de la
intercalación de L1 y L2. En la lista resultante no debe haber elementos repetidos.
Tener en cuenta que las listas pueden tener distintas longitudes.
 */