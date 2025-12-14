package clinicaMedica;

import clinicaMedica.Paciente.PacienteRepository;
import clinicaMedica.Paciente.Paciente;
import java.util.List;

/**
 * Test helper: tries to create a Paciente with a birth date in dd/MM/yyyy
 * format (as the UI provides) and then lists patients to confirm persistence.
 */
public class TestCreatePaciente {
    public static void main(String[] args) {
        try {
            PacienteRepository repo = PacienteRepository.getInstancia();

            Paciente p = new Paciente();
            p.setNome("Teste Persist");
            p.setCpf("123.456.789-09");
            p.setDataNascimento("01/02/1990");
            p.setPlano("PARTICULAR");

            repo.adicionarPaciente(p);

            List<Paciente> lista = repo.listarPacientes();
            System.out.println("Total de pacientes: " + lista.size());
            for (Paciente px : lista) {
                System.out.println("---");
                System.out.println("ID: " + px.getId());
                System.out.println("Nome: " + px.getNome());
                System.out.println("CPF (raw stored): '" + px.getCpf() + "'");
                System.out.println("Nascimento: '" + px.getDataNascimento() + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
