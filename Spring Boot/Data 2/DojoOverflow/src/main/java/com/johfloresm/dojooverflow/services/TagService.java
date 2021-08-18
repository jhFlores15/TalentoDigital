package com.johfloresm.dojooverflow.services;

import com.johfloresm.dojooverflow.models.Tag;
import com.johfloresm.dojooverflow.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService{

    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag t){
        return tagRepository.save(t);
    }

    public List<Tag> saveTags(List<Tag> tags){
        return (List<Tag>) tagRepository.saveAll(tags);
    }

    public Tag getTagBySubject(String subject){
        return tagRepository.findFirstBySubject(subject);
    }
}
