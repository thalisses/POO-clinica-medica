package clinicaMedica.Consulta;

import java.time.LocalDateTime;

/**
 * Classe abstrata que define o contrato para tipos de consulta.
 * Permite criar diferentes tipos de consulta com durações específicas.
 */
public abstract class TipoConsulta {
    
    /**
     * Retorna a duração da consulta em minutos.
     * Cada tipo concreto define sua própria duração.
     */
    public abstract int getDuracaoMinutos();
    
    /**
     * Retorna o nome do tipo de consulta.
     */
    public abstract String getNomeTipo();
    
    /**
     * Calcula o horário de término baseado no horário de início.
     */
    public LocalDateTime calcularTermino(LocalDateTime inicio) {
        return inicio.plusMinutes(getDuracaoMinutos());
    }
}
