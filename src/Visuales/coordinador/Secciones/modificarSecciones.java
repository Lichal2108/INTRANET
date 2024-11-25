/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuales.coordinador.Secciones;

import Clases.Estudiante;
import Visuales.administrador.admin_main;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaintranet.SistemaIntranet;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Monica
 */
public class modificarSecciones extends javax.swing.JFrame {

    private SistemaIntranet sistema;
    
    private Map<String, String> estadoInicialEstudiantes;
    
    
    public modificarSecciones() {
        initComponents();
        this.setTitle("Modificar secciones");
        this.setLocation(400, 190);

        sistema = new SistemaIntranet();

        inicializarComboBoxSecciones();

        // Configuración inicial: deshabilitar botones
        inicializarEstadoBotones();

        // Agregar listeners para actualizar la tabla
        agregarListeners();

        // Mostrar datos iniciales en la tabla
        actualizarTablaAlumnosDisponibles();
        actualizarTablaAulaActual();

        
        
    }

    
    
    private void actualizarTablaAulaActual() {
    // Obtener la sección seleccionada
        String seccionSeleccionada = (String) cmbSeccion.getSelectedItem();

        // Validar si se ha seleccionado una sección
        if (seccionSeleccionada == null || seccionSeleccionada.equals("-------")) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un aula válida.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Limpiar la tabla antes de llenarla
        DefaultTableModel modelo = (DefaultTableModel) jTableAulaActual.getModel();
        modelo.setRowCount(0);

        // Filtrar los estudiantes de acuerdo a la sección seleccionada
        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            if (seccionSeleccionada.equals(estudiante.getSeccion())) {
                modelo.addRow(new Object[]{
                    estudiante.getCodigo(),
                    estudiante.getNombres(),
                    estudiante.getApellidoP()
                });
            }
        }

