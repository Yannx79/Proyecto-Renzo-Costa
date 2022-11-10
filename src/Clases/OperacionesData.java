package Clases;

import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Leer y escribir y listar
public class OperacionesData {

    private final File archivoProducto;
    private final File archivoEmpleado;
    private final File archivoUsuario;
    private FileReader fr;
    private FileWriter fw;
    private PrintWriter pw;
    private BufferedReader br;
    private StringTokenizer st;

    public OperacionesData() {
        archivoEmpleado = new File("src/DB/dataEmpleado.txt");
        archivoProducto = new File("src/DB/dataProducto.txt");
        archivoUsuario = new File("src/DB/dataUsuario.txt");
    }

    public static void main(String[] args) {
        OperacionesData od = new OperacionesData();
        LinkedHashSet<Usuario> lsitaU = od.agregarListaDeProductoALosUsuariosInstanciados();
        for (Usuario u : lsitaU) {
            System.out.print(u.getNombre() + ": ");
            for (Producto p : u.getListaDeProductos()) {
                System.out.print(p.getNombreDeProducto() + ", ");
            }
            System.out.println("");
        }
    }

    /*OPERACIONES PARA LOS EMPLEADOS*/
    public void escribirEnArchivoEmpleado(Empleado e) {
        try {
            fw = new FileWriter(archivoEmpleado, true);
            fw.write(e.getNombre() + ";" + e.getCorreo() + ";" + e.getContrasena());
            fw.write(13);
            fw.close();
        } catch (IOException ioe) {
            ioe.getMessage();
            ioe.getLocalizedMessage();
        }
    }

