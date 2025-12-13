package clinicaMedica.Model.Consulta;

/**
 * Consulta de retorno com duração de 30 minutos.
 */
public class ConsultaRetorno extends TipoConsulta {
    
    @Override
    public int getDuracaoMinutos() {
        return 30;
    }
    
    @Override
    public String getNomeTipo() {
        return "Consulta de Retorno";
    }
}
