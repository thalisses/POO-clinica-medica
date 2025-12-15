/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package clinicaMedica.Medico;

/**
 * Menu visual para o médico
 * @author Sistema Clínica Médica
 */
public class MenuMedicoPanel extends javax.swing.JPanel {

    private PainelMedico painelPrincipal;
    
    public void setPainelPrincipal(PainelMedico p){
        this.painelPrincipal = p;
    }
    
    /**
     * Creates new form MenuMedicoPanel
     */
    public MenuMedicoPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        menuTxt = new javax.swing.JLabel();
        cadastrarProntuario = new javax.swing.JButton();
        atualizarProntuario = new javax.swing.JButton();
        gerarRelatorios = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(944, 557));
        setLayout(new java.awt.GridBagLayout());

        menuTxt.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        menuTxt.setForeground(new java.awt.Color(0, 102, 204));
        menuTxt.setText("MENU - MÉDICO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        add(menuTxt, gridBagConstraints);

        cadastrarProntuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cadastrarProntuario.setText("Cadastrar Prontuário");
        cadastrarProntuario.setPreferredSize(new java.awt.Dimension(280, 50));
        cadastrarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProntuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(60, 0, 0, 0);
        add(cadastrarProntuario, gridBagConstraints);

        atualizarProntuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        atualizarProntuario.setText("Atualizar Prontuário");
        atualizarProntuario.setPreferredSize(new java.awt.Dimension(280, 50));
        atualizarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarProntuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        add(atualizarProntuario, gridBagConstraints);

        gerarRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gerarRelatorios.setText("Gerar Relatórios");
        gerarRelatorios.setPreferredSize(new java.awt.Dimension(280, 50));
        gerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRelatoriosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 50, 0);
        add(gerarRelatorios, gridBagConstraints);
    }

    private void cadastrarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {
        painelPrincipal.trocarTela("CadastrarProntuario");
    }
     
    private void atualizarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {
        painelPrincipal.trocarTela("AtualizarProntuario");
    }
    
    private void gerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {
        painelPrincipal.trocarTela("GerarRelatorios");
    }

    // Variables declaration
    private javax.swing.JButton cadastrarProntuario;
    private javax.swing.JButton atualizarProntuario;
    private javax.swing.JButton gerarRelatorios;
    private javax.swing.JLabel menuTxt;
    // End of variables declaration
}
