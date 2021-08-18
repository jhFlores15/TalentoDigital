package com.johfloresm.dojooverflow.repositories;

import com.johfloresm.dojooverflow.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

    List<Answer> findAllByQuestionId(Long id);
}
