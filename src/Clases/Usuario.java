/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Usuario extends Persona {

    private long telefono;
    private LinkedList<Producto> listaDeProductos;

    public Usuario(String codigo, String nombre, long telefono) {
        super(nombre, codigo);
        this.telefono = telefono;
        this.listaDeProductos = new LinkedList<>();//Instaciar una nueva lista
    }

    public Usuario() {
        super(null, null);
        this.telefono = 0;
        this.listaDeProductos = new LinkedList<>();//Instaciar una nueva lista
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public LinkedList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(LinkedList<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public String calcularCategoriaMasSolicitada(String ubicacionDelAlmacen) {
        String categoria = "";
        Iterator<Producto> itProducto = listaDeProductos.iterator();
        int cantidadCalzado = 0, cantidadCasaca = 0, cantidadBilletera = 0,
                cantidadCartera = 0, cantidadMochila = 0, cantidadCorreas = 0, cantidadAccesorio = 0;
        int elMasDemandado = -99999;
        // Calzado, Casaca, Billeteras, Carteras, Mochilas, Correas, Accesorios
        while (itProducto.hasNext()) {
            Producto p = itProducto.next();
            if (p.getAlmacen().equalsIgnoreCase(ubicacionDelAlmacen)) {
                cantidadCalzado += elProductoPerteneceALaCategoria(p, "Calzado");
                cantidadCasaca += elProductoPerteneceALaCategoria(p, "Casaca");
                cantidadBilletera += elProductoPerteneceALaCategoria(p, "Billeteras");
                cantidadCartera += elProductoPerteneceALaCategoria(p, "Carteras");
                cantidadMochila += elProductoPerteneceALaCategoria(p, "Mochilas");
                cantidadCorreas += elProductoPerteneceALaCategoria(p, "Correas");
                cantidadAccesorio += elProductoPerteneceALaCategoria(p, "Accesorios");
            }
        }
        if (elMasDemandado < cantidadCalzado) {
            elMasDemandado = cantidadCalzado;
            categoria = "CALZADO";
        }
        if (elMasDemandado < cantidadAccesorio) {
            elMasDemandado = cantidadAccesorio;
            categoria = "ACCESORIOS";
        }
        if (elMasDemandado < cantidadBilletera) {
            elMasDemandado = cantidadBilletera;
            categoria = "BILLETERAS";
        }
        if (elMasDemandado < cantidadCartera) {
            elMasDemandado = cantidadCartera;
            categoria = "CARTERA";
        }
        if (elMasDemandado < cantidadCasaca) {
            elMasDemandado = cantidadCasaca;
            categoria = "CASACA";
        }
        if (elMasDemandado < cantidadCorreas) {
            elMasDemandado = cantidadCorreas;
            categoria = "CORREAS";
        }
        if (elMasDemandado < cantidadMochila) {
            elMasDemandado = cantidadMochila;
            categoria = "MOCHILA";
        }
        return categoria;
    }
    
    private int elProductoPerteneceALaCategoria(Producto p, String categoria) {
        if (p.getCategoria().equalsIgnoreCase(categoria)) {
            return 1;
        } else {
            return 0;
        }
    }

    public double calcularPrecioTotal() {
        double precioTotal = 0;
        for (Producto producto : listaDeProductos) {
            precioTotal += producto.calcularPrecioDeUnTipoDeProducto();
        }
        return precioTotal;
    }

    public double calcularPrecioTotalPorAlmacen(String ubicacionDelAlmacen) {
        double precioTotal = 0;
        Iterator<Producto> itProducto = listaDeProductos.iterator();
        while (itProducto.hasNext()) {
            Producto p = itProducto.next();
            if (p.getAlmacen().equalsIgnoreCase(ubicacionDelAlmacen)) {
                precioTotal += p.calcularPrecioDeUnTipoDeProducto();
            }
        }
        return precioTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.telefono ^ (this.telefono >>> 32));
        hash = 29 * hash + Objects.hashCode(this.listaDeProductos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.listaDeProductos, other.listaDeProductos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "telefono=" + telefono + '}';
    }

}
