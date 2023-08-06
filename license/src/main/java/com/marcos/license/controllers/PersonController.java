package com.marcos.license.controllers;

import com.marcos.license.models.Person;
import com.marcos.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/new")
    public String showPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/new")
    public String createPerson(@ModelAttribute Person person) {
        personService.createPerson(person.getFirstName(), person.getLastName());
        return "redirect:/list";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "personDetails";
    }
}
