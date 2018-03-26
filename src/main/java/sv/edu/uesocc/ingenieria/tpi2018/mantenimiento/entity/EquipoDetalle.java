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
@Table(name = "equipo_detalle", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoDetalle.findAll", query = "SELECT e FROM EquipoDetalle e")
    , @NamedQuery(name = "EquipoDetalle.findByIdEquipoDetalle", query = "SELECT e FROM EquipoDetalle e WHERE e.idEquipoDetalle = :idEquipoDetalle")
    , @NamedQuery(name = "EquipoDetalle.findByIdParte", query = "SELECT e FROM EquipoDetalle e WHERE e.idParte = :idParte")})
public class EquipoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo_detalle")
    private Long idEquipoDetalle;
    @Column(name = "id_parte")
    private Integer idParte;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_quipo")
    @ManyToOne
    private Equipo idEquipo;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelo idModelo;

    public EquipoDetalle() {
    }

    public EquipoDetalle(Long idEquipoDetalle) {
        this.idEquipoDetalle = idEquipoDetalle;
    }

    public Long getIdEquipoDetalle() {
        return idEquipoDetalle;
    }

    public void setIdEquipoDetalle(Long idEquipoDetalle) {
        this.idEquipoDetalle = idEquipoDetalle;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoDetalle != null ? idEquipoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDetalle)) {
            return false;
        }
        EquipoDetalle other = (EquipoDetalle) object;
        if ((this.idEquipoDetalle == null && other.idEquipoDetalle != null) || (this.idEquipoDetalle != null && !this.idEquipoDetalle.equals(other.idEquipoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.EquipoDetalle[ idEquipoDetalle=" + idEquipoDetalle + " ]";
    }
    
}
