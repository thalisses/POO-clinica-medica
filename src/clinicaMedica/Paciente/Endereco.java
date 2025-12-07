/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Paciente;

/**
 * Classe que representa o endereço de um paciente,
 * contendo informações como rua, número, bairro, cidade, estado e CEP.
 */

import javax.persistence.*;

@Entity 
@Table(name = "tb_endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    /** Nome da rua do endereço */
    @Column(nullable = false, length = 100)
    private String rua;
    
    /** Número do endereço */
    @Column(length = 10)
    private String numero;
    
    /** Bairro do endereço */
    @Column(length = 100)
    private String bairro;
    
    /** Cidade do endereço */
    @Column(nullable = false, length = 100)
    private String cidade;
    
    /** Estado do endereço */
    @Column(length = 50)
    private String estado;
    
    /** CEP do endereço */
    @Column(length = 15)
    private String cep;

    /**
     * Construtor padrão da classe Endereco.
     */
    public Endereco() {
    }
    
    /**
     * Construtor que inicializa todos os campos do endereço.
     * @param rua nome da rua
     * @param numero número da residência
     * @param bairro nome do bairro
     * @param cidade nome da cidade
     * @param estado nome do estado
     * @param cep código postal (CEP)
     */
    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    /** @return nome da rua */
    public String getRua() {
        return rua;
    }

    /** @param rua define o nome da rua */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /** @return número da residência */
    public String getNumero() {
        return numero;
    }

    /** @param numero define o número da residência */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /** @return nome do bairro */
    public String getBairro() {
        return bairro;
    }

    /** @param bairro define o nome do bairro */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /** @return nome da cidade */
    public String getCidade() {
        return cidade;
    }

    /** @param cidade define o nome da cidade */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /** @return nome do estado */
    public String getEstado() {
        return estado;
    }

    /** @param estado define o nome do estado */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** @return CEP do endereço */
    public String getCep() {
        return cep;
    }

    /** @param cep define o CEP do endereço */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna uma representação em texto com todos os dados do endereço.
     * @return string formatada com as informações do endereço
     */
    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
