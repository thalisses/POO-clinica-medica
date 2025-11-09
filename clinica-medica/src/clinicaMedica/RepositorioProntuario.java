/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;







import java.util.ArrayList;
import java.util.List;

public class RepositorioProntuario {

	// Lista de Prontuarios
	private List<Prontuario> lista_prontuarios = new ArrayList<Prontuario>();
	
	private int ID = 1; 
	
	// Construtor que inicia a lista de Prontuario
	public RepositorioProntuario(){
		
		this.lista_prontuarios = new ArrayList<>();
	}
	
	
	
	/*
	 * Cadastra um prontuario para a lista e seta um ID
	 * (chave primaria)
	 */
	public void cadastraProntuario(Prontuario prontuario) {
		prontuario.setId(ID++);
		lista_prontuarios.add(prontuario);
		System.out.println("Prontuario cadastrado");
		
	}

	/*
	 * Remove um prontuario da lista
	 * pelo ID
	 */
	public void removeProntuario(int id){
		
		boolean remover = lista_prontuarios.removeIf(p -> p.getId() == id);
		
		if(remover == true) {System.out.println("Prontuario removido");}
		
		else System.out.println("Prontuario não encontrado. ");
		
	}
	
	/*
	 * Atualiza um prontuario na lista
	 * pelo ID
	 */
	public void atualizaProntuario(int id, String sintomas, String diagnosticos, String prescricao) {
		Prontuario prontuarioAntigo = null;
		for(Prontuario prontuario : lista_prontuarios) {
			if(prontuario.getId() == id) {
				prontuarioAntigo = prontuario;
				break;
			}
		}
		
		if(prontuarioAntigo != null) {
			
			boolean mudancas = false;
			
			if(sintomas != null && !sintomas.isEmpty()) {
				prontuarioAntigo.setSintomas(sintomas);
				System.out.println("Sintomas atualizado.");
				mudancas = true;
			}else {System.out.println("Sintomas não atualizado");}
			
			
			if(diagnosticos != null && !diagnosticos.isEmpty()) {
				prontuarioAntigo.setDiagnostico(diagnosticos);
				System.out.println("Diagnostico atualizado");
				mudancas = true;
			}else {System.out.println("Diagnosticos não atualizados");}
			
			
			if(prescricao != null && !prescricao.isEmpty()) {
				prontuarioAntigo.setPrescricaoTratamento(prescricao);
				System.out.println("Prescricao Atualizada");
				mudancas = true;
			}else { System.out.println("Prescricao não atualizada "); }
			
			if(mudancas) { System.out.println("Pronturario de ID: " + id + " Atualizado!"); }
			
			else { System.out.println("Prontuario nao atulizado! "); }
				
			
			return;
		}
		else {System.out.println("Prontuario de ID: " + id + " não encontrado");}
		
	}
	
	//Retorna uma lista de prontuario
	public List<Prontuario> getListaProntuario(){
		return lista_prontuarios;
	}
	
	/*
	 * Metodo que retorna em forma de String 
	 * uma lista de prontuario.
	 */
	public String toString() {
		return "-------------------------" + 
				"\nExibindo historio de Prontuarios..."+
				"\n" + lista_prontuarios + "\n";
	}
}
