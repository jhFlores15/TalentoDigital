package com.johfloresm.dojooverflow.models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "tags")
public class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;
    @Size(min = 3, max = 255)
    private String         subject;
    @Column(updatable=false)
    private Date           createdAt;
    private Date           updatedAt;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions ; //= new ArrayList<Question>();

    public Tag (String subject){
        this.subject = subject.trim().toLowerCase(Locale.ROOT);
    }

    public Tag(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }

    public List<Question> getQuestions(){
        return questions;
    }

    public void setQuestions(List<Question> questions){
        this.questions = questions;
    }

   /** public void setQuestion(Question question){
        if(!this.questions.contains(question)){
            this.questions.add(question);
        }
    }*/

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.createdAt = new Date();
    }

}
