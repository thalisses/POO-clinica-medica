/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
	
	// Lista de Pacientes
    private List<Paciente> pacientes;
    	
    //Construtor que inicia a lista de pacientes
    public PacienteRepository() {
        this.pacientes = new ArrayList<>();
    }

    // Adiciona um paciente
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    // Atualiza um paciente pelo CPF
    public void atualizarPaciente(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(paciente.getCpf())) {
                pacientes.set(i, paciente);
                return;
            }
        }
        System.out.println("Paciente não encontrado!");
    }

    // Remove um paciente pelo CPF
    public void removerPaciente(String cpf) {
        pacientes.removeIf(p -> p.getCpf().equals(cpf));
    }

    // Retorna todos os pacientes
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    // Buscar paciente pelo CPF
    public Paciente buscarPorCpf(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
}
