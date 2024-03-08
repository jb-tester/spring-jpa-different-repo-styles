package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepository extends Repository<Contact, Integer> {

    Optional<Contact> findById(int id);

    Contact save(Contact entity);
}