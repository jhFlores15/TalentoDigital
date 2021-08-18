package com.johfloresm.dojooverflow.services;

import com.johfloresm.dojooverflow.models.Answer;
import com.johfloresm.dojooverflow.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    public Answer createAnswer(Answer a){
        return answerRepository.save(a);
    }
}
