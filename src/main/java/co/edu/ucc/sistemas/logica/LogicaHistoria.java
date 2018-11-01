/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.sistemas.logica;

import co.edu.ucc.sistemas.modelo.Historia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FIDO
 */
@Stateless
public class LogicaHistoria {

    @PersistenceContext(unitName = "airbnbPU")
    private EntityManager em;

    public void guardar(Historia h) throws Exception {
        em.persist(h);
    }

    public void actualizar(Historia h) throws Exception {
        Historia hTemp = em.find(Historia.class, h.getId());
        hTemp.setClientes(h.getClientes());
        hTemp.setPropiedades(h.getPropiedades());
        em.merge(hTemp);
    }

    public List<Historia> consultar() {
        return em.createQuery("Select h from Historia h")
                .getResultList();
    }

    public Historia consultaxId(Long id) {
        return em.find(Historia.class, id);
    }
}
