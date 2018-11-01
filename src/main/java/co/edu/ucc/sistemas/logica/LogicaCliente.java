package co.edu.ucc.sistemas.logica;

import co.edu.ucc.sistemas.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juvinao
 */
@Stateless
public class LogicaCliente {

    @PersistenceContext(unitName = "airbnbPU")
    private EntityManager em;

    public void guardar(Cliente c) throws Exception {
        em.persist(c);
    }

    public void actualizar(Cliente c) throws Exception {
        Cliente cTemp = em.find(Cliente.class, c.getId());
        cTemp.setNombre(c.getNombre());
        cTemp.setNombre(c.getTelefono());
        cTemp.setNombre(c.getTipodocumento());
        cTemp.setNombre(c.getDireccion());
        em.merge(cTemp);
    }

    public List<Cliente> consultar() {
        return em.createQuery("Select c from Cliente c")
                .getResultList();
    }

    public void eliminar(Long id) throws Exception {
        Cliente cTemp = em.find(Cliente.class, id);
        em.remove(cTemp);
    }

    public Cliente consultaxId(Long id) {
        return em.find(Cliente.class, id);
    }
}
