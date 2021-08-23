package com.johfloresm.waterbnb.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long       id;
    private String firstName;
    private String lastName;
    @Email(message="Email must be valid")
    private String     email;
    @Size(min=5, message="Password must be greater than 5 characters")
    private String     password;
    @Transient
    private String passwordConfirmation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role       role;
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Pool> poolsManage;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ratings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pool_id")
    )
    private List<Pool> poolsRating;
    @Column(updatable=false)
    private Date       createdAt;
    private Date   updatedAt;

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

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public List<Pool> getPoolsManage(){
        return poolsManage;
    }

    public void setPoolsManage(List<Pool> poolsManage){
        this.poolsManage = poolsManage;
    }

    public List<Pool> getPoolsRating(){
        return poolsRating;
    }

    public void setPoolsRating(List<Pool> poolsRating){
        this.poolsRating = poolsRating;
    }

    public User() {
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPasswordConfirmation(){
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation){
        this.passwordConfirmation = passwordConfirmation;
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

    // otros getters y setters removidos para resumir.
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
