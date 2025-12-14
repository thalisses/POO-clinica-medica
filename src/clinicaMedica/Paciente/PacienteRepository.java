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
    
    // Use the persistence-unit name declared in src/META-INF/persistence.xml
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-medicaPU");

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
        if (cpf == null) return null;
        String onlyDigits = cpf.replaceAll("\\D", "");
        String formatted = null;
        if (onlyDigits.length() == 11) {
            formatted = onlyDigits.substring(0, 3) + "." +
                        onlyDigits.substring(3, 6) + "." +
                        onlyDigits.substring(6, 9) + "-" +
                        onlyDigits.substring(9, 11);
        }

        // Try multiple forms to be tolerant with existing DB values (digits-only, formatted, original)
        try {
            TypedQuery<Paciente> query = em.createQuery(
                "SELECT p FROM Paciente p WHERE p.cpf = :cpf", Paciente.class);

            // 1) try digits-only
            query.setParameter("cpf", onlyDigits);
            try { return query.getSingleResult(); } catch (NoResultException ignore) {}

            // 2) try formatted (xxx.xxx.xxx-xx)
            if (formatted != null) {
                query.setParameter("cpf", formatted);
                try { return query.getSingleResult(); } catch (NoResultException ignore) {}
            }

            // 3) try raw input (maybe user saved with spaces or other chars)
            query.setParameter("cpf", cpf);
            try { return query.getSingleResult(); } catch (NoResultException ignore) {}

            return null;
        } catch (IllegalArgumentException ex) {
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
        // Normaliza para apenas dígitos (sem pontos/hífens)
        String onlyDigits = cpf.replaceAll("\\D", "");
        return onlyDigits;
    }
}
