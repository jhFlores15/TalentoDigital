package com.johfloresm.homeflix.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           film_id;
    String title;
    String description;
    int release_year;
    int rental_duration;
    float rental_rate;
    int length;
    float replacement_cost;
    String rating;
    String special_features;
    Date last_update;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="language_id")
    private Language       language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="original_language_id")
    private Language original_language;

    public Long getFilm_id(){
        return film_id;
    }

    public void setFilm_id(Long film_id){
        this.film_id = film_id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getRelease_year(){
        return release_year;
    }

    public void setRelease_year(int release_year){
        this.release_year = release_year;
    }

    public int getRental_duration(){
        return rental_duration;
    }

    public void setRental_duration(int rental_duration){
        this.rental_duration = rental_duration;
    }

    public float getRental_rate(){
        return rental_rate;
    }

    public void setRental_rate(float rental_rate){
        this.rental_rate = rental_rate;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public float getReplacement_cost(){
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost){
        this.replacement_cost = replacement_cost;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getSpecial_features(){
        return special_features;
    }

    public void setSpecial_features(String special_features){
        this.special_features = special_features;
    }

    public Date getLast_update(){
        return last_update;
    }

    public void setLast_update(Date last_update){
        this.last_update = last_update;
    }

    public List<Category> getCategories(){
        return categories;
    }

    public void setCategories(List<Category> categories){
        this.categories = categories;
    }

    public Language getLanguage(){
        return language;
    }

    public void setLanguage(Language language){
        this.language = language;
    }

    public Language getOriginal_language(){
        return original_language;
    }

    public void setOriginal_language(Language original_language){
        this.original_language = original_language;
    }

    @PreUpdate
    protected void onUpdate(){
        this.last_update = new Date();
    }

}
