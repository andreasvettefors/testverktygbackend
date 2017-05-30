/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupptre.testverktygbackend.services;

import com.grupptre.testverktygbackend.models.Answer;
import com.grupptre.testverktygbackend.models.Question;
import com.grupptre.testverktygbackend.models.Test;
import com.grupptre.testverktygbackend.models.Testresult;
import com.grupptre.testverktygbackend.repository.TestRepository;
import java.util.List;

/**
 *
 * @author hampus
 */
public class TestService {

    TestRepository tr = new TestRepository();

    public Test addTest(Test test) {
        return tr.addTest(test);
    }

    public Question addQuestion(int questionId, Question question) {
        return tr.addQuestion(questionId, question);
    }

    public Answer addAnswer(int questionId, Answer answer) {
        return tr.addAnswer(questionId, answer);
    }

    public Test getTest(int testId) {
        return tr.getTest(testId);
    }

    public List<Testresult> getResultFromTest(int userId, int testId) {
        return tr.getResultFromTest(userId, testId);
    }

}
