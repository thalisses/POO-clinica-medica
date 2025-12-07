/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar e gerenciar os pacientes do sistema.
 */
public class PacienteRepository {
    
    /** Lista com todos os pacientes cadastrados */
    private List<Paciente> pacientes;

    /** Instância única da classe (padrão Singleton) */
    private static PacienteRepository instancia;

    /**
     * Retorna a instância única do repositório.
     * @return instância de PacienteRepository
     */
    public static PacienteRepository getInstancia() {
        if (instancia == null) {
            instancia = new PacienteRepository();
        }
        return instancia;
    }

    /**
     * Construtor que inicializa a lista de pacientes.
     */
    public PacienteRepository() {
        this.pacientes = new ArrayList<>();
    }

    /**
     * Adiciona um novo paciente à lista.
     * @param paciente paciente a ser adicionado
     */
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    /**
     * Atualiza as informações de um paciente existente.
     * @param paciente paciente atualizado
     */
    public void atualizarPaciente(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(paciente.getCpf())) {
                pacientes.set(i, paciente);
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    /**
     * Remove um paciente do repositório pelo CPF.
     * @param cpf CPF do paciente a ser removido
     */
    public void removerPaciente(String cpf) {
        String cpfFormatado = formatarCpf(cpf);
        boolean removido = pacientes.removeIf(p -> p.getCpf() != null && p.getCpf().equals(cpfFormatado));

        if (removido) {
            System.out.println("Paciente removido do repositório.");
        } else {
            System.out.println("Paciente não encontrado no repositório.");
        }
    }

    /**
     * Retorna uma lista com todos os pacientes cadastrados.
     * @return lista de pacientes
     */
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    /**
     * Busca um paciente pelo CPF.
     * @param cpf CPF do paciente
     * @return paciente encontrado ou null se não existir
     */
    public Paciente buscarPorCpf(String cpf) {
        String cpfFormatado = formatarCpf(cpf);
        for (Paciente p : pacientes) {
            if (p.getCpf() != null && p.getCpf().equals(cpfFormatado)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Formata um CPF para o padrão xxx.xxx.xxx-xx.
     * @param cpf CPF a ser formatado
     * @return CPF formatado
     */
    private String formatarCpf(String cpf) {
        if (cpf == null) return null;
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return cpf;
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9, 11);
    }
}
