/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Consulta;

import javax.persistence.*;
import java.util.List;

public class ConsultaService {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ConsultorioPU");

    public void cadastrar(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        consulta = em.merge(consulta);
        em.remove(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public List<Consulta> listarTodas() {
        EntityManager em = emf.createEntityManager();
        List<Consulta> lista =
            em.createQuery("SELECT c FROM Consulta c", Consulta.class)
              .getResultList();
        em.close();
        return lista;
    }

    public List<Consulta> listarPorPaciente(Long pacienteId) {
        EntityManager em = emf.createEntityManager();
        List<Consulta> lista =
            em.createQuery("SELECT c FROM Consulta c WHERE c.pacientes.id = :id", Consulta.class)
              .setParameter("id", pacienteId)
              .getResultList();
        em.close();
        return lista;
    }
}

