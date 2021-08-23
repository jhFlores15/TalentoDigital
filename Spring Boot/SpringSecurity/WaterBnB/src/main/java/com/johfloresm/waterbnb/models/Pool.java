package com.johfloresm.waterbnb.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pools")
public class Pool{

    static final int HOST=1;
    static final int GUEST=2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     name;
    private String     address;
    private String     description;
    private float      cost_per_nigth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="size_id")
    private Size size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ratings",
            joinColumns = @JoinColumn(name = "pool_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersRating;
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

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public float getCost_per_nigth(){
        return cost_per_nigth;
    }

    public void setCost_per_nigth(float cost_per_nigth){
        this.cost_per_nigth = cost_per_nigth;
    }

    public Size getSize(){
        return size;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public User getHost(){
        return host;
    }

    public void setHost(User host){
        this.host = host;
    }

    public List<User> getUsersRating(){
        return usersRating;
    }

    public void setUsersRating(List<User> usersRating){
        this.usersRating = usersRating;
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
