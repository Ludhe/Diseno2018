/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rcarlos
 */
@Entity
//@Table(name = "equipo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdQuipo", query = "SELECT e FROM Equipo e WHERE e.idQuipo = :idQuipo")
    , @NamedQuery(name = "Equipo.findByCorrelativo", query = "SELECT e FROM Equipo e WHERE e.correlativo = :correlativo")
    , @NamedQuery(name = "Equipo.findByObservaciones", query = "SELECT e FROM Equipo e WHERE e.observaciones = :observaciones")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_quipo")
    private Integer idQuipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "correlativo")
    private String correlativo;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idEquipo")
    private List<OrdenTrabajo> ordenTrabajoList;
    @OneToMany(mappedBy = "idEquipo")
    private List<EquipoDetalle> equipoDetalleList;

    public Equipo() {
    }

    public Equipo(Integer idQuipo) {
        this.idQuipo = idQuipo;
    }

    public Equipo(Integer idQuipo, String correlativo) {
        this.idQuipo = idQuipo;
        this.correlativo = correlativo;
    }

    public Integer getIdQuipo() {
        return idQuipo;
    }

    public void setIdQuipo(Integer idQuipo) {
        this.idQuipo = idQuipo;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @XmlTransient
    public List<EquipoDetalle> getEquipoDetalleList() {
        return equipoDetalleList;
    }

    public void setEquipoDetalleList(List<EquipoDetalle> equipoDetalleList) {
        this.equipoDetalleList = equipoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuipo != null ? idQuipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idQuipo == null && other.idQuipo != null) || (this.idQuipo != null && !this.idQuipo.equals(other.idQuipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Equipo[ idQuipo=" + idQuipo + " ]";
    }
    
}
