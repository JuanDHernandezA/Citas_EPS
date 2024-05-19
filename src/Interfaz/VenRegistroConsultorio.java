/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Logica.DAO.ConsultorioDAO;
import Logica.DAO.EspecialidadDAO;
import Logica.DAO.SedeDAO;
import Logica.Models.Consultorio;
import Logica.Models.Especialidad;
import Logica.Models.Sede;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JDiego
 */
public class VenRegistroConsultorio extends javax.swing.JFrame {

    //ConsultasDB db = new ConsultasDB();
    SedeDAO sedeDAO = new SedeDAO();
    EspecialidadDAO especialidadDAO = new EspecialidadDAO();
    ConsultorioDAO consultorioDAO = new ConsultorioDAO();
    List<Especialidad> especialidades = new ArrayList<>();
    List<Sede> sedes = new ArrayList<>();

    /**
     * Creates new form VenRegistroConsultorio
     */
    public VenRegistroConsultorio() {
        initComponents();
        setLocationRelativeTo(null);
        Especialidades();
        Sedes();
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
        txtNumeroCon = new javax.swing.JTextField();
        btnCancelarRegistro = new javax.swing.JButton();
        btnRegistrarCon = new javax.swing.JButton();
        cbSede = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbEsp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Sede");

        jLabel1.setText("Registrar Nuevo Consultorio");

        jLabel2.setText("Número");

        jLabel3.setText("Especialidad");

        btnCancelarRegistro.setText("Cancelar");
        btnCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegistroActionPerformed(evt);
            }
        });

        btnRegistrarCon.setText("Registrar");
        btnRegistrarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConActionPerformed(evt);
            }
        });

        jLabel4.setText("Sede");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarRegistro)
                .addGap(36, 36, 36)
                .addComponent(btnRegistrarCon)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroCon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(cbEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCon)
                    .addComponent(btnCancelarRegistro))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegistroActionPerformed
        new VenMenuAdmin();
        dispose();
    }//GEN-LAST:event_btnCancelarRegistroActionPerformed

    private void btnRegistrarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConActionPerformed

        Consultorio con = new Consultorio();
        
        for (Sede sede : sedes) {
            if(sede.getNombre().equals(cbSede.getSelectedItem())){
                con.setSede(sede);
            }
        }
        
        for (Especialidad esp : especialidades) {
            if(esp.getNombre().equals(cbEsp.getSelectedItem())){
                con.setEspecialidad(esp);
            }
        }
        
        try {
            con.setNumero(Integer.parseInt(txtNumeroCon.getText()));
            consultorioDAO.insertarConsultorio(con);

            //JOptionPane.showMessageDialog(null, "Paciente registrado correctamente", "Registrar paciente", JOptionPane.INFORMATION_MESSAGE, check);
            JOptionPane.showMessageDialog(null, "Consultorio registrado correctamente", "Registrar Consultorio", JOptionPane.INFORMATION_MESSAGE);

            new VenMenuAdmin();
            dispose();

        } catch (Exception e) {
            System.out.println("Error SQL :v");
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Registro fallido", "Registrar Consultorio", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarConActionPerformed

    private void Sedes() {

        sedes = sedeDAO.obtenerSedes();

        for (Sede sede : sedes) {
            cbSede.addItem(sede.getNombre());
        }
    }

    private void Especialidades() {

        especialidades = especialidadDAO.obtenerEspecialidades();
        
        for (Especialidad esp : especialidades) {
            cbEsp.addItem(esp.getNombre());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRegistro;
    private javax.swing.JButton btnRegistrarCon;
    private javax.swing.JComboBox<String> cbEsp;
    private javax.swing.JComboBox<String> cbSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNumeroCon;
    // End of variables declaration//GEN-END:variables
}