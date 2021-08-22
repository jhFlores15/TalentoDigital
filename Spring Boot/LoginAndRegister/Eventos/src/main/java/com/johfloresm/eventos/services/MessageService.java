package com.johfloresm.eventos.services;

import com.johfloresm.eventos.models.Message;
import com.johfloresm.eventos.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService{
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessagesByEventId(Long id){
        return messageRepository.findAllByEventId(id);
    }

}
