/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuales.coordinador;

import java.util.ArrayList;

import Clases.Estudiante;
import Visuales.coordinador.Secciones.VerSeccion;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import sistemaintranet.SistemaIntranet;

/**
 *
 * @author YOPI
 */
public class subirAsistencia extends javax.swing.JFrame {

    SistemaIntranet sistema;
    public subirAsistencia() {
        initComponents();
        this.setTitle("Registrar asistencia");
        this.setLocation(400, 190);

        sistema = new SistemaIntranet();

        cargarSeccionesEnComboBox();

        // Agregar un TableModelListener para garantizar que solo se pueda seleccionar una opción de asistencia
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Declarar el listener como una variable final para permitir su uso en lambdas
        final TableModelListener[] listener = new TableModelListener[1];

        listener[0] = e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            // Asegurarnos de que la columna sea una de las columnas de asistencia (1, 2, o 3)
            if (column >= 1 && column <= 3) {
                // Deshabilitar temporalmente el listener para evitar recursividad
                modelo.removeTableModelListener(listener[0]);

                try {
                    Boolean asistio = (Boolean) modelo.getValueAt(row, 1);
                    Boolean faltaJustificada = (Boolean) modelo.getValueAt(row, 2);
                    Boolean faltaInjustificada = (Boolean) modelo.getValueAt(row, 3);

                    // Si se marca una opción, desmarcar las otras
                    if (asistio != null && asistio) {
                        modelo.setValueAt(false, row, 2);
                        modelo.setValueAt(false, row, 3);
                    } else if (faltaJustificada != null && faltaJustificada) {
                        modelo.setValueAt(false, row, 1);
                        modelo.setValueAt(false, row, 3);
                    } else if (faltaInjustificada != null && faltaInjustificada) {
                        modelo.setValueAt(false, row, 1);
                        modelo.setValueAt(false, row, 2);
                    }
                } finally {
                    // Volver a habilitar el listener
                    modelo.addTableModelListener(listener[0]);
                }
            }
        };

        // Añadir el listener al modelo
        modelo.addTableModelListener(listener[0]);
    }







    
    private void cargarSeccionesEnComboBox() {
        CmbSecciones.removeAllItems();

        for (String seccion : sistema.getOrganizador().getSecciones()) {
            CmbSecciones.addItem(seccion);
        }

        if (CmbSecciones.getItemCount() == 0) {
            CmbSecciones.addItem("No hay secciones disponibles");
            CmbSecciones.setEnabled(false);
        } else {
            CmbSecciones.setEnabled(true);
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CmbSecciones = new javax.swing.JComboBox<>();
        BtnGuardarCambios = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("SUBIR ASISTENCIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Alumno", "Asistió", "Falta justificada", "Falta injustificada", "Observación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Información de sección");

        jLabel3.setText("Sección");

        CmbSecciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbSecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbSeccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(CmbSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CmbSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnGuardarCambios.setText("Guardar cambios");
        BtnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarCambiosActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(BtnGuardarCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(BtnGuardarCambios))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Has cancelado la operación", 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
        VerSeccion inforSeccion=new VerSeccion();
        inforSeccion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CmbSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbSeccionesActionPerformed
        String seccionSeleccionada = (String) CmbSecciones.getSelectedItem();
        if (seccionSeleccionada != null && !seccionSeleccionada.equals("No hay secciones disponibles")) {
            cargarAsistenciaDeSeccion(seccionSeleccionada);
        }
    }//GEN-LAST:event_CmbSeccionesActionPerformed

    private void BtnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarCambiosActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombreCompleto = (String) modelo.getValueAt(i, 0); // Columna de nombre
            Boolean asistio = (Boolean) modelo.getValueAt(i, 1); // Columna "Asistió"
            Boolean faltaJustificada = (Boolean) modelo.getValueAt(i, 2); // Columna "Falta justificada"
            Boolean faltaInjustificada = (Boolean) modelo.getValueAt(i, 3); // Columna "Falta injustificada"

            Boolean asistencia = null;
            if (asistio != null && asistio) {
                asistencia = true;
            } else if (faltaJustificada != null && faltaJustificada) {
                asistencia = true;
            } else if (faltaInjustificada != null && faltaInjustificada) {
                asistencia = false;
            }

            if (asistencia != null) {
                // Buscar al estudiante correspondiente por su nombre
                for (Estudiante estudiante : sistema.getListaEstudiantes()) {
                    String nombreEstudiante = estudiante.getNombres() + " " + estudiante.getApellidoP() + " " + estudiante.getApellidoM();
                    if (nombreCompleto.equals(nombreEstudiante)) {
                        // Agregar la asistencia al estudiante
                        estudiante.getAsistencias().add(asistencia);
                        break;
                    }
                }
            }
        }
        
        
        
        
        // Crear el mensaje resumen de asistencias y faltas por estudiante
        StringBuilder resumen = new StringBuilder("Resumen de Asistencias:\n");
        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            int totalAsistencias = 0;
            int totalFaltas = 0;

            // Contar las asistencias y faltas en la lista del estudiante
            for (Boolean asistencia : estudiante.getAsistencias()) {
                if (asistencia != null && asistencia) {
                    totalAsistencias++;
                } else {
                    totalFaltas++;
                }
            }

            // Agregar la información del estudiante al resumen
            resumen.append(estudiante.getNombres()).append(" ")
                   .append(estudiante.getApellidoP()).append(" ")
                   .append(estudiante.getApellidoM()).append(": ")
                   .append("Asistencias: ").append(totalAsistencias).append(", ")
                   .append("Faltas: ").append(totalFaltas).append("\n");
        }

        // Mostrar el resumen con un JOptionPane
        JOptionPane.showMessageDialog(this, resumen.toString(), "Resumen de Asistencias", JOptionPane.INFORMATION_MESSAGE);

        
        
        
        
        
        
        
        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Las asistencias se han guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        
    }//GEN-LAST:event_BtnGuardarCambiosActionPerformed

    
    private void cargarAsistenciaDeSeccion(String seccion) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            if (seccion.equals(estudiante.getSeccion())) {
                modelo.addRow(new Object[]{
                    estudiante.getNombres()+" "+ estudiante.getApellidoP()+" "+estudiante.getApellidoM(),
                    false, 
                    false, 
                    false, 
                    ""     
                });
            }
        }
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
            java.util.logging.Logger.getLogger(subirAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subirAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subirAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subirAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subirAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarCambios;
    private javax.swing.JComboBox<String> CmbSecciones;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
