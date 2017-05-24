/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
@Entity
@Table(name = "user_has_test")
public class UserHasTest implements Serializable {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;

    @Column(name = "grade")
    private String grade;

    @Column(name = "isDone")
    private Short isDone;

    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne
    private Course courseId;

    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @ManyToOne
    @JsonManagedReference
    private Test testId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JsonManagedReference
    private User userId;

    public UserHasTest() {
    }

    public UserHasTest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Short getIsDone() {
        return isDone;
    }

    public void setIsDone(Short isDone) {
        this.isDone = isDone;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Test getTestId() {
        return testId;
    }

    public void setTestId(Test testId) {
        this.testId = testId;
    }

    /*public User getUserId() {
        return userId;
    }*/

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
