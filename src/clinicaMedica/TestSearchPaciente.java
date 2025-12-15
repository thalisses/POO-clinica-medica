package clinicaMedica;

import clinicaMedica.Paciente.Paciente;
import clinicaMedica.Paciente.PacienteRepository;

public class TestSearchPaciente {
    public static void main(String[] args) {
        try {
            PacienteRepository repo = PacienteRepository.getInstancia();

            String[] queries = {"12345678909", "123.456.789-09", "123 456 789 09", "12345678909"};
            for (String q : queries) {
                System.out.println("Procurando por: '" + q + "'");
                Paciente p = repo.buscarPorCpf(q);
                if (p != null) {
                    System.out.println("Encontrado: " + p.getNome() + " (CPF armazenado: '" + p.getCpf() + "')");
                } else {
                    System.out.println("Nenhum paciente encontrado para '" + q + "'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
