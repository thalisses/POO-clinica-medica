/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Secretaria;

import clinicaMedica.Model.Consulta.Consulta;
import clinicaMedica.Model.Consulta.ConsultaRepository;
import clinicaMedica.Model.Paciente.Contato;
import clinicaMedica.Model.Paciente.Paciente;
import clinicaMedica.Model.Paciente.PacienteRepository;

/**
 * Classe que representa uma secretária na clínica.
 * Responsável por cadastrar, atualizar e remover pacientes e consultas.
 */
public class Secretaria {
    private String nome;
    private String cpf;
    private String matricula;
    private Contato contato;
    private PacienteRepository pacienteRepo;
    private ConsultaRepository consultaRepo;

    /** Construtor padrão da classe Secretaria. */
    public Secretaria() {}

    /**
     * Construtor que inicializa todos os atributos da secretária.
     * @param nome nome da secretária
     * @param cpf CPF da secretária
     * @param matricula número de matrícula da secretária
     * @param contato dados de contato da secretária
     * @param pacienteRepo repositório de pacientes
     * @param consultaRepo repositório de consultas
     */
    public Secretaria(String nome, String cpf, String matricula, Contato contato, PacienteRepository pacienteRepo, ConsultaRepository consultaRepo) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.contato = contato;
        this.pacienteRepo = pacienteRepo;
        this.consultaRepo = consultaRepo;
    }

    /**
     * Cadastra um paciente no repositório.
     * @param paciente paciente a ser cadastrado
     */
    public void cadastrarPaciente(Paciente paciente) {
        pacienteRepo.adicionarPaciente(paciente);
    }

    /**
     * Atualiza um paciente existente no repositório.
     * @param paciente paciente a ser atualizado
     */
    public void atualizarPaciente(Paciente paciente) {
        pacienteRepo.atualizarPaciente(paciente);
    }

    /**
     * Remove um paciente do repositório pelo CPF.
     * @param cpf CPF do paciente a ser removido
     */
    public void removerPaciente(String cpf) {
        pacienteRepo.removerPaciente(cpf);
    }

    /**
     * Cadastra uma nova consulta no repositório.
     * @param consulta consulta a ser cadastrada
     */
    public void cadastrarConsulta(Consulta consulta) {
        consultaRepo.adicionarConsulta(consulta);
    }

    /**
     * Remove uma consulta do repositório.
     * @param consulta consulta a ser removida
     */
    public void removerConsulta(Consulta consulta) {
        consultaRepo.removerConsulta(consulta);
    }

    /** @return nome da secretária */
    public String getNome() {
        return nome;
    }

    /** @param nome define o nome da secretária */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return CPF da secretária */
    public String getCpf() {
        return cpf;
    }

    /** @param cpf define o CPF da secretária */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** @return matrícula da secretária */
    public String getMatricula() {
        return matricula;
    }

    /** @param matricula define a matrícula da secretária */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /** @return contato da secretária */
    public Contato getContato() {
        return contato;
    }

    /** @param contato define o contato da secretária */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /** @return repositório de pacientes */
    public PacienteRepository getPacienteRepo() {
        return pacienteRepo;
    }

    /** @param pacienteRepo define o repositório de pacientes */
    public void setPacienteRepo(PacienteRepository pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    /** @return repositório de consultas */
    public ConsultaRepository getConsultaRepo() {
        return consultaRepo;
    }

    /** @param consultaRepo define o repositório de consultas */
    public void setConsultaRepo(ConsultaRepository consultaRepo) {
        this.consultaRepo = consultaRepo;
    }

    /**
     * Retorna uma representação textual da secretária.
     * @return informações da secretária em formato de texto
     */
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                ", contato=" + contato +
                '}';
    }
}