    public void leerEInstanciarListaEmpleado(LinkedHashSet<Empleado> listaEmpleados) {
        listaEmpleados.clear();//Eliminar Datos anteriores
        String linea;
        String valoresDelEmpleado[];
        Empleado e;
        try {
            fr = new FileReader(archivoEmpleado);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                valoresDelEmpleado = linea.split(";");//Omitimos el metodo StringTokenizer
                e = new Empleado(valoresDelEmpleado[0], valoresDelEmpleado[1], valoresDelEmpleado[2]);
                listaEmpleados.add(e);
            }
            fr.close();
        } catch (IOException ioe) {
            ioe.getMessage();
            ioe.getLocalizedMessage();
        }
    }

    public void crearTablaEmpleado(DefaultTableModel dtmEmpleado) {
        dtmEmpleado.setRowCount(0);//Limpiamos filas
        LinkedHashSet<Empleado> listaEmpleadoTemporal = new LinkedHashSet<>();
        leerEInstanciarListaEmpleado(listaEmpleadoTemporal);
        for (Empleado e : listaEmpleadoTemporal) {
            Object[] fila = {e.getNombre(), e.getCorreo(), "***********"};
            dtmEmpleado.addRow(fila);
        }
    }

    public boolean validarEmpleado(String nombre, String correo, String contrasena) {
        LinkedHashSet<Empleado> listaEmpleadosTemporal = new LinkedHashSet<>();
        leerEInstanciarListaEmpleado(listaEmpleadosTemporal);
        for (Empleado empleado : listaEmpleadosTemporal) {
            if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getCorreo().equalsIgnoreCase(correo) && empleado.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "NOMBRE O CORREO O CONTRASEÑA INCORRECTAS", "VERFICAR DATOS", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    /*OPERACIONES DE PARA LOS USUARIOS*/
    public void escribirEnArchivoUsuario(Usuario u) {
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

    public void leerEInstanciarListaDeUsuarios(LinkedHashSet<Usuario> listaDeUsuarios) {
        listaDeUsuarios.clear();//Limpia los objetos existentes anteriores
        String linea;
        Usuario u;
        String[] valoresDelUsuario;
        try {
            fr = new FileReader(archivoUsuario);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                valoresDelUsuario = linea.split(";");
                u = new Usuario(valoresDelUsuario[0], valoresDelUsuario[1], Long.parseLong(valoresDelUsuario[2]));
                listaDeUsuarios.add(u);
            }
            fr.close();
        } catch (IOException e) {
            e.getLocalizedMessage();
            e.getMessage();
        }
    }

    public void escribirEnTablaDeUsuarios(DefaultTableModel dtmUsuarios) {
        dtmUsuarios.setRowCount(0);
        LinkedHashSet<Usuario> listaUsuariosTemporal = new LinkedHashSet<>();
        leerEInstanciarListaDeUsuarios(listaUsuariosTemporal);
        for (Usuario usuario : listaUsuariosTemporal) {
            Object[] fila = {usuario.getCodigo(), usuario.getNombre(), usuario.getTelefono()};
            dtmUsuarios.addRow(fila);
        }
    }

    public double calcularMontoFinalDeUnUsuario(String codigo) {
        LinkedHashSet<Usuario> listaDeUsuarios = agregarListaDeProductoALosUsuariosInstanciados();
        double montoFinal = 0;
        for (Usuario u : listaDeUsuarios) {
            if (u.getCodigo().equalsIgnoreCase(codigo)) {
                for (Producto p : u.getListaDeProductos()) {
                    montoFinal += p.calcularPrecioDeUnTipoDeProducto();
                }
                return montoFinal;
            }
        }
        return montoFinal;
    }

    public Usuario buscarUsuario(String codigo) {
        LinkedHashSet<Usuario> listaDeUsuarios = agregarListaDeProductoALosUsuariosInstanciados();
        for (Usuario u : listaDeUsuarios) {
            if (u.getCodigo().equalsIgnoreCase(codigo)) {
                return u;
            }
        }
        return null;
    }

    /*OPERACIONES DE PARA LOS PRODUCTOS*/
    public void escribirEnArchivoProductos(Producto p) {
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

    public void escribirEnArchivoProducto(LinkedList<Producto> list) {
        archivoUsuario.delete();
        ListIterator<Producto> it = list.listIterator();
        while (it.hasNext()) {
            Producto p = it.next();
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

    public void leerEInstanciarListaDeProductoDeTodosLosClientes(LinkedList<Producto> listaDeProductos) {
        listaDeProductos.clear();//Evitar los elementos repetidos
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
                listaDeProductos.add(p);
            }
            fr.close();
        } catch (IOException e) {
            e.getMessage();
            e.getLocalizedMessage();
        }
    }

    public void escribirEnTablaDeProductos(DefaultTableModel dtmProductos) {
        dtmProductos.setRowCount(0);
        LinkedList<Producto> listaDeProductosTemporales = new LinkedList<>();
        leerEInstanciarListaDeProductoDeTodosLosClientes(listaDeProductosTemporales);
        DecimalFormat dfProducto = new DecimalFormat("#.00");
        for (Producto p : listaDeProductosTemporales) {
            Object[] filaProducto = {p.getCodigoDeProducto(), p.getEstado(), p.getCantidad(), p.getCategoria(),
                p.getNombreDeProducto(), dfProducto.format(p.getPrecioUnitario()), p.getAlmacen(), p.getDestino(), p.getFechaDeRegistro(),
                p.getFechaProgramadaDeEntrega(), p.getCodigoDeUsuario(), dfProducto.format(p.calcularPrecioDeUnTipoDeProducto())
            };
            dtmProductos.addRow(filaProducto);
        }
    }

    /*OPERACIONES ENTRE CLASES*/
    public LinkedHashSet agregarListaDeProductoALosUsuariosInstanciados() {
        LinkedList<Producto> listaDeProductos;
        LinkedList<Producto> listaDeProductosTemporal = new LinkedList<>();
        LinkedHashSet<Usuario> listaDeUsuariosTemporal = new LinkedHashSet<>();
        leerEInstanciarListaDeProductoDeTodosLosClientes(listaDeProductosTemporal);
        leerEInstanciarListaDeUsuarios(listaDeUsuariosTemporal);
        /*CIRCULAR EN AMBAS LISTAS*/
        for (Usuario u : listaDeUsuariosTemporal) {
            listaDeProductos = new LinkedList<>();//Por cada Usuario se instancia una nueva Lista
            for (Producto p : listaDeProductosTemporal) {
                if (u.getCodigo().equalsIgnoreCase(p.getCodigoDeUsuario())) {
                    listaDeProductos.add(p);
                }
            }
            /*A las lista vacias se le agrega un elemento*/
            if (listaDeProductos.isEmpty()) {
                listaDeProductos.add(new Producto());
            }
            u.setListaDeProductos(listaDeProductos);
        }
        return listaDeUsuariosTemporal;
    }

    public void escribirProductoDeUnUsuarioEnTabla(DefaultTableModel dtmTablaDeProductoIndividuales, Usuario u) {
        dtmTablaDeProductoIndividuales.setNumRows(0);
//        Usuario usuario = buscarUsuario(u.getCodigo());
        for (Producto p : u.getListaDeProductos()) {
            Object fila[] = {p.getCodigoDeProducto(), p.getEstado(), p.getCantidad(), p.getCategoria(), p.getNombreDeProducto(),
                p.getPrecioUnitario(), p.getAlmacen(), p.getDestino(), p.getFechaDeRegistro(), p.getFechaProgramadaDeEntrega(), p.calcularPrecioDeUnTipoDeProducto()};
            dtmTablaDeProductoIndividuales.addRow(fila);
        }
    }

}
