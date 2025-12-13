/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Paciente;

/**
 *
 * @author User
 */

import javax.persistence.*;

@Entity 
@Table(name = "tb_contato")
public class Contato {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(length = 25)
    private String telefone;
    
    @Column(length = 25)
    private String celular;
    
    @Column(length = 100)
    private String email;

    public Contato(){}
    
    //contrutor da classe Contato
    public Contato(String telefone, String celular, String email) {
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }
    
    /*
     * Sets e Gets
     * para os atributos
     * da classe.
     */
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Metodo que retorna em formato String
	 * todos os atributos do objeto Contato
     */
    @Override
    public String toString() {
        return "Contato{" +
                "telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
