package com.johfloresm.listaestudiantes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String          firstName;
    private String          lastName;
    private int             age;
    @Column(updatable=false)
    private Date   createdAt;
    private Date   updatedAt;
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)
    private Contact         contact;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dormitory_id")
    @JsonIgnore
    private Dormitory dormitory;

    public Student(){}

    public Student(String firstName, String lastName, int age, Contact contact, Dormitory dormitory){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contact = contact;
        this.dormitory = dormitory;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
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

    public Contact getContact(){
        return contact;
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }

    public Dormitory getDormitory(){
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory){
        this.dormitory = dormitory;
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
