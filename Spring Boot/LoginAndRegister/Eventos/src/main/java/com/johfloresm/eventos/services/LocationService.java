package com.johfloresm.eventos.services;

import com.johfloresm.eventos.models.Location;
import com.johfloresm.eventos.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService{
    @Autowired
    LocationRepository locationRepository;

    public List<Location> getLocationsByStateId(Long id){
        return locationRepository.getLocationByStateId(id);
    }
}
