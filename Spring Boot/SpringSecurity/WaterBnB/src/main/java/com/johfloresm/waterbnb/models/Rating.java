package com.johfloresm.waterbnb.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ratings")
public class Rating{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     description;
    @Min(1)
    @Max(5)
    private int        rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pool_id")
    private Pool pool;
    @Column(updatable=false)
    private Date       createdAt;
    private             Date  updatedAt;
    public static final int[] RATINGS = new int[]{1, 2, 3, 4, 5};
    public Long getId(){
        return id;
    }

    public Rating(){}

    public Rating(User user,Pool pool,int rating,String description){
        this.user = user;
        this.rating = rating;
        this.pool = pool;
        this.description = description;
    }



    public void setId(Long id){
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Pool getPool(){
        return pool;
    }

    public void setPool(Pool pool){
        this.pool = pool;
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

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.createdAt = new Date();
    }
}
