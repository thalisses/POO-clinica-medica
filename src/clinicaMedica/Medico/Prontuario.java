/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Medico;

import clinicaMedica.Paciente.Paciente;
import java.time.LocalDate;

/**
 * Classe que representa o prontuário médico de um paciente,
 * contendo informações sobre sintomas, diagnóstico e prescrição.
 */
public class Prontuario {

    private int id;
    private LocalDate dataAtendimento;
    private Paciente paciente;
    private boolean receita;
    private String sintomas;
    private String diagnostico;
    private String prescricaoTratamento;

    /**
     * Construtor da classe Prontuario.
     *
     * @param sintomas sintomas relatados pelo paciente
     * @param diagnostico diagnóstico definido pelo médico
     * @param prescricaoTratamento tratamento ou medicação prescrita
     * @param paciente paciente associado ao prontuário
     */
    public Prontuario(String sintomas, String diagnostico, String prescricaoTratamento, Paciente paciente) {
        this.dataAtendimento = LocalDate.now();
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricaoTratamento = prescricaoTratamento;
        this.paciente = paciente;
    }

    /**
     * Retorna o identificador do prontuário.
     *
     * @return id do prontuário
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do prontuário.
     *
     * @param id identificador a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o CPF do paciente associado ao prontuário.
     *
     * @return CPF do paciente ou null se não houver paciente
     */
    public String getCpfPaciente() {
        if (paciente != null) {
            return paciente.getCpf();
        }
        return null;
    }

    /**
     * Retorna a data do atendimento.
     *
     * @return data do atendimento
     */
    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    /**
     * Define a data do atendimento.
     *
     * @param dataAtendimento data a ser definida
     */
    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    /**
     * Retorna os sintomas relatados.
     *
     * @return sintomas do paciente
     */
    public String getSintomas() {
        return sintomas;
    }

    /**
     * Define os sintomas do paciente.
     *
     * @param sintomas sintomas relatados
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    /**
     * Retorna o paciente associado ao prontuário.
     *
     * @return objeto Paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Define o paciente associado ao prontuário.
     *
     * @param paciente paciente a ser associado
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna o diagnóstico médico.
     *
     * @return diagnóstico do paciente
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Define o diagnóstico médico.
     *
     * @param diagnostico diagnóstico definido pelo médico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Retorna a prescrição ou tratamento indicado.
     *
     * @return texto da prescrição médica
     */
    public String getPrescricaoTratamento() {
        return prescricaoTratamento;
    }

    /**
     * Define a prescrição ou tratamento.
     *
     * @param prescricaoTratamento texto com o tratamento indicado
     */
    public void setPrescricaoTratamento(String prescricaoTratamento) {
        this.prescricaoTratamento = prescricaoTratamento;
    }

    /**
     * Define se o prontuário possui receita médica.
     *
     * @param receita valor booleano indicando se há receita
     */
    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    /**
     * Verifica se o prontuário possui receita médica.
     *
     * @return true se há receita, false caso contrário
     */
    public boolean getReceita() {
        return receita;
    }

    /**
     * Retorna uma representação textual do prontuário.
     *
     * @return string contendo os detalhes do prontuário
     */
    @Override
    public String toString() {
        return "\n  Prontuário ID: " + id + " (Data: " + dataAtendimento + ")\n" +
               "    Sintomas: " + sintomas + '\n' +
               "    Diagnóstico: " + diagnostico + '\n' +
               "    Prescrição: " + prescricaoTratamento;
    }
}
