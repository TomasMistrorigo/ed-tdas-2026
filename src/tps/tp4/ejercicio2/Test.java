package tp4.ejercicio2;

public class Test {
    public static void main(String[]args){
        ListaDoblementeEnlazadaMOD<Integer> l1=new ListaDoblementeEnlazadaMOD<>();
        ListaDoblementeEnlazadaMOD<String> l2=new ListaDoblementeEnlazadaMOD<>();
        ListaDoblementeEnlazadaMOD<Integer> l3=new ListaDoblementeEnlazadaMOD<>();

        l1.addFirst(1);
        l1.segundoYanteUltimo(3, 2);
        for(Integer elem:l1){
            System.out.println(elem);
        }

        System.out.println();

        l2.segundoYanteUltimo("al final", "al comienzo");
        for(String s:l2){
            System.out.println(s);
        }

        System.out.println();

        l3.addFirst(0);
        l3.addLast(2);
        l3.addLast(4);
        l3.segundoYanteUltimo(1, 3);
        for(int i:l3){
            System.out.println(i);
        }
    }
}
