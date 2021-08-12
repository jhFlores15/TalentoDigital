package com.johfloresm.licenciamanejo.services;

import com.johfloresm.licenciamanejo.models.License;
import com.johfloresm.licenciamanejo.models.Person;
import com.johfloresm.licenciamanejo.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService{
    
    @Autowired
    private LicenseRepository licenseRepository;

    public List<License> getLicenses(){
        return licenseRepository.findAll();
    }

    public License createLicense(License b) {
        License last = this.getLastLicenseCreated();
        b.setNumber(last.generateNumber());
        return licenseRepository.save(b);
    }

    public License getLastLicenseCreated(  ){
        return  licenseRepository.findFirstByOrderByIdDesc();
    }

    public License getLicenseById(Long id){
        return licenseRepository.findById(id).orElse(null);
    }

    public void deleteLicenseById(Long id){
        licenseRepository.deleteLicenseById(id);
    }

    public void updateLicense(License p){
        License license = this.getLicenseById(p.getId());
        license.setExpirationDate(p.getExpirationDate());
        license.setNumber(p.getNumber());
        license.setState(p.getState());

        licenseRepository.save(license);
    }
}
