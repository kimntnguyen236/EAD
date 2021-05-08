/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThienKim
 */
@Entity
@Table(name = "StaffTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffTB.findAll", query = "SELECT s FROM StaffTB s"),
    @NamedQuery(name = "StaffTB.findByStaffid", query = "SELECT s FROM StaffTB s WHERE s.staffid = :staffid"),
    @NamedQuery(name = "StaffTB.findByStaffpassword", query = "SELECT s FROM StaffTB s WHERE s.staffpassword = :staffpassword"),
    @NamedQuery(name = "StaffTB.findByStaffname", query = "SELECT s FROM StaffTB s WHERE s.staffname = :staffname"),
    @NamedQuery(name = "StaffTB.findByStaffemail", query = "SELECT s FROM StaffTB s WHERE s.staffemail = :staffemail"),
    @NamedQuery(name = "StaffTB.findBySalary", query = "SELECT s FROM StaffTB s WHERE s.salary = :salary"),
    @NamedQuery(name = "StaffTB.findByRole", query = "SELECT s FROM StaffTB s WHERE s.role = :role")})
public class StaffTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "staffid")
    private String staffid;
    @Size(max = 150)
    @Column(name = "staffpassword")
    private String staffpassword;
    @Size(max = 50)
    @Column(name = "staffname")
    private String staffname;
    @Size(max = 100)
    @Column(name = "staffemail")
    private String staffemail;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "role")
    private Boolean role;
    @JoinColumn(name = "departmentid", referencedColumnName = "departmentid")
    @ManyToOne
    private DepartmentTB departmentid;

    public StaffTB() {
    }

    public StaffTB(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffpassword() {
        return staffpassword;
    }

    public void setStaffpassword(String staffpassword) {
        this.staffpassword = staffpassword;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffemail() {
        return staffemail;
    }

    public void setStaffemail(String staffemail) {
        this.staffemail = staffemail;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public DepartmentTB getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(DepartmentTB departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffTB)) {
            return false;
        }
        StaffTB other = (StaffTB) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StaffTB[ staffid=" + staffid + " ]";
    }
    
}
