/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Consulta;

/**
 *
 * @author User
 */
import clinicaMedica.Medico.Doutor;
import clinicaMedica.Paciente.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private LocalTime horario;
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Doutor medico;
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente pacientes;

    public enum TipoConsulta { NORMAL, RETORNO;}
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConsulta tipoConsulta;

    // metodo para calcular o tipo de consulta, se é consulta normal retorna horario 1h
    // se não retorna horario 30m
    public LocalTime calcularFimConsulta (){
        if (tipoConsulta == TipoConsulta.NORMAL) {
            return horario.plusHours(1);
        }
        else {
            return horario.plusMinutes(30);
        }
    }
    
    // Contrutor da classe Consulta
    public Consulta(){}
    
    public Consulta(LocalDate data, LocalTime horario, Doutor medico, Paciente pacientes, TipoConsulta tipoConsulta) {
        this.data = data;
        this.horario = horario;
        this.medico = medico;
        this.pacientes = pacientes;
        this.tipoConsulta = tipoConsulta;
    }

    	/*
    	 * Sets e Gets
    	 * para os atributos
    	 * da classe Consulta
    	 */
    public Integer getId(){
        return id;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Doutor getMedico() {
        return medico;
    }

    public void setMedico(Doutor medico) {
        this.medico = medico;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    /*
     * Metodo que retorna em formato String
     * todos os objetos e atributos da classe
     * Consulta.
     */
    @Override
    public String toString() {
        return "Consulta{" +
                "data=" + data +
                ", horario=" + horario +
                ", medico=" + medico +
                ", pacientes=" + pacientes +
                ", tipoConsulta=" + tipoConsulta +
                '}';
    }
}