/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package clinicaMedica.Consulta;

import clinicaMedica.Secretaria.PainelSecretaria;
import clinicaMedica.Paciente.Contato;
import clinicaMedica.Paciente.Paciente;
import clinicaMedica.GerenciadorMensagens;
import clinicaMedica.Paciente.PacienteRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PainelRelatorioConsulta extends javax.swing.JPanel {

    private PainelSecretaria painelPrincipal;
    private EntityManager em;
    
    public void setPainelPrincipal(PainelSecretaria p){
        this.painelPrincipal = p;
    }
    
    /**
     * Creates new form PainelRelatorioConsulta
     */
    public PainelRelatorioConsulta() {
        initComponents();
        em = Persistence.createEntityManagerFactory("ConsultorioPU").createEntityManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();
        gerarButton = new javax.swing.JButton();
        enviarMensagensButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        voltarButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Consultas - Dia Seguinte");

        jLabel2.setText("Filtrar por:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Com E-mail", "Sem E-mail", "Com Celular", "Sem Celular" }));

        gerarButton.setText("Gerar Relatório");
        gerarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarButtonActionPerformed(evt);
            }
        });

        enviarMensagensButton.setText("Enviar Mensagens");
        enviarMensagensButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensagensButtonActionPerformed(evt);
            }
        });

        tabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "CPF", "Data/Hora", "Tipo", "E-mail", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaConsultas);

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
                        .addGap(10, 10, 10)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(gerarButton)
                        .addGap(20, 20, 20)
                        .addComponent(enviarMensagensButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerarButton)
                    .addComponent(enviarMensagensButton))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(voltarButton)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gerarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarButtonActionPerformed
        // Limpar tabela
        DefaultTableModel model = (DefaultTableModel) tabelaConsultas.getModel();
        model.setRowCount(0);
        
        // Data de amanhã
        LocalDate amanha = LocalDate.now().plusDays(1);
        LocalDateTime inicioAmanha = amanha.atStartOfDay();
        LocalDateTime fimAmanha = amanha.atTime(23, 59, 59);
        
        // Buscar consultas do dia seguinte
        String jpql = "SELECT c FROM Consulta c WHERE c.horario BETWEEN :inicio AND :fim";
        List<Consulta> consultas = em.createQuery(jpql, Consulta.class)
            .setParameter("inicio", inicioAmanha)
            .setParameter("fim", fimAmanha)
            .getResultList();
        
        // Filtrar conforme seleção
        String filtro = (String) comboFiltro.getSelectedItem();
        
        int count = 0;
        for (Consulta c : consultas) {
            Contato contato = c.getPacientes().getContato();
            boolean incluir = false;
            
            switch (filtro) {
                case "Todas":
                    incluir = true;
                    break;
                case "Com E-mail":
                    incluir = contato != null && contato.getEmail() != null && !contato.getEmail().trim().isEmpty();
                    break;
                case "Sem E-mail":
                    incluir = contato == null || contato.getEmail() == null || contato.getEmail().trim().isEmpty();
                    break;
                case "Com Celular":
                    incluir = contato != null && contato.getCelular() != null && !contato.getCelular().trim().isEmpty();
                    break;
                case "Sem Celular":
                    incluir = contato == null || contato.getCelular() == null || contato.getCelular().trim().isEmpty();
                    break;
            }
            
            if (incluir) {
                String email = (contato != null && contato.getEmail() != null) ? contato.getEmail() : "Não informado";
                String celular = (contato != null && contato.getCelular() != null) ? contato.getCelular() : "Não informado";
                
                model.addRow(new Object[]{
                    c.getPacientes().getNome(),
                    c.getPacientes().getCpf(),
                    c.getHorario().toString().replace("T", " "),
                    c.getTipoConsulta(),
                    email,
                    celular
                });
                count++;
            }
        }
        
        JOptionPane.showMessageDialog(this, 
            count + " consulta(s) encontrada(s) para " + amanha.toString(),
            "Relatório Gerado",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_gerarButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        painelPrincipal.trocarTela("MenuConsultas");
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void enviarMensagensButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensagensButtonActionPerformed
        // Buscar consultas do dia seguinte do banco de dados
        LocalDate amanha = LocalDate.now().plusDays(1);
        LocalDateTime inicioAmanha = amanha.atStartOfDay();
        LocalDateTime fimAmanha = amanha.atTime(23, 59, 59);
        
        String jpql = "SELECT c FROM Consulta c WHERE c.horario BETWEEN :inicio AND :fim";
        List<Consulta> consultas = em.createQuery(jpql, Consulta.class)
            .setParameter("inicio", inicioAmanha)
            .setParameter("fim", fimAmanha)
            .getResultList();
        
        if (consultas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Nenhuma consulta marcada para amanhã.",
                "Envio de Mensagens",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Simular envio de mensagens
        System.out.println("\n=== Enviando lembretes de consultas para " + amanha + " ===");
        
        for (Consulta c : consultas) {
            Paciente p = c.getPacientes();
            Contato contato = p.getContato();
            boolean temEmail = contato != null && contato.getEmail() != null && !contato.getEmail().isEmpty();
            boolean temCelular = contato != null && contato.getCelular() != null && !contato.getCelular().isEmpty();

            System.out.println("-----------------------------------------");
            System.out.println("Paciente: " + p.getNome());
            System.out.println("Horário da consulta: " + c.getHorario());

            if (temEmail) {
                System.out.println("Enviando e-mail para " + contato.getEmail() + "...");
            }
            if (temCelular) {
                System.out.println("Enviando SMS para " + contato.getCelular() + "...");
            }

            if (!temEmail && !temCelular) {
                System.out.println("AVISO: Paciente sem e-mail e celular cadastrados!");
            }
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("Envio de lembretes concluído! Total: " + consultas.size() + " consulta(s)");
        
        JOptionPane.showMessageDialog(this,
            "Mensagens enviadas com sucesso!\n" + consultas.size() + " consulta(s) encontrada(s).\nVerifique o console para detalhes.",
            "Envio de Mensagens",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_enviarMensagensButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JButton enviarMensagensButton;
    private javax.swing.JButton gerarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConsultas;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
