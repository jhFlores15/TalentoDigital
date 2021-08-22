package com.johfloresm.eventos.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.createdAt = new Date();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
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

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Event getEvent(){
        return event;
    }

    public void setEvent(Event event){
        this.event = event;
    }
}
