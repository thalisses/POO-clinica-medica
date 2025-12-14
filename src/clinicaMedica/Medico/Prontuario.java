/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Medico;

import clinicaMedica.Paciente.Paciente;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entidade JPA que representa o prontuário médico de um paciente.
 */
@Entity
@Table(name = "tb_prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column
    private boolean receita;

    @Column(length = 1000)
    private String sintomas;

    @Column(length = 1000)
    private String diagnostico;

    @Column(length = 2000)
    private String prescricaoTratamento;

    public Prontuario() {
        // Construtor padrão exigido pelo JPA
    }

    public Prontuario(String sintomas, String diagnostico, String prescricaoTratamento, Paciente paciente) {
        this.dataAtendimento = LocalDate.now();
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricaoTratamento = prescricaoTratamento;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfPaciente() {
        if (paciente != null) return paciente.getCpf();
        return null;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    @Override
    public String toString() {
        return "\n  Prontuário ID: " + id + " (Data: " + dataAtendimento + ")\n" +
               "    Sintomas: " + sintomas + '\n' +
               "    Diagnóstico: " + diagnostico + '\n' +
               "    Prescrição: " + prescricaoTratamento;
    }
}
