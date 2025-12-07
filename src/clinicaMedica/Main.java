/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicaMedica;

import clinicaMedica.Mensagem.GerenciadorMensagens;
import clinicaMedica.Consulta.ConsultaRepository;
import clinicaMedica.Medico.MenuMedico;
import clinicaMedica.Medico.RepositorioProntuario;
import clinicaMedica.Medico.Prontuario;
import clinicaMedica.Mensagem.Email;
import clinicaMedica.Mensagem.SMS;
import clinicaMedica.Paciente.InfoAdd;
import clinicaMedica.Paciente.Endereco;
import clinicaMedica.Paciente.Contato;
import clinicaMedica.Paciente.ArmazemHistoricoPaciente;
import clinicaMedica.Paciente.Paciente;
import clinicaMedica.Paciente.PacienteRepository;
import clinicaMedica.Secretaria.MenuSecretaria;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe principal responsável por iniciar o sistema da clínica médica.
 * Gerencia os menus principais de Secretaria, Médico e envio de mensagens.
 */
public class Main {

    /**
     * Método principal que inicializa o sistema e exibe o menu de opções.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PacienteRepository repositorioPacientes = new PacienteRepository();
        ConsultaRepository repositorioConsultas = new ConsultaRepository();
        ArmazemHistoricoPaciente armazem = new ArmazemHistoricoPaciente();

        MenuSecretaria menuSecretaria = new MenuSecretaria();
        MenuMedico menuMedico = new MenuMedico();

        String valor = "";
        while (!valor.equalsIgnoreCase("4")) {
            System.out.println("------------------");
            System.out.println("Digite uma opção: ");
            System.out.println("[1] Secretaria");
            System.out.println("[2] Médico");
            System.out.println("[3] Gerenciador de mensagem");
            System.out.println("[4] Sair");
            System.out.println("------------------");
            valor = entrada.nextLine();

            switch (valor) {
                case "1": {
                    menuSecretaria.menu();
                    break;
                }
                case "2": {
                    menuMedico.menu();
                    break;
                }
                case "3": {
                     // Cria o gerenciador e pergunta o tipo de mensagem
                    GerenciadorMensagens gerenciador = new GerenciadorMensagens();

                    System.out.println("Escolha o tipo de mensagem:");
                    System.out.println("[1] E-mail");
                    System.out.println("[2] SMS");
                    String tipo = entrada.nextLine();

                    if (tipo.equals("1")) {
                        gerenciador.setMensagem(new Email());
                    } else if (tipo.equals("2")) {
                        gerenciador.setMensagem(new SMS());
                    } else {
                        System.out.println("Opção inválida! Voltando ao menu principal...");
                        break;
                    }

                    gerenciador.enviarLembretes(repositorioPacientes, repositorioConsultas);
                    break;
                }
                case "4": {
                    System.out.println("Saindo...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                    break;
                }
            }
        }
        entrada.close();
    }

    /**
     * Formata a resposta do usuário, verificando se é "sim" ou "não".
     *
     * @param resposta resposta informada pelo usuário
     * @return true se a resposta for "sim", false caso contrário
     */
    public static boolean FormataResposta(String resposta) {
        if (resposta == null) {
            return false;
        }

        if (resposta.equalsIgnoreCase("sim")) {
            return true;
        }

        if (!resposta.equalsIgnoreCase("nao")) {
            System.out.println("Resposta inválida, atribuição automática para NÃO!");
        }

        return false;
    }
}
