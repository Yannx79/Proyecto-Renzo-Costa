package ClasesListas;

public class NodoAlmacen {

    public Almacen almacen;
    public NodoAlmacen anterior;
    public NodoAlmacen siguiente;

    public NodoAlmacen(Almacen almacen) {
        this(almacen, null, null);
    }

    public NodoAlmacen(Almacen almacen, NodoAlmacen anterior, NodoAlmacen siguiente) {
        this.almacen = almacen;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

}
