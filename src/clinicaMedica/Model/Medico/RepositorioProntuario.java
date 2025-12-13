/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Medico;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar, gerenciar e manipular os prontuários médicos.
 * Implementa um padrão Singleton para manter uma única instância do repositório.
 */
public class RepositorioProntuario {

    /** Lista de prontuários cadastrados. */
    private List<Prontuario> lista_prontuarios = new ArrayList<>();

    /** Identificador incremental para os prontuários. */
    private int ID = 1;

    /** Instância única do repositório (Singleton). */
    private static RepositorioProntuario instancia;

    /**
     * Retorna a instância única do repositório de prontuários.
     *
     * @return instância única do {@code RepositorioProntuario}
     */
    public static RepositorioProntuario getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioProntuario();
        }
        return instancia;
    }

    /**
     * Construtor que inicializa a lista de prontuários.
     */
    public RepositorioProntuario() {
        this.lista_prontuarios = new ArrayList<>();
    }

    /**
     * Cadastra um novo prontuário na lista e atribui um ID automático.
     *
     * @param prontuario objeto {@code Prontuario} a ser cadastrado
     */
    public void cadastraProntuario(Prontuario prontuario) {
        prontuario.setId(ID++);
        lista_prontuarios.add(prontuario);
        System.out.println("✅ Prontuário cadastrado para o paciente " 
                           + prontuario.getPaciente().getNome());
    }

    /**
     * Remove um prontuário com base no CPF do paciente.
     *
     * @param cpf CPF do paciente cujo prontuário será removido
     */
    public void removeProntuario(String cpf) {
        boolean remover = lista_prontuarios.removeIf(p -> 
            p.getCpfPaciente().equals(cpf)
        );

        if (remover)
            System.out.println("✅ Prontuário do paciente removido!");
        else
            System.out.println("❌ Prontuário não encontrado para o CPF informado.");
    }

    /**
     * Atualiza os dados de um prontuário existente com base no CPF do paciente.
     *
     * @param cpf CPF do paciente
     * @param sintomas novos sintomas, caso existam
     * @param diagnosticos novos diagnósticos, caso existam
     * @param prescricao nova prescrição de tratamento, caso exista
     */
    public void atualizaProntuario(String cpf, String sintomas, String diagnosticos, String prescricao) {
        Prontuario prontuarioAntigo = null;
        for (Prontuario prontuario : lista_prontuarios) {
            if (prontuario.getCpfPaciente().equals(cpf)) {
                prontuarioAntigo = prontuario;
                break;
            }
        }

        if (prontuarioAntigo != null) {
            boolean mudancas = false;

            if (sintomas != null && !sintomas.isEmpty()) {
                prontuarioAntigo.setSintomas(sintomas);
                System.out.println("Sintomas atualizados.");
                mudancas = true;
            } else System.out.println("Sintomas não atualizados.");

            if (diagnosticos != null && !diagnosticos.isEmpty()) {
                prontuarioAntigo.setDiagnostico(diagnosticos);
                System.out.println("Diagnóstico atualizado.");
                mudancas = true;
            } else System.out.println("Diagnóstico não atualizado.");

            if (prescricao != null && !prescricao.isEmpty()) {
                prontuarioAntigo.setPrescricaoTratamento(prescricao);
                System.out.println("Prescrição atualizada.");
                mudancas = true;
            } else System.out.println("Prescrição não atualizada.");

            if (mudancas)
                System.out.println("✅ Prontuário do CPF " + cpf + " atualizado!");
            else
                System.out.println("⚠️ Nenhuma alteração feita.");
        } else {
            System.out.println("❌ Prontuário não encontrado para o CPF informado!");
        }
    }

    /**
     * Busca um prontuário pelo CPF do paciente.
     *
     * @param cpf CPF do paciente
     * @return o prontuário encontrado ou {@code null} se não existir
     */
    public Prontuario buscarPorCpf(String cpf) {
        for (Prontuario p : lista_prontuarios) {
            if (p.getCpfPaciente().equals(cpf))
                return p;
        }
        return null;
    }

    /**
     * Retorna a lista completa de prontuários cadastrados.
     *
     * @return lista de prontuários
     */
    public List<Prontuario> getListaProntuario() {
        return lista_prontuarios;
    }

    /**
     * Retorna uma representação textual dos prontuários cadastrados.
     *
     * @return texto com todos os prontuários registrados
     */
    @Override
    public String toString() {
        return "-------------------------\n"
             + "Exibindo histórico de Prontuários...\n"
             + lista_prontuarios + "\n";
    }
}
