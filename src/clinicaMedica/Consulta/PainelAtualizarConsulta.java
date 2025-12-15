/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package clinicaMedica.Consulta;

import clinicaMedica.Secretaria.PainelSecretaria;
import clinicaMedica.Paciente.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PainelAtualizarConsulta extends javax.swing.JPanel {

    private PainelSecretaria painelPrincipal;
    private Consulta consultaSelecionada;
    
    public void setPainelPrincipal(PainelSecretaria p){
        this.painelPrincipal = p;
    }
    
    /**
     * Creates new form PainelAtualizarConsulta
     */
    public PainelAtualizarConsulta() {
        initComponents();
        carregarPacientes();
        configurarEventos();
    }
    
    private void carregarPacientes() {
        javax.persistence.EntityManager em =
            javax.persistence.Persistence
                .createEntityManagerFactory("ConsultorioPU")
                .createEntityManager();

        List<Paciente> listaPacientes =
                em.createQuery("FROM Paciente", Paciente.class).getResultList();
        for (Paciente p : listaPacientes) {
            comboPaciente.addItem(p);
        }
        
        // Deixar sem seleção inicial
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
        consultaSelecionada = null;

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
        
        comboConsulta.addActionListener(e -> {
            consultaSelecionada = (Consulta) comboConsulta.getSelectedItem();
            if (consultaSelecionada != null) {
                preencherCampos();
            }
        });
    }
    
    private void preencherCampos() {
        if (consultaSelecionada == null) return;
        
        LocalDateTime dataHora = consultaSelecionada.getHorario();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hf = DateTimeFormatter.ofPattern("HH:mm");
        
        campoData.setText(dataHora.format(df));
        campoHorario.setText(dataHora.format(hf));
        
        if (consultaSelecionada.getTipoConsulta() == Consulta.typo.NORMAL) {
            radioNormal.setSelected(true);
        } else {
            radioRetorno.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        atualizarButton = new javax.swing.JButton();
        campoData = new javax.swing.JTextField();
        campoHorario = new javax.swing.JTextField();
        radioNormal = new javax.swing.JRadioButton();
        radioRetorno = new javax.swing.JRadioButton();
        comboPaciente = new javax.swing.JComboBox<>();
        comboConsulta = new javax.swing.JComboBox<>();
        voltarButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Atualizar Consulta");

        jLabel2.setText("Paciente:");

        jLabel3.setText("Consulta:");

        jLabel4.setText("Nova Data:");

        jLabel5.setText("Novo Horário:");

        jLabel6.setText("Tipo:");

        atualizarButton.setText("Atualizar");
        atualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarButtonActionPerformed(evt);
            }
        });

        campoData.setText("dd/mm/aaaa");

        campoHorario.setText("HH:mm");

        buttonGroup1.add(radioNormal);
        radioNormal.setText("Normal (1 hora)");

        buttonGroup1.add(radioRetorno);
        radioRetorno.setText("Retorno (30 min)");

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
                        .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(radioNormal)
                        .addGap(10, 10, 10)
                        .addComponent(radioRetorno))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(atualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(radioNormal)
                    .addComponent(radioRetorno))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarButtonActionPerformed
        if (consultaSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para atualizar");
            return;
        }
        
        String textoData = campoData.getText();
        String textoHora = campoHorario.getText();
        
        if (textoData.isEmpty() || textoData.equals("dd/mm/aaaa")) {
            JOptionPane.showMessageDialog(this, "Informe a nova data");
            return;
        }
        
        if (textoHora.isEmpty() || textoHora.equals("HH:mm")) {
            JOptionPane.showMessageDialog(this, "Informe o novo horário");
            return;
        }
        
        if (!radioNormal.isSelected() && !radioRetorno.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecione o tipo da consulta");
            return;
        }
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data;
        try {
            data = LocalDate.parse(textoData, df);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/mm/aaaa");
            return;
        }
        
        DateTimeFormatter hf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora;
        try {
            hora = LocalTime.parse(textoHora, hf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Horário inválido. Use o formato HH:mm");
            return;
        }
        
        Consulta.typo tipo = radioNormal.isSelected() ? Consulta.typo.NORMAL : Consulta.typo.RETORNO;
        LocalDateTime novaDataHora = data.atTime(hora);
        
        consultaSelecionada.setData(novaDataHora);
        consultaSelecionada.setHorario(novaDataHora);
        consultaSelecionada.setTipoConsulta(tipo);
        
        new ConsultaService().atualizar(consultaSelecionada);
        JOptionPane.showMessageDialog(this, "Consulta atualizada com sucesso!");
        
        // Recarregar a lista de consultas
        Paciente p = (Paciente) comboPaciente.getSelectedItem();
        carregarConsultasDoPaciente(p);
    }//GEN-LAST:event_atualizarButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        painelPrincipal.trocarTela("MenuConsultas");
    }//GEN-LAST:event_voltarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoHorario;
    private javax.swing.JComboBox<Consulta> comboConsulta;
    private javax.swing.JComboBox<Paciente> comboPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton radioNormal;
    private javax.swing.JRadioButton radioRetorno;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
