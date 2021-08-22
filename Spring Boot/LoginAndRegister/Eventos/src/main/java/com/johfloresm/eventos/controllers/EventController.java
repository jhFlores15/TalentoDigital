package com.johfloresm.eventos.controllers;

import com.johfloresm.eventos.models.Event;
import com.johfloresm.eventos.models.Location;
import com.johfloresm.eventos.models.User;
import com.johfloresm.eventos.services.EventService;
import com.johfloresm.eventos.services.StateService;
import com.johfloresm.eventos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;
import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController{

    @Autowired
    EventService eventService;
    @Autowired
    UserService  userService;
    @Autowired
    StateService stateService;



    @RequestMapping("")
    public String index(@ModelAttribute("event")Event event, HttpSession httpSession, Model model){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        model.addAttribute("eventsState", eventService.getEventsByStateId(user.getLocation().getState().getId()));
        model.addAttribute("eventsNotState", eventService.getEventsByNotStateId(user.getLocation().getState().getId()));
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("user", user);

        return "events/index.jsp";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("event")Event event,@RequestParam("stateId") Long stateId,@RequestParam("locationStr") String locationStr, HttpSession httpSession,BindingResult result,Model model){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        if(result.hasErrors()){
            return index(event,httpSession,model);
        }
        User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        Location l = new Location(locationStr);
        l.setState(stateService.getStateById(stateId));
        event.setLocation(l);
        event.setHost(user);


        eventService.saveEvent(event);
        return "redirect:/events/"+event.getId();
    }

    @RequestMapping("{id}")
    public String show(@PathVariable("id") Long id,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        Event e = eventService.getEventById(id);
        model.addAttribute("event" , e);
        model.addAttribute("users" , e.getUsers());
        return "events/show.jsp";
    }

    @RequestMapping("{id}/edit")
    public String edit(@PathVariable Long id,Model model,HttpSession httpSession){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        Event e = eventService.getEventById(id);
        model.addAttribute("event",e);
        model.addAttribute("states", stateService.getStates());
        return "events/edit.jsp";
    }

    @RequestMapping(value = "{id}" , method=RequestMethod.PUT)
    public String update(
            @Valid @ModelAttribute("event")Event event,
            @RequestParam("stateId") Long stateId,
            @RequestParam("locationStr") String locationStr,
            BindingResult result,Model model,HttpSession httpSession
    ){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        if(result.hasErrors()){
            return edit(event.getId(),model,httpSession);
        }

        Event e = eventService.getEventById(event.getId());
        if(e.getLocation().getName() != locationStr){
            Location l = new Location(locationStr);
            l.setState(stateService.getStateById(stateId));
            event.setLocation(l);
        }

        eventService.saveEvent(e);
        return "events/"+event.getName();
    }

    @GetMapping("/{id}/join")
    public String join(@PathVariable("id") Long id,HttpSession httpSession){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        Event e = eventService.getEventById(id);
        user.setEvent(e);
        userService.saveUser(user);

        return "redirect:/events";
    }

    @GetMapping("/{id}/join/cancel")
    public String cancelJoin(@PathVariable("id") Long id,HttpSession httpSession){
        if(httpSession.getAttribute("idUser") == null){ return "redirect:/";}
        User user = userService.findUserById(Long.parseLong(httpSession.getAttribute("idUser").toString()));
        Event e = eventService.getEventById(id);
        user.removeEvent(e);

        userService.saveUser(user);
        return "redirect:/events";
    }
}
