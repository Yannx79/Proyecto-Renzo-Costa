/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Empleado;
import Clases.Producto;
import ClasesListas.*;
import Clases.Usuario;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

public class ControladorData {

    private final File archivoProducto;
    private final File archivoEmpleado;
    private final File archivoUsuario;
    private final File archivoAlmacen;
//    private final File archivoEmpresa;
    private FileReader fr;
    private FileWriter fw;
    private PrintWriter pw;
    private BufferedReader br;
    private StringTokenizer st;

    public ControladorData() {
        archivoEmpleado = new File("src/DB/dataEmpleado.txt");
        archivoProducto = new File("src/DB/dataProducto.txt");
        archivoUsuario = new File("src/DB/dataUsuario.txt");
        archivoAlmacen = new File("src/DB/dataAlmacen");
//        archivoEmpresa = new File("src/DB/dataEmpresa");
    }

    public static void main(String[] args) {
        ControladorData cd = new ControladorData();
//        ListaDeAlmacenes listaDeAlmacenes = cd.instanciarListaAlmacenes2();
//        listaDeAlmacenes.mostrarListaInicioFin();
    }

    /**
     * OPERACIONES A REALIZAR SE INTANCIA LA LISTA A PARTIR DEL TXT SE OPERA LA
     * LISTA SE SOBREESCRIBE EL TXT A PARTIR DE LA LISTA LA TABLA DEPENDE DEL
     * TXT
     */
    /*CLASE PRODUCTO*/
    public void sobreEscribirEnArchivoProductos(LinkedList<Producto> listaProducto) {
        archivoProducto.delete();//EL ARCHIVO SE GENERA DE NUEVO CON LA LISTA
        Iterator<Producto> it = listaProducto.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            try {
                fw = new FileWriter(archivoProducto, true);
                fw.write(p.getCodigoDeProducto() + ";" + p.getEstado() + ";" + p.getCantidad()
                        + ";" + p.getCategoria() + ";" + p.getNombreDeProducto() + ";"
                        + p.getPrecioUnitario() + ";" + p.getAlmacen() + ";"
                        + p.getDestino() + ";" + p.getFechaDeRegistro() + ";"
                        + p.getFechaProgramadaDeEntrega() + ";" + p.getCodigoDeUsuario());
                fw.write(13);
                fw.close();
            } catch (IOException e) {
                e.getMessage();
                e.getLocalizedMessage();
            }
        }
    }

    public LinkedList<Producto> instanciarListaProducto() {
        LinkedList<Producto> lista = new LinkedList<>();
        String linea;
        Producto p;
        String valoresDelProducto[];
        try {
            fr = new FileReader(archivoProducto);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                valoresDelProducto = linea.split(";");
                p = new Producto(
                        valoresDelProducto[0], valoresDelProducto[1], Integer.parseInt(valoresDelProducto[2]), valoresDelProducto[3], valoresDelProducto[4], Double.parseDouble(valoresDelProducto[5]),
                        valoresDelProducto[6], valoresDelProducto[7], valoresDelProducto[8], valoresDelProducto[9], valoresDelProducto[10]
                );
                lista.add(p);
            }
            fr.close();
        } catch (IOException e) {
            e.getMessage();
            e.getLocalizedMessage();
        }
        return lista;
    }

    public void sobreEscribirEnTablaDeProductosInicioFin(DefaultTableModel dtmProductos) {
        dtmProductos.setRowCount(0);//VACIAMOS LA TABLA
        LinkedList<Producto> listaDeProductosTemporales = instanciarListaProducto();
        DecimalFormat dfProducto = new DecimalFormat("#.00");
        Iterator<Producto> it = listaDeProductosTemporales.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            Object[] filaProducto = {p.getCodigoDeProducto(), p.getEstado(), p.getCantidad(), p.getCategoria(),
                p.getNombreDeProducto(), dfProducto.format(p.getPrecioUnitario()), p.getAlmacen(), p.getDestino(), p.getFechaDeRegistro(),
                p.getFechaProgramadaDeEntrega(), p.getCodigoDeUsuario(), dfProducto.format(p.calcularPrecioDeUnTipoDeProducto())
            };
            dtmProductos.addRow(filaProducto);
        }
    }

    public void sobreEscribirEnTablaDeProductosFinInicio(DefaultTableModel dtmProductos) {
        dtmProductos.setRowCount(0);//VACIAMOS LA TABLA
        LinkedList<Producto> listaDeProductosTemporales = instanciarListaProducto();
        DecimalFormat dfProducto = new DecimalFormat("#.00");
        ListIterator<Producto> it = listaDeProductosTemporales.listIterator();
        while (it.hasNext()) {
            it.next();
        }
        while (it.hasPrevious()) {
            Producto p = it.previous();
            Object[] filaProducto = {p.getCodigoDeProducto(), p.getEstado(), p.getCantidad(), p.getCategoria(),
                p.getNombreDeProducto(), dfProducto.format(p.getPrecioUnitario()), p.getAlmacen(), p.getDestino(), p.getFechaDeRegistro(),
                p.getFechaProgramadaDeEntrega(), p.getCodigoDeUsuario(), dfProducto.format(p.calcularPrecioDeUnTipoDeProducto())
            };
            dtmProductos.addRow(filaProducto);
        }
    }

    /*CLASE USUARIO*/
    public void sobreEscribirEnArchivoUsuario(LinkedHashSet<Usuario> listaUsuario) {
        archivoUsuario.delete();//ELIMINAR
        Iterator<Usuario> it = listaUsuario.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            try {
                fw = new FileWriter(archivoUsuario, true);
                fw.write(u.getCodigo() + ";" + u.getNombre() + ";" + u.getTelefono());
                fw.write(13);
                fw.close();
            } catch (IOException e) {
                e.getMessage();
                e.getLocalizedMessage();
            }
        }
    }

    public LinkedList<Usuario> instanciarLinkedListUsuario() {
        LinkedHashSet<Usuario> listaUsuarioHash = instanciarListaDeProductoPorCasaUsuario();
        LinkedList<Usuario> linkedListUsuario = new LinkedList<>();
        Iterator<Usuario> itUsuarioHash = listaUsuarioHash.iterator();
        Usuario usuario = new Usuario();

        while (itUsuarioHash.hasNext()) {
            usuario = itUsuarioHash.next();
            linkedListUsuario.add(usuario);
        }

        return linkedListUsuario;
    }

    public LinkedHashSet<Usuario> instanciarListaUsuario() {
        LinkedHashSet<Usuario> lista = new LinkedHashSet<>();
        String linea;
        Usuario u;
        try {
            fr = new FileReader(archivoUsuario);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] valoresDelUsuario = linea.split(";");
                u = new Usuario(valoresDelUsuario[0], valoresDelUsuario[1], Long.parseLong(valoresDelUsuario[2]));
                lista.add(u);
            }
            fr.close();
        } catch (IOException e) {
            e.getLocalizedMessage();
            e.getMessage();
        }
        return lista;
    }

    public void sobreEscribirTablaDeUsuariosInicioFin(DefaultTableModel dtmUsuarios) {
        dtmUsuarios.setRowCount(0);
        LinkedHashSet<Usuario> listaUsuariosTemporal = instanciarListaUsuario();
        Iterator<Usuario> it = listaUsuariosTemporal.iterator();
        while (it.hasNext()) {
            Usuario usuario = it.next();
            Object[] fila = {usuario.getCodigo(), usuario.getNombre(), usuario.getTelefono()};
            dtmUsuarios.addRow(fila);
        }
    }

    public void sobreEscribirTablaDeUsuariosFinInicio(DefaultTableModel dtmUsuarios) {
        dtmUsuarios.setRowCount(0);
        LinkedList<Usuario> listaUsuariosTemporal = instanciarLinkedListUsuario();
        ListIterator<Usuario> it = listaUsuariosTemporal.listIterator();
        while (it.hasNext()) {
            it.next();
        }
        while (it.hasPrevious()) {
            Usuario usuario = it.previous();
            Object[] fila = {usuario.getCodigo(), usuario.getNombre(), usuario.getTelefono()};
            dtmUsuarios.addRow(fila);
        }
    }

    public void sobreEscribirTablaDeProductoDeUnUsario(DefaultTableModel dtmTablaProducto, Usuario u) {
        dtmTablaProducto.setNumRows(0);
        LinkedList<Producto> listaProducto = u.getListaDeProductos();
        Iterator<Producto> itProducto = listaProducto.iterator();
        DecimalFormat df = new DecimalFormat("####.00");
        Producto p;
        while (itProducto.hasNext()) {
            p = itProducto.next();
            Object fila[] = {p.getCodigoDeProducto(), p.getEstado(), p.getCantidad(), p.getCategoria(), p.getNombreDeProducto(),
                p.getPrecioUnitario(), p.getAlmacen(), p.getDestino(), p.getFechaDeRegistro(), p.getFechaProgramadaDeEntrega(), df.format(p.calcularPrecioDeUnTipoDeProducto())};
            dtmTablaProducto.addRow(fila);
        }
    }

    /*CLASE ALMACEN*/
    public void sobreEscribirArchivoAlmacen(ListaDeAlmacenes listaDeAlmacenes) {
        archivoAlmacen.delete();//ELIMINAR
        NodoAlmacen almacenAuxilar = listaDeAlmacenes.inicio;

        while (almacenAuxilar != null) {
            Almacen almacen = almacenAuxilar.almacen;
            try {
                fw = new FileWriter(archivoAlmacen, true);
                fw.write(almacen.nombre + ";" + almacen.ubicacion + ";" + almacen.codigo);
                fw.write(13);
                fw.close();
            } catch (IOException e) {
                e.getMessage();
                e.getLocalizedMessage();
            }

            almacenAuxilar = almacenAuxilar.siguiente;
        }

    }

    private ListaDeAlmacenes leerDocumentoAlmacen() {
        ListaDeAlmacenes lista = new ListaDeAlmacenes();
        String linea;
        Almacen almacen;
        String valores[];
        try {
            fr = new FileReader(archivoAlmacen);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                valores = linea.split(";");
                almacen = new Almacen(valores[0], valores[1], valores[2]);
                lista.agregarAlFinal(almacen);
            }
            fr.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public LinkedList<Almacen> instanciarLinkedListAlmacen() {
        LinkedList<Almacen> listaAlmacen = new LinkedList<>();
        ListaDeAlmacenes listaDeAlmacenesArgumentada = instanciarListaAlmacenes();
        NodoAlmacen auxiliar = listaDeAlmacenesArgumentada.inicio;
        Almacen almacen;

        while (auxiliar != null) {
            almacen = auxiliar.almacen;
            listaAlmacen.addLast(almacen);
            auxiliar = auxiliar.siguiente;
        }

        return listaAlmacen;
    }

    public ListaDeAlmacenes instanciarListaAlmacenes() {
        ListaDeAlmacenes listaDeAlmacenes = leerDocumentoAlmacen();
        LinkedList<Producto> listaDeProducto = instanciarListaProducto();
        Iterator<Producto> itProducto;
        LinkedList<Producto> listaDeProductosDeAlmacenes;
        Producto producto;

//        listaDeAlmacenes.agregarAlFinal(new Almacen("ALMACEN SANTOS", "Almacen Centro", "00X1"));
//        listaDeAlmacenes.agregarAlFinal(new Almacen("ALMACEN FLORES", "Almacen Norte", "00X2"));
//        listaDeAlmacenes.agregarAlFinal(new Almacen("ALMACEN RUBEN", "Almacen Oeste", "00X3"));
//        listaDeAlmacenes.agregarAlFinal(new Almacen("ALMACEN SIO", "Almacen Sur", "00X4"));
//        listaDeAlmacenes.agregarAlFinal(new Almacen("ALMACEN LAS MARINAS", "Almacen Este", "00X5"));
        NodoAlmacen auxiliar = listaDeAlmacenes.inicio;
        while (auxiliar != null) {
            listaDeProductosDeAlmacenes = new LinkedList<>();
            itProducto = listaDeProducto.iterator();
            while (itProducto.hasNext()) {
                producto = itProducto.next();
                if (auxiliar.almacen.ubicacion.equalsIgnoreCase(producto.getAlmacen())) {
                    listaDeProductosDeAlmacenes.add(producto);
                }
            }
            auxiliar.almacen.listaDeProductos = listaDeProductosDeAlmacenes;
            auxiliar = auxiliar.siguiente;
        }
        return listaDeAlmacenes;
    }

    public void sobreEscribirEnTablaDeProductosSegunAlmacenInicioFin(DefaultTableModel dtmProductos, String nombreDeAlmacen) {
        dtmProductos.setRowCount(0);
        DecimalFormat dfProducto = new DecimalFormat("####.00");
        ListaDeAlmacenes listaDeAlmacenes = instanciarListaAlmacenes();
        NodoAlmacen auxiliar = listaDeAlmacenes.inicio;
        while (auxiliar != null) {
            if (auxiliar.almacen.ubicacion.equalsIgnoreCase(nombreDeAlmacen)) {
                LinkedList<Producto> listaDeProductos = auxiliar.almacen.listaDeProductos;
                Iterator<Producto> itProducto = listaDeProductos.iterator();
                while (itProducto.hasNext()) {
                    Producto producto = itProducto.next();
                    Object[] filaProducto = {producto.getCodigoDeProducto(), producto.getEstado(), producto.getCantidad(), producto.getCategoria(),
                        producto.getNombreDeProducto(), dfProducto.format(producto.getPrecioUnitario()), producto.getAlmacen(), producto.getDestino(), producto.getFechaDeRegistro(),
                        producto.getFechaProgramadaDeEntrega(), producto.getCodigoDeUsuario(), dfProducto.format(producto.calcularPrecioDeUnTipoDeProducto())
                    };
                    dtmProductos.addRow(filaProducto);
                }
                break;
            }
            auxiliar = auxiliar.siguiente;
        }
    }

    public void sobreEscribirEnTablaDeProductosSegunAlmacenFinInicio(DefaultTableModel dtmProductos, String nombreDeAlmacen) {
        dtmProductos.setRowCount(0);
        DecimalFormat dfProducto = new DecimalFormat("####.00");
        ListaDeAlmacenes listaDeAlmacenes = instanciarListaAlmacenes();
        NodoAlmacen auxiliar = listaDeAlmacenes.fin;
        while (auxiliar != null) {
            if (auxiliar.almacen.ubicacion.equalsIgnoreCase(nombreDeAlmacen)) {
                LinkedList<Producto> listaDeProductos = auxiliar.almacen.listaDeProductos;
                ListIterator<Producto> itProducto = listaDeProductos.listIterator();
                while (itProducto.hasNext()) {
                    itProducto.next();
                }
                while (itProducto.hasPrevious()) {
                    Producto producto = itProducto.previous();
                    Object[] filaProducto = {producto.getCodigoDeProducto(), producto.getEstado(), producto.getCantidad(), producto.getCategoria(),
                        producto.getNombreDeProducto(), dfProducto.format(producto.getPrecioUnitario()), producto.getAlmacen(), producto.getDestino(), producto.getFechaDeRegistro(),
                        producto.getFechaProgramadaDeEntrega(), producto.getCodigoDeUsuario(), dfProducto.format(producto.calcularPrecioDeUnTipoDeProducto())
                    };
                    dtmProductos.addRow(filaProducto);
                }
                break;
            }
            auxiliar = auxiliar.anterior;
        }
    }

    public void sobreEscribirEnTablaDeUsuariosSegunAlmacenDeInicioFin(DefaultTableModel dtmUsuarios, String ubicacionDeAlmacen) {
        dtmUsuarios.setRowCount(0);
        LinkedList<Usuario> listaUsuarioPorAlmacen = instanciarLinkedListUsuarioPorAlmacen(ubicacionDeAlmacen);
        Iterator<Usuario> itUsuario = listaUsuarioPorAlmacen.iterator();
        while (itUsuario.hasNext()) {
            Usuario usuario = itUsuario.next();
            Object[] fila = {usuario.getCodigo(), usuario.getNombre(), usuario.getTelefono()};
            dtmUsuarios.addRow(fila);
        }
    }

    public void sobreEscribirEnTablaDeUsuariosSegunAlmacenDeFinInicio(DefaultTableModel dtmUsuarios, String ubicacionDeAlmacen) {
        dtmUsuarios.setRowCount(0);
        LinkedList<Usuario> listaUsuarioPorAlmacen = instanciarLinkedListUsuarioPorAlmacen(ubicacionDeAlmacen);
        ListIterator<Usuario> itUsuario = listaUsuarioPorAlmacen.listIterator();
        while (itUsuario.hasNext()) {
            itUsuario.next();
        }
        while (itUsuario.hasPrevious()) {
            Usuario usuario = itUsuario.previous();
            Object[] fila = {usuario.getCodigo(), usuario.getNombre(), usuario.getTelefono()};
            dtmUsuarios.addRow(fila);
        }
    }

    public LinkedList<Usuario> instanciarLinkedListUsuarioPorAlmacen(String ubicacionDelAlmacen) {
        LinkedList<Usuario> LinkedListDeUsuario = new LinkedList<>();
        LinkedHashSet<Usuario> listaUsuario = getUsuarioPorAlmacen(ubicacionDelAlmacen);
        Iterator<Usuario> itUsuario = listaUsuario.iterator();

        while (itUsuario.hasNext()) {
            Usuario u = itUsuario.next();
            LinkedListDeUsuario.add(u);
        }

        return LinkedListDeUsuario;
    }

    private LinkedHashSet<Usuario> getUsuarioPorAlmacen(String ubicacionDelAlmacen) {
        /*LINKEDHASHSET EVITA QUE TENGA ELEMENTO REPETIDOS*/
        LinkedHashSet<Usuario> listaDeUsuarioDeUnAlmacen = new LinkedHashSet<>();
        LinkedList<Usuario> listaDeUsuario = instanciarLinkedListUsuario();
        Iterator<Usuario> itUsuario;
        ListaDeAlmacenes listaDeAlmacenes = instanciarListaAlmacenes();
        NodoAlmacen nodoAlmacen = listaDeAlmacenes.buscarNodoEspecífico(ubicacionDelAlmacen);
        LinkedList<Producto> listaDeProductoDeUnAlmacen = nodoAlmacen.almacen.listaDeProductos;
        Iterator<Producto> itProducto = listaDeProductoDeUnAlmacen.iterator();
        Producto producto;
        Usuario usuario;

        while (itProducto.hasNext()) {
            producto = itProducto.next();
//            System.out.print(producto.getNombreDeProducto() +" - ");
            itUsuario = listaDeUsuario.iterator();
            while (itUsuario.hasNext()) {
                usuario = itUsuario.next();
//                System.out.print(usuario.getNombre() + " + ");
                if (producto.getCodigoDeUsuario().equalsIgnoreCase(usuario.getCodigo())) {
//                    System.out.println(usuario.getCodigo() + "  " + producto.getCodigoDeUsuario());
                    listaDeUsuarioDeUnAlmacen.add(usuario);
                    break;
                }
            }
//            System.out.println("");
        }

        return listaDeUsuarioDeUnAlmacen;
    }

    /*CLASE EMPLEADO*/
    public LinkedList<Empleado> instanciarListaEmpleado() {
        LinkedList<Empleado> listaEmpleado = new LinkedList<>();
        String linea;
        String[] valores;
        Empleado e;
        try {
            fr = new FileReader(archivoEmpleado);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                valores = linea.split(";");
                e = new Empleado(valores[0], valores[1], valores[2]);
                listaEmpleado.addLast(e);
            }
            fr.close();
        } catch (IOException x) {
            System.err.println(x.getMessage() + "\n" + x.getLocalizedMessage());
        }
        return listaEmpleado;
    }

    /*ASOCIACIONES ENTRE CLASES*/
    public LinkedHashSet<Usuario> instanciarListaDeProductoPorCasaUsuario() {
        LinkedHashSet<Usuario> listaDeUsuario = instanciarListaUsuario();
        LinkedList<Producto> listaDeProductos = instanciarListaProducto();
        LinkedList listaDeProductoPorUsuario;
        Iterator<Usuario> itUsuario = listaDeUsuario.iterator();
        ListIterator<Producto> itProducto;
        Usuario usuario;
        Producto producto;
        while (itUsuario.hasNext()) {
            listaDeProductoPorUsuario = new LinkedList();
            usuario = itUsuario.next();
            itProducto = listaDeProductos.listIterator();
            while (itProducto.hasNext()) {
                producto = itProducto.next();
                if (usuario.getCodigo().equalsIgnoreCase(producto.getCodigoDeUsuario())) {
                    listaDeProductoPorUsuario.add(producto);
                }
            }
            usuario.setListaDeProductos(listaDeProductoPorUsuario);
        }
        return listaDeUsuario;
    }

    public void sobreEscribirArchivoProducto(LinkedHashSet<Usuario> listaUsuario) {
        archivoProducto.delete();
        Iterator<Usuario> itUsuario = listaUsuario.iterator();
        Iterator<Producto> itProducto;
        LinkedList<Producto> listaProductoIndividual;
        while (itUsuario.hasNext()) {
            listaProductoIndividual = itUsuario.next().getListaDeProductos();
            itProducto = listaProductoIndividual.iterator();
            while (itProducto.hasNext()) {
                Producto p = itProducto.next();
                try {
                    fw = new FileWriter(archivoProducto, true);
                    fw.write(p.getCodigoDeProducto() + ";" + p.getEstado() + ";" + p.getCantidad() + ";" + p.getCategoria() + ";" + p.getNombreDeProducto() + ";"
                            + p.getPrecioUnitario() + ";" + p.getAlmacen() + ";" + p.getDestino() + ";" + p.getFechaDeRegistro() + ";" + p.getFechaProgramadaDeEntrega() + ";" + p.getCodigoDeUsuario());
                    fw.write(13);
                    fw.close();
                } catch (IOException e) {
                    e.getMessage();
                    e.getLocalizedMessage();
                }
            }
        }
    }

}
