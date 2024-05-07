package com.mytests.spring.springjpadifferentrepostyles.data;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
@NamedQuery(name = "Contact.namedQuery1", query = "SELECT c FROM Contact c where c.lastname = :lastname")
@NamedNativeQuery(name = "Contact.namedNativeQuery1", query = "SELECT * FROM Contact where lastname = ?1")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "telephone", length = 30)
    private String telephone;

    @Column(name = "email", length = 30)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
               "id=" + id +
               ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", telephone='" + telephone + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    public Contact(String firstname, String lastname, String telephone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
    }

    public Contact() {
    }
}