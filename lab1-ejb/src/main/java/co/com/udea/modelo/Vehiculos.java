/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.udea.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juane
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByPlaca", query = "SELECT v FROM Vehiculos v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculos.findByAnioFabricacion", query = "SELECT v FROM Vehiculos v WHERE v.anioFabricacion = :anioFabricacion"),
    @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculos.findByCapacidadPasajeros", query = "SELECT v FROM Vehiculos v WHERE v.capacidadPasajeros = :capacidadPasajeros")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_fabricacion")
    @Temporal(TemporalType.DATE)
    private Date anioFabricacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "capacidad_pasajeros")
    private String capacidadPasajeros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placa")
    private Collection<Conductores> conductoresCollection;

    public Vehiculos() {
    }

    public Vehiculos(String placa) {
        this.placa = placa;
    }

    public Vehiculos(String placa, String modelo, String marca, Date anioFabricacion, String color, String capacidadPasajeros) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
        this.color = color;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Date anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(String capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @XmlTransient
    public Collection<Conductores> getConductoresCollection() {
        return conductoresCollection;
    }

    public void setConductoresCollection(Collection<Conductores> conductoresCollection) {
        this.conductoresCollection = conductoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.udea.Vehiculos[ placa=" + placa + " ]";
    }
    
}
