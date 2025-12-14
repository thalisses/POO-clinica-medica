/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Medico;

import clinicaMedica.Paciente.Contato;
import clinicaMedica.Paciente.Paciente;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe que representa um doutor no sistema da clínica.
 * Contém informações pessoais, profissionais e de contato do médico.
 */
@Entity
@Table(name = "medico")
public class Doutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 100, name = "NOME", nullable = false)
    /** Nome do doutor */
    private String nome;
    
    @Column(length = 20, name = "CPF", nullable = false)
    /** CPF do doutor */
    private String cpf;
    
    @Column(length = 20, name = "CRM", nullable = false)
    /** CRM (registro profissional) do doutor */
    private String crm;
    
    @Column(length = 30, name = "ESPECIALIDADE", nullable = false)
    /** Especialidade médica do doutor */
    private String especialidade;
    
    
    /** Contato do doutor */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato contato;


    /**
     * Construtor da classe Doutor.
     * @param nome nome do doutor
     * @param cpf cpf do doutor
     * @param crm crm do doutor
     * @param especialidade especialidade médica
     * @param contato informações de contato
     */
    
    public Doutor(){}
    
    public Doutor(String nome, String cpf, String crm, String especialidade, Contato contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.especialidade = especialidade;
        this.contato = contato;
    }

    /**
     * Mostra as informações médicas adicionais de um paciente.
     * @param pacientes paciente cujas informações serão exibidas
     */
    public void visualizarInfoSaude(Paciente pacientes) {
        System.out.println("Informações médicas de " + pacientes.getNome() + ":");
        System.out.println(pacientes.getInfoAdd().toString());
    }
    
    public Long getId(){
        return id;
    }
    
    /** Retorna o nome do doutor. */
    public String getNome() {
        return nome;
    }

    /** Define o nome do doutor. */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Retorna o CPF do doutor. */
    public String getCpf() {
        return cpf;
    }

    /** Define o CPF do doutor. */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** Retorna o CRM do doutor. */
    public String getCrm() {
        return crm;
    }

    /** Define o CRM do doutor. */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /** Retorna a especialidade médica do doutor. */
    public String getEspecialidade() {
        return especialidade;
    }

    /** Define a especialidade médica do doutor. */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /** Retorna o contato do doutor. */
    public Contato getContato() {
        return contato;
    }

    /** Define o contato do doutor. */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /**
     * Retorna uma representação em texto do doutor.
     * @return informações do doutor em formato String
     */
    @Override
public String toString() {
    return nome + " (" + especialidade + ")";
}
}
