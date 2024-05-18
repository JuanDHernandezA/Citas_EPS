/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BD.ConsultasDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FliaSalinasRodriguez
 */
public class VenMenuIngreso extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public VenMenuIngreso() {
        initComponents();
        setLocationRelativeTo(null);
        GroupIngreso.add(BtnMedico);
        GroupIngreso.add(BtnPaciente);
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

        GroupIngreso = new javax.swing.ButtonGroup();
        TxtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnPaciente = new javax.swing.JRadioButton();
        BtnMedico = new javax.swing.JRadioButton();
        BtnIngresar = new javax.swing.JButton();
        BtnAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú de Ingreso");
        setMinimumSize(new java.awt.Dimension(276, 326));
        getContentPane().setLayout(null);
        getContentPane().add(TxtId);
        TxtId.setBounds(50, 74, 154, 22);

        jLabel1.setText("Número de Identificación");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 52, 154, 16);

        jLabel2.setText("Menú de Ingreso");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 6, 154, 34);

        jLabel3.setText("Ingresar como");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 102, 170, 16);

        BtnPaciente.setText("Paciente");
        getContentPane().add(BtnPaciente);
        BtnPaciente.setBounds(50, 130, 130, 21);

        BtnMedico.setText("Médico");
        getContentPane().add(BtnMedico);
        BtnMedico.setBounds(50, 163, 140, 21);

        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIngresar);
        BtnIngresar.setBounds(84, 202, 72, 23);

        BtnAdmin.setText("Admin");
        BtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAdmin);
        BtnAdmin.setBounds(156, 236, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        try {
            ConsultasDB bd = new ConsultasDB();
            //ResultSet res = bd.obtenerUsuario(Integer.parseInt(TxtId.getText()));

            //if (res.next()) { DESCOMENTAR PARA INGRESAR CON LOS USUARIOS
            if (true) {
                if (BtnMedico.isSelected()) {
                    //MenuMedico med = new MenuMedico(Integer.parseInt(TxtId.getText()));
                    //med.setVisible(true);
                    dispose();
                } else {
                    if (BtnPaciente.isSelected()) {
                        //MenuPaciente pac = new MenuPaciente();
                        //pac.setVisible(true);
                        dispose();
                    } else {
                        System.out.println("Sin Botón seleccionado");
                    }
                }
            } else {
                System.out.println("Ese usuario no existe...");
            }

        } catch (Exception ex) {
            System.out.println("No se pudo completar la operación... F");
            System.out.println(ex);
        }

    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void BtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdminActionPerformed
        VenMenuAdmin ma = new VenMenuAdmin();
        //ma.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdmin;
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JRadioButton BtnMedico;
    private javax.swing.JRadioButton BtnPaciente;
    private javax.swing.ButtonGroup GroupIngreso;
    private javax.swing.JTextField TxtId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}