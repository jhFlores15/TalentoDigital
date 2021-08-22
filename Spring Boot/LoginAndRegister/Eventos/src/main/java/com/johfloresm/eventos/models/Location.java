package com.johfloresm.eventos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    @JsonIgnore
    private State state;
    @OneToMany(mappedBy="location", fetch = FetchType.LAZY)
    private List<User> users;
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

    public Location(){}
    public Location(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUser(List<User> users){
        this.users = users;
    }
}
