import tp4.ejercicio1.ListaDoblementeEnlazada;

public class testerEj1 {
    public static void main(String[]args){
        ListaDoblementeEnlazada<Integer> l=new ListaDoblementeEnlazada<>();
        l.addFirst(5);
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);

        for(Integer e:l.dividirLista(l.first())){
            System.out.print(e+" ");
        }
        System.out.println();
        for(Integer e:l){
            System.out.print(e);
        }
    }
}
