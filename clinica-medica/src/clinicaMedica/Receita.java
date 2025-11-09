/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.time.LocalDateTime;
import java.util.List;

public class Receita{
	
	
	/*
	 * Metodo que retorna uma Receita Medica
	 */
	public static String GerarReceita(Paciente paciente, String receita) {
		
		return "\n===================================\n"+
				"\nRECEITA MEDICA"+
				"\n===================================\n"+
				"\nPaciente: " + paciente.getNome() + ", " + paciente.getCpf() + "\n" +
				"Detalhes da receita: \n" + receita;
	}
	
	/*
	 * Retorna um atestado médico
	 */
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
	/*
	 * Retorna um relatorio mensal de atendimentos
	 */
	public static String RelatorioMensal(Doutor medico, int mes, int ano, ConsultaRepository listaConsulta) {
		StringBuilder relatorio = new StringBuilder();
		
		relatorio.append("\n===============================================\n");
		relatorio.append("RELATÓRIO MENSAL DE ATENDIMENTOS");
		relatorio.append("\n===============================================\n");
		relatorio.append("Doutor(a): " + medico.getNome() + "\n");
		relatorio.append("Período: " + mes + "/" + ano + "\n");
		relatorio.append("-----------------------------------------------\n\n");
		relatorio.append("Pacientes atendidos:\n");
		
		int contador = 0;
		List<Consulta> todasAsConsultas = listaConsulta.listarConsultas(); 
		
		for (Consulta consulta : todasAsConsultas) {
			LocalDateTime dataConsulta = consulta.getData();
		
			boolean mesmoDoutor = consulta.getMedico().equals(medico);
			boolean mesmoAno = dataConsulta.getYear() == ano;
			boolean mesmoMes = dataConsulta.getMonthValue() == mes;

			if (mesmoDoutor && mesmoAno && mesmoMes) {
				contador++;
				Paciente paciente = consulta.getPacientes(); 
				relatorio.append(contador + ". " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")\n");
			}
		}
		
		if (contador == 0) {
			relatorio.append("Nenhum paciente atendido neste período.\n");
		}
		
		relatorio.append("\n-----------------------------------------------\n");
		relatorio.append("TOTAL DE PACIENTES: " + contador + "\n");
		relatorio.append("===============================================\n");

		return relatorio.toString();	
	}	
}