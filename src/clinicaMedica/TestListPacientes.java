package clinicaMedica;

import clinicaMedica.Paciente.PacienteRepository;
import clinicaMedica.Paciente.Paciente;
import java.util.List;

/**
 * Small utility to list patients and show how CPF is stored in the DB.
 */
public class TestListPacientes {
    public static void main(String[] args) {
        try {
            PacienteRepository repo = PacienteRepository.getInstancia();
            List<Paciente> lista = repo.listarPacientes();
            System.out.println("Total de pacientes: " + lista.size());
            for (Paciente p : lista) {
                System.out.println("---");
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("CPF (raw stored): '" + p.getCpf() + "'");
                System.out.println("Nascimento: '" + p.getDataNascimento() + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
