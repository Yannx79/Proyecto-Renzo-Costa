/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author yanni
 */
public class Producto implements Comparable<Producto> {

    private String codigoDeProducto;
    private String estado; //En Almacen, Partiendo, En Camino, Entregado
    private int cantidad;
    private String categoria; // Calzado, Casaca, Billeteras, Carteras, Mochilas, Correas, Accesorios
    private String nombreDeProducto;
    private double precioUnitario;
    private String almacen; //Partida = {Almacen Centro, Almacen Norte, Almacen Oeste, Almacen Sur, Almacen Este}
    private String destino;
    private String fechaDeRegistro;
    private String fechaProgramadaDeEntrega;
    private String codigoDeUsuario;
    private static boolean comparacion[]; // codigo, nombre, cantidad, precio total, fecha de registro, fecha de salida

    public Producto(String codigoDeProducto, String estado, int cantidad, String categoria, String nombreDeProducto, double precioUnitario, String almacen, String destino, String fechaDeRegistro, String fechaProgramadaDeEntrega, String codigoDeUsuario) {
        this.codigoDeProducto = codigoDeProducto;
        this.estado = estado;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.nombreDeProducto = nombreDeProducto;
        this.precioUnitario = precioUnitario;
        this.almacen = almacen;
        this.destino = destino;
        this.fechaDeRegistro = fechaDeRegistro;
        this.fechaProgramadaDeEntrega = fechaProgramadaDeEntrega;
        this.nombreDeProducto = nombreDeProducto;
        this.codigoDeUsuario = codigoDeUsuario;
        comparacion = new boolean[6];
        for (int i = 0; i < 6; i++) {
            comparacion[i] = false;
        }
        comparacion[0] = true;
    }

    public Producto() {

    }

    public static void setComparacion(boolean[] comparacion) {
        Producto.comparacion = comparacion;
    }

    public String getCodigoDeUsuario() {
        return codigoDeUsuario;
    }

    public void setCodigoDeUsuario(String codigoDeUsuario) {
        this.codigoDeUsuario = codigoDeUsuario;
    }

    public double calcularPrecioDeUnTipoDeProducto() {
        return cantidad * precioUnitario;
    }

    public String getCodigoDeProducto() {
        return codigoDeProducto;
    }

    public void setCodigoDeProducto(String codigoDeProducto) {
        this.codigoDeProducto = codigoDeProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreDeProducto() {
        return nombreDeProducto;
    }

    public void setNombreDeProducto(String nombreDeProducto) {
        this.nombreDeProducto = nombreDeProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getFechaProgramadaDeEntrega() {
        return fechaProgramadaDeEntrega;
    }

    public void setFechaProgramadaDeEntrega(String fechaProgramadaDeEntrega) {
        this.fechaProgramadaDeEntrega = fechaProgramadaDeEntrega;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoDeProducto=" + codigoDeProducto + ", estado=" + estado + ", cantidad=" + cantidad + ", categoria=" + categoria + ", nombreDeProducto=" + nombreDeProducto + ", precioUnitario=" + precioUnitario + ", almacen=" + almacen + ", destino=" + destino + ", fechaDeRegistro=" + fechaDeRegistro + ", fechaProgramadaDeEntrega=" + fechaProgramadaDeEntrega + ", codigoDeUsuario=" + codigoDeUsuario + '}';
    }

    @Override
    public int compareTo(Producto t) {
        return (comparacion[0]) ? this.codigoDeProducto.compareTo(t.codigoDeProducto)
                : (comparacion[1]) ? this.nombreDeProducto.compareTo(t.nombreDeProducto)
                        : (comparacion[2]) ? t.cantidad - this.cantidad
                                : (comparacion[3]) ? (int) (t.calcularPrecioDeUnTipoDeProducto() - this.calcularPrecioDeUnTipoDeProducto())
                                        : (comparacion[4]) ? this.getFechaDeRegistro().compareTo(t.getFechaDeRegistro())
                                                : this.getFechaProgramadaDeEntrega().compareTo(t.getFechaProgramadaDeEntrega());
    }

}
