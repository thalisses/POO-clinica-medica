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
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String celular;
    @Column(length = 30, nullable = false)
    private String email;

    public Contato(){}
    
    //contrutor da classe Contato
    public Contato(String celular, String email) {
        this.celular = celular;
        this.email = email;
    }
    
    /*
     * Sets e Gets
     * para os atributos
     * da classe.
     */
    
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
                "celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
