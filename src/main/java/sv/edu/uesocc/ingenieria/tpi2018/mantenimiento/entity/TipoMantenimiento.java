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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipo_mantenimiento", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t")
    , @NamedQuery(name = "TipoMantenimiento.findByIdTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.idTipoMantenimiento = :idTipoMantenimiento")
    , @NamedQuery(name = "TipoMantenimiento.findByNombre", query = "SELECT t FROM TipoMantenimiento t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoMantenimiento.findByDescipcion", query = "SELECT t FROM TipoMantenimiento t WHERE t.descipcion = :descipcion")
    , @NamedQuery(name = "TipoMantenimiento.findByActivo", query = "SELECT t FROM TipoMantenimiento t WHERE t.activo = :activo")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_mantenimiento")
    private Integer idTipoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descipcion")
    private String descipcion;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "idTipoMantenimiento")
    private List<OrdenTrabajo> ordenTrabajoList;
    @JoinColumn(name = "id_sub_tipo_mantenimiento", referencedColumnName = "id_sub_tipo_mantenimiento")
    @ManyToOne
    private SubTipoMantenimiento idSubTipoMantenimiento;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public TipoMantenimiento(Integer idTipoMantenimiento, String nombre) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.nombre = nombre;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    public SubTipoMantenimiento getIdSubTipoMantenimiento() {
        return idSubTipoMantenimiento;
    }

    public void setIdSubTipoMantenimiento(SubTipoMantenimiento idSubTipoMantenimiento) {
        this.idSubTipoMantenimiento = idSubTipoMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMantenimiento != null ? idTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.idTipoMantenimiento == null && other.idTipoMantenimiento != null) || (this.idTipoMantenimiento != null && !this.idTipoMantenimiento.equals(other.idTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoMantenimiento[ idTipoMantenimiento=" + idTipoMantenimiento + " ]";
    }
    
}
