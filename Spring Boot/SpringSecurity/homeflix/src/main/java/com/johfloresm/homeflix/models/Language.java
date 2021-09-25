package com.johfloresm.homeflix.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "language")
public class Language{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long language_id;
    String name;
    private Date           last_update;
    @OneToMany(mappedBy="language", fetch = FetchType.LAZY)
    private List<Film> films;

    public Long getLanguage_id(){
        return language_id;
    }

    public void setLanguage_id(Long language_id){
        this.language_id = language_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getLast_update(){
        return last_update;
    }

    public void setLast_update(Date last_update){
        this.last_update = last_update;
    }

    public List<Film> getFilms(){
        return films;
    }

    public void setFilms(List<Film> films){
        this.films = films;
    }

    @PreUpdate
    protected void onUpdate(){
        this.last_update = new Date();
    }
}
