/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;
  
    @Column(name = "eMail")
    private String eMail;
 
    @Column(name = "password")
    private String password;
    
    @Column(name = "authorization")
    private Integer authorization;
    
    @ManyToMany(mappedBy = "userList",cascade = CascadeType.ALL)
    private List<Course> courseList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonBackReference
    private List<UserHasTest> userHasTestList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Studentanswer> studentanswerList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Integer authorization) {
        this.authorization = authorization;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<UserHasTest> getUserHasTestList() {
        return userHasTestList;
    }

    public void setUserHasTestList(List<UserHasTest> userHasTestList) {
        this.userHasTestList = userHasTestList;
    }

    @XmlTransient
    public List<Studentanswer> getStudentanswerList() {
        return studentanswerList;
    }

    public void setStudentanswerList(List<Studentanswer> studentanswerList) {
        this.studentanswerList = studentanswerList;
    }
    
}
