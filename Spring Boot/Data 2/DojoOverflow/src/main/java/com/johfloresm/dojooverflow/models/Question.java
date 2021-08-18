package com.johfloresm.dojooverflow.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;
    private String         question;
    @Column(updatable=false)
    private Date           createdAt;
    private Date           updatedAt;
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<Answer>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags ; //= new ArrayList<Tag>();

    public Question(String question){
        this.question = question;
    }

    public Question(){

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
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

    public List<Answer> getAnswers(){
        return answers;
    }

    public void setAnswers(List<Answer> answers){
        this.answers = answers;
    }

    public List<Tag> getTags(){
        return tags;
    }

    public String getTagsComma(){
        String srtTags = "";
        for(Tag tag: this.tags){
            srtTags+= tag.getSubject() + ",";
        }

        return srtTags.replaceFirst(".$","");
    }

    public void setTags(List<Tag> tags){
        this.tags = tags;
    }

    public void setAnswer(Answer a){
        if( !this.answers.contains(a)){
            this.answers.add(a);
        }
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.createdAt = new Date();
    }
}
