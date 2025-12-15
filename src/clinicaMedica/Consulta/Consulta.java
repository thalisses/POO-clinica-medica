/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Consulta;

/**
 * Representa uma consulta médica no sistema.
 * Entidade JPA mapeada para a tabela tb_consulta no banco de dados.
 * Armazena informações sobre data, horário, paciente e tipo de consulta.
 *
 * @author User
 */
import clinicaMedica.Paciente.Paciente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;

@Entity
@Table(name = "tb_consulta")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "data_consulta")
    private LocalDateTime data;
    
    @Column(name = "horario_consulta")
    private LocalDateTime horario;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacientes;

    /** Enumeração dos tipos de consulta disponíveis. */
    public enum typo { 
        /** Consulta normal - duração de 1 hora. */
        NORMAL, 
        /** Consulta de retorno - duração de 30 minutos. */
        RETORNO;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_consulta")
    private typo tipoConsulta;

    /**
     * Construtor padrão sem argumentos.
     * Necessário para o funcionamento do JPA.
     */
    public Consulta() {
    }

    /**
     * Calcula o horário de término da consulta com base no tipo.
     * Consultas normais têm duração de 1 hora, consultas de retorno duram 30 minutos.
     * 
     * @return horário de término da consulta
     */
    public LocalDateTime calcularTipo (){
        if (tipoConsulta == typo.NORMAL) return horario.plusHours(1);
        else return horario.plusMinutes(30);
    }
    
    /**
     * Cria uma nova consulta com todos os atributos.
     * 
     * @param data data da consulta
     * @param horario horário de início da consulta
     * @param pacientes paciente que será atendido
     * @param tipoConsulta tipo da consulta (NORMAL ou RETORNO)
     */
    public Consulta(LocalDateTime data, LocalDateTime horario, Paciente pacientes, typo tipoConsulta) {
        this.data = data;
        this.horario = horario;
        this.pacientes = pacientes;
        this.tipoConsulta = tipoConsulta;
    }

    /**
     * Métodos getters e setters para acesso e modificação
     * dos atributos da classe Consulta.
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public typo getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(typo tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    /**
     * Retorna uma representação textual formatada da consulta.
     * Formato: "Nome do Paciente - dd/MM/yyyy HH:mm (TIPO)"
     * Exemplo: "João Silva - 22/12/2025 14:30 (NORMAL)"
     * 
     * @return string formatada com informações da consulta
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return pacientes.getNome() + " - " + 
               horario.format(formatter) + " (" + tipoConsulta + ")";
    }
}