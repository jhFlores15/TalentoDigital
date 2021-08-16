package com.johfloresm.listaestudiantes.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "classes")
public class Class{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long          id;
    private String        name;
    @Column(updatable = false)
    private Date          createdAt;
    private Date          updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "students_classes",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Class(){ }

    public Class(String name){
        this.name = name;
    }
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

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public void  setStudent(Student s){
        if(!this.students.contains(s)){
            this.students.add(s);
        }
    }
}
