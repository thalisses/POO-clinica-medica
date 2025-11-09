/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.time.LocalDateTime;

public class TestadorRelatorio {

    

	public static void main(String[] args) {
        
        System.out.println("Iniciando teste de geração de relatório...");

        // ===================================================
        // 1. CRIAR DADOS FALSOS 
        // ===================================================

        // Criar Doutores
        Contato contato1 = new Contato("44993233043", "43994320245", "Dr.House@gmail.com");
        Contato contato2 = new Contato("44993562469", "439945367845", "Dr.Grey@gmail.com");
        Doutor drHouse = new Doutor("Dr. House", "22222222222", "crm32442", "Pediatra", contato1);
        Doutor drGrey = new Doutor("Dr. Grey", "44444444444", "crm34362", "Neuro", contato2);

       
        // Criar endereço Generico
        Endereco endereco1 = new Endereco("rua das acacias", "456", "Liberdade", "Sao paulo", "Sao Paulo", "84323221");
    		
        // Criar Contato Generco
        Contato contato3 = new Contato("44993552449", "439945367845", "PacienteQualquer@gmail.com");
        
        // Criar Informacoes adicionais Genericas
        InfoAdd informacao = new InfoAdd(true, false, true, true, false, "bariatrica", "amendoin", "nao possui");
 
        // Criar Pacientes
        Paciente pacienteUm = new Paciente("Maria", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteDois = new Paciente("Carlos", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteTres = new Paciente("Pedro", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);
        Paciente pacienteQuatro = new Paciente("ivone", "11111111111", "12111970", endereco1, contato3, "Prever", informacao);

        // Criar Repositório
        ConsultaRepository repositorioConsultas = new ConsultaRepository();

        // ===================================================
        // 2. COLOCAR CONSULTAS NO REPOSITORIO
        // ===================================================
        
        // Vamos gerar um relatório para o Dr. House em Outubro de 2025.

        // ---- Cenários que DEVEM APARECER no relatório ----
        
        // Consulta 1: Dr. House, Out/2025
        Consulta c1 = new Consulta(
            LocalDateTime.of(2025, 10, 5, 9, 0),  // data
            LocalDateTime.of(2025, 10, 5, 9, 0),  // horario (só para preencher)
            drHouse, 
            pacienteUm, 
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c1);

        // Consulta 2: Dr. House, Out/2025
        Consulta c2 = new Consulta(
            LocalDateTime.of(2025, 10, 20, 11, 30), // data
            LocalDateTime.of(2025, 10, 20, 11, 30), // horario
            drHouse, 
            pacienteDois, 
            Consulta.typo.RETORNO
        );
        repositorioConsultas.adicionarConsulta(c2);

        // ---- Cenários que NÃO DEVEM APARECER no relatório ----
        
        // Consulta 3: Dr. House, mas em Novembro (Mês Errado)
        Consulta c3 = new Consulta(
            LocalDateTime.of(2025, 11, 1, 10, 0), // data
            LocalDateTime.of(2025, 11, 1, 10, 0), // horario
            drHouse, 
            pacienteTres, 
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c3);

        // Consulta 4: Dr. House, Outubro, mas de 2024 (Ano Errado)
        Consulta c4 = new Consulta(
            LocalDateTime.of(2024, 10, 5, 14, 0), // data
            LocalDateTime.of(2024, 10, 5, 14, 0), // horario
            drHouse, 
            pacienteUm, 
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c4);

        // Consulta 5: Outubro de 2025, mas com a Dr. Grey (Médico Errado)
        Consulta c5 = new Consulta(
            LocalDateTime.of(2025, 10, 15, 16, 0), // data
            LocalDateTime.of(2025, 10, 15, 16, 0), // horario
            drGrey, // <-- Médico diferente
            pacienteQuatro, 
            Consulta.typo.NORMAL
        );
        repositorioConsultas.adicionarConsulta(c5);


        // ===================================================
        // 3. EXECUTAR OS TESTES
        // ===================================================

        // ---- TESTE 1: Relatório Dr. House (Outubro/2025) ----
        // (Deve mostrar Paciente Um e Paciente Dois)
        System.out.println("\n--- TESTE 1: Relatório (Dr. House, 10/2025) ---");
        
        String relatorio1 = Receita.RelatorioMensal(
            drHouse,   // Médico
            10,        // Mês
            2025,      // Ano
            repositorioConsultas
        );
        
        System.out.println(relatorio1);


        // ---- TESTE 2: Relatório Dr. Grey (Outubro/2025) ----
        // (Deve mostrar Paciente Quatro)
        System.out.println("\n--- TESTE 2: Relatório (Dr. Grey, 10/2025) ---");
        
        String relatorio2 = Receita.RelatorioMensal(
            drGrey,    // Médico
            10,        // Mês
            2025,      // Ano
            repositorioConsultas
        );
        
        System.out.println(relatorio2);


        // ---- TESTE 3: Relatório Vazio (Dezembro/2025) ----
        // (Deve mostrar "Nenhum paciente atendido")
        System.out.println("\n--- TESTE 3: Relatório Vazio (Dr. House, 12/2025) ---");
        
        String relatorio3 = Receita.RelatorioMensal(
            drHouse,   // Médico
            12,        // Mês
            2025,      // Ano
            repositorioConsultas
        );
        
        System.out.println(relatorio3);
    }
}
