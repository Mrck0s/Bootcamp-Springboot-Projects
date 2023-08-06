package com.marcos.license.controllers;

import com.marcos.license.models.Person;
import com.marcos.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    private final PersonService personService;

    public ListController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public String getAllPersons(Model model) {
        Iterable<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "personList";
    }
}

