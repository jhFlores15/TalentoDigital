package com.johfloresm.waterbnb.repositories;

import com.johfloresm.waterbnb.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long>{

    List<Rating> findAllByPoolId(Long id);
}
