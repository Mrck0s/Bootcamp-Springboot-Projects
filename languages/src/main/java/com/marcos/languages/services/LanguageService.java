package com.marcos.languages.services;

import com.marcos.languages.models.Language;
import com.marcos.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service

public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages() {
        return (List<Language>) languageRepository.findAll();
    }

    public void addLanguage(Language lan) {
        languageRepository.save(lan);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        return optionalLanguage.orElse(null);
    }

    public void updateLanguage(Language language) {
        Optional<Language> existingLanguage = languageRepository.findById(language.getId());
        if (existingLanguage.isPresent()) {
            Language updatedLanguage = existingLanguage.get();
            updatedLanguage.setName(language.getName());
            updatedLanguage.setCreator(language.getCreator());
            updatedLanguage.setCurrentVersion(language.getCurrentVersion());

            languageRepository.save(updatedLanguage);
        }
    }

    public void deleteLanguage(Long id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No se encontró ningún lenguaje con el ID proporcionado.");
        }

    }
}
