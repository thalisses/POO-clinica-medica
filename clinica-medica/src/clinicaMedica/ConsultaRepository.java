/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {
	//lista de consultas
    private List<Consulta> consultas;
    
    // Metodo contrutor que inicia a lista de consultas
    public ConsultaRepository() {
        this.consultas = new ArrayList<>();
    }

    // Adiciona uma consulta
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    // Remove uma consulta
    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    // Retorna todas as consultas
    public List<Consulta> listarConsultas() {
        return consultas;
    }

    // Buscar consultas de um paciente pelo CPF
    public List<Consulta> buscarPorCpfPaciente(String cpf) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getPacientes().getCpf().equals(cpf)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
