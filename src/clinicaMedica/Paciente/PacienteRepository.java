/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Paciente;

import javax.persistence.*;
import java.util.List;

/**
 * Classe responsável por armazenar e gerenciar os pacientes do sistema.
 */
public class PacienteRepository {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioPU");

    /** Instância única da classe (padrão Singleton) */
    private static PacienteRepository instancia;

    /**
     * Retorna a instância única do repositório.
     * @return instância de PacienteRepository
     */
    public static PacienteRepository getInstancia() {
        if (instancia == null) {
            instancia = new PacienteRepository();
        }
        return instancia;
    }

    /**
     * Construtor Vazio.
     */
    public PacienteRepository() {}

    /**
     * Adiciona um novo paciente à lista.
     * @param paciente paciente a ser adicionado
     */
    public void adicionarPaciente(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{em.close();}
    }

    /**
     * Atualiza as informações de um paciente existente.
     * @param paciente paciente atualizado
     */
    public void atualizarPaciente(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{ em.close();}
    }

    /**
     * Remove um paciente do repositório pelo CPF.
     * @param cpf CPF do paciente a ser removido
     */
    public void removerPaciente(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            
            Paciente p = buscarPorCpfInternal(em, cpf);
            
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p); 
                em.getTransaction().commit();
                System.out.println("Paciente removido com sucesso.");
            } else {
                System.out.println("Paciente não encontrado para remoção.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Retorna uma lista com todos os pacientes cadastrados.
     * @return lista de pacientes
     */
    public List<Paciente> listarPacientes() {
        EntityManager em = emf.createEntityManager();
        try {

            TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
            return query.getResultList(); 
        } finally {
            em.close();
        }
    }

    /**
     * Busca um paciente pelo CPF.
     * @param cpf CPF do paciente
     * @return paciente encontrado ou null se não existir
     */
    public Paciente buscarPorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            return buscarPorCpfInternal(em, cpf);
        }finally{em.close();}
    }
    
    private Paciente buscarPorCpfInternal(EntityManager em, String cpf) {
        String cpfFormatado = formatarCpf(cpf);
        try {
            
            TypedQuery<Paciente> query = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.cpf = :cpf", Paciente.class);
            query.setParameter("cpf", cpfFormatado);
            
            return query.getSingleResult(); 
        } catch (NoResultException e) {
            return null; 
        }
    }

    /**
     * Formata um CPF para o padrão xxx.xxx.xxx-xx.
     * @param cpf CPF a ser formatado
     * @return CPF formatado
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
}
