/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Medico;

import clinicaMedica.Model.Consulta.ConsultaRepository;
import clinicaMedica.Model.Paciente.ArmazemHistoricoPaciente;
import clinicaMedica.Model.Paciente.Contato;
import clinicaMedica.Model.Paciente.Endereco;
import clinicaMedica.Model.Paciente.InfoAdd;
import clinicaMedica.Model.Paciente.Paciente;
import clinicaMedica.Model.Paciente.PacienteRepository;
import java.util.Scanner;

/**
 * Classe que representa o menu usado pelo médico no sistema.
 * Permite gerenciar prontuários, informações de pacientes e gerar relatórios.
 */
public class MenuMedico {

    /**
     * Scanner para ler entradas do usuário.
     */
    private Scanner entrada = new Scanner(System.in);

    /**
     * Repositório de pacientes.
     */
    private PacienteRepository repositorio = PacienteRepository.getInstancia();

    /**
     * Armazena o histórico dos pacientes.
     */
    private ArmazemHistoricoPaciente armazem = new ArmazemHistoricoPaciente();

    /**
     * Repositório de prontuários.
     */
    private RepositorioProntuario repositorioProntuario = RepositorioProntuario.getInstancia();

    /**
     * Médico que está usando o sistema.
     */
    private Doutor doutor;

    /**
     * Repositório de consultas.
     */
    private ConsultaRepository repositorioConsultas = new ConsultaRepository();

    /**
     * Construtor que recebe o médico.
     * @param doutor médico logado
     */
    public MenuMedico(Doutor doutor) {
        this.doutor = doutor;
    }

    /**
     * Construtor vazio.
     */
    public MenuMedico() {}

    /**
     * Mostra o menu principal do médico e suas opções.
     */
    public void menu() {
        String valor = "";
        while (!valor.equalsIgnoreCase("4")) {
            System.out.println("------------------");
            System.out.println("[1] Gerenciar Prontuários");
            System.out.println("[2] Gerenciar informações adicionais de paciente");
            System.out.println("[3] Gerar relatório mensal");
            System.out.println("[4] Sair");
            System.out.println("------------------");
            System.out.print("Escolha: ");
            valor = entrada.nextLine();

            switch (valor) {
                case "1":
                    menuProntuario();
                    break;
                case "2":
                    menuInfoAdicionais();
                    break;
                case "3":
                    gerarRelatorioMensal();
                    break;
                case "4":
                    System.out.println("Encerrando menu médico...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Mostra o menu de gerenciamento de prontuários.
     */
    private void menuProntuario() {
        String opcao = "";
        while (!opcao.equals("4")) {
            System.out.println("----------------------");
            System.out.println("[1] Cadastrar prontuário");
            System.out.println("[2] Atualizar prontuário");
            System.out.println("[3] Remover prontuário");
            System.out.println("[4] Voltar");
            System.out.println("----------------------");
            opcao = entrada.nextLine();

            switch (opcao) {
                case "1": cadastrar(); break;
                case "2": atualizar(); break;
                case "3": remover(); break;
                case "4": System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Mostra o menu para gerenciar informações adicionais de pacientes.
     */
    private void menuInfoAdicionais() {
        String opcao = "";
        while (!opcao.equals("4")) {
            System.out.println("----------------------");
            System.out.println("[1] Cadastrar informações adicionais");
            System.out.println("[2] Atualizar informações adicionais");
            System.out.println("[3] Remover informações adicionais");
            System.out.println("[4] Voltar");
            System.out.println("----------------------");
            opcao = entrada.nextLine();

            switch (opcao) {
                case "1": InfoAdd.cadastrar(entrada, repositorio); break;
                case "2": InfoAdd.atualizar(entrada, repositorio); break;
                case "3": InfoAdd.remover(entrada, repositorio); break;
                case "4": System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Gera um relatório mensal com as consultas do médico.
     */
    private void gerarRelatorioMensal() {
        System.out.print("Digite o mês (1-12): ");
        int mes = entrada.nextInt();
        System.out.print("Digite o ano (ex: 2025): ");
        int ano = entrada.nextInt();
        entrada.nextLine(); // consumir quebra de linha

        String relatorio = Receita.RelatorioMensal(doutor, mes, ano, repositorioConsultas);
        System.out.println(relatorio);
    }

    /**
     * Formata a resposta do usuário para sim ou não.
     * @param resposta resposta digitada
     * @return true se for "sim", false caso contrário
     */
    public static boolean FormataResposta(String resposta) {
        if (resposta == null) return false;
        if (resposta.equalsIgnoreCase("sim")) return true;
        if (!resposta.equalsIgnoreCase("nao"))
            System.out.println("Resposta inválida, atribuição automática para NAO!");
        return false;
    }

    /**
     * Cadastra um novo prontuário para o paciente.
     */
    public void cadastrar() {
        System.out.println("\n--- Cadastro de Prontuário ---");
        System.out.print("CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("❌ Paciente não encontrado!");
            return;
        }

        System.out.print("Sintomas: ");
        String sintomas = entrada.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = entrada.nextLine();
        System.out.print("Prescrição: ");
        String prescricao = entrada.nextLine();

        Prontuario prontuario = new Prontuario(sintomas, diagnostico, prescricao, paciente);
        repositorioProntuario.cadastraProntuario(prontuario);
        System.out.println("✅ Prontuário cadastrado para o paciente " + paciente.getNome());
    }

    /**
     * Atualiza um prontuário existente pelo CPF do paciente.
     */
    public void atualizar() {
        System.out.println("\n--- Atualizar Prontuário ---");
        System.out.print("Digite o cpf do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("❌ Paciente não encontrado!");
            return;
        }

        Prontuario prontuario = repositorioProntuario.buscarPorCpf(cpf);
        if (prontuario == null) {
            System.out.println("❌ Nenhum prontuário encontrado para esse paciente!");
            return;
        }

        System.out.print("Novos sintomas (Enter para manter): ");
        String sintomas = entrada.nextLine();
        System.out.print("Novo diagnóstico (Enter para manter): ");
        String diagnostico = entrada.nextLine();
        System.out.print("Nova prescrição (Enter para manter): ");
        String prescricao = entrada.nextLine();

        repositorioProntuario.atualizaProntuario(cpf, sintomas, diagnostico, prescricao);
    }

    /**
     * Remove um prontuário do paciente informado.
     */
    public void remover() {
        System.out.println("\n--- Remover Prontuário ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("❌ Paciente não encontrado!");
            return;
        }

        Prontuario prontuario = repositorioProntuario.buscarPorCpf(cpf);
        if (prontuario == null) {
            System.out.println("❌ Nenhum prontuário encontrado para esse paciente!");
            return;
        }

        repositorioProntuario.removeProntuario(cpf);
        System.out.println("🗑️ Prontuário removido com sucesso!");
    }
}
