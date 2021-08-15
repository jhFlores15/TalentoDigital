package com.johfloresm.listaestudiantes.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dormitories")
public class Dormitory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long          id;
    private String        name;
    @Column(updatable = false)
    private Date          createdAt;
    private Date          updatedAt;
    @OneToMany(mappedBy = "dormitory", fetch = FetchType.LAZY)
    private List<Student> student;

    public Dormitory(){}
    public Dormitory(String name){
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

    public List<Student> getStudent(){
        return student;
    }

    public void setStudent(List<Student> student){
        this.student = student;
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
