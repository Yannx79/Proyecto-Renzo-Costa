package Controladores;

import Clases.OperacionesData;
import Clases.Producto;
import Clases.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Window;
import java.util.LinkedHashSet;
import org.jfree.data.general.DefaultPieDataset;

public class ControladorDeGraficas {

    private OperacionesData od;

    public ControladorDeGraficas() {
        od = new OperacionesData();
    }

    public void graficarBarrasDeEstado(JPanel jp) {
        LinkedList<Producto> listaDeProductoTemporales = new LinkedList<>();
        od.leerEInstanciarListaDeProductoDeTodosLosClientes(listaDeProductoTemporales);
        int cantidaEnAlmacen = 0, cantidadPartiendo = 0, cantidadEnCamino = 0, cantidadEntregado = 0;
        /*ENCONTRAR LOS VALORES Y EN LA GRAFICA*/
        for (Producto p : listaDeProductoTemporales) {
            if (p.getEstado().equalsIgnoreCase("En Almacen")) {
                cantidaEnAlmacen++;
            } else if (p.getEstado().equalsIgnoreCase("Partiendo")) {
                cantidadPartiendo++;
            } else if (p.getEstado().equalsIgnoreCase("En Camino")) {
                cantidadEnCamino++;
            } else {//ENTREGADO
                cantidadEntregado++;
            }
        }
        /*Graficar*/
        DefaultCategoryDataset datosEstado = new DefaultCategoryDataset();
        datosEstado.setValue(cantidaEnAlmacen, "UBICACION", "EN ALMACEN");
        datosEstado.setValue(cantidadPartiendo, "UBICACION", "PARTIENDO");
        datosEstado.setValue(cantidadEnCamino, "UBICACION", "EN CAMINO");
        datosEstado.setValue(cantidadEntregado, "UBICACION", "ENTREGADO");
        JFreeChart graficoDeBarras = ChartFactory.createBarChart3D(
                "SEGUIMIENTO DE LOS PRODUCTOS VS CANTIDAD",
                "UBICACIÓN DE LOS PRODUCTOS",
                "CANTIDAD",
                datosEstado,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        ChartPanel chartPanelBarras = new ChartPanel(graficoDeBarras);
        chartPanelBarras.setMouseWheelEnabled(true);
        chartPanelBarras.setPreferredSize(new Dimension(jp.getWidth(), jp.getHeight()));
        jp.setLayout(new BorderLayout());
        jp.add(chartPanelBarras, BorderLayout.NORTH);
        //pack();
        //repaint();
    }

    public void graficarCircularDeCategoriaParaUnUsuario(JPanel jp, String codigo) {
        int cantidadCalzado, cantidadCasaca, cantidadBilletera, cantidadCartera, cantidadMochila, cantidadCorrea, cantidadAccesorios;
        Usuario usuario = od.buscarUsuario(codigo);
        cantidadCalzado = calcularCantidadDeCategoriaParaUnUsuario("Calzado", codigo);
        cantidadAccesorios = calcularCantidadDeCategoriaParaUnUsuario("Accesorios", codigo);
        cantidadCasaca = calcularCantidadDeCategoriaParaUnUsuario("Casaca", codigo);
        cantidadBilletera = calcularCantidadDeCategoriaParaUnUsuario("Billeteras", codigo);
        cantidadCartera = calcularCantidadDeCategoriaParaUnUsuario("Carteras", codigo);
        cantidadMochila = calcularCantidadDeCategoriaParaUnUsuario("Mochilas", codigo);
        cantidadCorrea = calcularCantidadDeCategoriaParaUnUsuario("Correas", codigo);
        DefaultPieDataset datosCirculares = new DefaultPieDataset();
        datosCirculares.setValue("CALZADO", cantidadCalzado);
        datosCirculares.setValue("ACCESORIOS", cantidadAccesorios);
        datosCirculares.setValue("CASACA", cantidadCasaca);
        datosCirculares.setValue("BILLETERAS", cantidadBilletera);
        datosCirculares.setValue("CARTERA", cantidadCartera);
        datosCirculares.setValue("MOCHILA", cantidadMochila);
        datosCirculares.setValue("CORREA", cantidadCorrea);
        JFreeChart graficoCircular = ChartFactory.createPieChart3D(
                "CATEGORIA DE PRODUCTOS COMPRADO POR " + usuario.getNombre().toUpperCase(),
                datosCirculares,
                true,
                true,
                false
        );
        ChartPanel panelCircular = new ChartPanel(graficoCircular);
        panelCircular.setMouseWheelEnabled(true);
        panelCircular.setPreferredSize(new Dimension(jp.getWidth(), jp.getHeight()));
        jp.setLayout(new BorderLayout());
        jp.add(panelCircular, BorderLayout.NORTH);
    }

    public void graficarBarrarDeEstadoParaUnUsuario(JPanel jp, String codigo) {
        Usuario u = od.buscarUsuario(codigo);
        int cantidaEnAlmacen = 0, cantidadPartiendo = 0, cantidadEnCamino = 0, cantidadEntregado = 0;
        /*ENCONTRAR LOS VALORES Y EN LA GRAFICA*/
        for (Producto p : u.getListaDeProductos()) {
            if (p.getEstado().equalsIgnoreCase("En Almacen")) {
                cantidaEnAlmacen++;
            } else if (p.getEstado().equalsIgnoreCase("Partiendo")) {
                cantidadPartiendo++;
            } else if (p.getEstado().equalsIgnoreCase("En Camino")) {
                cantidadEnCamino++;
            } else {
                cantidadEntregado++;
            }
        }
        DefaultCategoryDataset datosBarra = new DefaultCategoryDataset();
        datosBarra.setValue(cantidaEnAlmacen, "ESTADO", "EN ALMACEN");
        datosBarra.setValue(cantidadPartiendo, "ESTADO", "PARTIENDO");
        datosBarra.setValue(cantidadEnCamino, "ESTADO", "EN CAMINO");
        datosBarra.setValue(cantidadEntregado, "ESTADO", "ENTREGADO");
        JFreeChart graficoCircular = ChartFactory.createBarChart3D(
                "SEGUIMIENTO DE LOS PRODUCTOS DE " + u.getNombre().toUpperCase(),
                "UBICACION",
                "CANTIDAD",
                datosBarra,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false
        );
        ChartPanel panelCircular = new ChartPanel(graficoCircular);
        panelCircular.setMouseWheelEnabled(true);
        panelCircular.setPreferredSize(new Dimension(jp.getWidth(), jp.getHeight()));
        jp.setLayout(new BorderLayout());
        jp.add(panelCircular, BorderLayout.NORTH);
    }

    private int calcularCantidadDeCategoriaParaUnUsuario(String categoria, String codigo) {
        Usuario usuario = od.buscarUsuario(codigo);
        int cantidad = 0;
        for (Producto producto : usuario.getListaDeProductos()) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                cantidad++;
            }
        }
        return cantidad;
    }

}
