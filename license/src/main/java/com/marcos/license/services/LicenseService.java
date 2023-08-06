package com.marcos.license.services;

import com.marcos.license.models.License;
import com.marcos.license.models.Person;
import com.marcos.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;
    private final PersonService personService;

    public LicenseService(LicenseRepository licenseRepository, PersonService personService) {
        this.licenseRepository = licenseRepository;
        this.personService = personService;
    }

    public License createLicense(String state, Date expirationDate) {
        License license = new License();
        license.setState(state);
        license.setExpirationDate(expirationDate);
        long licenseNumber = personService.getAllPersons().spliterator().getExactSizeIfKnown() + 1;
        String formattedLicenseNumber = String.format("%06d", licenseNumber);
        license.setNumber(formattedLicenseNumber);

        license.setCreatedAt(LocalDateTime.now());
        license.setUpdatedAt(LocalDateTime.now());

        return licenseRepository.save(license);
    }

    public Iterable<License> getAllLicenses() {
        return licenseRepository.findAll();
    }
}
