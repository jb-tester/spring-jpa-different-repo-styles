package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepository extends Repository<Contact, Integer> {

    // https://youtrack.jetbrains.com/issue/IDEA-356059/Spring-Data-the-run-gutter-icons-could-be-shown-for-non-generic-methods-in-NoRepositoryBean-classes
    Optional<Contact> findById(int id);

    Contact save(Contact entity);
}