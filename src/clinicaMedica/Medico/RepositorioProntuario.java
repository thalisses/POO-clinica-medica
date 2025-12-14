/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Medico;

import java.util.List;

/**
 * Repositório adaptador que preserva a API em memória já usada
 * pelo restante do sistema, mas delega as operações de persistência
 * para o `ProntuarioRepository` baseado em JPA.
 */
public class RepositorioProntuario {

    private static RepositorioProntuario instancia;
    private final ProntuarioRepository repo;

    public static RepositorioProntuario getInstancia() {
        if (instancia == null) instancia = new RepositorioProntuario();
        return instancia;
    }

    public RepositorioProntuario() {
        this.repo = new ProntuarioRepository();
    }

    public void cadastraProntuario(Prontuario prontuario) {
        repo.cadastraProntuario(prontuario);
        System.out.println("✅ Prontuário cadastrado para o paciente "
                           + (prontuario.getPaciente() != null ? prontuario.getPaciente().getNome() : "<desconhecido>"));
    }

    public void removeProntuario(String cpf) {
        repo.removeProntuario(cpf);
        System.out.println("Remoção solicitada para CPF: " + cpf);
    }

    public void atualizaProntuario(String cpf, String sintomas, String diagnosticos, String prescricao) {
        repo.atualizaProntuario(cpf, sintomas, diagnosticos, prescricao);
    }

    public Prontuario buscarPorCpf(String cpf) {
        return repo.buscarPorCpf(cpf);
    }

    public List<Prontuario> getListaProntuario() {
        return repo.listarProntuarios();
    }

    @Override
    public String toString() {
        return "-------------------------\nExibindo histórico de Prontuários...\n" + getListaProntuario() + "\n";
    }
}
