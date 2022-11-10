/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Empleado;
import Clases.Producto;
import Clases.Usuario;
import ClasesListas.Almacen;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Plantilla {

    private String nombreDelGerente;
    private String nombreDelDocumento;
    private String formato;
    private LinkedList<Producto> listaProducto;
    private LinkedList<Usuario> listaUsuario;
    private LinkedList<Empleado> listaEmpleado;
    private LinkedList<Almacen> listaAlmacen;
    private boolean imprimir[];
    /*usuario, empleado, almacen, producto*/
    private ControladorData cd;

    Document documento;
    FileOutputStream archivo;
    private Paragraph titulo;
    private BaseColor colorContador;
    private BaseColor colorCabecera;

    public static void main(String[] args) {
        boolean[] valor = {true, true, true, true};
        Plantilla p = new Plantilla("YANNICK", "YannickDocu", "pdf", valor);
        p.buildPlantilla();
    }

    public Plantilla(String nombreDelGerente, String nombreDelDocumento, String formato, boolean[] tablaParaImprimir) {
        this.nombreDelGerente = nombreDelGerente;
        this.nombreDelDocumento = nombreDelDocumento;
        this.formato = formato;
        this.imprimir = tablaParaImprimir;
        this.cd = new ControladorData();
        this.listaProducto = cd.instanciarListaProducto();
        this.listaUsuario = cd.instanciarLinkedListUsuario();
        this.listaEmpleado = cd.instanciarListaEmpleado();
        this.listaAlmacen = cd.instanciarLinkedListAlmacen();
        colorCabecera = new BaseColor(149,16,43);
        colorContador = new BaseColor(215,215,215);
        documento = new Document();
        titulo = new Paragraph("TABLAS IMPORTANTES DE LA EMPRESA RENZO COSTA S.A.C");
    }
    public Plantilla(String nombreDelGerente, String nombreDelDocumento, String formato, boolean[] tablaParaImprimir, BaseColor colorContador, BaseColor colorCabecera) {
        this.nombreDelGerente = nombreDelGerente;
        this.nombreDelDocumento = nombreDelDocumento;
        this.formato = formato;
        this.imprimir = tablaParaImprimir;
        this.cd = new ControladorData();
        this.listaProducto = cd.instanciarListaProducto();
        this.listaUsuario = cd.instanciarLinkedListUsuario();
        this.listaEmpleado = cd.instanciarListaEmpleado();
        this.listaAlmacen = cd.instanciarLinkedListAlmacen();
        colorCabecera = colorCabecera;
        colorContador = colorContador;
        documento = new Document();
        titulo = new Paragraph("TABLAS IMPORTANTES DE LA EMPRESA RENZO COSTA S.A.C");
    }

    public Plantilla() {
    }
    
    public void buildPlantilla() {
        Iterator it;
        int numero = 0;
        try {
            archivo = new FileOutputStream("documentos/" + nombreDelDocumento + "." + formato);
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(Element.ALIGN_CENTER);

            Image image = null;
            try {
                image = Image.getInstance("src/Imagenes/imgLogojpg.jpg");
                image.scaleAbsolute(50,50);
                image.setAbsolutePosition(0,0);
            } catch (Exception e) {
                System.err.println(e.getCause());
            }

            documento.add(image);
            documento.add(titulo);
            documento.add(new Paragraph("NOMBRE DEL GERENTE: " + nombreDelGerente.toUpperCase()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
            Date fecha = new Date();
            documento.add(new Paragraph("FECHA: " + sdf.format(fecha)));
            documento.add(Chunk.NEWLINE);
            /*TABLA USUARIO*/
            if (imprimir[0]) {
                Paragraph tituloUsuario = new Paragraph("TABLA DE USUARIOS");
                tituloUsuario.setAlignment(Element.ALIGN_CENTER);
                documento.add(tituloUsuario);
                documento.add(Chunk.NEWLINE);
                PdfPTable tablaUsuario = new PdfPTable(4);
                tablaUsuario.setWidthPercentage(100);
                PdfPCell contador = new PdfPCell(new Phrase("N°"));
                contador.setBackgroundColor(colorContador);
                PdfPCell codigo = new PdfPCell(new Phrase("CODIGO"));
                codigo.setBackgroundColor(colorCabecera);
                PdfPCell nombre = new PdfPCell(new Phrase("NOMBRE"));
                nombre.setBackgroundColor(colorCabecera);
                PdfPCell telefono = new PdfPCell(new Phrase("TELEFONO"));
                telefono.setBackgroundColor(colorCabecera);
                tablaUsuario.addCell(contador);
                tablaUsuario.addCell(codigo);
                tablaUsuario.addCell(nombre);
                tablaUsuario.addCell(telefono);
                it = listaUsuario.iterator();
                Usuario u;
                while (it.hasNext()) {
                    numero++;
                    u = (Usuario) it.next();
                    tablaUsuario.addCell(String.valueOf(numero));
                    tablaUsuario.addCell(u.getCodigo());
                    tablaUsuario.addCell(u.getNombre().toUpperCase());
                    tablaUsuario.addCell(String.valueOf(u.getTelefono()));
                }
                numero = 0;
                documento.add(tablaUsuario);
                documento.add(Chunk.NEWLINE);
            }
            /*TABLA EMPLEADO*/
            if (imprimir[1]) {
                Paragraph tituloEmpleado = new Paragraph("TABLA DE EMPLEADOS");
                tituloEmpleado.setAlignment(Element.ALIGN_CENTER);
                documento.add(tituloEmpleado);
                documento.add(Chunk.NEWLINE);
                PdfPTable tablaEmpleado = new PdfPTable(4);
                tablaEmpleado.setWidthPercentage(100);
                PdfPCell contador = new PdfPCell(new Phrase("N°"));
                contador.setBackgroundColor(colorContador);
                PdfPCell correo = new PdfPCell(new Phrase("CORREO"));
                correo.setBackgroundColor(colorCabecera);
                PdfPCell nombre = new PdfPCell(new Phrase("NOMBRE"));
                nombre.setBackgroundColor(colorCabecera);
                PdfPCell password = new PdfPCell(new Phrase("CONTRASEÑA"));
                password.setBackgroundColor(colorCabecera);
                
                tablaEmpleado.addCell(contador);
                tablaEmpleado.addCell(correo);
                tablaEmpleado.addCell(nombre);
                tablaEmpleado.addCell(password);
                
                it = listaEmpleado.iterator();
                
                while(it.hasNext()){
                    Empleado e = (Empleado) it.next();
                    numero++;
                    tablaEmpleado.addCell(String.valueOf(numero));
                    tablaEmpleado.addCell(e.getCorreo());
                    tablaEmpleado.addCell(e.getNombre());
                    tablaEmpleado.addCell("*************");
                }
                numero = 0;
                documento.add(tablaEmpleado);
                documento.add(Chunk.NEWLINE);
            }
            /*TABLA ALMACEN*/
            if (imprimir[2]) {
                Paragraph tituloAlmacen = new Paragraph("TABLA DE ALMACENES");
                tituloAlmacen.setAlignment(Element.ALIGN_CENTER);
                documento.add(tituloAlmacen);
                documento.add(Chunk.NEWLINE);
                PdfPTable tablaAlmacen = new PdfPTable(4);
                tablaAlmacen.setWidthPercentage(100);
                PdfPCell contador = new PdfPCell(new Phrase("CONTADOR"));
                contador.setBackgroundColor(colorContador);
                PdfPCell nombre = new PdfPCell(new Phrase("NOMBRE DE ALMACEN"));
                nombre.setBackgroundColor(colorCabecera);
                PdfPCell ubicacion = new PdfPCell(new Phrase("UBICACION DE ALMACEN"));
                ubicacion.setBackgroundColor(colorCabecera);
                PdfPCell codigo = new PdfPCell(new Phrase("CODIGO DE ALMACEN"));
                codigo.setBackgroundColor(colorCabecera);
                
                tablaAlmacen.addCell(contador);
                tablaAlmacen.addCell(nombre);
                tablaAlmacen.addCell(ubicacion);
                tablaAlmacen.addCell(codigo);
                it = listaAlmacen.iterator();
                
                while(it.hasNext()){
                    Almacen a = (Almacen) it.next();
                    numero++;
                    tablaAlmacen.addCell(String.valueOf(numero));
                    tablaAlmacen.addCell(a.nombre.toUpperCase());
                    tablaAlmacen.addCell(a.ubicacion.toUpperCase());
                    tablaAlmacen.addCell(a.codigo);
                }
                numero = 0;
                
                documento.add(tablaAlmacen);
                documento.add(Chunk.NEWLINE);
            }
            /*TABLA PRODUCTO*/
            if (imprimir[3]) {
                Paragraph tituloProducto = new Paragraph("TABLA DE PRODUCTO");
                tituloProducto.setAlignment(Element.ALIGN_CENTER);
                documento.add(tituloProducto);
                documento.add(Chunk.NEWLINE);
                
                PdfPTable tablaProducto = new PdfPTable(12);
                tablaProducto.setWidthPercentage(100);
                PdfPCell contador = new PdfPCell(new Paragraph("N°"));
                contador.setBackgroundColor(colorContador);
                PdfPCell codigoProducto = new PdfPCell(new Paragraph("CODIGO PRODUCTO"));
                codigoProducto.setBackgroundColor(colorCabecera);
                PdfPCell estado = new PdfPCell(new Paragraph("ESTADO"));
                estado.setBackgroundColor(colorCabecera);
                PdfPCell cantidad = new PdfPCell(new Paragraph("CANTIDAD"));
                cantidad.setBackgroundColor(colorCabecera);
                PdfPCell categoria = new PdfPCell(new Paragraph("CATEGORIA"));
                categoria.setBackgroundColor(colorCabecera);
                PdfPCell nombre = new PdfPCell(new Paragraph("NOMBRE"));
                nombre.setBackgroundColor(colorCabecera);
                PdfPCell precioUnitario = new PdfPCell(new Paragraph("PRECIO UNITARIO"));
                precioUnitario.setBackgroundColor(colorCabecera);
                PdfPCell almacen = new PdfPCell(new Paragraph("ALMACEN"));
                almacen.setBackgroundColor(colorCabecera);
                PdfPCell destino = new PdfPCell(new Paragraph("DESTINO"));
                destino.setBackgroundColor(colorCabecera);
                PdfPCell fechaRegistro = new PdfPCell(new Paragraph("REGISTRO"));
                fechaRegistro.setBackgroundColor(colorCabecera);
                PdfPCell fechaEntrega = new PdfPCell(new Paragraph("ENTREGA"));
                fechaEntrega.setBackgroundColor(colorCabecera);
                PdfPCell codigoUsuario = new PdfPCell(new Paragraph("CODIGO USUARIO"));
                codigoUsuario.setBackgroundColor(colorCabecera);
                
                tablaProducto.addCell(contador);
                tablaProducto.addCell(codigoProducto);
                tablaProducto.addCell(estado);
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(categoria);
                tablaProducto.addCell(nombre);
                tablaProducto.addCell(precioUnitario);
                tablaProducto.addCell(almacen);
                tablaProducto.addCell(destino);
                tablaProducto.addCell(fechaRegistro);
                tablaProducto.addCell(fechaEntrega);
                tablaProducto.addCell(codigoUsuario);
                it = listaProducto.iterator();
                
                while(it.hasNext()){
                    Producto p = (Producto) it.next();
                    numero++;
                    tablaProducto.addCell(String.valueOf(numero));
                    tablaProducto.addCell(p.getCodigoDeProducto());
                    tablaProducto.addCell(p.getEstado());
                    tablaProducto.addCell(String.valueOf(p.getCantidad()));
                    tablaProducto.addCell(p.getCategoria());
                    tablaProducto.addCell(p.getNombreDeProducto());
                    tablaProducto.addCell(String.valueOf(p.getPrecioUnitario()));
                    tablaProducto.addCell(p.getAlmacen());
                    tablaProducto.addCell(p.getDestino());
                    tablaProducto.addCell(p.getFechaDeRegistro());
                    tablaProducto.addCell(p.getFechaProgramadaDeEntrega());
                    tablaProducto.addCell(p.getCodigoDeUsuario());
                }
                numero = 0;
                
                documento.add(tablaProducto);
                documento.add(Chunk.NEWLINE);
            }

            documento.close();
        } catch (Exception e) {
            System.err.println(e.getCause());
            System.err.println(e.getLocalizedMessage());
            System.err.println(e.getMessage());
        }
    }
    
    public void deletePlantilla(){
    }
    
}
