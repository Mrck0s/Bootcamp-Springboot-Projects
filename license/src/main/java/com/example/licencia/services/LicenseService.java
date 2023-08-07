package com.example.licencia.services;


import com.example.licencia.models.License;
import com.example.licencia.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License l){
        return licenseRepository.save(l);
    }

    public List<License> getAllLicenses(){
        return licenseRepository.findAll();
    }

    public Long getNextLicenseId() {
        Long lastLicenseId = licenseRepository.findMaxId();
        if(lastLicenseId != null){
            return lastLicenseId + 1;
        } else {
            return 1L;
        }
    }
}
