package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContactProjectionRepository extends JpaRepository<Contact, Long> {

    String Q1 = "select c from Contact c where c.lastname like 'ivanov'";

    List<ContactProjection> findByFirstname(String firstName);

    @Query(Q1)
    List<ContactProjection> customQuery1();
}
