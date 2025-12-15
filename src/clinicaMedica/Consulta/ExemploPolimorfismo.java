package clinicaMedica.Consulta;

import clinicaMedica.Consulta.ConsultaRetorno;
import clinicaMedica.Consulta.ConsultaNormal;
import java.time.LocalDateTime;

/**
 * Exemplo demonstrando o uso de polimorfismo com tipos de consulta.
 */
public class ExemploPolimorfismo {
    
    public static void main(String[] args) {
        
        System.out.println("=== DEMONSTRAÇÃO DE POLIMORFISMO ===\n");
        
        // criando diferentes tipos de consulta
        TipoConsulta consultaNormal = new ConsultaNormal();
        TipoConsulta consultaRetorno = new ConsultaRetorno();
        
        // mesmo tipo de referência, comportamentos diferentes
        System.out.println("Consulta Normal: " + consultaNormal.getDuracaoMinutos() + " minutos");
        System.out.println("Consulta Retorno: " + consultaRetorno.getDuracaoMinutos() + " minutos");
        
        // testando cálculo de término
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("\nHorário início: " + agora);
        System.out.println("Término Normal: " + consultaNormal.calcularTermino(agora));
        System.out.println("Término Retorno: " + consultaRetorno.calcularTermino(agora));
        
        System.out.println("\n✓ Polimorfismo aplicado com sucesso!");
    }
}
