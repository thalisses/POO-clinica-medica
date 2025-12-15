package clinicaMedica.Medico;

import clinicaMedica.Paciente.Paciente;
import clinicaMedica.Paciente.PacienteRepository;
import clinicaMedica.Paciente.Contato;
import javax.swing.JOptionPane;

/**
 * Painel para geração de relatórios médicos (receitas, atestados, declarações)
 * @author Sistema Clínica Médica
 */
public class GerarRelatorios extends javax.swing.JPanel {

    private PainelMedico painelPrincipal;
    private Paciente pacienteEncontrado = null;
    
    public void setPainelPrincipal(PainelMedico p) {
        this.painelPrincipal = p;
    }

    public GerarRelatorios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        tituloLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        campoCpf = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        nomeLabel = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        separatorLabel = new javax.swing.JLabel();
        tipoRelatorioLabel = new javax.swing.JLabel();
        receitaButton = new javax.swing.JButton();
        atestadoButton = new javax.swing.JButton();
        declaracaoButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(944, 557));

        tituloLabel.setFont(new java.awt.Font("Segoe UI", 1, 36));
        tituloLabel.setForeground(new java.awt.Color(0, 102, 204));
        tituloLabel.setText("GERAR RELATÓRIOS");

        cpfLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        cpfLabel.setText("CPF do Paciente:");

        campoCpf.setFont(new java.awt.Font("Segoe UI", 0, 16));

        buscarButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        nomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        nomeLabel.setText("Nome do Paciente:");

        campoNome.setEditable(false);
        campoNome.setFont(new java.awt.Font("Segoe UI", 0, 16));
        campoNome.setBackground(new java.awt.Color(240, 240, 240));

        separatorLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        separatorLabel.setText("────────────────────────────────────");

        tipoRelatorioLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        tipoRelatorioLabel.setText("Selecione o tipo de relatório:");

        receitaButton.setFont(new java.awt.Font("Segoe UI", 0, 20));
        receitaButton.setText("Receita Médica");
        receitaButton.setEnabled(false);
        receitaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receitaButtonActionPerformed(evt);
            }
        });

        atestadoButton.setFont(new java.awt.Font("Segoe UI", 0, 20));
        atestadoButton.setText("Atestado Médico");
        atestadoButton.setEnabled(false);
        atestadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atestadoButtonActionPerformed(evt);
            }
        });

        declaracaoButton.setFont(new java.awt.Font("Segoe UI", 0, 20));
        declaracaoButton.setText("Declaração de Acompanhamento");
        declaracaoButton.setEnabled(false);
        declaracaoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declaracaoButtonActionPerformed(evt);
            }
        });

        voltarButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        voltarButton.setText("← Voltar");
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfLabel)
                            .addComponent(nomeLabel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(campoNome))
                        .addGap(20, 20, 20)
                        .addComponent(buscarButton))
                    .addComponent(separatorLabel)
                    .addComponent(tipoRelatorioLabel)
                    .addComponent(receitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atestadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(declaracaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tituloLabel)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(separatorLabel)
                .addGap(20, 20, 20)
                .addComponent(tipoRelatorioLabel)
                .addGap(20, 20, 20)
                .addComponent(receitaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(atestadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(declaracaoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(voltarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String cpf = campoCpf.getText().trim();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite o CPF.");
            return;
        }

        try {
            PacienteRepository repo = PacienteRepository.getInstancia();
            pacienteEncontrado = repo.buscarPorCpf(cpf);

            if (pacienteEncontrado == null) {
                JOptionPane.showMessageDialog(this, "Paciente não encontrado para o CPF: " + cpf);
                limparCampos();
                return;
            }

            campoNome.setText(pacienteEncontrado.getNome());
            receitaButton.setEnabled(true);
            atestadoButton.setEnabled(true);
            declaracaoButton.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Paciente encontrado: " + pacienteEncontrado.getNome());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar paciente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void receitaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (pacienteEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Busque um paciente primeiro!");
            return;
        }

        String receita = JOptionPane.showInputDialog(this, 
            "Digite a prescrição médica (medicamentos, dosagens, instruções):", 
            "Receita Médica", 
            JOptionPane.PLAIN_MESSAGE);

        if (receita != null && !receita.trim().isEmpty()) {
            String receitaFormatada = Receita.GerarReceita(pacienteEncontrado, receita);
            JOptionPane.showMessageDialog(this, receitaFormatada, "Receita Gerada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void atestadoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (pacienteEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Busque um paciente primeiro!");
            return;
        }

        String diasStr = JOptionPane.showInputDialog(this, 
            "Digite o número de dias de afastamento:", 
            "Atestado Médico", 
            JOptionPane.PLAIN_MESSAGE);

        if (diasStr != null && !diasStr.trim().isEmpty()) {
            try {
                int dias = Integer.parseInt(diasStr.trim());
                // Criar um médico fictício para o atestado
                Contato contatoMedico = new Contato("(00) 0000-0000", "(00) 00000-0000", "medico@clinica.com");
                Doutor medico = new Doutor("Dr. Médico Responsável", "000.000.000-00", "12345-UF", "Clínico Geral", contatoMedico);
                String atestado = Receita.GerarAtestado(medico, pacienteEncontrado, dias);
                JOptionPane.showMessageDialog(this, atestado, "Atestado Gerado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, digite um número válido de dias.");
            }
        }
    }

    private void declaracaoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (pacienteEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Busque um paciente primeiro!");
            return;
        }

        String declaracao = gerarDeclaracao(pacienteEncontrado);
        JOptionPane.showMessageDialog(this, declaracao, "Declaração Gerada", JOptionPane.INFORMATION_MESSAGE);
    }

    private String gerarDeclaracao(Paciente paciente) {
        return "\n================ DECLARAÇÃO DE ACOMPANHAMENTO ================\n\n" +
               "Declaro para os devidos fins que o(a) paciente " + paciente.getNome() +
               ", portador(a) do CPF " + paciente.getCpf() +
               ", esteve em consulta médica nesta data e necessita de acompanhante.\n\n" +
               "Data: " + java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n\n" +
               "________________________________________\n" +
               "Assinatura do Médico Responsável\n" +
               "==============================================================\n";
    }

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
        if (painelPrincipal != null) {
            painelPrincipal.trocarTela("Menu");
        }
    }

    private void limparCampos() {
        campoCpf.setText("");
        campoNome.setText("");
        pacienteEncontrado = null;
        receitaButton.setEnabled(false);
        atestadoButton.setEnabled(false);
        declaracaoButton.setEnabled(false);
    }

    // Variables declaration
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JButton buscarButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel separatorLabel;
    private javax.swing.JLabel tipoRelatorioLabel;
    private javax.swing.JButton receitaButton;
    private javax.swing.JButton atestadoButton;
    private javax.swing.JButton declaracaoButton;
    private javax.swing.JButton voltarButton;
}
