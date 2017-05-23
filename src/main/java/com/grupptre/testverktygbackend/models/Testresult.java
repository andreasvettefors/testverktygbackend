/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andreas Vettefors (contact@vettefors.se)
 */
@Entity
@Table(name = "testresult")
public class Testresult implements Serializable {

    @NotNull
    @Column(name = "user_id")
    @Id
    private int userId;
 
    @NotNull
    @Column(name = "test_id")
    private int testId;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;
    
    @Column(name = "isCorrect")
    private Short isCorrect;

    public Testresult() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Short getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Short isCorrect) {
        this.isCorrect = isCorrect;
    }
    
}
