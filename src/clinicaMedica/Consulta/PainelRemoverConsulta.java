/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package clinicaMedica.Consulta;

import clinicaMedica.Secretaria.PainelSecretaria;
import clinicaMedica.Paciente.Paciente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PainelRemoverConsulta extends javax.swing.JPanel {

    private PainelSecretaria painelPrincipal;
    
    public void setPainelPrincipal(PainelSecretaria p){
        this.painelPrincipal = p;
    }
    
    /**
     * Creates new form PainelRemoverConsulta
     */
    public PainelRemoverConsulta() {
        initComponents();
        carregarPacientes();
        configurarEventos();
    }
    
    private void carregarPacientes() {
        javax.persistence.EntityManager em =
            javax.persistence.Persistence
                .createEntityManagerFactory("ConsultorioPU")
                .createEntityManager();

        List<Paciente> lista = em.createQuery("FROM Paciente", Paciente.class).getResultList();

        for (Paciente p : lista) {
            comboPaciente.addItem(p);
        }        
        comboPaciente.setSelectedIndex(-1);
        em.close();
    }
    
    public void recarregarPacientes() {
        comboPaciente.removeAllItems();
        comboConsulta.removeAllItems();
        carregarPacientes();
    }

    private void carregarConsultasDoPaciente(Paciente p) {
        comboConsulta.removeAllItems();

        if (p == null) return;

        List<Consulta> lista = new ConsultaService().listarPorPaciente(p.getId());

        for (Consulta c : lista) {
            comboConsulta.addItem(c);
        }
    }

    private void configurarEventos() {
        comboPaciente.addActionListener(e -> {
            Paciente p = (Paciente) comboPaciente.getSelectedItem();
            carregarConsultasDoPaciente(p);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboPaciente = new javax.swing.JComboBox<>();
        comboConsulta = new javax.swing.JComboBox<>();
        removerButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Remover Consulta");

        jLabel2.setText("Paciente:");

        jLabel3.setText("Consulta:");

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        Consulta selecionada = (Consulta) comboConsulta.getSelectedItem();

        if (selecionada == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma consulta selecionada.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja remover esta consulta?",
            "Confirmar Remoção",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            new ConsultaService().remover(selecionada);
            JOptionPane.showMessageDialog(this, "Consulta removida com sucesso!");

            // Recarrega lista após remoção
            Paciente p = (Paciente) comboPaciente.getSelectedItem();
            carregarConsultasDoPaciente(p);
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        painelPrincipal.trocarTela("MenuConsultas");
    }//GEN-LAST:event_voltarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Consulta> comboConsulta;
    private javax.swing.JComboBox<Paciente> comboPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton removerButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
