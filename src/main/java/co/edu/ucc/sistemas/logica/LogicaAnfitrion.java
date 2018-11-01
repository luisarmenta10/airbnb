package co.edu.ucc.sistemas.logica;

import co.edu.ucc.sistemas.modelo.Anfitrion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juvinao
 */
@Stateless
public class LogicaAnfitrion {

    @PersistenceContext(unitName = "airbnbPU")
    private EntityManager em;

    public void guardar(Anfitrion a) throws Exception {
        em.persist(a);
    }

    public void actualizar(Anfitrion a) throws Exception {
        Anfitrion aTemp = em.find(Anfitrion.class, a.getId());
        aTemp.setNombre(a.getNombre());
        aTemp.setNombre(a.getTipodocumento());
        aTemp.setNombre(a.getTelefono());
        em.merge(aTemp);
    }

    public List<Anfitrion> consultar() {
        return em.createQuery("Select a from Anfitrion a")
                .getResultList();
    }

    public void eliminar(Long id) throws Exception {
        Anfitrion aTemp = em.find(Anfitrion.class, id);
        em.remove(aTemp);
    }

    public Anfitrion consultaxId(Long id) {
        return em.find(Anfitrion.class, id);
    }
}
