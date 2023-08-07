package com.example.licencia.services;

import com.example.licencia.models.License;
import com.example.licencia.models.Persons;
import com.example.licencia.repositories.LicenseRepository;
import com.example.licencia.repositories.PersonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {

    private final PersonsRepository personsRepository;
    private final LicenseRepository licenseRepository;

    public PersonsService(PersonsRepository personsRepository, LicenseRepository licenseRepository) {
        this.personsRepository = personsRepository;
        this.licenseRepository = licenseRepository;
    }

    public Persons findPersons(Long id) {
        Optional<Persons> allPersons = personsRepository.findById(id);
        if (allPersons.isPresent()) {
            return allPersons.get();
        } else {
            return null;
        }
    }

    public List<Persons> getAllPersons() {
        List<Persons> allPersons = personsRepository.findAll();
        for (Persons person : allPersons) {
            License license = licenseRepository.findByPerson(person);
            if (license != null) {
                person.setLicense(license);
            }
        }
        return personsRepository.findAll();
    }

    public Persons createPersons(Persons p) {
        return personsRepository.save(p);
    }
}
