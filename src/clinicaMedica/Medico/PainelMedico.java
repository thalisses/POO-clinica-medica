package clinicaMedica.Medico;

import clinicaMedica.Consulta.PanelSelecionarPaciente;
import clinicaMedica.Paciente.Paciente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Painel NetBeans (com initComponents) para o módulo Médico.
 */
public class PainelMedico extends javax.swing.JPanel {

    private final RepositorioProntuario repo = RepositorioProntuario.getInstancia();

    /**
     * Creates new form PainelMedico
     */
    public PainelMedico() {
        initComponents();
        jTextAreaResultado.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDiagnostico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaPrescricao = new javax.swing.JTextArea();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSelecionarPaciente = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaResultado = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("CPF do Paciente:");

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setRows(4);
        jScrollPane1.setViewportView(jTextAreaSintomas);

        jTextAreaDiagnostico.setColumns(20);
        jTextAreaDiagnostico.setRows(4);
        jScrollPane2.setViewportView(jTextAreaDiagnostico);

        jTextAreaPrescricao.setColumns(20);
        jTextAreaPrescricao.setRows(4);
        jScrollPane3.setViewportView(jTextAreaPrescricao);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonSelecionarPaciente.setText("Selecionar Paciente");
        jButtonSelecionarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarPacienteActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonListar.setText("Listar todos");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSelecionarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonListar)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonBuscar)
                .addComponent(jButtonSelecionarPaciente)
                .addComponent(jButtonCadastrar)
                .addComponent(jButtonAtualizar)
                .addComponent(jButtonRemover)
                .addComponent(jButtonListar))
        );

        jTextAreaResultado.setColumns(20);
        jTextAreaResultado.setRows(10);
        jScrollPane4.setViewportView(jTextAreaResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    // </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String cpf = jTextFieldCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe o CPF para buscar."); return; }
        Prontuario p = repo.buscarPorCpf(cpf);
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Prontuário não encontrado para o CPF informado.");
            return;
        }
        jTextAreaSintomas.setText(p.getSintomas());
        jTextAreaDiagnostico.setText(p.getDiagnostico());
        jTextAreaPrescricao.setText(p.getPrescricaoTratamento());
        jTextAreaResultado.setText(p.toString());
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSelecionarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarPacienteActionPerformed
        PanelSelecionarPaciente selector = new PanelSelecionarPaciente();
        int option = JOptionPane.showConfirmDialog(this, selector, "Selecionar Paciente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            Paciente p = selector.getPacienteSelecionado();
            if (p != null) {
                jTextFieldCpf.setText(p.getCpf());
                JOptionPane.showMessageDialog(this, "Paciente selecionado: " + p.getNome());
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum paciente selecionado.");
            }
        }
    }//GEN-LAST:event_jButtonSelecionarPacienteActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        String cpf = jTextFieldCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe o CPF do paciente."); return; }
        Prontuario p = new Prontuario(jTextAreaSintomas.getText(), jTextAreaDiagnostico.getText(), jTextAreaPrescricao.getText(), null);
        try {
            clinicaMedica.Paciente.Paciente paciente = clinicaMedica.Paciente.PacienteRepository.getInstancia().buscarPorCpf(cpf);
            if (paciente != null) p.setPaciente(paciente);
        } catch (Exception ignored) {}
        repo.cadastraProntuario(p);
        JOptionPane.showMessageDialog(this, "Prontuário cadastrado.");
        jTextAreaResultado.setText(p.toString());
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        String cpf = jTextFieldCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe o CPF para atualizar."); return; }
        repo.atualizaProntuario(cpf, jTextAreaSintomas.getText(), jTextAreaDiagnostico.getText(), jTextAreaPrescricao.getText());
        JOptionPane.showMessageDialog(this, "Atualização solicitada.");
        jButtonListarActionPerformed(null);
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        String cpf = jTextFieldCpf.getText().trim();
        if (cpf.isEmpty()) { JOptionPane.showMessageDialog(this, "Informe o CPF para remover."); return; }
        repo.removeProntuario(cpf);
        JOptionPane.showMessageDialog(this, "Remoção solicitada.");
        jButtonListarActionPerformed(null);
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        List<Prontuario> lista = repo.getListaProntuario();
        StringBuilder sb = new StringBuilder();
        for (Prontuario p : lista) sb.append(p.toString()).append('\n');
        jTextAreaResultado.setText(sb.toString());
    }//GEN-LAST:event_jButtonListarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSelecionarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaDiagnostico;
    private javax.swing.JTextArea jTextAreaPrescricao;
    private javax.swing.JTextArea jTextAreaResultado;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextFieldCpf;
    // End of variables declaration//GEN-END:variables

}
