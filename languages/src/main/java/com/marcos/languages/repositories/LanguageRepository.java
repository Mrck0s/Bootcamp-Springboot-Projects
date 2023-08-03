package com.marcos.languages.repositories;

import com.marcos.languages.models.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {}

