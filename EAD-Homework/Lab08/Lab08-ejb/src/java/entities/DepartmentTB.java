/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThienKim
 */
@Entity
@Table(name = "DepartmentTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentTB.findAll", query = "SELECT d FROM DepartmentTB d"),
    @NamedQuery(name = "DepartmentTB.findByDepartmentid", query = "SELECT d FROM DepartmentTB d WHERE d.departmentid = :departmentid"),
    @NamedQuery(name = "DepartmentTB.findByDepartmentname", query = "SELECT d FROM DepartmentTB d WHERE d.departmentname = :departmentname")})
public class DepartmentTB implements Serializable {

    @OneToMany(mappedBy = "departmentid")
    private List<StaffTB> staffTBList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departmentid")
    private Integer departmentid;
    @Size(max = 50)
    @Column(name = "departmentname")
    private String departmentname;

    public DepartmentTB() {
    }

    public DepartmentTB(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentid != null ? departmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentTB)) {
            return false;
        }
        DepartmentTB other = (DepartmentTB) object;
        if ((this.departmentid == null && other.departmentid != null) || (this.departmentid != null && !this.departmentid.equals(other.departmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DepartmentTB[ departmentid=" + departmentid + " ]";
    }

    @XmlTransient
    public List<StaffTB> getStaffTBList() {
        return staffTBList;
    }

    public void setStaffTBList(List<StaffTB> staffTBList) {
        this.staffTBList = staffTBList;
    }
    
}
