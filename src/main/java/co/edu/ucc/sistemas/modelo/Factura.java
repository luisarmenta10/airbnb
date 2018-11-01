/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.sistemas.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author FIDO
 */
@Entity
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Cliente> cliente;
    @OneToMany
    private List<Anfitrion> anfitrion;
    private Long precioalquiler;
    @OneToMany
    private List<Propiedades> propiedades;

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Anfitrion> getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(List<Anfitrion> anfitrion) {
        this.anfitrion = anfitrion;
    }

    public Long getPrecioalquiler() {
        return precioalquiler;
    }

    public void setPrecioalquiler(Long precioalquiler) {
        this.precioalquiler = precioalquiler;
    }

    public List<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
