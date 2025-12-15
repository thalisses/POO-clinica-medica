/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicaMedica;

import clinicaMedica.Medico.PainelMedico;
import clinicaMedica.Secretaria.PainelSecretaria;

/**
 * Tela principal do sistema que permite escolher entre Médico e Secretária
 * @author Sistema Clínica Médica
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Construtor da tela principal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Inicializa os componentes da interface gráfica
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSecretaria = new javax.swing.JButton();
        btnMedico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Clínica Médica - Saúde & Cia");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Clínica Médica Saúde & Cia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(40, 20, 20, 20);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Selecione o tipo de acesso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 30, 20);
        jPanel1.add(jLabel2, gridBagConstraints);

        btnSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnSecretaria.setText("Secretária");
        btnSecretaria.setPreferredSize(new java.awt.Dimension(280, 120));
        btnSecretaria.setFocusPainted(false);
        btnSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecretariaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 40, 10);
        jPanel1.add(btnSecretaria, gridBagConstraints);

        btnMedico.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnMedico.setText("Médico");
        btnMedico.setPreferredSize(new java.awt.Dimension(280, 120));
        btnMedico.setFocusPainted(false);
        btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 40, 20);
        jPanel1.add(btnMedico, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnSecretariaActionPerformed(java.awt.event.ActionEvent evt) {
        // Abre o painel da secretária
        javax.swing.JFrame frameSecretaria = new javax.swing.JFrame("Sistema Clínica Médica - Secretária");
        frameSecretaria.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        
        PainelSecretaria painelSecretaria = new PainelSecretaria();
        frameSecretaria.add(painelSecretaria);
        
        frameSecretaria.setSize(1000, 650);
        frameSecretaria.setLocationRelativeTo(null);
        frameSecretaria.setVisible(true);
    }

    private void btnMedicoActionPerformed(java.awt.event.ActionEvent evt) {
        // Abre o painel do médico
        PainelMedico painelMedico = new PainelMedico();
        painelMedico.setVisible(true);
    }

    /**
     * Método principal para testes
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnSecretaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
