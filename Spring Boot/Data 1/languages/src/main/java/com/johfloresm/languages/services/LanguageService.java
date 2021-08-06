package com.johfloresm.languages.services;

import com.johfloresm.languages.models.Language;
import com.johfloresm.languages.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService{

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }

    public Language findLanguage(Long id) {
        Language language = languageRepository.findById(id).orElse(null);
        return language;
    }

    public Long deleteLanguage(Long id){
        return languageRepository.deleteBookById(id);
    }

    public void updateLanguage(Language language){
        Language b = this.findLanguage(language.getId());

        b.setName(language.getName());
        b.setCreator(language.getCreator());
        b.setCurrentVersion(language.getCurrentVersion());

        languageRepository.save(b);
    }


}
