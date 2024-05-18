/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author FliaSalinasRodriguez
 */
public class VenMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    public VenMenuAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menú administrador");
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

        BtnRegPaciente = new javax.swing.JButton();
        BtnRegMedico = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnRegSede = new javax.swing.JButton();
        BtnRegConsultorio = new javax.swing.JButton();
        BtnRegEsp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Administrador");

        BtnRegPaciente.setLabel("Registrar Paciente");
        BtnRegPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegPacienteActionPerformed(evt);
            }
        });

        BtnRegMedico.setLabel("Registrar Médico");
        BtnRegMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegMedicoActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Mono", 0, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO ADMINISTRADOR");

        BtnRegSede.setText("Registrar Sede");
        BtnRegSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegSedeActionPerformed(evt);
            }
        });

        BtnRegConsultorio.setText("Registrar Consultorio");
        BtnRegConsultorio.setToolTipText("");
        BtnRegConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegConsultorioActionPerformed(evt);
            }
        });

        BtnRegEsp.setText("Registrar Especialización");
        BtnRegEsp.setToolTipText("");
        BtnRegEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegEspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnRegEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegConsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCancelar)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(BtnRegSede)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnRegConsultorio)
                        .addGap(8, 8, 8)
                        .addComponent(BtnRegEsp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnRegPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnRegMedico)
                        .addContainerGap(44, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        VenMenuIngreso m = new VenMenuIngreso();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnRegPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegPacienteActionPerformed
        //Registrar_paciente rp = new Registrar_paciente();
        //rp.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnRegPacienteActionPerformed

    private void BtnRegMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegMedicoActionPerformed
        //Registrar_medico rm = new Registrar_medico();
        //rm.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnRegMedicoActionPerformed

    private void BtnRegSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegSedeActionPerformed
        VenRegistroSede rs = new VenRegistroSede();
        dispose();
    }//GEN-LAST:event_BtnRegSedeActionPerformed

    private void BtnRegConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRegConsultorioActionPerformed

    private void BtnRegEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegEspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRegEspActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnRegConsultorio;
    private javax.swing.JButton BtnRegEsp;
    private javax.swing.JButton BtnRegMedico;
    private javax.swing.JButton BtnRegPaciente;
    private javax.swing.JButton BtnRegSede;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}