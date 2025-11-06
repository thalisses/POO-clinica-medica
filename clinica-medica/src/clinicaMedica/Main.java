/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author User
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Map<String, Paciente> repositorioPacientes = new HashMap<>();
        ArmazemHistoricoPaciente armazem = new ArmazemHistoricoPaciente();
        
        
        String valor = "";
        while (!valor.equalsIgnoreCase("6")) {
            System.out.println("------------------");
            System.out.println("Digite uma opçao: ");
            System.out.println("[1] Cadastrar paciente");
            System.out.println("[2] Cadastrar Prontuario Paciente");
            System.out.println("[3] exibir prontuarios de um paciente");
            System.out.println("[4] Remover prontuario de um paciente");
            System.out.println("[5] Atualizar prontuario de um paciente");
            System.out.println("[6] Sair");
            System.out.println("------------------");
            valor = entrada.nextLine();
            
            switch (valor) {
            
                case "1": {
                    System.out.println("Digite o nome: ");
                    String nome = entrada.nextLine();
                    System.out.println("digite o CPF (somente numeros)");
                    String cpf = entrada.nextLine();
                    System.out.println("Data de nascimento: (dd/mm/aaaa)");
                    String nascimento = entrada.nextLine();
                    System.out.println("Plano: ");
                    String plano = entrada.nextLine();
                    
                
                    // 1. Declaramos a variável de informações aqui, começando como nula.
                    InfoAdd informacoes = null; 

                    System.out.println("Paciente possui informaçoes adicionais? ");
                    System.out.println("Responda com [sim] ou [nao]");
                    String opcao = entrada.nextLine().toLowerCase();
                    
                    // 2. O switch agora tem a ÚNICA responsabilidade de preencher 'informacoes', se necessário.
                    switch (opcao) {
                        case "sim": {
                            System.out.println("paciente fuma ? [sim, nao] ");
                            boolean fuma = FormataResposta(entrada.nextLine());
                            System.out.println("Paciente bebe? [sim, nao]");
                            boolean bebe = FormataResposta(entrada.nextLine());
                            System.out.println("Paciente tem colesterol alto? [sim, nao] ");
                            boolean colesterol = FormataResposta(entrada.nextLine());
                            System.out.println("Paciente tem diabete ? [sim, nao] ");
                            boolean diabetes = FormataResposta(entrada.nextLine());
                            System.out.println("Possui doencas cardiacas? Se sim, quais? (Se não, deixe em branco)");
                            boolean doencaCardiaca = FormataResposta(entrada.nextLine());; // Ajustado para ser String
                            System.out.println("Possui cirurgias ? Se sim, quais?");
                            String cirurgias = entrada.nextLine();
                            System.out.println("Possui alergias ? Se sim, quais?");
                            String alergia = entrada.nextLine();
                            System.out.println("Observações adicionais? ");
                            String obsAdicionais = entrada.nextLine();
                            
                            // A variável 'informacoes' que foi declarada lá fora recebe o novo objeto.
                            informacoes = new InfoAdd(fuma, bebe, colesterol, diabetes, doencaCardiaca, cirurgias, alergia, obsAdicionais);
                            break;
                        }
                        case "nao": {
                            // Se a opção for "nao", não fazemos nada. A variável 'informacoes' continuará sendo 'null'.
                            break;
                        }
                        default:
                            System.out.println("Opção errada, informações adicionais não serão cadastradas.");
                            break;
                    }
                    
                    // 3. Criamos o Paciente UMA ÚNICA VEZ, aqui fora do switch.
                    // Ele receberá o objeto 'informacoes' preenchido ou o valor 'null', dependendo da escolha do usuário.
                    
                    
                    //SETANDO AUTOMATICO PARA TESTE
                    Endereco endereco = new Endereco("rua das acacias", "456", "Liberdade", "Sao paulo", "Sao Paulo", "84323221");
                    Contato contato = new Contato("44993552449", "439945367845", "PacienteQualquer@gmail.com");
                    //criando paciente
                    Paciente paciente = new Paciente(nome, cpf, nascimento, endereco, contato, plano, informacoes);
                    repositorioPacientes.put(cpf, paciente);

                    System.out.println("\n--- PACIENTE CADASTRADO ---");
                    System.out.println(paciente); // Imprime o resultado final
                    
                    break;
                }
                case "2":{
                		System.out.println("Digite o CPF do paciente: ");
                		String cpf = entrada.nextLine();
                		
                		if (!repositorioPacientes.containsKey(cpf)) {
                            System.out.println("Paciente com CPF " + cpf + ", não encontrado.");
                            break;
                        }
                		
                		System.out.println("Digite os sintomas: ");
                		String sintomas = entrada.nextLine();
                		System.out.println("Diagnosticos: ");
                		String diagnostico = entrada.nextLine();
                		System.out.println("Prescricao Tratamento: ");
                		String prescricao = entrada.nextLine();
                		
                		
          
                		RepositorioProntuario repositorio = armazem.getRepositorioPaciente(cpf);
                		Prontuario prontuario = new Prontuario(sintomas, diagnostico, prescricao);
                		repositorio.cadastraProntuario(prontuario);
                		
                		break;
       
                }
                case "3": {
                		System.out.println("Digite o cpf (apenas numero) ");
                		String cpf = entrada.nextLine();
                		System.out.println("Exibindo Prontuario...");
                		
                		if (!repositorioPacientes.containsKey(cpf)) {
                            System.out.println("Paciente com CPF: " + cpf + ", não encontrado.");
                            break;
                        }
                		System.out.println(armazem.buscaHistorico(cpf));
                		break;
                }
                case "4":{
	                	System.out.println("Digite o CPF do paciente (Apenas numeros) ");
	                	String cpf = entrada.nextLine();
	                	System.out.println(armazem.buscaHistorico(cpf));
	                	System.out.println("\nQual Prontuario deseja remover? (Digite o numero do 'ID')");
	                	String idString = entrada.nextLine();
	                	if (idString.equalsIgnoreCase("")) {
	                		System.out.println("ID invalido");
	                		break;
	                	}
	                	int id = Integer.parseInt(idString);
	                	armazem.getRepositorioPaciente(cpf).removeProntuario(id);
	                	System.out.println("Removendo...");
	                	System.out.println("Prontuario Removido. ");
	                	System.out.println(armazem.buscaHistorico(cpf));
	                	break;
                	
                }
                
                case "5":{
	                	System.out.println("Digite o CPF do paciente (Apenas numeros) ");
	                	String cpf = entrada.nextLine();
	                	System.out.println(armazem.buscaHistorico(cpf));
	                	System.out.println("\nQual Prontuario deseja atualizar? (Digite o numero do 'ID')");
	                	String idString = entrada.nextLine();
	                	if (idString.equalsIgnoreCase("")) {
	                		System.out.println("ID invalido");
	                		break;
	                	}
	                	int id = Integer.parseInt(idString);
	                	System.out.println("Digite o sintoma:  ([ENTER] para pular)");
	                	String sintomas = entrada.nextLine();
	                	System.out.println("Digite o Diagnostico ([ENTER] para pular)");
	                	String diagnostico = entrada.nextLine();
	                	System.out.println("Digite a Prescricao ([ENTER] para pular)");
	                	String prescricao = entrada.nextLine();
	                	armazem.getRepositorioPaciente(cpf).atualizaProntuario(id, sintomas, diagnostico, prescricao);
	                	System.out.println(armazem.buscaHistorico(cpf));                    
	                	break;

                }
                case "6": {
                		System.out.println("Saindo...");
                		
                }
                default: {
                     System.out.println("Opção inválida.");
                     break;
                }
            }
        }
        entrada.close();
    }
    
    // Sua função está boa, aqui uma pequena sugestão para deixá-la mais curta
    public static boolean FormataResposta(String resposta) {
        if (resposta == null) {
            return false;
        }
        
        if (resposta.equalsIgnoreCase("sim")) {
            return true;
        }

        if (!resposta.equalsIgnoreCase("nao")) {
            System.out.println("Resposta invalida, atribuição automatica para NAO!");
        }

        return false;
    }
}