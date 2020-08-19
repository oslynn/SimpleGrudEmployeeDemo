package com.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author ottsa
 */
@Entity
@Table(name = "employee")
public class Employee extends AuditModel {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;

  @Basic(optional = false)
  @NotNull
  //@Size(min = 1, max = 250)
  @Column(name = "name")
  private String name;

  @Basic(optional = false)
  @NotNull
  //@Size(min = 1, max = 255)
  @Column(name = "email")
  private String email;

  @Column(name = "role")
  private String role;

  @Column(name = "department")
  private String department;

  @Column(name = "skill_sets")
  private String skillSets;

  @Column(name = "date_of_birth")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfBirth;

  @Column(name = "date_of_joining")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfJoining;

  @Column(name = "is_active")
  private String isActive;



  public Employee() {
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getSkillSets() {
    return skillSets;
  }

  public void setSkillSets(String skillSets) {
    this.skillSets = skillSets;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Date getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(Date dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public String getIsActive() {
    return isActive;
  }

  public void setIsActive(String isActive) {
    this.isActive = isActive;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Employee)) {
      return false;
    }
    Employee other = (Employee) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.employee.Employee[ id=" + id + " ]";
  }
  
}
