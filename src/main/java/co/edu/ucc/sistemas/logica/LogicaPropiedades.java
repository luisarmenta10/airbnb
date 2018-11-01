/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.sistemas.logica;

import co.edu.ucc.sistemas.modelo.Propiedades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FIDO
 */
@Stateless
public class LogicaPropiedades {

    @PersistenceContext(unitName = "airbnbPU")
    private EntityManager em;

    public void guardar(Propiedades p) throws Exception {
        em.persist(p);
    }

    public void actualizar(Propiedades p) throws Exception {
        Propiedades pTemp = em.find(Propiedades.class, p.getId());
        pTemp.setAnfitrion(p.getAnfitrion());
        pTemp.setCliente(p.getCliente());
        pTemp.setCantidadpersonas(p.getCantidadpersonas());
        pTemp.setDescripcion(p.getDescripcion());
        pTemp.setTipopropiedad(p.getTipopropiedad());
        pTemp.setUbicacion(p.getUbicacion());
        em.merge(pTemp);
    }

    public List<Propiedades> consultar() {
        return em.createQuery("Select p from Propiedades p")
                .getResultList();
    }

    public void eliminar(Long id) throws Exception {
        Propiedades pTemp = em.find(Propiedades.class, id);
        em.remove(pTemp);
    }

    public Propiedades consultaxId(Long id) {
        return em.find(Propiedades.class, id);
    }
}
