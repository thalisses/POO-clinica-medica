package clinicaMedica.Model.Prontuario;

// Não precisa de imports, é um POJO simples

public class Prontuario {
   
    private String cpfPaciente;
    private String sintomas;
    private String diagnostico;
    private String prescricao;

    public Prontuario() {
    }

    // CONSTRUTOR COMPLETO
    public Prontuario(String cpfPaciente, String sintomas, String diagnostico, String prescricao) {
        this.cpfPaciente = cpfPaciente;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    // GETTERS E SETTERS (Métodos que a sua tela usa para ler e escrever os atributos)
    
    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
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

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
}