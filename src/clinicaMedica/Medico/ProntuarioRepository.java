package clinicaMedica.Medico;

import javax.persistence.*;
import java.util.List;

/**
 * Repositório JPA para Prontuário.
 */
public class ProntuarioRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-medicaPU");

    public ProntuarioRepository() {}

    public void cadastraProntuario(Prontuario prontuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prontuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally { em.close(); }
    }

    public void removeProntuario(String cpf) {
        EntityManager em = emf.createEntityManager();
        try {
            Prontuario p = buscarPorCpfInternal(em, cpf);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(em.contains(p) ? p : em.merge(p));
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally { em.close(); }
    }

    public void atualizaProntuario(String cpf, String sintomas, String diagnosticos, String prescricao) {
        EntityManager em = emf.createEntityManager();
        try {
            Prontuario p = buscarPorCpfInternal(em, cpf);
            if (p != null) {
                em.getTransaction().begin();
                boolean mudancas = false;
                if (sintomas != null && !sintomas.isEmpty()) { p.setSintomas(sintomas); mudancas = true; }
                if (diagnosticos != null && !diagnosticos.isEmpty()) { p.setDiagnostico(diagnosticos); mudancas = true; }
                if (prescricao != null && !prescricao.isEmpty()) { p.setPrescricaoTratamento(prescricao); mudancas = true; }
                if (mudancas) em.merge(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally { em.close(); }
    }

    public Prontuario buscarPorCpf(String cpf) {
        EntityManager em = emf.createEntityManager();
        try { return buscarPorCpfInternal(em, cpf); } finally { em.close(); }
    }

    private Prontuario buscarPorCpfInternal(EntityManager em, String cpf) {
        try {
            TypedQuery<Prontuario> q = em.createQuery("SELECT p FROM Prontuario p WHERE p.paciente.cpf = :cpf", Prontuario.class);
            q.setParameter("cpf", formatarCpf(cpf));
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Prontuario> listarProntuarios() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Prontuario> q = em.createQuery("SELECT p FROM Prontuario p", Prontuario.class);
            return q.getResultList();
        } finally { em.close(); }
    }

    private String formatarCpf(String cpf) {
        if (cpf == null) return null;
        String onlyDigits = cpf.replaceAll("\\D", "");
        if (onlyDigits.length() != 11) return cpf;
        return onlyDigits.substring(0, 3) + "." +
               onlyDigits.substring(3, 6) + "." +
               onlyDigits.substring(6, 9) + "-" +
               onlyDigits.substring(9, 11);
    }
}
