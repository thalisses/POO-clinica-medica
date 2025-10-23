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
import java.util.HashMap;
import java.util.List;
import java.util.Map;






public class RepositorioProntuario {

	private final Map<String, List<Prontuario>> prontuariosPorPaciente = new HashMap<>();
	private int proximoIdProntuario = 1;

 
 
 
 
	public void cadastrarProntuario(String cpfPaciente, Prontuario novoProntuario) {
		novoProntuario.setId(proximoIdProntuario);
     
		List<Prontuario> listaDoPaciente = prontuariosPorPaciente.get(cpfPaciente);

		if (listaDoPaciente == null) {     
			listaDoPaciente = new ArrayList<>();
			prontuariosPorPaciente.put(cpfPaciente, listaDoPaciente);
		}
    
		listaDoPaciente.add(novoProntuario);     
		System.out.println("Prontuário cadastrado com sucesso para o paciente de CPF " + cpfPaciente);
	}

	public List<Prontuario> buscarProntuarios(String cpfPaciente) {
		return prontuariosPorPaciente.getOrDefault(cpfPaciente, new ArrayList<>());
	}
	
	public boolean atualizarProntuario(String cpfPaciente, Prontuario prontuarioAtualizado) {

		List<Prontuario> listaDoPaciente = prontuariosPorPaciente.get(cpfPaciente);
		if (listaDoPaciente != null) {
			for (int i = 0; i < listaDoPaciente.size(); i++) {
				if (listaDoPaciente.get(i).getId() == prontuarioAtualizado.getId()) {
					listaDoPaciente.set(i, prontuarioAtualizado);
					System.out.println("Prontuário ID " + prontuarioAtualizado.getId() + " atualizado.");
					return true;
				}
			}
		}
		System.out.println("Erro: Prontuário não encontrado para atualização.");
		return false;
	}

	public boolean removerProntuario(String cpfPaciente, long idProntuario) {
    
		List<Prontuario> listaDoPaciente = prontuariosPorPaciente.get(cpfPaciente);
		if (listaDoPaciente != null) {
			boolean removido = listaDoPaciente.removeIf(prontuario -> prontuario.getId() == idProntuario);
			if(removido) {
				System.out.println("Prontuário ID " + idProntuario + " removido.");
				return true;
			}
		}
		System.out.println("Erro: Prontuário não encontrado para remoção.");
		return false;
	}
}
