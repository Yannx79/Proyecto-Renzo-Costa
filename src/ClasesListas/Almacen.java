
package ClasesListas;

import Clases.Producto;
import java.util.LinkedList;

public class Almacen {
    
    public  String nombre;
    public  String ubicacion;
    public  String codigo;
    public  LinkedList<Producto> listaDeProductos;

    public Almacen(String nombre, String ubicacion, String codigo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
    }
    
    public Almacen(){
        
    }
    
    
    
}
