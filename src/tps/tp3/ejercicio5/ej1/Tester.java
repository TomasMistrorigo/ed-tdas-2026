package tp3.ejercicio5.ej1;

public class Tester {
    public static void main(String[] args) {
        
        Persona[]A=new Persona[3];
        
        A[0]=new Persona("Pepe",18);
        A[1]=new Persona("Oscar",53);
        A[2]=new Persona("Tobias",16);

        System.out.println("antes de invertir...");
        System.out.println(A[0].toString());
        System.out.println(A[1].toString());
        System.out.println(A[2].toString());

        //Invirtiendo
        ArregloPersona.invertir(A);

        System.out.println("despues de invertir");
        System.out.println(A[0].toString());
        System.out.println(A[1].toString());
        System.out.println(A[2].toString());
        
    }
}
