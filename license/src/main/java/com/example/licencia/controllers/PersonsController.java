package com.example.licencia.controllers;

import com.example.licencia.models.License;
import com.example.licencia.models.Persons;
import com.example.licencia.services.LicenseService;
import com.example.licencia.services.PersonsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class PersonsController {

    private final PersonsService personsService;
    private final LicenseService licenseService;
    PersonsController(PersonsService personsService, LicenseService licenseService){
        this.personsService = personsService;
        this.licenseService = licenseService;

    }

    @GetMapping("/")
    public String index(Model model){
        List<Persons> allPersons = personsService.getAllPersons();
        List<License> allLicenses = licenseService.getAllLicenses();

        for (License license : allLicenses) {
            license.setIdAndFormatNumber(license.getId());
        }
        model.addAttribute("allPersons", allPersons);
        model.addAttribute("allLicenses", allLicenses);
        return "index";
    }

    @GetMapping("/persons/new")
    public String personsNew(Model model){
        model.addAttribute("newPersons", new Persons());
        return "personsNew";
    }

    @PostMapping("/persons/new")
    public String createPersons(@RequestParam("first") String first, @RequestParam("last") String last){
        Persons persons = new Persons();
        persons.setFirst_name(first);
        persons.setLast_name(last);
        personsService.createPersons(persons);
        return "redirect:/persons/new";
    }

    @GetMapping("/licenses/new")
    public String licensesNew(Model model){
        model.addAttribute("newLicenses", new License());
        List<Persons> allPersons = personsService.getAllPersons();
        model.addAttribute("allPersons", allPersons);
        return "licenseNew";
    }

    @PostMapping("/licenses/new")
    public String createLicenses(@RequestParam("personName") Long personName,
                                 @RequestParam("state") String state,
                                 @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        License license = new License();
        Persons person = personsService.findPersons(personName);

        if (person != null){
            license.setPerson(person);
        }

        license.setState(state);
        license.setExpirationDate(date);

        Long nextLicenseId = licenseService.getNextLicenseId();
        license.setIdAndFormatNumber(nextLicenseId);
        licenseService.createLicense(license);

        return "redirect:/licenses/new";
    }

    @GetMapping("/persons/{id}")
    public String showPersons(@PathVariable("id") Long id, Model model){
        Persons showPerson = personsService.findPersons(id);
        model.addAttribute("showPerson", showPerson);
        License personLicense = showPerson.getLicense();
        model.addAttribute("personLicense", personLicense);
        return "showPersons";
    }
}
