/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Main {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO TESTE AUTOMATIZADO DO SISTEMA DA CLÍNICA ---");

        // 1. SETUP: Criando os repositórios que vão guardar os dados em memória
        Map<String, Paciente> repositorioPacientes = new HashMap<>();
        RepositorioProntuario repositorioProntuario = new RepositorioProntuario();

        // 2. CENÁRIO 1: Instanciando um paciente COMPLETO (com informações adicionais)
        System.out.println("\n-> Cadastrando Paciente 1: Joca da Silva (com informações adicionais)...");
        InfoAdd infoJoca = new InfoAdd(true, false, true, false, false, "Apendicite em 2010", "Poeira", "Paciente ansioso");
        
        Paciente pacienteJoca = new Paciente(
            "Joca da Silva", "11122233301", "15051980", "Maringá", "44999998888", "Unimed", infoJoca);
        repositorioPacientes.put(pacienteJoca.getCpf(), pacienteJoca);
        
        // 3. CENÁRIO 2: Instanciando um paciente SIMPLES (sem informações adicionais)
        System.out.println("-> Cadastrando Paciente 2: Maria Oliveira (sem informações adicionais)...");
        Paciente pacienteMaria = new Paciente(
            "Maria Oliveira", "44455566602", "20111995", "Sarandi", "44988887777", "Particular", null
        );
        repositorioPacientes.put(pacienteMaria.getCpf(), pacienteMaria);

        // 4. CENÁRIO 3: Instanciando e cadastrando prontuários para o Paciente 1 (Joca)
        System.out.println("-> Adicionando 2 prontuários para Joca da Silva...");
        Prontuario prontuarioJoca1 = new Prontuario(
            "Tosse seca e febre", "Virose", "Repouso e hidratação por 3 dias"
        );
        Prontuario prontuarioJoca2 = new Prontuario(
            "Dor de cabeça persistente", "Enxaqueca", "Analgésico e evitar luz forte"
        );
        repositorioProntuario.cadastrarProntuario(pacienteJoca.getCpf(), prontuarioJoca1);
        repositorioProntuario.cadastrarProntuario(pacienteJoca.getCpf(), prontuarioJoca2);

        // 5. CENÁRIO 4: Instanciando e cadastrando um prontuário para o Paciente 2 (Maria)
        System.out.println("-> Adicionando 1 prontuário para Maria Oliveira...");
        Prontuario prontuarioMaria1 = new Prontuario(
            "Dor de garganta e dificuldade para engolir", "Amigdalite", "Antibiótico por 7 dias"
        );
        repositorioProntuario.cadastrarProntuario(pacienteMaria.getCpf(), prontuarioMaria1);
        
        System.out.println("\n--- FASE DE CADASTRO CONCLUÍDA. INICIANDO EXIBIÇÃO DOS DADOS. ---\n");
        
        // 6. EXIBIÇÃO: Chamando as funções para mostrar os resultados
        
        // Exibindo todos os pacientes cadastrados
        System.out.println("=================================================");
        System.out.println("  EXIBINDO TODOS OS PACIENTES CADASTRADOS");
        System.out.println("=================================================");
        if (repositorioPacientes.isEmpty()) {
            System.out.println("Nenhum paciente no repositório.");
        } else {
            for (Paciente p : repositorioPacientes.values()) {
                System.out.println(p); // Chama o toString() do Paciente
                System.out.println("-----");
            }
        }
        
        // Exibindo o histórico completo de um paciente específico (Joca)
        System.out.println("\n=================================================");
        System.out.println("  EXIBINDO HISTÓRICO DE PRONTUÁRIOS DE JOCA");
        System.out.println("=================================================");
        List<Prontuario> historicoJoca = repositorioProntuario.buscarProntuarios(pacienteJoca.getCpf());
        if (historicoJoca.isEmpty()) {
            System.out.println("Nenhum prontuário encontrado para Joca.");
        } else {
            for (Prontuario pront : historicoJoca) {
                System.out.println(pront); // Chama o toString() do Prontuario
            }
        }
        
        // Exibindo o histórico completo de outro paciente (Maria)
        System.out.println("\n=================================================");
        System.out.println("  EXIBINDO HISTÓRICO DE PRONTUÁRIOS DE MARIA");
        System.out.println("=================================================");
        List<Prontuario> historicoMaria = repositorioProntuario.buscarProntuarios(pacienteMaria.getCpf());
        if (historicoMaria.isEmpty()) {
            System.out.println("Nenhum prontuário encontrado para Maria.");
        } else {
            for (Prontuario pront : historicoMaria) {
                System.out.println(pront); // Chama o toString() do Prontuario
            }
        }

        System.out.println("\n--- TESTE FINALIZADO ---");
    }

    // A função FormataResposta não é necessária neste main de teste, 
    // mas pode ser mantida aqui sem problemas.
    public static boolean FormataResposta(String resposta) {
        if (resposta == null) return false;
        if (resposta.equalsIgnoreCase("sim")) return true;
        if (!resposta.equalsIgnoreCase("nao")) {
            System.out.println("Resposta invalida, atribuição automatica para NAO!");
        }
        return false;
    }
}