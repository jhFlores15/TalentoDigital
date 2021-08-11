package com.johfloresm.licenciamanejo.models;

import org.apache.logging.log4j.util.Strings;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "licenses")
public class License{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

    static Long lastNumber = 0L;


    public License() {

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public Date getExpirationDate(){
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate){
        this.expirationDate = expirationDate;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
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

    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public static Long getLastNumber(){
        return lastNumber;
    }

    public static void setLastNumber(Long lastNumber){
        License.lastNumber = lastNumber;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.createdAt = new Date();
    }

    public static String generateNumber (){
        String number = (++lastNumber ).toString();
        return Strings.repeat("0", 5 - number.length()) + number;
    }
}
