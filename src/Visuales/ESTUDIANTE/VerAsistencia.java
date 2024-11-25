/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuales.ESTUDIANTE;

import Clases.Asistencia;
import Clases.Estudiante;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Richard
 */
public class VerAsistencia extends javax.swing.JFrame {

    private JFrame parentWindow;
    private Estudiante usuario;
    
    public VerAsistencia(JFrame parentWindow, Estudiante usuario) {
            initComponents();
            this.parentWindow = parentWindow;
            this.usuario = usuario;

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            // Configurar la tabla
            configurarTabla();
            cargarDatosAsistencia();
        }

    
    
    private void configurarTabla() {
        // Definir columnas dinámicamente según las asistencias
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir edición
            }

            @Override
            public Class<?> getColumnClass(int column) {
                // La primera columna es de tipo texto, las demás usarán iconos
                return column == 0 ? String.class : JLabel.class;
            }
        };

        // Definir las columnas
        model.addColumn("Fecha");
        model.addColumn("Asistencia");

        jTable1.setModel(model);

        // Configurar renderizador para iconos
        jTable1.setDefaultRenderer(JLabel.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                return (Component) value; // Retorna el JLabel
            }
        });
    }
    
    
    
    private void cargarDatosAsistencia() {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar tabla antes de cargar

        // Obtener las asistencias del estudiante
        List<Asistencia> asistencias = usuario.getListaA().getAsistencias();

        // Cargar datos
        for (Asistencia asistencia : asistencias) {
            JLabel icono;
            if (asistencia.isAsist()) {
                icono = new JLabel(new ImageIcon("C:/Users/Richard/Documents/NetBeansProjects/Intranet_DS/src/Sources/check.png"));
            } else {
                icono = new JLabel(new ImageIcon("C:/Users/Richard/Documents/NetBeansProjects/Intranet_DS/src/Sources/cross.png"));
            }

            model.addRow(new Object[] { asistencia.getFecha(), icono });
        }
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Total de Faltas:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null},
                {"2", null, null, null, null, null, null},
                {"3", null, null, null, null, null, null},
                {"4", null, null, null, null, null, null},
                {"5", null, null, null, null, null, null},
                {"6", null, null, null, null, null, null},
                {"7", null, null, null, null, null, null},
                {"8", null, null, null, null, null, null},
                {"9", null, null, null, null, null, null},
                {"10", null, null, null, null, null, null},
                {"11", null, null, null, null, null, null},
                {"12", null, null, null, null, null, null},
                {"13", null, null, null, null, null, null},
                {"14", null, null, null, null, null, null},
                {"15", null, null, null, null, null, null},
                {"16", null, null, null, null, null, null},
                {"17", null, null, null, null, null, null},
                {"18", null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Semana", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 530, 390));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Asistencias del Alumno");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Ejemplo de ejecución
                Estudiante estudiante = new Estudiante("123", "pass", "Juan", "Perez", "Lopez", 20, "123456789",
                        "12345678", "UNMSM", "Mañana", "Masculino");
                estudiante.getListaA().agregarAsistencia(new Asistencia("2024-11-01", "123", true));
                estudiante.getListaA().agregarAsistencia(new Asistencia("2024-11-02", "123", false));

                new VerAsistencia(null, estudiante).setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
