package com.johfloresm.dojooverflow.repositories;

import com.johfloresm.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{

    Tag findFirstBySubject(String subject);

}
