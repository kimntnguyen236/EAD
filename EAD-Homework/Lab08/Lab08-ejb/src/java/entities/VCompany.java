/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
 * @author ThienKim
 */
@Cacheable(true)
@Entity
@Table(name = "vCompany")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VCompany.findAll", query = "SELECT v FROM VCompany v"),
    @NamedQuery(name = "VCompany.findByStaffid", query = "SELECT v FROM VCompany v WHERE v.staffid = :staffid"),
    @NamedQuery(name = "VCompany.findByStaffpassword", query = "SELECT v FROM VCompany v WHERE v.staffpassword = :staffpassword"),
    @NamedQuery(name = "VCompany.findByStaffname", query = "SELECT v FROM VCompany v WHERE v.staffname = :staffname"),
    @NamedQuery(name = "VCompany.findByStaffemail", query = "SELECT v FROM VCompany v WHERE v.staffemail = :staffemail"),
    @NamedQuery(name = "VCompany.findBySalary", query = "SELECT v FROM VCompany v WHERE v.salary = :salary"),
    @NamedQuery(name = "VCompany.findByRole", query = "SELECT v FROM VCompany v WHERE v.role = :role"),
    @NamedQuery(name = "VCompany.findByDepartmentid", query = "SELECT v FROM VCompany v WHERE v.departmentid = :departmentid"),
    @NamedQuery(name = "VCompany.findByDepartmentname", query = "SELECT v FROM VCompany v WHERE v.departmentname = :departmentname")})
public class VCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "staffid")
    @Id
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
    @Column(name = "departmentid")
    private Integer departmentid;
    @Size(max = 50)
    @Column(name = "departmentname")
    private String departmentname;

    public VCompany() {
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
    
}
