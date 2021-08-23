package com.johfloresm.waterbnb.services;

import com.johfloresm.waterbnb.models.Rating;
import com.johfloresm.waterbnb.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService{
    @Autowired
    RatingRepository ratingRepository;

    public List<Rating> getRatingsByPoolId(Long id){
        return ratingRepository.findAllByPoolId(id);
    }

    public Rating saveRating(Rating r){
        return ratingRepository.save(r);
    }
}
