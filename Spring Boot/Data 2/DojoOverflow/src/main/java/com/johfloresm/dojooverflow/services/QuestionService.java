package com.johfloresm.dojooverflow.services;

import com.johfloresm.dojooverflow.models.Question;
import com.johfloresm.dojooverflow.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id){
        return questionRepository.findQuestionById(id);
    }

    @Transactional
    public Question createQuestion(Question q){
        return questionRepository.save(q);
    }
}
