package clinicaMedica.Model.Prontuario;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioRepository {
    private static ProntuarioRepository instancia;
    private List<Prontuario> listaProntuarios;

    private ProntuarioRepository() {
        listaProntuarios = new ArrayList<>();
        // Adicionando um prontuario de teste
        Prontuario teste = new Prontuario();
        teste.setCpfPaciente("123");
        teste.setSintomas("Dor de cabeça");
        teste.setDiagnostico("Enxaqueca");
        teste.setPrescricao("Dipirona");
        listaProntuarios.add(teste);
    }

    public static ProntuarioRepository getInstancia() {
        if (instancia == null) {
            instancia = new ProntuarioRepository();
        }
        return instancia;
    }

    public Prontuario buscarPorCpf(String cpf) {
        for (Prontuario p : listaProntuarios) {
            if (p.getCpfPaciente().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public void atualizar(Prontuario pNovo) {
        Prontuario existente = buscarPorCpf(pNovo.getCpfPaciente());
        if (existente != null) {
            existente.setSintomas(pNovo.getSintomas());
            existente.setDiagnostico(pNovo.getDiagnostico());
            existente.setPrescricao(pNovo.getPrescricao());
        } else {
            // Se não existir, cadastra (opcional)
            listaProntuarios.add(pNovo);
        }
    }
}