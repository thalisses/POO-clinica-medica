/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Secretaria;

import clinicaMedica.Model.Consulta.Consulta;
import clinicaMedica.Model.Consulta.Consulta.typo;
import clinicaMedica.Model.Consulta.ConsultaRepository;
import clinicaMedica.Model.Medico.Doutor;
import clinicaMedica.Model.Paciente.Contato;
import clinicaMedica.Model.Paciente.Endereco;
import clinicaMedica.Model.Paciente.Paciente;
import clinicaMedica.Model.Paciente.PacienteRepository;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar o menu da secretaria.
 * Permite cadastrar, atualizar e remover pacientes e consultas.
 */
public class MenuSecretaria {

    private final Scanner entrada = new Scanner(System.in);
    private final PacienteRepository repositorioPacientes = PacienteRepository.getInstancia();
    private ConsultaRepository repositorioConsultas = new ConsultaRepository();

    public MenuSecretaria() {}

    /**
     * Exibe o menu principal da secretaria.
     */
    public void menu() {
        String valor = "";
        while (!valor.equalsIgnoreCase("3")) {
            System.out.println("------------------");
            System.out.println("Digite uma opção: ");
            System.out.println("[1] Gerenciar Pacientes");
            System.out.println("[2] Gerenciar Consultas");
            System.out.println("[3] Sair");
            System.out.println("------------------");
            valor = entrada.nextLine();

            switch (valor) {
                case "1":
                    menuPacientes();
                    break;
                case "2":
                    menuConsultas();
                    break;
                case "3":
                    System.out.println("Encerrando menu da secretaria...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Exibe o menu de gerenciamento de pacientes.
     */
    private void menuPacientes() {
        String opcao = "";
        while (!opcao.equals("4")) {
            System.out.println("----------------------");
            System.out.println("[1] Cadastrar paciente");
            System.out.println("[2] Atualizar paciente");
            System.out.println("[3] Remover paciente");
            System.out.println("[4] Voltar");
            System.out.println("----------------------");
            opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarPaciente();
                    break;
                case "2":
                    atualizarPaciente();
                    break;
                case "3":
                    removerPaciente();
                    break;
                case "4":
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Exibe o menu de gerenciamento de consultas.
     */
    private void menuConsultas() {
        String opcao = "";
        while (!opcao.equals("4")) {
            System.out.println("----------------------");
            System.out.println("[1] Cadastrar consulta");
            System.out.println("[2] Atualizar consulta");
            System.out.println("[3] Remover consulta");
            System.out.println("[4] Voltar");
            System.out.println("----------------------");
            opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarConsulta();
                    break;
                case "2":
                    atualizarConsulta();
                    break;
                case "3":
                    removerConsulta();
                    break;
                case "4":
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    /**
     * Cadastra um novo paciente no repositório.
     */
    private void cadastrarPaciente() {
        System.out.println("\n--- Cadastro de Paciente ---");
        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        String cpf;
        while (true) {
            System.out.print("CPF (somente números): ");
            cpf = entrada.nextLine().replaceAll("[^0-9]", "");
            if (cpf.length() == 11) break;
            System.out.println("CPF inválido! Deve conter 11 dígitos.");
        }

        System.out.print("Data de nascimento: ");
        String nascimento = entrada.nextLine();

        System.out.println("\n--- Endereço ---");
        System.out.print("Rua: ");
        String rua = entrada.nextLine();
        System.out.print("Número: ");
        String numero = entrada.nextLine();
        System.out.print("Bairro: ");
        String bairro = entrada.nextLine();
        System.out.print("Cidade: ");
        String cidade = entrada.nextLine();
        System.out.print("Estado: ");
        String estado = entrada.nextLine();
        System.out.print("CEP: ");
        String cep = entrada.nextLine();

        System.out.println("\n--- Contato ---");
        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();
        System.out.print("Celular: ");
        String celular = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Plano de saúde: ");
        String plano = entrada.nextLine();

        System.out.print("Convenio (apenas números) { [1] Particular; [2] Plano de Saude}: " );
        String convenio = entrada.nextLine();
        
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
        Contato contato = new Contato(telefone, celular, email);
        
        Paciente.tiposConvenios enumConvenio = null;
        if(!convenio.isEmpty()){
            if(convenio.equalsIgnoreCase("1")){
                enumConvenio = Paciente.tiposConvenios.PARTICULARES;
            }else if(convenio.equalsIgnoreCase("2")){
                enumConvenio = Paciente.tiposConvenios.PLANO_DE_SAUDE;
            }
        }
        
        Paciente paciente = new Paciente(nome, cpf, nascimento, endereco, contato, enumConvenio, null, plano);
        repositorioPacientes.adicionarPaciente(paciente);
        System.out.println("✅ Paciente cadastrado com sucesso!");
    }

    /**
     * Atualiza os dados de um paciente existente.
     */
    private void atualizarPaciente() {
        System.out.println("\n--- Atualização de Paciente ---");
        System.out.print("CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorioPacientes.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.print("Novo nome (Enter para manter): ");
        String nome = entrada.nextLine();
        if (!nome.isEmpty()) paciente.setNome(nome);

        System.out.print("Novo plano (Enter para manter): ");
        String plano = entrada.nextLine();
        if (!plano.isEmpty()) paciente.setPlano(plano);
        
        System.out.print("Novo Convenio { [1] Particular; [2] Plano de Saude} (Enter para manter):");
        String convenio = entrada.nextLine();
        
       Paciente.tiposConvenios enumConvenio = null;
        if(!convenio.isEmpty()){
            if(convenio.equalsIgnoreCase("1")){
                enumConvenio = Paciente.tiposConvenios.PARTICULARES;
            }else if(convenio.equalsIgnoreCase("2")){
                enumConvenio = Paciente.tiposConvenios.PLANO_DE_SAUDE;
            }
        }
        
        System.out.println("Novo Endereço: ");
        
        System.out.print("Rua (Enter para manter): ");
        String rua = entrada.nextLine();
        if(!rua.isEmpty()) paciente.getEndereco().setRua(rua);
        
        System.out.print("Número (Enter para manter): ");
        String numero = entrada.nextLine();
        if(!numero.isEmpty()) paciente.getEndereco().setNumero(numero);
        
        System.out.print("Bairro (Enter para manter): ");
        String bairro = entrada.nextLine();
        if(!numero.isEmpty()) paciente.getEndereco().setBairro(bairro);
        
        System.out.print("Cidade (Enter para manter): ");
        String cidade = entrada.nextLine();
        if(!cidade.isEmpty()) paciente.getEndereco().setCidade(cidade);
        
        System.out.print("Estado (Enter para manter): ");
        String estado = entrada.nextLine();
        if(!estado.isEmpty()) paciente.getEndereco().setEstado(estado);
        
        System.out.print("CEP (Enter para manter): ");
        String cep = entrada.nextLine();
        if(!cep.isEmpty()) paciente.getEndereco().setCep(cep);
        
        System.out.println("Novo contato Contato (Enter para manter): ");
        
        System.out.print("Telefone (Enter para manter): ");
        String telefone = entrada.nextLine();
        if(!telefone.isEmpty()) paciente.getContato().setTelefone(telefone);
        
        System.out.print("Celular (Enter para manter): ");
        String celular = entrada.nextLine();
        if(!celular.isEmpty()) paciente.getContato().setCelular(celular);
        
        System.out.print("Email (Enter para manter): ");
        String email = entrada.nextLine();
        if(!email.isEmpty()) paciente.getContato().setEmail(email);

        repositorioPacientes.atualizarPaciente(paciente);
        System.out.println("✅ Paciente atualizado com sucesso!");
    }

    /**
     * Remove um paciente do repositório.
     */
    private void removerPaciente() {
        System.out.println("\n--- Remover Paciente ---");
        System.out.print("CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorioPacientes.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        repositorioPacientes.removerPaciente(cpf);
        System.out.println("✅ Paciente removido com sucesso!");
    }

    /**
     * Cadastra uma nova consulta.
     */
    private void cadastrarConsulta() {
        System.out.println("\n--- Cadastro de Consulta ---");
        System.out.print("CPF do paciente: ");
        String cpf = entrada.nextLine();
        Paciente paciente = repositorioPacientes.buscarPorCpf(cpf);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.print("Nome do médico: ");
        String nomeMedico = entrada.nextLine();
        System.out.print("CPF do médico: ");
        String cpfMedico = entrada.nextLine();
        System.out.print("CRM: ");
        String crm = entrada.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = entrada.nextLine();

        System.out.println("\n--- Contato do Médico ---");
        System.out.print("Telefone: ");
        String telefone = entrada.nextLine();
        System.out.print("Celular: ");
        String celular = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();

        Contato contatoMedico = new Contato(telefone, celular, email);
        Doutor medico = new Doutor(nomeMedico, cpfMedico, crm, especialidade, contatoMedico);

        System.out.print("Data da consulta (aaaa-mm-dd): ");
        String dataStr = entrada.nextLine();
        System.out.print("Horário da consulta (hh:mm): ");
        String horaStr = entrada.nextLine();
        LocalDateTime data = LocalDateTime.parse(dataStr + "T" + horaStr);

        System.out.print("Tipo da consulta (1 - NORMAL | 2 - RETORNO): ");
        String tipoStr = entrada.nextLine();
        Consulta.typo tipo = tipoStr.equals("2") ? Consulta.typo.RETORNO : Consulta.typo.NORMAL;

        Consulta consulta = new Consulta(data, data, medico, paciente, tipo);
        repositorioConsultas.adicionarConsulta(consulta);
        System.out.println("✅ Consulta cadastrada com sucesso!");
    }

    /**
     * Atualiza uma consulta existente.
     */
    private void atualizarConsulta() {
        System.out.print("\nCPF do paciente da consulta a atualizar: ");
        String cpf = entrada.nextLine();

        for (Consulta c : repositorioConsultas.listarConsultas()) {
            if (c.getPacientes().getCpf().equals(cpf)) {
                System.out.print("Novo tipo de consulta (1 - NORMAL | 2 - RETORNO): ");
                String novoTipo = entrada.nextLine();

                if (novoTipo.equals("1")) {
                    c.setTipoConsulta(typo.NORMAL);
                } else if (novoTipo.equals("2")) {
                    c.setTipoConsulta(typo.RETORNO);
                } else {
                    System.out.println("Tipo inválido! Mantendo tipo atual.");
                }

                System.out.println("✅ Consulta atualizada!");
                return;
            }
        }
        System.out.println("Consulta não encontrada!");
    }

    /**
     * Remove uma consulta existente.
     */
    private void removerConsulta() {
        System.out.print("\nCPF do paciente para remover consulta: ");
        String cpf = entrada.nextLine();

        Consulta encontrada = null;
        for (Consulta c : repositorioConsultas.listarConsultas()) {
            if (c.getPacientes().getCpf().equals(cpf)) {
                encontrada = c;
                break;
            }
        }

        if (encontrada != null) {
            repositorioConsultas.removerConsulta(encontrada);
            System.out.println("✅ Consulta removida com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}
