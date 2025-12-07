/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
public class Doutor {
    private String nome;
    private String cpf;
    private String crm;
    private String especialidade;
    private Contato contato;

    //Contrutor da classe Doutor
    public Doutor(String nome, String cpf, String crm, String especialidade, Contato contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.especialidade = especialidade;
        this.contato = contato;
    }
    
    /*
     * Retorna informações de saúde adicional
     * do paciente.
     * */ 
    public void visualizarInfoSaude(Paciente pacientes) {
        System.out.println("Informações médicas de " + pacientes.getNome() + ":");
        System.out.println(pacientes.getInfoAdd().toString());
    }

    
    /*
     * Sets e Gets
     * para todos 
     * atributos
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
    
    
    public String getCrm() {
        return crm;
    }
    
    
    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    
    public String getEspecialidade() {
        return especialidade;
    }
    
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    /*
     * Retorna uma representacao em formato de String
     * de todos os atributos do objeto Doutor.
     * 
     */
    
    @Override
    public String toString() {
        return "Doutor{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", contato=" + contato +
                '}';
    }
}