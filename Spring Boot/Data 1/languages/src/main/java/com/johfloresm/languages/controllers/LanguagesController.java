package com.johfloresm.languages.controllers;

import com.johfloresm.languages.models.Language;
import com.johfloresm.languages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/languages")
public class LanguagesController{

    @Autowired
    private LanguageService languageService;

    @RequestMapping("")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);

        return "index.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("language") Language language, BindingResult result,Model model){
        if (result.hasErrors()) {
            List<Language> languages = languageService.allLanguages();
            model.addAttribute("languages", languages);
            return "index.jsp";
        }

        languageService.createLanguage(language);
        return "redirect:/languages";
    }

    @RequestMapping("{id}")
    public String show (@PathVariable("id") Long id, Model model){
        model.addAttribute("language", languageService.findLanguage(id));
        return "show.jsp";
    }

    @RequestMapping("{id}/edit")
    public String edit (@PathVariable("id") Long id, Model model){
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String update (@Valid @ModelAttribute("language") Language language,BindingResult result){
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }


}
