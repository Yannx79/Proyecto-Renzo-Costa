
package Clases;

public class Persona {
    
    protected String nombre;
    protected String codigo;

    public Persona(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
    
    
    
}
