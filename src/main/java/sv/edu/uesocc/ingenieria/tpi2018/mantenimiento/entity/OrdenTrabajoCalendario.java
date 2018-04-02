/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rcarlos
 */
@Entity
//@Table(name = "orden_trabajo_calendario", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoCalendario.findAll", query = "SELECT o FROM OrdenTrabajoCalendario o")
    , @NamedQuery(name = "OrdenTrabajoCalendario.findByIdOrdenTrabajoCalendario", query = "SELECT o FROM OrdenTrabajoCalendario o WHERE o.idOrdenTrabajoCalendario = :idOrdenTrabajoCalendario")})
public class OrdenTrabajoCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo_calendario")
    private Integer idOrdenTrabajoCalendario;
    @JoinColumn(name = "id_fecha", referencedColumnName = "id_fecha")
    @ManyToOne
    private Calendario idFecha;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo")
    @ManyToOne
    private OrdenTrabajo idOrdenTrabajo;

    public OrdenTrabajoCalendario() {
    }

    public OrdenTrabajoCalendario(Integer idOrdenTrabajoCalendario) {
        this.idOrdenTrabajoCalendario = idOrdenTrabajoCalendario;
    }

    public Integer getIdOrdenTrabajoCalendario() {
        return idOrdenTrabajoCalendario;
    }

    public void setIdOrdenTrabajoCalendario(Integer idOrdenTrabajoCalendario) {
        this.idOrdenTrabajoCalendario = idOrdenTrabajoCalendario;
    }

    public Calendario getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Calendario idFecha) {
        this.idFecha = idFecha;
    }

    public OrdenTrabajo getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(OrdenTrabajo idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajoCalendario != null ? idOrdenTrabajoCalendario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoCalendario)) {
            return false;
        }
        OrdenTrabajoCalendario other = (OrdenTrabajoCalendario) object;
        if ((this.idOrdenTrabajoCalendario == null && other.idOrdenTrabajoCalendario != null) || (this.idOrdenTrabajoCalendario != null && !this.idOrdenTrabajoCalendario.equals(other.idOrdenTrabajoCalendario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.OrdenTrabajoCalendario[ idOrdenTrabajoCalendario=" + idOrdenTrabajoCalendario + " ]";
    }
    
}
