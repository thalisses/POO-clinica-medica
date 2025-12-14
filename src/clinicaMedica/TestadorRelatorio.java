/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

import clinicaMedica.Medico.Receita;
import clinicaMedica.Medico.Doutor;
import clinicaMedica.Consulta.ConsultaRepository;
import clinicaMedica.Consulta.Consulta;
import clinicaMedica.Paciente.InfoAdd;
import clinicaMedica.Paciente.Endereco;
import clinicaMedica.Paciente.Contato;
import clinicaMedica.Paciente.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe responsável por testar a geração de relatórios mensais de consultas.
 * Cria dados fictícios de médicos, pacientes e consultas para verificar
 * o funcionamento correto do método de geração de relatórios.
 */
public class TestadorRelatorio {

    /**
     * Método principal que executa os testes de geração de relatórios de consultas.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        System.out.println("Iniciando teste de geração de relatório...");

        // ===================================================
        // 1. CRIAR DADOS FALSOS
        // ===================================================

        Contato contato1 = new Contato("44993233043", "43994320245", "Dr.House@gmail.com");
        Contato contato2 = new Contato("44993562469", "439945367845", "Dr.Grey@gmail.com");
        Doutor drHouse = new Doutor("Dr. House", "22222222222", "crm32442", "Pediatra", contato1);
        Doutor drGrey = new Doutor("Dr. Grey", "44444444444", "crm34362", "Neuro", contato2);

        Endereco endereco1 = new Endereco("rua das acacias", "456", "Liberdade", "Sao paulo", "Sao Paulo", "84323221");
        Contato contato3 = new Contato("44993552449", "439945367845", "PacienteQualquer@gmail.com");
        InfoAdd informacao = new InfoAdd(true, false, true, true, false, "bariatrica", "amendoin", "nao possui");

        Paciente pacienteUm = new Paciente("Maria", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteDois = new Paciente("Carlos", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteTres = new Paciente("Pedro", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteQuatro = new Paciente("Ivone", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);

        ConsultaRepository repositorioConsultas = new ConsultaRepository();

        // ===================================================
        // 2. COLOCAR CONSULTAS NO REPOSITORIO
        // ===================================================

        Consulta c1 = new Consulta(
            LocalDate.of(2025, 10, 5),
            LocalTime.of(9, 0),
            drHouse,
            pacienteUm,
            Consulta.TipoConsulta.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c1);

        Consulta c2 = new Consulta(
            LocalDate.of(2025, 10, 20),
            LocalTime.of(11, 30),
            drHouse,
            pacienteDois,
            Consulta.TipoConsulta.RETORNO
        );
        repositorioConsultas.adicionarConsulta(c2);

        Consulta c3 = new Consulta(
            LocalDate.of(2025, 11, 1),
            LocalTime.of(10, 0),
            drHouse,
            pacienteTres,
            Consulta.TipoConsulta.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c3);

        Consulta c4 = new Consulta(
            LocalDate.of(2024, 10, 5),
            LocalTime.of(14, 0),
            drHouse,
            pacienteUm,
            Consulta.TipoConsulta.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c4);

        Consulta c5 = new Consulta(
            LocalDate.of(2025, 10, 15),
            LocalTime.of(16, 0),
            drGrey,
            pacienteQuatro,
            Consulta.TipoConsulta.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c5);

        // ===================================================
        // 3. EXECUTAR OS TESTES
        // ===================================================

        System.out.println("\n--- TESTE 1: Relatório (Dr. House, 10/2025) ---");
        String relatorio1 = Receita.RelatorioMensal(drHouse, 10, 2025, repositorioConsultas);
        System.out.println(relatorio1);

        System.out.println("\n--- TESTE 2: Relatório (Dr. Grey, 10/2025) ---");
        String relatorio2 = Receita.RelatorioMensal(drGrey, 10, 2025, repositorioConsultas);
        System.out.println(relatorio2);

        System.out.println("\n--- TESTE 3: Relatório Vazio (Dr. House, 12/2025) ---");
        String relatorio3 = Receita.RelatorioMensal(drHouse, 12, 2025, repositorioConsultas);
        System.out.println(relatorio3);
    }
}
