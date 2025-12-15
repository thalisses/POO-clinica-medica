/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */

import clinicaMedica.Consulta.Consulta;
import clinicaMedica.Consulta.ConsultaRepository;
import clinicaMedica.Paciente.Contato;
import clinicaMedica.Paciente.Paciente;
import clinicaMedica.Paciente.PacienteRepository;
import java.time.LocalDate;
import java.util.List;

public class GerenciadorMensagens {

    public static void enviarLembretes(PacienteRepository repoPacientes, ConsultaRepository repoConsultas) {
    LocalDate hoje = LocalDate.now();
    LocalDate amanha = hoje.plusDays(1);

    System.out.println("\n=== Enviando lembretes de consultas para " + amanha + " ===");

    // Pega todas as consultas
    List<Consulta> consultas = repoConsultas.listarConsultas();

    boolean encontrou = false;
    for (Consulta c : consultas) {
        // Comparar apenas a data (sem hora) do horário da consulta
        LocalDate dataConsulta = c.getHorario().toLocalDate();
        
        if (dataConsulta.equals(amanha)) {
            Paciente p = c.getPacientes();
            encontrou = true;

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
    }

    if (!encontrou) {
        System.out.println("Nenhuma consulta marcada para amanhã.");
    }

    System.out.println("-----------------------------------------");
    System.out.println("Envio de lembretes concluído!");
}

}
