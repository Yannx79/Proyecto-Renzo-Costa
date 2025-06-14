/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.OperacionesData;
import Clases.Usuario;
import Clases.Producto;
import Controladores.ControladorDeGraficas;
import Controladores.ControladorData;
import Controladores.PlaceHolder;
import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class frmBuscarUsuario extends javax.swing.JFrame {

    private DefaultTableModel dtmListaDeProducto;
    Object data[][] = {};
    String header[] = {"CODIGO DE PRODUCO", "ESTADO", "CANTIDAD", "CATEGORIA", "NOMBRE DE PRODUCTO", "PRECIO UNITARIO",
        "ALMACEN", "DESTINO", "FECHA DE REGISTRO", "FECHA DE ENTREGA", "PRECIO TOTAL"
    };
    OperacionesData od;
    ControladorData cd;
    ControladorDeGraficas cdg;
    LinkedHashSet<Usuario> listaDeUsuario;
    LinkedList<Producto> listaProducto;
    Usuario usuarioEncontrado = null;

    public frmBuscarUsuario() {
        initComponents();
        dtmListaDeProducto = new DefaultTableModel();
        dtmListaDeProducto.setDataVector(data, header);
        jtblTablaDeProductoDeUsuario.setModel(dtmListaDeProducto);
        rsscalelabel.RSScaleLabel.setScaleLabel(jlabelUsuario, "src/Imagenes/imgBuscarCliente.jpg");//ESPECIFICAR
        od = new OperacionesData();
        cd = new ControladorData();
        cdg = new ControladorDeGraficas();
        listaDeUsuario = cd.instanciarListaDeProductoPorCasaUsuario();
        listaProducto = cd.instanciarListaProducto();
        establecerPlaceHolders();
        /*DISEÑO DE FRAME*/
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
    }

    private void establecerPlaceHolders() {
        PlaceHolder phCodigo = new PlaceHolder("Ingrese un codigo", jtxtCodigoDeUsuario);
        PlaceHolder phMontoFinal = new PlaceHolder("Aquí se muestra el monto final", jtxtMontoInveridoFinal);
        PlaceHolder phNombreDeUsuario = new PlaceHolder("Aquí se muestra el nombre", jtxtNombreDeUsuario);
        PlaceHolder phTelefonoDeUsuario = new PlaceHolder("Aquí se muestra el telefono", jtxtTelefonoDeUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jbtnInicio = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtxtMontoInveridoFinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTablaDeProductoDeUsuario = new javax.swing.JTable();
        jbtnConsultar = new javax.swing.JButton();
        jpanelCircularCategoria = new javax.swing.JPanel();
        jpanelEstado = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jtxtCodigoDeUsuario = new javax.swing.JTextField();
        jlabelUsuario = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtxtTelefonoDeUsuario = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jtxtNombreDeUsuario = new javax.swing.JTextField();
        jtbnRestaurar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jtbnEliminar = new javax.swing.JButton();
        jbtnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jbCerrarSesion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnInicio.setBackground(new java.awt.Color(149, 16, 43));
        jbtnInicio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jbtnInicio.setForeground(new java.awt.Color(255, 255, 255));
        jbtnInicio.setText("INICIO");
        jbtnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInicioActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 680, 230, 60));

        jbSalir.setBackground(new java.awt.Color(255, 255, 255));
        jbSalir.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jbSalir.setText("X");
        jbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 50, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SEGUIMIENTO DEL PRODUCTO SEGÚN EL USUARIO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 60));

        jPanel5.setBackground(new java.awt.Color(215, 215, 215));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "MONTO INVERTIDO DEL USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtMontoInveridoFinal.setBackground(new java.awt.Color(215, 215, 215));
        jtxtMontoInveridoFinal.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jtxtMontoInveridoFinal.setBorder(null);
        jPanel5.add(jtxtMontoInveridoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 300, 70));

        jtblTablaDeProductoDeUsuario.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jtblTablaDeProductoDeUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblTablaDeProductoDeUsuario.setRowHeight(30);
        jScrollPane1.setViewportView(jtblTablaDeProductoDeUsuario);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 1280, 200));

        jbtnConsultar.setBackground(new java.awt.Color(149, 16, 43));
        jbtnConsultar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jbtnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnConsultar.setText("CONSULTAR");
        jbtnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 680, 200, 60));

        jpanelCircularCategoria.setBackground(new java.awt.Color(215, 215, 215));
        jpanelCircularCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpanelCircularCategoriaLayout = new javax.swing.GroupLayout(jpanelCircularCategoria);
        jpanelCircularCategoria.setLayout(jpanelCircularCategoriaLayout);
        jpanelCircularCategoriaLayout.setHorizontalGroup(
            jpanelCircularCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jpanelCircularCategoriaLayout.setVerticalGroup(
            jpanelCircularCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jPanel2.add(jpanelCircularCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 410, 250));

        jpanelEstado.setBackground(new java.awt.Color(215, 215, 215));
        jpanelEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpanelEstadoLayout = new javax.swing.GroupLayout(jpanelEstado);
        jpanelEstado.setLayout(jpanelEstadoLayout);
        jpanelEstadoLayout.setHorizontalGroup(
            jpanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        jpanelEstadoLayout.setVerticalGroup(
            jpanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jPanel2.add(jpanelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, -1, 250));

        jPanel8.setBackground(new java.awt.Color(215, 215, 215));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CODIGO DE USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 14))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtCodigoDeUsuario.setBackground(new java.awt.Color(215, 215, 215));
        jtxtCodigoDeUsuario.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jtxtCodigoDeUsuario.setBorder(null);
        jPanel8.add(jtxtCodigoDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 40));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 290, 70));

        jlabelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgBuscarCliente.jpg"))); // NOI18N
        jlabelUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jlabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 420, 270));

        jPanel9.setBackground(new java.awt.Color(215, 215, 215));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "TELEFONO DE USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 14))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtTelefonoDeUsuario.setBackground(new java.awt.Color(215, 215, 215));
        jtxtTelefonoDeUsuario.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jtxtTelefonoDeUsuario.setBorder(null);
        jPanel9.add(jtxtTelefonoDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 40));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 320, 70));

        jPanel10.setBackground(new java.awt.Color(215, 215, 215));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "NOMBRE DE USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semilight", 0, 14))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtNombreDeUsuario.setBackground(new java.awt.Color(215, 215, 215));
        jtxtNombreDeUsuario.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jtxtNombreDeUsuario.setBorder(null);
        jPanel10.add(jtxtNombreDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 40));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 340, 70));

        jtbnRestaurar.setBackground(new java.awt.Color(149, 16, 43));
        jtbnRestaurar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jtbnRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        jtbnRestaurar.setText("RESTAURAR");
        jtbnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnRestaurarActionPerformed(evt);
            }
        });
        jPanel2.add(jtbnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 680, 230, 60));

        jbtnActualizar.setBackground(new java.awt.Color(149, 16, 43));
        jbtnActualizar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jbtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnActualizar.setText("ACTUALIZAR");
        jbtnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 680, 210, 60));

        jtbnEliminar.setBackground(new java.awt.Color(149, 16, 43));
        jtbnEliminar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jtbnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jtbnEliminar.setText("ELIMINAR");
        jtbnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jtbnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 200, 60));

        jbtnAgregar.setBackground(new java.awt.Color(149, 16, 43));
        jbtnAgregar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar.setText("AGREGAR");
        jbtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 210, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 1330, 760));

        jPanel1.setBackground(new java.awt.Color(149, 16, 43));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 710, 40, 40));

        jbCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jbCerrarSesion.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbCerrarSesion.setText("CERRAR SESIÓN");
        jbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCerrarSesion.setFocusable(false);
        jbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCerrarSesionMouseClicked(evt);
            }
        });
        jPanel1.add(jbCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 720, 270, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("RENZO COSTA S.A.C.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 990, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 1330, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarSesionMouseClicked
        dispose();
        frmLogueo logueo = new frmLogueo();
        logueo.setVisible(true);
    }//GEN-LAST:event_jbCerrarSesionMouseClicked

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        frmInicio inicio = new frmInicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtnInicioActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConsultarActionPerformed
        String codigo = jtxtCodigoDeUsuario.getText();
        if (codigo.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "INGRESE UN CODIGO POR FAVOR", "CODIGO NO INGRESADO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Usuario u = buscarUsuario(codigo);
            if (u != null) {
                jtxtMontoInveridoFinal.setText(String.valueOf("S/. " + od.calcularMontoFinalDeUnUsuario(jtxtCodigoDeUsuario.getText())));
                jtxtNombreDeUsuario.setText(u.getNombre());
                jtxtTelefonoDeUsuario.setText(String.valueOf(u.getTelefono()));
                cd.sobreEscribirTablaDeProductoDeUnUsario(dtmListaDeProducto, u);
                habilitarBoton();
                graficar();
            } else {
                JOptionPane.showMessageDialog(null, "EL CODIGO INSERTADO NO ESTA REGISTRADO", "CODIGO INCORRECTO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbtnConsultarActionPerformed

    private void jtbnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnRestaurarActionPerformed
        limpiarFrm();
        inhabilitarBoton();
    }//GEN-LAST:event_jtbnRestaurarActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        String codigo = jtxtCodigoDeUsuario.getText();
        String nombre = jtxtNombreDeUsuario.getText();
        long telefono = Long.parseLong(jtxtTelefonoDeUsuario.getText());
        LinkedList<Producto> listaProductoIndividual;
        listaProductoIndividual = usuarioEncontrado.getListaDeProductos();
        Iterator<Producto> itProductoIndividual = listaProductoIndividual.iterator();

        usuarioEncontrado.setCodigo(codigo);
        usuarioEncontrado.setTelefono(telefono);
        usuarioEncontrado.setNombre(nombre);
        cd.sobreEscribirEnArchivoUsuario(listaDeUsuario);

        while (itProductoIndividual.hasNext()) {
            Producto p = itProductoIndividual.next();
            p.setCodigoDeUsuario(codigo);
        }
        cd.sobreEscribirArchivoProducto(listaDeUsuario);

        limpiarFrm();
        inhabilitarBoton();
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jtbnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnEliminarActionPerformed
        listaDeUsuario.remove(usuarioEncontrado);
        cd.sobreEscribirArchivoProducto(listaDeUsuario);
        cd.sobreEscribirEnArchivoUsuario(listaDeUsuario);
        limpiarFrm();
    }//GEN-LAST:event_jtbnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        inhabilitarBoton();
    }//GEN-LAST:event_formWindowOpened

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        String codigoDeUsuario = jtxtCodigoDeUsuario.getText();
        String nombre = jtxtNombreDeUsuario.getText();
        long telefono;
        if (jtxtTelefonoDeUsuario.getText().equalsIgnoreCase("")) {
            telefono = 0;
        } else {
            telefono = Long.parseLong(jtxtTelefonoDeUsuario.getText());
        }
        if (!"".equals(codigoDeUsuario) && !"".equals(nombre) && telefono != 0) {
            Usuario u = new Usuario(codigoDeUsuario, nombre, telefono);
            listaDeUsuario.add(u);
            cd.sobreEscribirEnArchivoUsuario(listaDeUsuario);
            limpiarFrm();
        } else {
            JOptionPane.showMessageDialog(this, "INGRESE LOS DATOS CORRECTOS", "DATOS INCORRECTOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private JPanel limpiarPanel(int width, int height){
        JPanel jp = new JPanel();
        jp.setSize(width, height);
        jp.setBackground(new Color(215,215,215));
        return jp;
    }
    
    private void limpiarFrm() {
        jtxtCodigoDeUsuario.setText("");
        jtxtNombreDeUsuario.setText("");
        jtxtMontoInveridoFinal.setText("");
        jtxtTelefonoDeUsuario.setText("");
        dtmListaDeProducto.setRowCount(0);
        jpanelCircularCategoria.removeAll();
        jpanelEstado.removeAll();
        jpanelEstado.add(limpiarPanel(jpanelEstado.getWidth(),jpanelEstado.getHeight()));
        jpanelCircularCategoria.add(limpiarPanel(jpanelCircularCategoria.getWidth(),jpanelCircularCategoria.getHeight()));
        repaint();
    }

    private void graficar() {
        jpanelCircularCategoria.removeAll();
        jpanelEstado.removeAll();
        cdg.graficarCircularDeCategoriaParaUnUsuario(jpanelCircularCategoria, jtxtCodigoDeUsuario.getText());
        cdg.graficarBarrarDeEstadoParaUnUsuario(jpanelEstado, jtxtCodigoDeUsuario.getText());
        pack();
        repaint();
    }

    private Usuario buscarUsuario(String codigo) {
        Iterator<Usuario> itUsuario = listaDeUsuario.iterator();
        while (itUsuario.hasNext()) {
            usuarioEncontrado = itUsuario.next();
            if (usuarioEncontrado.getCodigo().equalsIgnoreCase(codigo)) {
                return usuarioEncontrado;
            }
        }
        return usuarioEncontrado;
    }

    private void habilitarBoton() {
        jtbnEliminar.setEnabled(true);
        jbtnActualizar.setEnabled(true);
        jbtnAgregar.setEnabled(false);
    }

    private void inhabilitarBoton() {
        jtbnEliminar.setEnabled(false);
        jbtnActualizar.setEnabled(false);
        jbtnAgregar.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBuscarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jbCerrarSesion;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnConsultar;
    private javax.swing.JButton jbtnInicio;
    private javax.swing.JLabel jlabelUsuario;
    private javax.swing.JPanel jpanelCircularCategoria;
    private javax.swing.JPanel jpanelEstado;
    private javax.swing.JTable jtblTablaDeProductoDeUsuario;
    private javax.swing.JButton jtbnEliminar;
    private javax.swing.JButton jtbnRestaurar;
    private javax.swing.JTextField jtxtCodigoDeUsuario;
    private javax.swing.JTextField jtxtMontoInveridoFinal;
    private javax.swing.JTextField jtxtNombreDeUsuario;
    private javax.swing.JTextField jtxtTelefonoDeUsuario;
    // End of variables declaration//GEN-END:variables
}
