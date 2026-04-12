package tp3.ejercicio5.ej1;

class Persona{
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad){
        this.nombre=nombre;
        this.edad=Math.abs(edad);
    }
    public String getNombre(){return nombre;}
    public int getEdad(){return edad;}
    public String toString(){
        return nombre+" "+edad;
    }
}