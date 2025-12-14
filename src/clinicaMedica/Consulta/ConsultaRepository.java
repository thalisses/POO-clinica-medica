/*
 * Repositório simples para operações CRUD de Consulta.
 */
package clinicaMedica.Consulta;

import javax.persistence.*;
import java.util.List;

/**
 * Implementação de repositório para consultas, usando JPA.
 */
public class ConsultaRepository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("clinica-medicaPU");

    public ConsultaRepository() {}

    public void adicionarConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void atualizarConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void removerConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            consulta = em.merge(consulta);
            em.remove(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Consulta> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Consulta> query = em.createQuery("SELECT c FROM Consulta c", Consulta.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    // Backwards-compatible naming used in older code
    public List<Consulta> listarConsultas() {
        return listarTodas();
    }

    public List<Consulta> listarPorPaciente(Long pacienteId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Consulta> query = em.createQuery(
                    "SELECT c FROM Consulta c WHERE c.pacientes.id = :id", Consulta.class);
            query.setParameter("id", pacienteId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
