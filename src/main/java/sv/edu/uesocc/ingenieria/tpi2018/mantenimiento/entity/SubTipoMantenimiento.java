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
//@Table(name = "sub_tipo_mantenimiento", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubTipoMantenimiento.findAll", query = "SELECT s FROM SubTipoMantenimiento s")
    , @NamedQuery(name = "SubTipoMantenimiento.findByIdSubTipoMantenimiento", query = "SELECT s FROM SubTipoMantenimiento s WHERE s.idSubTipoMantenimiento = :idSubTipoMantenimiento")
    , @NamedQuery(name = "SubTipoMantenimiento.findByNombre", query = "SELECT s FROM SubTipoMantenimiento s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SubTipoMantenimiento.findByDescripcion", query = "SELECT s FROM SubTipoMantenimiento s WHERE s.descripcion = :descripcion")})
public class SubTipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_tipo_mantenimiento")
    private Integer idSubTipoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idSubTipoMantenimiento")
    private List<TipoMantenimiento> tipoMantenimientoList;

    public SubTipoMantenimiento() {
    }

    public SubTipoMantenimiento(Integer idSubTipoMantenimiento) {
        this.idSubTipoMantenimiento = idSubTipoMantenimiento;
    }

    public SubTipoMantenimiento(Integer idSubTipoMantenimiento, String nombre) {
        this.idSubTipoMantenimiento = idSubTipoMantenimiento;
        this.nombre = nombre;
    }

    public Integer getIdSubTipoMantenimiento() {
        return idSubTipoMantenimiento;
    }

    public void setIdSubTipoMantenimiento(Integer idSubTipoMantenimiento) {
        this.idSubTipoMantenimiento = idSubTipoMantenimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TipoMantenimiento> getTipoMantenimientoList() {
        return tipoMantenimientoList;
    }

    public void setTipoMantenimientoList(List<TipoMantenimiento> tipoMantenimientoList) {
        this.tipoMantenimientoList = tipoMantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubTipoMantenimiento != null ? idSubTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubTipoMantenimiento)) {
            return false;
        }
        SubTipoMantenimiento other = (SubTipoMantenimiento) object;
        if ((this.idSubTipoMantenimiento == null && other.idSubTipoMantenimiento != null) || (this.idSubTipoMantenimiento != null && !this.idSubTipoMantenimiento.equals(other.idSubTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.SubTipoMantenimiento[ idSubTipoMantenimiento=" + idSubTipoMantenimiento + " ]";
    }
    
}
