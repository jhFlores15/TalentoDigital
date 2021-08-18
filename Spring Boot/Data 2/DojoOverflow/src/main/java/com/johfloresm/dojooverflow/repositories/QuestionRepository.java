package com.johfloresm.dojooverflow.repositories;

import com.johfloresm.dojooverflow.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

    List<Question> findAll();

    Question findQuestionById(Long id);
}
