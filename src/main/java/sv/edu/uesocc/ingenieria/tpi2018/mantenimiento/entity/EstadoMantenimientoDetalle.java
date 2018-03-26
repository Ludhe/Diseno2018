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
@Table(name = "estado_mantenimiento_detalle", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoMantenimientoDetalle.findAll", query = "SELECT e FROM EstadoMantenimientoDetalle e")
    , @NamedQuery(name = "EstadoMantenimientoDetalle.findByIdEstadoMantenimientoDetalle", query = "SELECT e FROM EstadoMantenimientoDetalle e WHERE e.idEstadoMantenimientoDetalle = :idEstadoMantenimientoDetalle")
    , @NamedQuery(name = "EstadoMantenimientoDetalle.findByIdPaso", query = "SELECT e FROM EstadoMantenimientoDetalle e WHERE e.idPaso = :idPaso")})
public class EstadoMantenimientoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_mantenimiento_detalle")
    private Integer idEstadoMantenimientoDetalle;
    @Column(name = "id_paso")
    private Integer idPaso;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "id_mantenimiento_detalle", referencedColumnName = "id_mantenimiento_detalle")
    @ManyToOne
    private MantenimientoDetalle idMantenimientoDetalle;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
    @ManyToOne
    private Responsable idResponsable;

    public EstadoMantenimientoDetalle() {
    }

    public EstadoMantenimientoDetalle(Integer idEstadoMantenimientoDetalle) {
        this.idEstadoMantenimientoDetalle = idEstadoMantenimientoDetalle;
    }

    public Integer getIdEstadoMantenimientoDetalle() {
        return idEstadoMantenimientoDetalle;
    }

    public void setIdEstadoMantenimientoDetalle(Integer idEstadoMantenimientoDetalle) {
        this.idEstadoMantenimientoDetalle = idEstadoMantenimientoDetalle;
    }

    public Integer getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public MantenimientoDetalle getIdMantenimientoDetalle() {
        return idMantenimientoDetalle;
    }

    public void setIdMantenimientoDetalle(MantenimientoDetalle idMantenimientoDetalle) {
        this.idMantenimientoDetalle = idMantenimientoDetalle;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoMantenimientoDetalle != null ? idEstadoMantenimientoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMantenimientoDetalle)) {
            return false;
        }
        EstadoMantenimientoDetalle other = (EstadoMantenimientoDetalle) object;
        if ((this.idEstadoMantenimientoDetalle == null && other.idEstadoMantenimientoDetalle != null) || (this.idEstadoMantenimientoDetalle != null && !this.idEstadoMantenimientoDetalle.equals(other.idEstadoMantenimientoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.EstadoMantenimientoDetalle[ idEstadoMantenimientoDetalle=" + idEstadoMantenimientoDetalle + " ]";
    }
    
}
