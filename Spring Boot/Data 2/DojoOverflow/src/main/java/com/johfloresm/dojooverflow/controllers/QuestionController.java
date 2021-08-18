package com.johfloresm.dojooverflow.controllers;

import com.johfloresm.dojooverflow.models.Answer;
import com.johfloresm.dojooverflow.models.Question;
import com.johfloresm.dojooverflow.models.Tag;
import com.johfloresm.dojooverflow.repositories.AnswerRepository;
import com.johfloresm.dojooverflow.services.AnswerService;
import com.johfloresm.dojooverflow.services.QuestionService;
import com.johfloresm.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("questions")
public class QuestionController{

    private QuestionService questionService;
    private TagService      tagService;
    private AnswerService answerService;
    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService){
        this.questionService = questionService;
        this.tagService      = tagService;
        this.answerService = answerService;
    }
    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("questions", questionService.getQuestions());
        return "questions/index.jsp";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer,Model model){
        model.addAttribute("question", questionService.getQuestionById(id) );
        return "questions/show.jsp";
    }

    @RequestMapping("/new")
    public String create(){
        return "questions/create.jsp";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String store(@RequestParam("question") String question, @RequestParam("tags") String tags){
        Question q = new Question(question);
        String[] tagsList = tags.split(",");
        List<Tag> tagsObject = new ArrayList<Tag>();
        for(String subject: tagsList){
            Tag t = tagService.getTagBySubject(subject);
            tagsObject.add((t == null) ? new Tag(subject) : t);
        }
        q.setTags(tagsObject);
        questionService.createQuestion(q);
        return "redirect:/questions/"+q.getId();
    }

    @RequestMapping(value = "{id}/addAnswer", method = RequestMethod.POST)
    public String addAnswer( @PathVariable("id") Long id,@RequestParam(value = "answer") String answer){
        Question q = questionService.getQuestionById(id);
        Answer a = new Answer(answer);
        a.setQuestion(q);
        answerService.createAnswer(a);
        return "redirect:/questions/"+q.getId();
    }
}
