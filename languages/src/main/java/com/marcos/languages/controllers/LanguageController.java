package com.marcos.languages.controllers;

import com.marcos.languages.models.Language;
import com.marcos.languages.services.LanguageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public String getAllLanguages(Model model) {
        model.addAttribute("languages", languageService.allLanguages());
        return "list";
    }

    @GetMapping("/{id}")
    public String getLanguageById(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        if (language == null) {
            throw new IllegalArgumentException("Invalid language Id:" + id);
        }
        model.addAttribute("language", language);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String editLanguageById(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        if (language == null) {
            throw new IllegalArgumentException("Invalid language Id:" + id);
        }
        model.addAttribute("language", language);
        return "edit";
    }

    @PostMapping
    public String createLanguage(@Valid Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }

        languageService.addLanguage(language);
        return "redirect:/languages";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute("language") Language updatedLanguage,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        } else {
            Language existingLanguage = languageService.findLanguage(id);
            existingLanguage.setName(updatedLanguage.getName());
            existingLanguage.setCreator(updatedLanguage.getCreator());
            existingLanguage.setCurrentVersion(updatedLanguage.getCurrentVersion());

            languageService.updateLanguage(existingLanguage);

            return "redirect:/languages";
        }
    }

    @PostMapping("/{id}")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
