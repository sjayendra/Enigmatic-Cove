package com.jay.crud1;

import javax.persistence.*;


//Table - User
@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="judgements_id_seq")
    //@SequenceGenerator(name="judgements_id_seq", sequenceName="judgements_id_seq", allocationSize=1)
    private long id;

    //@NotBlank(message = "Name is mandatory")
    private String name;

    //@NotBlank(message = "Email is mandatory")
    private String email;

    private String role;
    // standard constructors / setters / getters / toString

    protected User() {
    }
    public User(String name,String role, String email) {
        super();
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public long getId() {
        return  id;
    }
    public String getName() {return name;}
    public String getRole() {return role;}
    public String getEmail() {return email;}

}