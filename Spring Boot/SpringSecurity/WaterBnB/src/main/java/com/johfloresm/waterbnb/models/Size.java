package com.johfloresm.waterbnb.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sizes")
public class Size{
    static final int SMALL  = 1;
    static final int MEDIUM = 2;
    static final int LARGE  = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     name;
    @OneToMany(mappedBy="size", fetch = FetchType.LAZY)
    private List<Pool> pools;
    @Column(updatable=false)
    private Date       createdAt;
    private Date       updatedAt;

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

    public List<Pool> getPools(){
        return pools;
    }

    public void setPools(List<Pool> pools){
        this.pools = pools;
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
