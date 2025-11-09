/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
public class Secretaria {
    private String nome;
    private String cpf;
    private String matricula;
    private Contato contato;
    private PacienteRepository pacienteRepo;
    private ConsultaRepository consultaRepo;

    public Secretaria() {}
    /*
     * Contrutor de secretaria
     */
    public Secretaria(String nome, String cpf, String matricula, Contato contato, PacienteRepository pacienteRepo, ConsultaRepository consultaRepo) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.contato = contato;
        this.pacienteRepo = pacienteRepo;
        this.consultaRepo = consultaRepo;
    }
    
    /*
     * Cadastra um paciente no repositorio
     */
    public void cadastrarPaciente(Paciente paciente) {
        pacienteRepo.adicionarPaciente(paciente);
    }
    
    /*
     * Atualiza um paciente no repositorio
     */
    public void atualizarPaciente(Paciente paciente) {
        pacienteRepo.atualizarPaciente(paciente);
    }
    
    /*
     * Remove um paciente no repositorio 
     * por meio do cpf (chave primaria)
     */
    public void removerPaciente(String cpf) {
        pacienteRepo.removerPaciente(cpf);
    }

    	/*
    	 * Cadastra uma consulta no repositorio
    	 */
    public void cadastrarConsulta(Consulta consulta) {
        consultaRepo.adicionarConsulta(consulta);
    }

    /*
     * Remove uma consulta do repositorio
     */
    public void removerConsulta(Consulta consulta) {
        consultaRepo.removerConsulta(consulta);
    }

    
    /*
     * Sets e Gets
     * para atributos
     * da classe Secretaria
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public PacienteRepository getPacienteRepo() {
        return pacienteRepo;
    }

    public void setPacienteRepo(PacienteRepository pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    public ConsultaRepository getConsultaRepo() {
        return consultaRepo;
    }

    public void setConsultaRepo(ConsultaRepository consultaRepo) {
        this.consultaRepo = consultaRepo;
    }
    
    /*
     * Metodo que retorna em String todos os 
     * objetos e atributos da classe Seretaria.
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
