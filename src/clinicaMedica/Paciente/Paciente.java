/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Paciente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Table;

/**
 * Classe que representa um paciente da clínica médica,
 * contendo informações pessoais, de contato, endereço e convênio.
 */

@Entity
@Table(name= "tb_paciente")
public class Paciente {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Nome completo do paciente */
    @Column(nullable = false)
    private String nome;
    
    /** CPF do paciente, armazenado sem formatação (apenas dígitos) */
    @Column(nullable = false, unique = true)
    private String cpf;
    
    /** Data de nascimento no formato dd/mm/yyyy */
    @Column(nullable = false)
    private String dataNascimento;
    
    /** Endereço do paciente */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    /** Contato do paciente (telefone e e-mail) */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato contato;
    
    /** Tipo de convênio médico (particular ou plano de saúde) */
    @Enumerated(EnumType.STRING) 
    @Column(length = 35)
    private tiposConvenios convenio;
    
    
    @Column(nullable = false)
    private String plano;
    
    /** Informações adicionais de saúde do paciente */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoAdd_id")
    private InfoAdd informacoesAdicionais;
 
    /**
     * Tipos de convênios aceitos pela clínica.
     */
    public enum tiposConvenios { PARTICULARES, PLANO_DE_SAUDE; }

    
    /**
     * Construtor padrão (vazio).
     */
    public Paciente() { }
    
    /**
     * Construtor que inicializa um paciente com todos os atributos.
     * @param nome nome completo
     * @param cpf número do CPF
     * @param dataNascimento data de nascimento no formato ddMMyyyy
     * @param endereco endereço do paciente
     * @param contato informações de contato
     * @param convenio tipo de convênio
     * @param informacoesAdicionais informações adicionais de saúde
     */
    public Paciente(String nome, String cpf, String dataNascimento, Endereco endereco, Contato contato, tiposConvenios convenio, InfoAdd informacoesAdicionais, String plano ) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.endereco = endereco;
        this.contato = contato;
        this.convenio = convenio;
        setInfoAdd(informacoesAdicionais);
        setPlano(plano);
    }

    // Backwards-compatible constructor used by some test/console code
    public Paciente(String nome, String cpf, String dataNascimento, Endereco endereco, Contato contato, String plano, InfoAdd informacoesAdicionais) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.endereco = endereco;
        this.contato = contato;
        this.convenio = null;
        setInfoAdd(informacoesAdicionais);
        setPlano(plano);
    }
    
    public Long getId(){ 
        return id;
    }

    /** @return CPF do paciente */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF formatado no padrão xxx.xxx.xxx-xx.
     * Exibe mensagens se o CPF for inválido.
     * @param cpf CPF a ser formatado
     */
    public void setCpf(String cpf) {
        if (cpf == null) {
            this.cpf = null;
            return;
        }
        // Armazena apenas os dígitos do CPF (ex: 01234567890)
        String onlyDigits = cpf.replaceAll("\\D", "");
        this.cpf = onlyDigits;
    }

    /** @return nome do paciente */
    public String getNome() {
        return nome;
    }

    /** @param nome nome do paciente */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return data de nascimento formatada */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento formatada (dd/mm/yyyy).
     * @param dataNascimento data no formato ddMMyyyy
     */
    public void setDataNascimento(String dataNascimento) {
        String nascimentoFormatado = converterNascimento(dataNascimento);
        if (nascimentoFormatado != null) { 
            this.dataNascimento = nascimentoFormatado; 
        } else {
            this.dataNascimento = null;
            System.out.println("Nascimento inválido, impossível atribuir!");
        }
    }

    /** @return endereço do paciente */
    public Endereco getEndereco() {
        return endereco;
    }

    /** @param endereco endereço do paciente */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Define o número de celular formatado (xx) xxxxx-xxxx.
     * @param numeroCelular número de telefone com DDD
     */
    public void setNumeroCelular(String numeroCelular) {
        String numeroFormatado = converterTelefone(numeroCelular);
        if (numeroFormatado != null) {
            this.contato.setCelular(numeroFormatado);
        } else {
            this.contato.setCelular(null);
            System.out.println("Telefone inválido, impossível atribuir.");
        }
    }

    /** @return tipo de convênio */
    public tiposConvenios getConvenio() {
        return convenio;
    }

    /** @param convenio tipo de convênio */
    public void setConvenio(tiposConvenios convenio) {
        this.convenio = convenio;
    }
    
    public String getPlano(){
        return plano;
    }
    
    public void setPlano(String plano){
        this.plano = plano;
    }
    

    /** @param informacoesAdicionais informações adicionais de saúde */
    public void setInfoAdd(InfoAdd informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    /** @return informações de contato */
    public Contato getContato() {
        return contato;
    }

    /** @param contato informações de contato */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /** @return informações adicionais de saúde */
    public InfoAdd getInfoAdd() {
        return informacoesAdicionais;
    }

    /**
     * Converte número de telefone para o formato (xx) xxxxx-xxxx.
     * @param telefone número de telefone
     * @return telefone formatado ou null se inválido
     */
    public String converterTelefone(String telefone) {
        if (telefone.length() != 11) {
            return null;
        }
        return "(" + telefone.substring(0, 2) + ")" +
               " " + telefone.substring(2, 7) + "-" + 
               telefone.substring(7, 11);
    }

    /**
     * Converte data de nascimento para o formato dd/mm/yyyy.
     * @param nascimento data no formato ddMMyyyy
     * @return data formatada ou null se inválida
     */
    public String converterNascimento(String nascimento) {
        if (nascimento == null) return null;
        // Aceita formatos com ou sem separadores, ex: "ddMMyyyy" ou "dd/MM/yyyy"
        String onlyDigits = nascimento.replaceAll("\\D", "");
        if (onlyDigits.length() != 8) return null;
        return onlyDigits.substring(0, 2) + "/" +
               onlyDigits.substring(2, 4) + "/" +
               onlyDigits.substring(4, 8);
    }

    /**
     * Converte CPF para o formato xxx.xxx.xxx-xx.
     * @param cpfInicial CPF numérico (sem pontuação)
     * @return CPF formatado ou null se inválido
     */
    public String converterCpf(String cpfInicial) {
        if (cpfInicial == null) return null;
        String onlyDigits = cpfInicial.replaceAll("\\D", "");
        if (!onlyDigits.matches("\\d{11}")) {
            return null;
        }
        return onlyDigits.substring(0, 3) + "." +
               onlyDigits.substring(3, 6) + "." +
               onlyDigits.substring(6, 9) + "-" +
               onlyDigits.substring(9, 11);
    }

    /**
     * Retorna uma representação textual de todas as informações do paciente.
     * @return string formatada com os dados do paciente
     */
    @Override
public String toString() {
    return nome;
}
}
