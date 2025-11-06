/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.HashMap;
public class ArmazemHistoricoPaciente {
    
    /*
	 * Map que armazena para cada cpf (chave primaria)
	 * uma lista de prontuarios. Ou seja, cada paciente
	 * tem uma lista de Prontuario
	 */
	private HashMap<String, RepositorioProntuario> Lista_PacienteProntuario = new HashMap<>();
	
	/*
	 * Contrutor que inicia o HashMap
	 */
	public ArmazemHistoricoPaciente() {
		this.Lista_PacienteProntuario = new HashMap<>();
	}
	
	/*
	 * Armazena uma chave primaria e uma lista de prontuarios.
	 * exemplo: cpf -> List<Prontuarios>
	 */
	public void AramazenaProntuario(String cpf, RepositorioProntuario repositorio) {
		Lista_PacienteProntuario.put(cpf, repositorio);
		
	}
	
	/*
	 * Retorna o repositorio de prontuario de um paciente.
	 * Caso Paciente nao tem um repositorio, cria um.
	 * Busca repositorio pela chave primaria (cpf).
	 */
	public RepositorioProntuario getRepositorioPaciente(String cpf) {
		RepositorioProntuario repositorio = Lista_PacienteProntuario.get(cpf);
		
		if(repositorio == null) { 
			repositorio = new RepositorioProntuario(); 
			Lista_PacienteProntuario.put(cpf, repositorio);
		}
		return repositorio;
	}
	
	/*
	 * Retorna uma String formatada com todo 
	 * o historico de prontuario de um paciente
	 */
	
	public String buscaHistorico(String cpf) {
		RepositorioProntuario repositorio = getRepositorioPaciente(cpf);
		return repositorio.toString();
		
	}
    
}
