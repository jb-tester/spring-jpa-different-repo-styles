package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Contact.class, idClass = Integer.class)
public interface AnnotatedAsRepositoryDefinitionInterface {

    // Could not parse repository method name. Please check that "findByFirstname" is using Spring Data method naming conventions.
    List<Contact> findByFirstname(String firstname);
}
