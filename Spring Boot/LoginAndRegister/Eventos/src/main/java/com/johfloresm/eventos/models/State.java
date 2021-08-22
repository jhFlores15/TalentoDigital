package com.johfloresm.eventos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "states")
public class State{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;
    private String         name;
    @JsonIgnore
    @OneToMany(mappedBy="state", fetch = FetchType.LAZY)
    private List<Location> locations;
    @Column(updatable=false)
    private Date           createdAt;
    private Date           updatedAt;
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

    public List<Location> getLocations(){
        return locations;
    }

    public void setLocations(List<Location> locations){
        this.locations = locations;
    }
}
