/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.HashMap;
public class ArmazemHistoricoPaciente {
    
    private HashMap<String, RepositorioProntuario> Lista_PacienteProntuario = new HashMap<>();
	
	public ArmazemHistoricoPaciente() {
		this.Lista_PacienteProntuario = new HashMap<>();
	}
	
	public void AramazenaProntuario(String cpf, RepositorioProntuario repositorio) {
		Lista_PacienteProntuario.put(cpf, repositorio);
		
	}
	
	
	public RepositorioProntuario getRepositorioPaciente(String cpf) {
		RepositorioProntuario repositorio = Lista_PacienteProntuario.get(cpf);
		
		if(repositorio == null) { 
			repositorio = new RepositorioProntuario(); 
			Lista_PacienteProntuario.put(cpf, repositorio);
		}
		return repositorio;
	}
	
	
	public String buscaHistorico(String cpf) {
		RepositorioProntuario repositorio = getRepositorioPaciente(cpf);
		return repositorio.toString();
		
	}
    
}
