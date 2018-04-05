/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.entity;

import java.io.Serializable;

/**
 *
 * @author jcpleitez
 */
public class Orden implements Serializable{

    private Integer id;
    private String mesa;
    private String mesero;
    private String cliente;
    private Double total;

    public Orden() {
    }

    public Orden(Integer id, String mesa, String mesero, String cliente, Double total) {
        this.id = id;
        this.mesa = mesa;
        this.mesero = mesero;
        this.cliente = cliente;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }
    
    public String getIdText() {
        return id+"";
    }
    
    public String getIdString() {
        return id+"";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orden other = (Orden) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    

}
