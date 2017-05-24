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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
@Entity
@Table(name = "test")
public class Test implements Serializable {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    @Column(name = "timeLimit")
    private Integer timeLimit;
    
    @Column(name = "seeResult")
    private Short seeResult;
    
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private List<UserHasTest> userHasTestList;
    
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private List<Question> questionList;

    public Test() {
    }

    public Test(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Short getSeeResult() {
        return seeResult;
    }

    public void setSeeResult(Short seeResult) {
        this.seeResult = seeResult;
    }

    @XmlTransient
    public List<UserHasTest> getUserHasTestList() {
        return userHasTestList;
    }

    public void setUserHasTestList(List<UserHasTest> userHasTestList) {
        this.userHasTestList = userHasTestList;
    }

    
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
    
}
