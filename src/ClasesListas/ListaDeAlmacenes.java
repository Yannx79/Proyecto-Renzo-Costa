/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesListas;

public class ListaDeAlmacenes {

    public NodoAlmacen inicio, fin;

    public ListaDeAlmacenes() {
        inicio = fin = null;
    }

    /*LISTA ESTA VACIA*/
    public boolean estaVacia() {
        return inicio == null;
    }

    /*AGREGAR AL FINAL*/
    public void agregarAlFinal(Almacen almacen) {
        if (!estaVacia()) {
            fin = new NodoAlmacen(almacen, fin, null);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoAlmacen(almacen);
        }
    }

    public void agregarAlInicio(Almacen almacen) {
        if (!estaVacia()) {
            inicio = new NodoAlmacen(almacen, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoAlmacen(almacen);
        }
    }

    /*MOSTRAR DE INICIO A FIN*/
    public void mostrarListaInicioFin() {
        if (!estaVacia()) {
            String datos = "";
            NodoAlmacen auxiliar = inicio;
            while (auxiliar != null) {
                datos = datos + "<=>{" + "Nombre: " + auxiliar.almacen.nombre + " Codigo de Almacen: "
                        + auxiliar.almacen.codigo + " Ubicación: " + auxiliar.almacen.ubicacion + "}<=>";
                auxiliar = auxiliar.siguiente;
            }
            System.out.println("LISTA");
            System.out.println(datos);
        }
    }

    /*MOSTRAR DE FIN A INICIO*/
    public void mostrarListFinInicio() {
        if (!estaVacia()) {
            String datos = "";
            NodoAlmacen auxiliar = fin;
            while (auxiliar != null) {
                datos = datos + "<=>{" + "Nombre: " + auxiliar.almacen.nombre + " Codigo de Almacen: "
                        + auxiliar.almacen.codigo + " Ubicación: " + auxiliar.almacen.ubicacion + "}<=>";
                auxiliar = auxiliar.anterior;
            }
            System.out.println("LISTA");
            System.out.println(datos);
        }
    }

    /*ELIMINAR INICIO, FINAL, ESPECIFICO*/
    public void eliminarDelInicio() {
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
    }

    public void eliminarDelFinal() {
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
    }

    public NodoAlmacen buscarNodoEspecífico(String ubicacionDelAlmacen){
        NodoAlmacen auxiliar = inicio;
        while(auxiliar != null && !auxiliar.almacen.ubicacion.equalsIgnoreCase(ubicacionDelAlmacen)){
            auxiliar = auxiliar.siguiente;
        }
        return auxiliar;
    }
    
    public boolean eliminarNodoEspecifico(Almacen almacen) {
        NodoAlmacen actual = inicio;
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            encontrado = actual.almacen == almacen;
            if (!encontrado) {
                actual = actual.siguiente;
            }
        }
        if (encontrado) {
            if (inicio == fin) {
                inicio = fin = null;
            } else if (actual == fin) {
                fin = fin.anterior;
                fin.siguiente = null;
            } else if (actual == inicio) {
                inicio = inicio.siguiente;
                inicio.anterior = null;
            } else {
                actual.anterior.siguiente = actual.siguiente;
                actual = null;
            }
        }
        return encontrado;
    }

}
