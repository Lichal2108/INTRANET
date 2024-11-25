/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuales.coordinador.Secciones;

import Visuales.coordinador.menu_coordinador;
import sistemaintranet.SistemaIntranet;

/**
 *
 * @author Monica
 */
public class SeccionesMain extends javax.swing.JFrame {

    private SistemaIntranet sistema;
    
    public SeccionesMain() {
        initComponents();
        this.setTitle("Página principal secciones");
        this.setLocation(400, 190);

        sistema = new SistemaIntranet(); // Inicializar sistema
        cargarSeccionesEnComboBox();

        configurarTablaEstudiantes();
        
    }

    
    
    
    private void cargarSeccionesEnComboBox() {
        cmbSeccion.removeAllItems(); // Limpiar el combo box

        for (String seccion : sistema.getOrganizador().getSecciones()) {
            cmbSeccion.addItem(seccion); // Agregar cada sección al combo box
        }

        if (cmbSeccion.getItemCount() == 0) {
            cmbSeccion.addItem("No hay secciones disponibles");
            cmbSeccion.setEnabled(false); // Deshabilitar si no hay secciones
        } else {
            cmbSeccion.setEnabled(true); // Habilitar si hay secciones
        }
    }
    
    private void mostrarEstudiantesDeSeccion(String seccion) {
        // Obtener el modelo de la tabla
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTableEstudiantesEnSeccion.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de llenarla

        // Iterar sobre la lista de estudiantes y agregar los que pertenecen a la sección seleccionada
        for (Clases.Estudiante estudiante : sistema.getListaEstudiantes()) {
            if (seccion.equals(estudiante.getSeccion())) {
                model.addRow(new Object[]{
                    estudiante.getCodigo(), // Columna Código
                    estudiante.getNombres() + " " + estudiante.getApellidoP() + " " + estudiante.getApellidoM() // Columna Nombre completo
                });
            }
        }

        // Mostrar un mensaje si no hay estudiantes en la sección seleccionada
        if (model.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "No hay estudiantes registrados en la sección seleccionada.", 
                    "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void configurarTablaEstudiantes() {
       // Obtener el modelo de columna de la tabla
       javax.swing.table.TableColumnModel columnModel = jTableEstudiantesEnSeccion.getColumnModel();

       // Configurar el ancho de las columnas
       columnModel.getColumn(0).setPreferredWidth(100); // Columna Código
       columnModel.getColumn(0).setMaxWidth(100); // Ancho máximo
       columnModel.getColumn(0).setResizable(false); // No permitir cambiar tamaño

       columnModel.getColumn(1).setPreferredWidth(500); // Columna Nombre Completo
       columnModel.getColumn(1).setResizable(false); // No permitir cambiar tamaño

       // Deshabilitar redimensionamiento de la tabla
       jTableEstudiantesEnSeccion.getTableHeader().setResizingAllowed(false);
       jTableEstudiantesEnSeccion.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
   }   
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscarSeccion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstudiantesEnSeccion = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        BtnModificarSeccion = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSeccion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        btnBuscarSeccion.setText("Buscar");
        btnBuscarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSeccionActionPerformed(evt);
            }
        });

        jTableEstudiantesEnSeccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Estudiante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEstudiantesEnSeccion.setShowGrid(true);
        jScrollPane1.setViewportView(jTableEstudiantesEnSeccion);
        if (jTableEstudiantesEnSeccion.getColumnModel().getColumnCount() > 0) {
            jTableEstudiantesEnSeccion.getColumnModel().getColumn(0).setPreferredWidth(700);
        }

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BtnModificarSeccion.setText("Modificar Sección");
        BtnModificarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarSeccionActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SECCIONES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        jLabel2.setText("Buscar por Nombre de Salón:");

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnModificarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarSeccion)
                    .addComponent(jLabel2)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(BtnModificarSeccion)
                    .addComponent(jButton4))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void btnBuscarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSeccionActionPerformed
        String seccionSeleccionada = (String) cmbSeccion.getSelectedItem();
        if (seccionSeleccionada != null && !seccionSeleccionada.equals("No hay secciones disponibles")) {
            mostrarEstudiantesDeSeccion(seccionSeleccionada);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione una sección válida.", 
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnBuscarSeccionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        menu_coordinador menuCoord=new menu_coordinador();
        menuCoord.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BtnModificarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnModificarSeccionActionPerformed

    
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
            java.util.logging.Logger.getLogger(SeccionesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeccionesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeccionesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeccionesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeccionesMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnModificarSeccion;
    private javax.swing.JButton btnBuscarSeccion;
    private javax.swing.JComboBox<String> cmbSeccion;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstudiantesEnSeccion;
    // End of variables declaration//GEN-END:variables
}
