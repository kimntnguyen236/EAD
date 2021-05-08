/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TâmHoàngMinh
 */
@Entity
@Table(name = "Tabledithi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabledithi.findAll", query = "SELECT t FROM Tabledithi t"),
    @NamedQuery(name = "Tabledithi.findByTablecollum1", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum1 = :tablecollum1"),
    @NamedQuery(name = "Tabledithi.findByTablecollum2", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum2 = :tablecollum2"),
    @NamedQuery(name = "Tabledithi.findByTablecollum3", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum3 = :tablecollum3"),
    @NamedQuery(name = "Tabledithi.findByTablecollum4", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum4 = :tablecollum4"),
    @NamedQuery(name = "Tabledithi.findByTablecollum5", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum5 = :tablecollum5"),
    @NamedQuery(name = "Tabledithi.findByTablecollum6", query = "SELECT t FROM Tabledithi t WHERE t.tablecollum6 = :tablecollum6")})
public class Tabledithi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tablecollum1")
    private String tablecollum1;
    @Size(max = 50)
    @Column(name = "tablecollum2")
    private String tablecollum2;
    @Size(max = 50)
    @Column(name = "tablecollum3")
    private String tablecollum3;
    @Size(max = 50)
    @Column(name = "tablecollum4")
    private String tablecollum4;
    @Column(name = "tablecollum5")
    private Integer tablecollum5;
    @Column(name = "tablecollum6")
    private Integer tablecollum6;

    public Tabledithi() {
    }

    public Tabledithi(String tablecollum1) {
        this.tablecollum1 = tablecollum1;
    }

    public String getTablecollum1() {
        return tablecollum1;
    }

    public void setTablecollum1(String tablecollum1) {
        this.tablecollum1 = tablecollum1;
    }

    public String getTablecollum2() {
        return tablecollum2;
    }

    public void setTablecollum2(String tablecollum2) {
        this.tablecollum2 = tablecollum2;
    }

    public String getTablecollum3() {
        return tablecollum3;
    }

    public void setTablecollum3(String tablecollum3) {
        this.tablecollum3 = tablecollum3;
    }

    public String getTablecollum4() {
        return tablecollum4;
    }

    public void setTablecollum4(String tablecollum4) {
        this.tablecollum4 = tablecollum4;
    }

    public Integer getTablecollum5() {
        return tablecollum5;
    }

    public void setTablecollum5(Integer tablecollum5) {
        this.tablecollum5 = tablecollum5;
    }

    public Integer getTablecollum6() {
        return tablecollum6;
    }

    public void setTablecollum6(Integer tablecollum6) {
        this.tablecollum6 = tablecollum6;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablecollum1 != null ? tablecollum1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabledithi)) {
            return false;
        }
        Tabledithi other = (Tabledithi) object;
        if ((this.tablecollum1 == null && other.tablecollum1 != null) || (this.tablecollum1 != null && !this.tablecollum1.equals(other.tablecollum1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tabledithi[ tablecollum1=" + tablecollum1 + " ]";
    }
    
}
