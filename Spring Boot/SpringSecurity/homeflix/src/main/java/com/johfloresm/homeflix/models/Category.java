package com.johfloresm.homeflix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    String name;
    private Date           last_update;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    public Long getCategory_id(){
        return category_id;
    }

    public void setCategory_id(Long category_id){
        this.category_id = category_id;
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

    @PreUpdate
    protected void onUpdate(){
        this.last_update = new Date();
    }
}
