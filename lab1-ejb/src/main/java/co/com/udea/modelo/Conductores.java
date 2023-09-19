/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juane
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductores.findAll", query = "SELECT c FROM Conductores c"),
    @NamedQuery(name = "Conductores.findByCedula", query = "SELECT c FROM Conductores c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Conductores.findByNombre", query = "SELECT c FROM Conductores c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Conductores.findByFechaNacimiento", query = "SELECT c FROM Conductores c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Conductores.findByLicencia", query = "SELECT c FROM Conductores c WHERE c.licencia = :licencia")})
public class Conductores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "licencia")
    private String licencia;
    @JoinColumn(name = "placa", referencedColumnName = "placa")
    @ManyToOne(optional = false)
    private Vehiculos placa;

    public Conductores() {
    }

    public Conductores(Integer cedula) {
        this.cedula = cedula;
    }

    public Conductores(Integer cedula, String nombre, Date fechaNacimiento, String licencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.licencia = licencia;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Vehiculos getPlaca() {
        return placa;
    }

    public void setPlaca(Vehiculos placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductores)) {
            return false;
        }
        Conductores other = (Conductores) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.udea.Conductores[ cedula=" + cedula + " ]";
    }
    
}
