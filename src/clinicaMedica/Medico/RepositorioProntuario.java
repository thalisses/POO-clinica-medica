/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Medico;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Classe responsável por armazenar, gerenciar e manipular os prontuários médicos
 * utilizando JPA para persistência em banco de dados.
 * Implementa o padrão Singleton para garantir uma única instância do repositório.
 */
public class RepositorioProntuario {

    /** Factory para criação de EntityManagers conectados ao banco de dados. */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioPU");

    /** Instância única do repositório (padrão Singleton). */
    private static RepositorioProntuario instancia;

    /**
     * Retorna a instância única do repositório de prontuários.
     *
     * @return instância única do {@code RepositorioProntuario}
     */
    public static RepositorioProntuario getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioProntuario();
        }
        return instancia;
    }

    /**
     * Construtor privado para evitar instanciação direta.
     * Utilize o método getInstancia() para obter a instância única.
     */
    public RepositorioProntuario() {
    }

    /**
     * Cadastra um novo prontuário no banco de dados.
     *
     * @param prontuario objeto {@code Prontuario} a ser cadastrado
     */
    public void cadastraProntuario(Prontuario prontuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prontuario);
            em.getTransaction().commit();
            System.out.println("Prontuário cadastrado para o paciente " 
                               + prontuario.getPaciente().getNome());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Remove um prontuário com base no CPF do paciente.
     *
     * @param cpf CPF do paciente cujo prontuário será removido
     */
    public void removeProntuario(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            String jpql = "DELETE FROM Prontuario p WHERE p.paciente.cpf = :cpf";
            int deletados = em.createQuery(jpql)
                    .setParameter("cpf", cpf)
                    .executeUpdate();
            em.getTransaction().commit();
            
            if (deletados > 0)
                System.out.println("Prontuário(s) do paciente removido(s)!");
            else
                System.out.println("Prontuário não encontrado para o CPF informado.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Atualiza os dados do prontuário mais recente de um paciente.
     * Busca o prontuário pela data de atendimento mais recente.
     *
     * @param cpf CPF do paciente (será formatado automaticamente)
     * @param sintomas novos sintomas (ou null/vazio para não alterar)
     * @param diagnosticos novo diagnóstico (ou null/vazio para não alterar)
     * @param prescricao nova prescrição de tratamento (ou null/vazio para não alterar)
     */
    public void atualizaProntuario(String cpf, String sintomas, String diagnosticos, String prescricao) {
        EntityManager em = emf.createEntityManager();
        try {
            // Formata o CPF
            String cpfFormatado = formatarCpf(cpf);
            
            // Busca o prontuário mais recente do paciente
            TypedQuery<Prontuario> query = em.createQuery(
                "SELECT p FROM Prontuario p WHERE p.paciente.cpf = :cpf ORDER BY p.dataAtendimento DESC", 
                Prontuario.class);
            query.setParameter("cpf", cpfFormatado);
            query.setMaxResults(1);
            
            List<Prontuario> resultados = query.getResultList();
            
            if (resultados.isEmpty()) {
                System.out.println("ERRO: Prontuário não encontrado para o CPF informado!");
                return;
            }
            
            Prontuario prontuarioAntigo = resultados.get(0);
            boolean mudancas = false;

            em.getTransaction().begin();
            
            if (sintomas != null && !sintomas.isEmpty()) {
                prontuarioAntigo.setSintomas(sintomas);
                System.out.println("Sintomas atualizados.");
                mudancas = true;
            } else System.out.println("Sintomas não atualizados.");

            if (diagnosticos != null && !diagnosticos.isEmpty()) {
                prontuarioAntigo.setDiagnostico(diagnosticos);
                System.out.println("Diagnóstico atualizado.");
                mudancas = true;
            } else System.out.println("Diagnóstico não atualizado.");

            if (prescricao != null && !prescricao.isEmpty()) {
                prontuarioAntigo.setPrescricaoTratamento(prescricao);
                System.out.println("Prescrição atualizada.");
                mudancas = true;
            } else System.out.println("Prescrição não atualizada.");

            if (mudancas) {
                em.merge(prontuarioAntigo);
                em.getTransaction().commit();
                System.out.println("Prontuário do CPF " + cpf + " atualizado!");
            } else {
                em.getTransaction().rollback();
                System.out.println("AVISO: Nenhuma alteração feita.");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Busca o prontuário mais recente de um paciente pelo CPF.
     * Retorna apenas o último prontuário cadastrado, ordenado por data de atendimento.
     *
     * @param cpf CPF do paciente (será formatado automaticamente)
     * @return o prontuário mais recente encontrado ou {@code null} se não existir
     */
    public Prontuario buscarPorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            String cpfFormatado = formatarCpf(cpf);
            TypedQuery<Prontuario> query = em.createQuery(
                "SELECT p FROM Prontuario p WHERE p.paciente.cpf = :cpf ORDER BY p.dataAtendimento DESC", 
                Prontuario.class);
            query.setParameter("cpf", cpfFormatado);
            query.setMaxResults(1);
            
            List<Prontuario> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Lista todos os prontuários de um paciente específico, ordenados por data.
     * Os prontuários são retornados do mais recente para o mais antigo.
     *
     * @param paciente objeto Paciente com CPF preenchido
     * @return lista de prontuários do paciente (vazia se não houver prontuários)
     */
    public List<Prontuario> listarPorPaciente(clinicaMedica.Paciente.Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Prontuario> query = em.createQuery(
                "SELECT p FROM Prontuario p WHERE p.paciente.cpf = :cpf ORDER BY p.dataAtendimento DESC", 
                Prontuario.class);
            query.setParameter("cpf", paciente.getCpf());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    /**
     * Retorna todos os prontuários cadastrados no sistema.
     * Os prontuários são ordenados por data de atendimento (mais recentes primeiro).
     *
     * @return lista completa de prontuários (vazia se não houver prontuários cadastrados)
     */
    public List<Prontuario> getListaProntuario() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Prontuario> query = em.createQuery(
                "SELECT p FROM Prontuario p ORDER BY p.dataAtendimento DESC", 
                Prontuario.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }
    
    /**
     * Formata um CPF para o padrão xxx.xxx.xxx-xx.
     * Remove caracteres não numéricos e adiciona pontos e hífen.
     * 
     * @param cpf CPF a ser formatado (apenas números ou com formatação)
     * @return CPF formatado no padrão xxx.xxx.xxx-xx, ou o CPF original se inválido
     */
    private String formatarCpf(String cpf) {
        if (cpf == null) return null;
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return cpf;
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9, 11);
    }

    /**
     * Retorna uma representação textual dos prontuários cadastrados.
     *
     * @return texto com todos os prontuários registrados
     */
    @Override
    public String toString() {
        return "-------------------------\n"
             + "Exibindo histórico de Prontuários...\n"
             + getListaProntuario() + "\n";
    }
}
