/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author rcarlos
 */
@Entity
@Table(name = "calendario_excepcion", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioExcepcion.findAll", query = "SELECT c FROM CalendarioExcepcion c")
    , @NamedQuery(name = "CalendarioExcepcion.findByIdExcepcion", query = "SELECT c FROM CalendarioExcepcion c WHERE c.idExcepcion = :idExcepcion")
    , @NamedQuery(name = "CalendarioExcepcion.findByFecha", query = "SELECT c FROM CalendarioExcepcion c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CalendarioExcepcion.findByEstado", query = "SELECT c FROM CalendarioExcepcion c WHERE c.estado = :estado")
    , @NamedQuery(name = "CalendarioExcepcion.findByDescripcion", query = "SELECT c FROM CalendarioExcepcion c WHERE c.descripcion = :descripcion")})
public class CalendarioExcepcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_excepcion")
    private Integer idExcepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;

    public CalendarioExcepcion() {
    }

    public CalendarioExcepcion(Integer idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public CalendarioExcepcion(Integer idExcepcion, Date fecha) {
        this.idExcepcion = idExcepcion;
        this.fecha = fecha;
    }

    public Integer getIdExcepcion() {
        return idExcepcion;
    }

    public void setIdExcepcion(Integer idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExcepcion != null ? idExcepcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioExcepcion)) {
            return false;
        }
        CalendarioExcepcion other = (CalendarioExcepcion) object;
        if ((this.idExcepcion == null && other.idExcepcion != null) || (this.idExcepcion != null && !this.idExcepcion.equals(other.idExcepcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.CalendarioExcepcion[ idExcepcion=" + idExcepcion + " ]";
    }
    
}
