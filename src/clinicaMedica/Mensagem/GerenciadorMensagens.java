/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Mensagem;

import clinicaMedica.Consulta.ConsultaRepository;
import clinicaMedica.Paciente.PacienteRepository;


/**
 * Classe responsável por gerenciar o envio de mensagens e lembretes de consultas.
 */
public class GerenciadorMensagens {

    private Mensagem mensagem;

    /**
     * Define o tipo de mensagem a ser enviada (Email ou SMS).
     * @param mensagem objeto que implementa a interface Mensagem
     */
    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * Envia lembretes para pacientes usando o tipo de mensagem definido.
     * @param pacientes repositório de pacientes
     * @param consultas repositório de consultas
     */
    public void enviarLembretes(PacienteRepository pacientes, ConsultaRepository consultas) {
        if (mensagem == null) {
            System.out.println("Nenhum tipo de mensagem definido!");
            return;
        }

        // Aqui você pode adaptar para percorrer os pacientes e consultas reais
        mensagem.enviar("Lembrete de consulta: verifique seus agendamentos!");
    }
}