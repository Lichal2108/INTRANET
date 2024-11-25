/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuales.coordinador;

import Clases.Asistencia;
import java.util.ArrayList;

import Clases.Estudiante;
import Visuales.coordinador.Secciones.VerSeccion;
import java.util.HashMap;
import java.util.HashSet;
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
        private HashMap<String, HashSet<String>> fechasPorSeccion; // Fechas por sección
        private Object[][] estadoOriginalTabla;
        
        public subirAsistencia() {
            initComponents();
            this.setTitle("Registrar asistencia");
            this.setLocation(400, 190);

            sistema = new SistemaIntranet();
            fechasPorSeccion = new HashMap<>(); // Inicializa la estructura de fechas por sección

            cargarSeccionesEnComboBox();

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            final TableModelListener[] listener = new TableModelListener[1];

            listener[0] = e -> {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column >= 1 && column <= 3) {
                    modelo.removeTableModelListener(listener[0]);
                    try {
                        Boolean asistio = (Boolean) modelo.getValueAt(row, 1);
                        Boolean faltaJustificada = (Boolean) modelo.getValueAt(row, 2);
                        Boolean faltaInjustificada = (Boolean) modelo.getValueAt(row, 3);

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
                        modelo.addTableModelListener(listener[0]);
                    }
                }
            };

            modelo.addTableModelListener(listener[0]);
            BtnGuardarCambios.setEnabled(false);
            jButton2.setEnabled(false);
        }






    
    
    private void mostrarResumenAsistencias() {
        StringBuilder resumen = new StringBuilder("Relación de Asistencias y Faltas por Estudiante:\n");

        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            // Contar asistencias y faltas desde la lista de asistencias
            int totalAsistencias = 0;
            int totalFaltas = 0;

            for (Asistencia asistencia : estudiante.getListaA().getAsistencias()) {
                if (asistencia.isAsist()) {
                    totalAsistencias++;
                } else {
                    totalFaltas++;
                }
            }

            // Agregar la información del estudiante al resumen
            resumen.append(estudiante.getNombres()).append(" ")
                   .append(estudiante.getApellidoP()).append(" ")
                   .append(estudiante.getApellidoM()).append(":\n")
                   .append(" - Asistencias: ").append(totalAsistencias).append("\n")
                   .append(" - Faltas: ").append(totalFaltas).append("\n\n");
        }

        // Mostrar el resumen en un JOptionPane
        JOptionPane.showMessageDialog(this, resumen.toString(), 
                "Resumen de Asistencias", JOptionPane.INFORMATION_MESSAGE);
    }


    private void mostrarResumenAsistenciasConFechas() {
        StringBuilder resumen = new StringBuilder("<html><body><h3>Relación de Asistencias, Faltas y Fechas por Estudiante:</h3>");

        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            // Contar asistencias y faltas desde la lista de asistencias
            int totalAsistencias = 0;
            int totalFaltas = 0;
            StringBuilder fechasAsistencias = new StringBuilder();
            StringBuilder fechasFaltas = new StringBuilder();

            for (Asistencia asistencia : estudiante.getListaA().getAsistencias()) {
                if (asistencia.isAsist()) {
                    totalAsistencias++;
                    fechasAsistencias.append(asistencia.getFecha()).append(", ");
                } else {
                    totalFaltas++;
                    fechasFaltas.append(asistencia.getFecha()).append(", ");
                }
            }

            // Limpiar las últimas comas en las listas de fechas
            if (fechasAsistencias.length() > 0) {
                fechasAsistencias.setLength(fechasAsistencias.length() - 2);
            }
            if (fechasFaltas.length() > 0) {
                fechasFaltas.setLength(fechasFaltas.length() - 2);
            }

            // Agregar la información del estudiante al resumen
            resumen.append("<p><strong>").append(estudiante.getNombres()).append(" ")
                   .append(estudiante.getApellidoP()).append(" ")
                   .append(estudiante.getApellidoM()).append(":</strong><br>")
                   .append(" - Asistencias: ").append(totalAsistencias).append("<br>")
                   .append("   Fechas: ").append(fechasAsistencias.toString()).append("<br>")
                   .append(" - Faltas: ").append(totalFaltas).append("<br>")
                   .append("   Fechas: ").append(fechasFaltas.toString()).append("</p>");
        }

        resumen.append("</body></html>");

        // Crear un JLabel con el contenido HTML
        javax.swing.JLabel label = new javax.swing.JLabel(resumen.toString());
        label.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        // Crear un JScrollPane y añadir el JLabel
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(label);
        scrollPane.setPreferredSize(new java.awt.Dimension(600, 400));

        // Mostrar el JScrollPane en un JOptionPane
        javax.swing.JOptionPane.showMessageDialog(this, scrollPane, 
                "Resumen de Asistencias y Faltas", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
   
    
    
    
    
    
    private void restaurarEstadoOriginal() {
        if (estadoOriginalTabla != null) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0); // Limpia la tabla actual

            for (Object[] fila : estadoOriginalTabla) {
                modelo.addRow(fila); // Restaura cada fila desde el estado original
            }
        }
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
    
    
    
    private void restaurarEstadoInicial() {
            BtnGuardarCambios.setEnabled(false);
            jButton2.setEnabled(false);
            BtnRealizarCambios.setEnabled(true);
            CmbSecciones.setEnabled(true);
            TxtFecha.setEnabled(true);
            TxtFecha.setText(""); 
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
        jLabel4 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        BtnRealizarCambios = new javax.swing.JButton();
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Alumno", "Asistió", "Falta justificada", "Falta injustificada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
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

        jLabel4.setText("Fecha");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(CmbSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(BtnRealizarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
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
                    .addComponent(CmbSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRealizarCambios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
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
                        .addGap(294, 294, 294)
                        .addComponent(BtnGuardarCambios)
                        .addGap(56, 56, 56)
                        .addComponent(jButton2)))
                .addContainerGap(47, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        restaurarEstadoOriginal(); // Restaurar la tabla a su estado inicial
        JOptionPane.showMessageDialog(this, "Operación cancelada. Los cambios no se han guardado.",
                "Cancelación", JOptionPane.INFORMATION_MESSAGE);

        // Restaurar el estado inicial de los botones y campos
        restaurarEstadoInicial();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CmbSeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbSeccionesActionPerformed
        String seccionSeleccionada = (String) CmbSecciones.getSelectedItem();
        if (seccionSeleccionada != null && !seccionSeleccionada.equals("No hay secciones disponibles")) {
            cargarAsistenciaDeSeccion(seccionSeleccionada);
        }
    }//GEN-LAST:event_CmbSeccionesActionPerformed

    private void BtnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarCambiosActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            String fecha = TxtFecha.getText().trim();
            String seccionSeleccionada = (String) CmbSecciones.getSelectedItem();

            if (fecha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una fecha válida.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si la fecha ya se usó en la sección seleccionada
            if (!fechasPorSeccion.containsKey(seccionSeleccionada)) {
                fechasPorSeccion.put(seccionSeleccionada, new HashSet<>());
            }

            HashSet<String> fechasDeLaSeccion = fechasPorSeccion.get(seccionSeleccionada);

            if (fechasDeLaSeccion.contains(fecha)) {
                JOptionPane.showMessageDialog(this, 
                    "La fecha ingresada ya fue registrada para esta sección. Ingrese una nueva fecha.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar que todos los alumnos tengan una marca
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Boolean asistio = (Boolean) modelo.getValueAt(i, 1);
                Boolean faltaJustificada = (Boolean) modelo.getValueAt(i, 2);
                Boolean faltaInjustificada = (Boolean) modelo.getValueAt(i, 3);

                if ((asistio == null || !asistio) &&
                    (faltaJustificada == null || !faltaJustificada) &&
                    (faltaInjustificada == null || !faltaInjustificada)) {
                    JOptionPane.showMessageDialog(this,
                            "Todos los alumnos deben tener una marca de asistencia. Verifique la fila " + (i + 1) + ".",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Guardar la asistencia si todas las verificaciones son correctas
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String nombreCompleto = (String) modelo.getValueAt(i, 0);
                Boolean asistio = (Boolean) modelo.getValueAt(i, 1);
                Boolean faltaJustificada = (Boolean) modelo.getValueAt(i, 2);
                Boolean faltaInjustificada = (Boolean) modelo.getValueAt(i, 3);

                boolean asistenciaEstado = false;

                if (asistio != null && asistio) {
                    asistenciaEstado = true;
                } else if (faltaJustificada != null && faltaJustificada) {
                    asistenciaEstado = true;
                }

                for (Estudiante estudiante : sistema.getListaEstudiantes()) {
                    String nombreEstudiante = estudiante.getNombres() + " " + estudiante.getApellidoP() + " " + estudiante.getApellidoM();
                    if (nombreCompleto.equals(nombreEstudiante)) {
                        Asistencia nuevaAsistencia = new Asistencia(fecha, estudiante.getCodigo(), asistenciaEstado);
                        estudiante.getListaA().agregarAsistencia(nuevaAsistencia);
                        break;
                    }
                }
            }

            // Añadir la fecha a la lista de fechas de la sección
            fechasDeLaSeccion.add(fecha);

            mostrarResumenAsistenciasConFechas();
            JOptionPane.showMessageDialog(this, "Asistencias guardadas exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            restaurarEstadoInicial();
    }//GEN-LAST:event_BtnGuardarCambiosActionPerformed

    private void BtnRealizarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRealizarCambiosActionPerformed
        BtnGuardarCambios.setEnabled(true);
        jButton2.setEnabled(true);

        // Deshabilitar botón de realizar cambios y combobox
        BtnRealizarCambios.setEnabled(false);
        CmbSecciones.setEnabled(false);
        TxtFecha.setEnabled(false);
    }//GEN-LAST:event_BtnRealizarCambiosActionPerformed

    
    private void cargarAsistenciaDeSeccion(String seccion) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> temporal = new ArrayList<>(); // Para guardar el estado inicial

        for (Estudiante estudiante : sistema.getListaEstudiantes()) {
            if (seccion.equals(estudiante.getSeccion())) {
                Object[] fila = {
                    estudiante.getNombres() + " " + estudiante.getApellidoP() + " " + estudiante.getApellidoM(),
                    false,
                    false,
                    false
                };
                modelo.addRow(fila);
                temporal.add(fila.clone()); // Clonar para evitar referencias directas
            }
        }

        // Guardar el estado original en una estructura de respaldo
        estadoOriginalTabla = temporal.toArray(new Object[0][0]);
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
    private javax.swing.JButton BtnRealizarCambios;
    private javax.swing.JComboBox<String> CmbSecciones;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
