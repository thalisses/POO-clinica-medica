/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Mensagem;

/**
 * Classe que implementa o envio de mensagens por SMS.
 */
public class SMS implements Mensagem {

    @Override
    public void enviar(String conteudo) {
        System.out.println("Enviando SMS: " + conteudo);
    }
}