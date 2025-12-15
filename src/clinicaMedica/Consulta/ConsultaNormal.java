package clinicaMedica.Consulta;

/**
 * Consulta normal com duração de 1 hora (60 minutos).
 */
public class ConsultaNormal extends TipoConsulta {
    
    @Override // usado para sobrescrever o método da classe mãe
    public int getDuracaoMinutos() {
        return 60;
    }
    
    @Override
    public String getNomeTipo() {
        return "Consulta Normal";
    }
}
