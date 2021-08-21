package com.johflores.world.models;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Language{
    enum Official {T,F}
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String country_code;
    private String language;
    private Official is_official;
    private double percentage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCountry_code(){
        return country_code;
    }

    public void setCountry_code(String country_code){
        this.country_code = country_code;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public Official getIs_official(){
        return is_official;
    }

    public void setIs_official(Official is_official){
        this.is_official = is_official;
    }

    public double getPercentage(){
        return percentage;
    }

    public void setPercentage(double percentage){
        this.percentage = percentage;
    }

    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
    }
}
