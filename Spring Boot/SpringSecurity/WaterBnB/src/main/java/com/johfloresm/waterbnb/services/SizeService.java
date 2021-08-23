package com.johfloresm.waterbnb.services;

import com.johfloresm.waterbnb.models.Size;
import com.johfloresm.waterbnb.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService{
    @Autowired
    SizeRepository sizeRepository;

    public List<Size> getSizes(){
        return sizeRepository.findAll();
    }
}
