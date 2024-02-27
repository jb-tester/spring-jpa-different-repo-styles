package com.mytests.spring.springjpadifferentrepostyles.repositories;


import org.springframework.beans.factory.annotation.Value;

public interface ContactProjection {

    String getFirstname();
    String getLastname();
    @Value("#{target.email + ' ' + target.telephone}")
    String getContacts();
}
