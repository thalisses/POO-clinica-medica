/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.util.List;

public class Receita {

	private String receita;
	private String atestado;
	private int clientes_atendidos_mes;
	
	
	public static String GerarReceita(Paciente paciente, String receita) {
		
		return "\n===================================\n"+
				"\nRECEITA MEDICA"+
				"\n===================================\n"+
				"\nPaciente: " + paciente.getNome() + ", " + paciente.getCpf() + "\n" +
				"Detalhes da receita: \n" + receita;
	}
	
	public static String GerarAtestado(Doutor medico, Paciente paciente, int diasAfastado) {
		
		return "\n================ ATESTADO MÉDICO ================\n\n" +
	               "Atesto o(a) paciente " + paciente.getNome() + 
	               ", portador(a) do CPF " + paciente.getCpf() +
	               ", necessita de " + diasAfastado + " dia(s) de afastamento de suas atividades a partir desta data.\n\n" +
	               "Data: " + java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n\n" +
	               "________________________________________\n" +
	               "Dr(a). " + medico.getNome() + "\n" +
	               "Especialidade: " + medico.getEspecialidade() + "\n" + 
	               "===============================================\n";
	}
	
	//public static String RelatorioMensal(Doutor medico, int mes, int ano, List<Consultas> todasConsultas) {
		//implementaçao apos classe consulta estar completa
		
	//}
	
}
