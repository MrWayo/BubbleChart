/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wayo Sapiens
 */
@Entity
@Table(name = "chart")
@NamedQueries({
    @NamedQuery(name = "Chart.findAll", query = "SELECT c FROM Chart c")
    , @NamedQuery(name = "Chart.findByIdchart", query = "SELECT c FROM Chart c WHERE c.idchart = :idchart")
    , @NamedQuery(name = "Chart.findByMes", query = "SELECT c FROM Chart c WHERE c.mes = :mes")
    , @NamedQuery(name = "Chart.findByIngresos", query = "SELECT c FROM Chart c WHERE c.ingresos = :ingresos")})
public class Chart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_chart")
    private Integer idchart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingresos")
    private int ingresos;

    public Chart() {
    }

    public Chart(Integer idchart) {
        this.idchart = idchart;
    }

    public Chart(Integer idchart, String mes, int ingresos) {
        this.idchart = idchart;
        this.mes = mes;
        this.ingresos = ingresos;
    }

    public Integer getIdchart() {
        return idchart;
    }

    public void setIdchart(Integer idchart) {
        this.idchart = idchart;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchart != null ? idchart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chart)) {
            return false;
        }
        Chart other = (Chart) object;
        if ((this.idchart == null && other.idchart != null) || (this.idchart != null && !this.idchart.equals(other.idchart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Chart[ idchart=" + idchart + " ]";
    }
    
}
