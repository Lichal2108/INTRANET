
package Visuales.administrador;

import Clases.Coordinador;
import Clases.Estudiante;
import Clases.Profesor;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class crear_perfiles extends javax.swing.JFrame {
    
    
   
    public crear_perfiles() {
        initComponents();
        this.setTitle("Registro usuarios");
        this.setLocation(400, 190);
        
        txtContraseña.setEnabled(false);
        txt_nombre.setEnabled(false);
        txtApellidoM.setEnabled(false);
        txtApellidoP.setEnabled(false);
        txtTelefono.setEnabled(false);
        txt_codigo.setEnabled(false);
        txt_dni.setEnabled(false);
        cmbEspecialidad.setEnabled(false);
        cmbTurno.setEnabled(false);
        cmbUniversidad.setEnabled(false);
        cmbsexo.setEnabled(false);
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_fondo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmb_tipousuario = new javax.swing.JComboBox<>();
        btn_aceptar = new javax.swing.JButton();
        cmbTurno = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbUniversidad = new javax.swing.JComboBox<>();
        cmbEspecialidad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbsexo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jPanelApellidoP = new javax.swing.JPanel();
        jPanelApellidoM = new javax.swing.JPanel();
        jPanelContraseña = new javax.swing.JPanel();
        jPanelDNI = new javax.swing.JPanel();
        jPanelSexo = new javax.swing.JPanel();
        jPanelTurno = new javax.swing.JPanel();
        jPanelTelefono = new javax.swing.JPanel();
        jPanelCodigo = new javax.swing.JPanel();
        jPanelUniversidad = new javax.swing.JPanel();
        jPanelEspecialidad = new javax.swing.JPanel();
        jPanelNombre1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_fondo.setBackground(new java.awt.Color(255, 204, 102));
        lbl_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Nombre");
        lbl_fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        lbl_fondo.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 102, 482, -1));

        jLabel1.setText("Apellido P.");
        lbl_fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        lbl_fondo.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 170, 482, -1));

        jLabel2.setText("Codigo");
        lbl_fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });
        lbl_fondo.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 204, 190, -1));

        jLabel3.setText("DNI");
        lbl_fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });
        lbl_fondo.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 238, 482, -1));

        jLabel4.setText("Universidad");
        lbl_fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel6.setText("Turno");
        lbl_fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        jLabel7.setText("Especialidad");
        lbl_fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel8.setText("Teléfono");
        lbl_fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));
        lbl_fondo.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 447, -1));

        jLabel9.setText("Tipo usuario");
        lbl_fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        cmb_tipousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Estudiante", "Profesor", "Coordinador" }));
        cmb_tipousuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipousuarioActionPerformed(evt);
            }
        });
        lbl_fondo.add(cmb_tipousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 68, 120, -1));

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        lbl_fondo.add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 396, -1, -1));

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Mañana", "Tarde" }));
        lbl_fondo.add(cmbTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 183, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        lbl_fondo.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 396, -1, -1));

        jLabel11.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel11.setText("CREAR PERFILES");
        lbl_fondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 6, 213, 37));

        txtApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMActionPerformed(evt);
            }
        });
        lbl_fondo.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 136, 482, -1));

        jLabel12.setText("Apellido M.");
        lbl_fondo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        cmbUniversidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "UNMSM", "UNAC", "UNI", "UNFV" }));
        lbl_fondo.add(cmbUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 272, 167, -1));

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Razonamiento Verbal", "Razonamiento Matematico", "Lenguaje", "Literatura", "Matemáticas", "Ciencias Naturales", "Ciencias Sociales" }));
        lbl_fondo.add(cmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 306, 176, -1));

        jLabel10.setText("Sexo");
        lbl_fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        cmbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Femenino", "Masculino", "Reservado" }));
        lbl_fondo.add(cmbsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 183, -1));

        jLabel13.setText("Contraseña");
        lbl_fondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));
        lbl_fondo.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 190, -1));

        javax.swing.GroupLayout jPanelApellidoPLayout = new javax.swing.GroupLayout(jPanelApellidoP);
        jPanelApellidoP.setLayout(jPanelApellidoPLayout);
        jPanelApellidoPLayout.setHorizontalGroup(
            jPanelApellidoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelApellidoPLayout.setVerticalGroup(
            jPanelApellidoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, 20));

        javax.swing.GroupLayout jPanelApellidoMLayout = new javax.swing.GroupLayout(jPanelApellidoM);
        jPanelApellidoM.setLayout(jPanelApellidoMLayout);
        jPanelApellidoMLayout.setHorizontalGroup(
            jPanelApellidoMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelApellidoMLayout.setVerticalGroup(
            jPanelApellidoMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, 20));

        javax.swing.GroupLayout jPanelContraseñaLayout = new javax.swing.GroupLayout(jPanelContraseña);
        jPanelContraseña.setLayout(jPanelContraseñaLayout);
        jPanelContraseñaLayout.setHorizontalGroup(
            jPanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelContraseñaLayout.setVerticalGroup(
            jPanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, -1));

        javax.swing.GroupLayout jPanelDNILayout = new javax.swing.GroupLayout(jPanelDNI);
        jPanelDNI.setLayout(jPanelDNILayout);
        jPanelDNILayout.setHorizontalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelDNILayout.setVerticalGroup(
            jPanelDNILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        javax.swing.GroupLayout jPanelSexoLayout = new javax.swing.GroupLayout(jPanelSexo);
        jPanelSexo.setLayout(jPanelSexoLayout);
        jPanelSexoLayout.setHorizontalGroup(
            jPanelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelSexoLayout.setVerticalGroup(
            jPanelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        javax.swing.GroupLayout jPanelTurnoLayout = new javax.swing.GroupLayout(jPanelTurno);
        jPanelTurno.setLayout(jPanelTurnoLayout);
        jPanelTurnoLayout.setHorizontalGroup(
            jPanelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelTurnoLayout.setVerticalGroup(
            jPanelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, -1, -1));

        javax.swing.GroupLayout jPanelTelefonoLayout = new javax.swing.GroupLayout(jPanelTelefono);
        jPanelTelefono.setLayout(jPanelTelefonoLayout);
        jPanelTelefonoLayout.setHorizontalGroup(
            jPanelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelTelefonoLayout.setVerticalGroup(
            jPanelTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        javax.swing.GroupLayout jPanelCodigoLayout = new javax.swing.GroupLayout(jPanelCodigo);
        jPanelCodigo.setLayout(jPanelCodigoLayout);
        jPanelCodigoLayout.setHorizontalGroup(
            jPanelCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelCodigoLayout.setVerticalGroup(
            jPanelCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        javax.swing.GroupLayout jPanelUniversidadLayout = new javax.swing.GroupLayout(jPanelUniversidad);
        jPanelUniversidad.setLayout(jPanelUniversidadLayout);
        jPanelUniversidadLayout.setHorizontalGroup(
            jPanelUniversidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelUniversidadLayout.setVerticalGroup(
            jPanelUniversidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        javax.swing.GroupLayout jPanelEspecialidadLayout = new javax.swing.GroupLayout(jPanelEspecialidad);
        jPanelEspecialidad.setLayout(jPanelEspecialidadLayout);
        jPanelEspecialidadLayout.setHorizontalGroup(
            jPanelEspecialidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelEspecialidadLayout.setVerticalGroup(
            jPanelEspecialidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        javax.swing.GroupLayout jPanelNombre1Layout = new javax.swing.GroupLayout(jPanelNombre1);
        jPanelNombre1.setLayout(jPanelNombre1Layout);
        jPanelNombre1Layout.setHorizontalGroup(
            jPanelNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanelNombre1Layout.setVerticalGroup(
            jPanelNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_fondo.add(jPanelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, 20));

        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
            
        
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        
            if (!verificarCampos()) {
                // Si los campos no son válidos, no continuar
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos en rojo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String tipoUsuario = cmb_tipousuario.getSelectedItem().toString();
            String codigo = txt_codigo.getText();
            String contraseña = txtContraseña.getText();
            String nombre = txt_nombre.getText();
            String apellidoPaterno = txtApellidoP.getText();
            String apellidoMaterno = txtApellidoM.getText();
            String celular = txtTelefono.getText();
            String dni = txt_dni.getText();
            String sexo = cmbsexo.getSelectedItem().toString();

            switch (tipoUsuario) {
                case "Estudiante":
                    String universidad = cmbUniversidad.getSelectedItem().toString();
                    String turno = cmbTurno.getSelectedItem().toString();

                    Estudiante estudiante = new Estudiante(
                        codigo, contraseña, nombre, apellidoPaterno, apellidoMaterno, 0, // Edad puedes ajustarla si es necesaria
                        celular, dni, universidad, turno, sexo
                    );
                    JOptionPane.showMessageDialog(this, "Estudiante registrado exitosamente.");
                    break;

                case "Profesor":
                    String especialidad = cmbEspecialidad.getSelectedItem().toString();

                    Profesor profesor = new Profesor(
                        codigo, contraseña, nombre, apellidoPaterno, apellidoMaterno, celular, dni, especialidad, sexo
                    );
                    JOptionPane.showMessageDialog(this, "Profesor registrado exitosamente.");
                    break;

                case "Coordinador":
                    Coordinador coordinador = new Coordinador(
                        codigo, contraseña, nombre, apellidoPaterno, apellidoMaterno, celular, dni, sexo
                    );
                    JOptionPane.showMessageDialog(this, "Coordinador registrado exitosamente.");
                    break;
            }
        
    }//GEN-LAST:event_btn_aceptarActionPerformed

    
    private boolean verificarCampos() {
            boolean valido = true; 
            String tipoUsuario = cmb_tipousuario.getSelectedItem().toString();

            
            if (tipoUsuario.equals("-------------")) {
                JOptionPane.showMessageDialog(this, "No se ha elegido un tipo de usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (txtContraseña.getText().isEmpty()) {
                jPanelContraseña.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelContraseña.setBackground(Color.GREEN);
            }

            if (txt_nombre.getText().isEmpty()) {
                jPanelNombre1.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelNombre1.setBackground(Color.GREEN);
            }

            if (txtApellidoM.getText().isEmpty()) {
                jPanelApellidoM.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelApellidoM.setBackground(Color.GREEN);
            }

            if (txtApellidoP.getText().isEmpty()) {
                jPanelApellidoP.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelApellidoP.setBackground(Color.GREEN);
            }

            if (txtTelefono.getText().isEmpty()) {
                jPanelTelefono.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelTelefono.setBackground(Color.GREEN);
            }

            if (txt_codigo.getText().isEmpty()) {
                jPanelCodigo.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelCodigo.setBackground(Color.GREEN);
            }

            if (txt_dni.getText().isEmpty()) {
                jPanelDNI.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelDNI.setBackground(Color.GREEN);
            }

            // Validar los campos específicos según el tipo de usuario
            switch (tipoUsuario) {
                case "Estudiante":
                    if (cmbTurno.getSelectedItem() == null || cmbTurno.getSelectedItem().toString().equals("-------------")) {
                        jPanelTurno.setBackground(Color.RED);
                        valido = false;
                    } else {
                        jPanelTurno.setBackground(Color.GREEN);
                    }

                    if (cmbUniversidad.getSelectedItem() == null || cmbUniversidad.getSelectedItem().toString().equals("-------------")) {
                        jPanelUniversidad.setBackground(Color.RED);
                        valido = false;
                    } else {
                        jPanelUniversidad.setBackground(Color.GREEN);
                    }
                    break;

                case "Profesor":
                    if (cmbEspecialidad.getSelectedItem() == null || cmbEspecialidad.getSelectedItem().toString().equals("-------------")) {
                        jPanelEspecialidad.setBackground(Color.RED);
                        valido = false;
                    } else {
                        jPanelEspecialidad.setBackground(Color.GREEN);
                    }
                    break;

                case "Coordinador":
                    break;

                default:
                    valido = false;
                    break;
            }

            if (cmbsexo.getSelectedItem() == null || cmbsexo.getSelectedItem().toString().equals("-------------")) {
                jPanelSexo.setBackground(Color.RED);
                valido = false;
            } else {
                jPanelSexo.setBackground(Color.GREEN);
            }

            return valido; 
        }

    
    
    
    
    
    
    
    
    
    
    
    
    
    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<' ' || c>' ')) evt.consume();
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<' ' || c>' ')) evt.consume();
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_txt_dniKeyTyped

    
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JOptionPane.showMessageDialog(this, "Has cancelado la operación", 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
        admin_main principal=new admin_main();
        principal.setVisible(true);
        this.setVisible(false);
   
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txtApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMActionPerformed

    private void cmb_tipousuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipousuarioActionPerformed
       
        String tipoUsuario = cmb_tipousuario.getSelectedItem().toString();

        switch (tipoUsuario) {
            case "Estudiante":
                txtContraseña.setEnabled(true);
                txt_nombre.setEnabled(true);
                txtApellidoM.setEnabled(true);
                txtApellidoP.setEnabled(true);
                txtTelefono.setEnabled(true);
                txt_codigo.setEnabled(true);
                txt_dni.setEnabled(true);
                cmbEspecialidad.setEnabled(false);
                cmbTurno.setEnabled(true);
                cmbUniversidad.setEnabled(true);
                cmbsexo.setEnabled(true);
                break;

            case "Profesor":
                txtContraseña.setEnabled(true);
                txt_nombre.setEnabled(true);
                txtApellidoM.setEnabled(true);
                txtApellidoP.setEnabled(true);
                txtTelefono.setEnabled(true);
                txt_codigo.setEnabled(true);
                txt_dni.setEnabled(true);
                cmbEspecialidad.setEnabled(true);
                cmbTurno.setEnabled(false);
                cmbUniversidad.setEnabled(false);
                cmbsexo.setEnabled(true);
                break;

            case "Coordinador":
                txtContraseña.setEnabled(true);
                txt_nombre.setEnabled(true);
                txtApellidoM.setEnabled(true);
                txtApellidoP.setEnabled(true);
                txtTelefono.setEnabled(true);
                txt_codigo.setEnabled(true);
                txt_dni.setEnabled(true);
                cmbEspecialidad.setEnabled(false);
                cmbTurno.setEnabled(false);
                cmbUniversidad.setEnabled(false);
                cmbsexo.setEnabled(true);
                break;

            default:
                // Deshabilitar todos los campos si no se selecciona un tipo de usuario válido
                txtContraseña.setEnabled(false);
                txt_nombre.setEnabled(false);
                txtApellidoM.setEnabled(false);
                txtApellidoP.setEnabled(false);
                txtTelefono.setEnabled(false);
                txt_codigo.setEnabled(false);
                txt_dni.setEnabled(false);
                cmbEspecialidad.setEnabled(false);
                cmbTurno.setEnabled(false);
                cmbUniversidad.setEnabled(false);
                cmbsexo.setEnabled(false);
                break;
        }


        
        
    }//GEN-LAST:event_cmb_tipousuarioActionPerformed

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
            java.util.logging.Logger.getLogger(crear_perfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crear_perfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crear_perfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crear_perfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new crear_perfiles().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JComboBox<String> cmbEspecialidad;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JComboBox<String> cmbUniversidad;
    private javax.swing.JComboBox<String> cmb_tipousuario;
    private javax.swing.JComboBox<String> cmbsexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelApellidoM;
    private javax.swing.JPanel jPanelApellidoP;
    private javax.swing.JPanel jPanelCodigo;
    private javax.swing.JPanel jPanelContraseña;
    private javax.swing.JPanel jPanelDNI;
    private javax.swing.JPanel jPanelEspecialidad;
    private javax.swing.JPanel jPanelNombre1;
    private javax.swing.JPanel jPanelSexo;
    private javax.swing.JPanel jPanelTelefono;
    private javax.swing.JPanel jPanelTurno;
    private javax.swing.JPanel jPanelUniversidad;
    private javax.swing.JPanel lbl_fondo;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    private static class DriverManager {

        private static Connection getConnection(String url, String usuario, String contraseña) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public DriverManager() {
        }
    }
}
