package com.johfloresm.eventos.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.websocket.OnMessage;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long        id;
    @Email(message="Email must be valid")
    private String      email;
    private String      firstName;
    private String      lastName;
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="location_id")
    private Location    location;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "messages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> event_messages;
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> events_user;

    @Column(updatable=false)
    private Date   createdAt;
    private Date   updatedAt;


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

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
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

    public List<Event> getEvents(){
        return events;
    }

    public void setEvent(Event event){
        if(!this.events.contains(event)){ this.events.add(event); }
    }
    public void removeEvent(Event event){
        if(this.events.contains(event)){ this.events.remove(event); }
    }


    public void setEvents(List<Event> events){
        this.events = events;
    }

    public List<Event> getEvent_messages(){
        return event_messages;
    }

    public void setEvent_messages(List<Event> event_messages){
        this.event_messages = event_messages;
    }

    public List<Event> getEvents_user(){
        return events_user;
    }

    public void setEvents_user(List<Event> events_user){
        this.events_user = events_user;
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
