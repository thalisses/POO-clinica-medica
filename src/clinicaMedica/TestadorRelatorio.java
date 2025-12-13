/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

import clinicaMedica.Model.Medico.Receita;
import clinicaMedica.Model.Medico.Doutor;
import clinicaMedica.Model.Consulta.ConsultaRepository;
import clinicaMedica.Model.Consulta.Consulta;
import clinicaMedica.Model.Paciente.InfoAdd;
import clinicaMedica.Model.Paciente.Endereco;
import clinicaMedica.Model.Paciente.Contato;
import clinicaMedica.Model.Paciente.Paciente;
import java.time.LocalDateTime;

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
        Paciente.tiposConvenios enumConvenio = null;
        Paciente pacienteUm = new Paciente("Maria", "11111111111", "12111970", endereco1, contato3,enumConvenio, informacao, "Prever");
        Paciente pacienteDois = new Paciente("Carlos", "11111111111", "12111970", endereco1, contato3,enumConvenio.PARTICULARES, informacao, "Prever");
        Paciente pacienteTres = new Paciente("Pedro", "11111111111", "12111970", endereco1, contato3, enumConvenio.PARTICULARES, informacao, "Prever");
        Paciente pacienteQuatro = new Paciente("Ivone", "11111111111", "12111970", endereco1, contato3, enumConvenio.PARTICULARES,informacao, "Prever");

        ConsultaRepository repositorioConsultas = new ConsultaRepository();

        // ===================================================
        // 2. COLOCAR CONSULTAS NO REPOSITORIO
        // ===================================================

        Consulta c1 = new Consulta(
            LocalDateTime.of(2025, 10, 5, 9, 0),
            LocalDateTime.of(2025, 10, 5, 9, 0),
            drHouse,
            pacienteUm,
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c1);

        Consulta c2 = new Consulta(
            LocalDateTime.of(2025, 10, 20, 11, 30),
            LocalDateTime.of(2025, 10, 20, 11, 30),
            drHouse,
            pacienteDois,
            Consulta.typo.RETORNO
        );
        repositorioConsultas.adicionarConsulta(c2);

        Consulta c3 = new Consulta(
            LocalDateTime.of(2025, 11, 1, 10, 0),
            LocalDateTime.of(2025, 11, 1, 10, 0),
            drHouse,
            pacienteTres,
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c3);

        Consulta c4 = new Consulta(
            LocalDateTime.of(2024, 10, 5, 14, 0),
            LocalDateTime.of(2024, 10, 5, 14, 0),
            drHouse,
            pacienteUm,
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c4);

        Consulta c5 = new Consulta(
            LocalDateTime.of(2025, 10, 15, 16, 0),
            LocalDateTime.of(2025, 10, 15, 16, 0),
            drGrey,
            pacienteQuatro,
            Consulta.typo.NORMAL
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
