package clinicaMedica;

import clinicaMedica.Consulta.ConsultaRepository;
import clinicaMedica.Paciente.PacienteRepository;
import clinicaMedica.Secretaria.PainelSecretaria;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Simple Swing entrypoint for the application. Provides buttons to open
 * Secretaria panel, (placeholder) Médico module and to run the
 * Gerenciador de mensagens (shows simulated output).
 */
public class MainGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> buildAndShowGui());
    }

    private static void buildAndShowGui() {
        JFrame frame = new JFrame("Saúde & Cia - Sistema Clínico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Top-level tabbed UI: Secretaria and Médico as tabs.
        JTabbedPane tabs = new JTabbedPane();

        // Add Secretaria tab
        tabs.addTab("Secretaria", new PainelSecretaria());

        // Add Médico tab
        tabs.addTab("Médico", new clinicaMedica.Medico.PainelMedico());

        // Keep a small top panel for actions (like running the mensagens manager)
        JPanel top = new JPanel();
        JButton mensagensBtn = new JButton("Enviar Lembretes (Gerenciador)");
        mensagensBtn.addActionListener((ActionEvent e) -> runGerenciadorMensagens(frame));
        top.add(mensagensBtn);

        frame.getContentPane().add(top, BorderLayout.NORTH);
        frame.getContentPane().add(tabs, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void openSecretaria() {
        JFrame janela = new JFrame("Painel - Secretária");
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PainelSecretaria painel = new PainelSecretaria();
        janela.getContentPane().add(painel);
        janela.pack();
        janela.setSize(1000, 700);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    private static void openMedico() {
        JFrame janela = new JFrame("Painel - Médico");
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clinicaMedica.Medico.PainelMedico painel = new clinicaMedica.Medico.PainelMedico();
        janela.getContentPane().add(painel);
        janela.pack();
        janela.setSize(900, 700);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    private static void runGerenciadorMensagens(JFrame parent) {
        // Capture System.out temporarily to display simulated messages in a dialog
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        try {
            System.setOut(ps);

            // run the existing manager with repository instances
            clinicaMedica.GerenciadorMensagens.enviarLembretes(PacienteRepository.getInstancia(), new ConsultaRepository());

            ps.flush();
            String output = baos.toString();

            JTextArea ta = new JTextArea(output);
            ta.setEditable(false);
            JScrollPane scroll = new JScrollPane(ta);
            scroll.setPreferredSize(new Dimension(700, 400));
            JOptionPane.showMessageDialog(parent, scroll, "Resultados do Gerenciador de Mensagens", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace(originalOut);
            JOptionPane.showMessageDialog(parent, "Erro ao executar o gerenciador: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.setOut(originalOut);
            try { ps.close(); } catch (Exception ignore) {}
        }
    }
}
