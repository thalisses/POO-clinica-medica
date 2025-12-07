/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.time.LocalDate;

public class Prontuario {


	private int id;
	private LocalDate dataAtendimento;
	private boolean receita;
	private String sintomas;
	private String diagnostico;
	private String prescricaoTratamento;
	

	/*
	 * Metodo Construtor para 
	 * classe Prontuario
	 */
	 public Prontuario(String sintomas, String diagnostico, String prescricaoTratamento) {
	     this.dataAtendimento = LocalDate.now(); 
	     this.sintomas = sintomas;
	     this.diagnostico = diagnostico;
	     this.prescricaoTratamento = prescricaoTratamento;  
	 }
	 
	 
	 /*
	  * Sets e Gets
	  * para todos atributos
	  * da classe Prontuario
	  */
	 public int getId() {
	     return id;
	 }
	
	 public void setId(int id) {
	     this.id = id;
	 }
	
	 public LocalDate getDataAtendimento() {
	     return dataAtendimento;
	 }
	
	 public void setDataAtendimento(LocalDate dataAtendimento) {
	     this.dataAtendimento = dataAtendimento;
	 }
	
	 public String getSintomas() {
	     return sintomas;
	 }
	
	 public void setSintomas(String sintomas) {
	     this.sintomas = sintomas;
	 }
	
	 public String getDiagnostico() {
	     return diagnostico;
	 }
	
	 public void setDiagnostico(String diagnostico) {
	     this.diagnostico = diagnostico;
	 }
	
	 public String getPrescricaoTratamento() {
	     return prescricaoTratamento;
	 }
	 public void setPrescricaoTratamento(String prescricaoTratamento) {
		 this.prescricaoTratamento = prescricaoTratamento;
	 }
	
	 public void setReceita(boolean receita) {
		 this.receita = receita;
	 }
	 
	 public boolean getReceita() {
		 return receita;
	 }
	 
	 /*
	  * Metodo que retorna em formato String
	  * todos os atributos e objetos da classe
	  * Prontuario
	  */
	 @Override
	 public String toString() {
	     return "\n  Prontuário ID: " + id + " (Data: " + dataAtendimento + ")\n" +
	            "    Sintomas: " + sintomas + '\n' +
	            "    Diagnóstico: " + diagnostico + '\n' +
	            "    Prescrição: " + prescricaoTratamento;
	 }
	
}