        // Mostrar un mensaje si no hay estudiantes en la sección seleccionada
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes registrados en la sección seleccionada.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
   
    
    
    
    private void agregarListeners() {
        cmbSeccion.addActionListener(evt -> {
            actualizarTablaAulaActual();
            actualizarTablaAlumnosDisponibles();
        });

        BtnRealizarCambios.addActionListener(evt -> {
            // Habilitar botones de acción
            btnAgregarEstudiante.setEnabled(true);
            btnEliminarEstudiante.setEnabled(true);
            jButton1.setEnabled(true); // Botón Guardar Cambios

            // Deshabilitar botón de realizar cambios y combo box
            BtnRealizarCambios.setEnabled(false);
            cmbSeccion.setEnabled(false);
        });

        jButton1.addActionListener(evt -> { // Botón Guardar Cambios
            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Cambios guardados con éxito.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);

            // Restaurar estado inicial
            btnAgregarEstudiante.setEnabled(false);
            btnEliminarEstudiante.setEnabled(false);
            jButton1.setEnabled(false); // Botón Guardar Cambios

            BtnRealizarCambios.setEnabled(true);
            cmbSeccion.setEnabled(true);
        });
    }
    
    
    
    
    
    private void actualizarTablaAlumnosDisponibles() {
        // Obtener la sección seleccionada
        String seccionSeleccionada = (String) cmbSeccion.getSelectedItem();

        // Validar si se ha seleccionado una sección válida
        if (seccionSeleccionada == null || seccionSeleccionada.equals("-------")) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un aula válida.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Determinar la universidad y turno basados en la sección seleccionada
        String[] seccionPartes = seccionSeleccionada.split("-");
        if (seccionPartes.length != 2) {
            JOptionPane.showMessageDialog(this, "El formato de la sección no es válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String universidad = seccionPartes[0]; // Universidad asociada a la sección
        String turno = seccionPartes[1];       // Turno asociado a la sección

        // Limpiar la tabla antes de llenarla
        DefaultTableModel modelo = (DefaultTableModel) jTableAlumnosDisponibles.getModel();
        modelo.setRowCount(0);

        // Filtrar los estudiantes disponibles según universidad y turno
        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            if ((estudiante.getSeccion() == null || estudiante.getSeccion().trim().isEmpty()) // Estudiantes sin sección
                    && universidad.equals(estudiante.getUniversidad())                      // Coinciden universidad
                    && turno.equals(estudiante.getTurno())) {                               // Coinciden turno
                modelo.addRow(new Object[]{
                    estudiante.getCodigo(),
                    estudiante.getNombres(),
                    estudiante.getApellidoP(),
                    estudiante.getUniversidad(),
                    estudiante.getTurno()
                });
            }
        }

        // Mostrar un mensaje si no hay estudiantes disponibles para agregar
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes disponibles para agregar en el aula seleccionada.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    
    
    private void inicializarComboBoxSecciones() {
        cmbSeccion.removeAllItems();
        for (String seccion : sistema.getOrganizador().getSecciones()) {
            cmbSeccion.addItem(seccion);
        }
    }
    
    
    
    private void inicializarEstadoBotones() {
        btnAgregarEstudiante.setEnabled(false);
        btnEliminarEstudiante.setEnabled(false);
        jButton1.setEnabled(false); // Botón Guardar Cambios
    }   
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbSeccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlumnosDisponibles = new javax.swing.JTable();
        btnAgregarEstudiante = new javax.swing.JButton();
        btnEliminarEstudiante = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAulaActual = new javax.swing.JTable();
        jLabelNombreDeAula = new javax.swing.JLabel();
        BtnRealizarCambios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("MODIFICAR SALON");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        cmbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecc Aula");

        jTableAlumnosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Apellido", "Universidad", "Turno"
            }
        ));
        jTableAlumnosDisponibles.setShowGrid(true);
        jScrollPane2.setViewportView(jTableAlumnosDisponibles);

        btnAgregarEstudiante.setText("Agregar Estudiante");
        btnAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstudianteActionPerformed(evt);
            }
        });

        btnEliminarEstudiante.setText("Eliminar Estudiante");
        btnEliminarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstudianteActionPerformed(evt);
            }
        });

        jTableAulaActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Apellido"
            }
        ));
        jTableAulaActual.setShowGrid(true);
        jScrollPane3.setViewportView(jTableAulaActual);

        jLabelNombreDeAula.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelNombreDeAula.setText("NombreDeAula");

        BtnRealizarCambios.setText("Realizar Cambios");
        BtnRealizarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRealizarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelNombreDeAula, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(BtnRealizarCambios)
                .addGap(193, 193, 193)
                .addComponent(btnAgregarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jLabelNombreDeAula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEstudiante)
                    .addComponent(btnEliminarEstudiante)
                    .addComponent(BtnRealizarCambios))
                .addGap(16, 16, 16))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(453, 453, 453))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            String seccionOriginal = estadoInicialEstudiantes.get(estudiante.getCodigo());
            estudiante.setSeccion(seccionOriginal);
        }

        // Actualizar tablas
        actualizarTablaAlumnosDisponibles();
        actualizarTablaAulaActual();

        // Deshabilitar botones de acción
        btnAgregarEstudiante.setEnabled(false);
        btnEliminarEstudiante.setEnabled(false);
        jButton1.setEnabled(false); // Botón Guardar Cambios

        // Habilitar el combo box y el botón de realizar cambios
        cmbSeccion.setEnabled(true);
        BtnRealizarCambios.setEnabled(true);

        // Mostrar mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Los cambios han sido descartados.",
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEliminarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEstudianteActionPerformed
        int filaSeleccionada = jTableAulaActual.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un estudiante para eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener datos del estudiante seleccionado
        DefaultTableModel modeloActual = (DefaultTableModel) jTableAulaActual.getModel();
        String codigo = (String) modeloActual.getValueAt(filaSeleccionada, 0);

        // Buscar el estudiante en el sistema
        Estudiante estudiante = sistema.getListaEstudiantes().stream()
                .filter(e -> e.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (estudiante != null) {
            // Eliminar la asignación de sección del estudiante
            estudiante.setSeccion(null);

            // Actualizar las tablas
            actualizarTablaAlumnosDisponibles();
            actualizarTablaAulaActual();

            JOptionPane.showMessageDialog(this, "Estudiante eliminado de la sección.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarEstudianteActionPerformed

    private void btnAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstudianteActionPerformed
        int filaSeleccionada = jTableAlumnosDisponibles.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un estudiante para agregar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener datos del estudiante seleccionado
        DefaultTableModel modeloDisponibles = (DefaultTableModel) jTableAlumnosDisponibles.getModel();
        String codigo = (String) modeloDisponibles.getValueAt(filaSeleccionada, 0);

        // Buscar el estudiante en el sistema
        Estudiante estudiante = sistema.getListaEstudiantes().stream()
                .filter(e -> e.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (estudiante != null) {
            // Asignar el estudiante a la sección seleccionada
            String seccionSeleccionada = (String) cmbSeccion.getSelectedItem();
            estudiante.setSeccion(seccionSeleccionada);

            // Actualizar las tablas
            actualizarTablaAlumnosDisponibles();
            actualizarTablaAulaActual();

            JOptionPane.showMessageDialog(this, "Estudiante agregado a la sección: " + seccionSeleccionada,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarEstudianteActionPerformed

    private void cmbSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeccionActionPerformed

    private void BtnRealizarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRealizarCambiosActionPerformed
        estadoInicialEstudiantes = new HashMap<>();
        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            estadoInicialEstudiantes.put(estudiante.getCodigo(), estudiante.getSeccion());
        }

        // Habilitar botones de acción
        btnAgregarEstudiante.setEnabled(true);
        btnEliminarEstudiante.setEnabled(true);
        jButton1.setEnabled(true); // Botón Guardar Cambios

        // Deshabilitar botón de realizar cambios y combo box
        BtnRealizarCambios.setEnabled(false);
        cmbSeccion.setEnabled(false);
    }//GEN-LAST:event_BtnRealizarCambiosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Cambios guardados con éxito.",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        // Restaurar estado inicial
        btnAgregarEstudiante.setEnabled(false);
        btnEliminarEstudiante.setEnabled(false);
        jButton1.setEnabled(false); // Botón Guardar Cambios

        BtnRealizarCambios.setEnabled(true);
        cmbSeccion.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(modificarSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarSecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarSecciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRealizarCambios;
    private javax.swing.JButton btnAgregarEstudiante;
    private javax.swing.JButton btnEliminarEstudiante;
    private javax.swing.JComboBox<String> cmbSeccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombreDeAula;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableAlumnosDisponibles;
    private javax.swing.JTable jTableAulaActual;
    // End of variables declaration//GEN-END:variables
}
