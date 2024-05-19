/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.DAO.SedeDAO;
import Logica.Models.Sede;
import javax.swing.JOptionPane;

/**
 *
 * @author JDiego
 */
public class VenRegistroSede extends javax.swing.JFrame {

    //ConsultasDB db = new ConsultasDB();
    SedeDAO sedeDAO = new SedeDAO();
    
    /**
     * Creates new form VenRegistroSede
     */
    public VenRegistroSede() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccionSede = new javax.swing.JTextField();
        txtNombreSede = new javax.swing.JTextField();
        btnRegistrarSede = new javax.swing.JButton();
        btnCancelarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Nueva Sede");

        jLabel1.setText("Registrar Nueva Sede");

        jLabel2.setText("Nombre");

        jLabel3.setText("Dirección");

        btnRegistrarSede.setText("Registrar");
        btnRegistrarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSedeActionPerformed(evt);
            }
        });

        btnCancelarRegistro.setText("Cancelar");
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDireccionSede, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreSede, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarRegistro)
                .addGap(36, 36, 36)
                .addComponent(btnRegistrarSede)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccionSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarSede)
                    .addComponent(btnCancelarRegistro))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        new VenMenuAdmin();
        dispose();
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void btnRegistrarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSedeActionPerformed
        Sede sede = new Sede();
        
        sede.setNombre(txtNombreSede.getText());
        sede.setDireccion(txtDireccionSede.getText());

        try {
            sedeDAO.insertarSede(sede);

            //JOptionPane.showMessageDialog(null, "Paciente registrado correctamente", "Registrar paciente", JOptionPane.INFORMATION_MESSAGE, check);
            JOptionPane.showMessageDialog(null, "Sede registrada correctamente", "Registrar Sede", JOptionPane.INFORMATION_MESSAGE);

            new VenMenuAdmin();
            dispose();

        } catch (Exception e) {
            System.out.println("Error SQL :v");
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Registro fallido", "Registrar Sede", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarSedeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRegistro;
    private javax.swing.JButton btnRegistrarSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDireccionSede;
    private javax.swing.JTextField txtNombreSede;
    // End of variables declaration//GEN-END:variables
}
