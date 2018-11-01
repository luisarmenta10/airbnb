package co.edu.ucc.sistemas.logica;


import co.edu.ucc.sistemas.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juvinao
 */
@Stateless
public class LogicaFactura {

    @PersistenceContext(unitName = "airbnbPU")
    private EntityManager em;

    public void guardar(Factura f) throws Exception {
        em.persist(f);
    }

    public void actualizar(Factura f) throws Exception {
        Factura fTemp = em.find(Factura.class, f.getId());
        fTemp.setAnfitrion(f.getAnfitrion());
        fTemp.setCliente(f.getCliente());
        fTemp.setPrecioalquiler(f.getPrecioalquiler());
        fTemp.setPropiedades(f.getPropiedades());
        em.merge(fTemp);
    }

    public List<Factura> consultar() {
        return em.createQuery("Select f from Factura f")
                .getResultList();
    }

    public Factura consultaxId(Long id) {
        return em.find(Factura.class, id);
    }
}
