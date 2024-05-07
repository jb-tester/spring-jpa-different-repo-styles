package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContactProjectionRepository extends JpaRepository<Contact, Long> {

    String Q1 = "select c from Contact c where c.lastname like 'ivanov'";

    // ok
    List<ContactProjection> findByFirstname(String firstName);

    // ok
    @Query(Q1)
    List<ContactProjection> customQuery1();

    // jpa console is opened - fixed
    // https://youtrack.jetbrains.com/issue/IDEA-348612/Spring-Data-for-repository-methods-annotated-with-QuerynativeQiery-true-the-JPA-console-is-invoked
    @Query(nativeQuery = true, value = "select * from Contact")
    List<ContactProjection> customQuery2();
}
