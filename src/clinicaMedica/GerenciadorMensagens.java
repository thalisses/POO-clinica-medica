/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */

import clinicaMedica.Model.Consulta.Consulta;
import clinicaMedica.Model.Consulta.ConsultaRepository;
import clinicaMedica.Model.Paciente.Contato;
import clinicaMedica.Model.Paciente.Paciente;
import clinicaMedica.Model.Paciente.PacienteRepository;
    import java.time.LocalDate;
import java.util.List;

public class GerenciadorMensagens {

    public static void enviarLembretes(PacienteRepository repoPacientes, ConsultaRepository repoConsultas) {
    LocalDate hoje = LocalDate.now();
    LocalDate amanha = hoje.plusDays(1);

    System.out.println("\n📅 === Enviando lembretes de consultas para " + amanha + " ===");

    // Pega todas as consultas
    List<Consulta> consultas = repoConsultas.listarConsultas();

    boolean encontrou = false;
    for (Consulta c : consultas) {
        if (c.getData().equals(amanha)) {
            Paciente p = c.getPacientes(); // <- se o método for getPaciente(), ajuste aqui!
            encontrou = true;

            Contato contato = p.getContato();
            boolean temEmail = contato != null && contato.getEmail() != null && !contato.getEmail().isEmpty();
            boolean temCelular = contato != null && contato.getCelular() != null && !contato.getCelular().isEmpty();

            System.out.println("-----------------------------------------");
            System.out.println("Paciente: " + p.getNome());
            System.out.println("Horário da consulta: " + c.getHorario());
            System.out.println("Médico: " + c.getMedico().getNome());

            if (temEmail) {
                System.out.println("📧 Enviando e-mail para " + contato.getEmail() + "...");
            }
            if (temCelular) {
                System.out.println("📱 Enviando SMS para " + contato.getCelular() + "...");
            }

            if (!temEmail && !temCelular) {
                System.out.println("⚠️ Paciente sem e-mail e celular cadastrados!");
            }
        }
    }

    if (!encontrou) {
        System.out.println("✅ Nenhuma consulta marcada para amanhã.");
    }

    System.out.println("-----------------------------------------");
    System.out.println("📤 Envio de lembretes concluído!");
}

}
