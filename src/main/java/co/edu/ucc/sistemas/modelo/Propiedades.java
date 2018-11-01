/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucc.sistemas.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author FIDO
 */
@Entity
public class Propiedades implements Serializable {

    @ManyToOne
    private Fotos fotos;

    

    @ManyToOne
    private Cliente cliente;

    

    @ManyToOne
    private Tipopropiedad tipopropiedad;

    @ManyToOne
    private Anfitrion anfitrion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Fotos getFotos() {
        return fotos;
    }

    public void setFotos(Fotos fotos) {
        this.fotos = fotos;
    }

    public Tipopropiedad getTipopropiedad() {
        return tipopropiedad;
    }

    public void setTipopropiedad(Tipopropiedad tipopropiedad) {
        this.tipopropiedad = tipopropiedad;
    }
    private String ubicacion;
    private Integer cantidadpersonas;
    private String Descripcion;

    public Anfitrion getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(Anfitrion anfitrion) {
        this.anfitrion = anfitrion; 
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(Integer cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
