package com.mytests.spring.springjpadifferentrepostyles.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepositoryGenerics<T, ID> extends Repository<T, ID> {
     // https://youtrack.jetbrains.com/issue/IDEA-347610/Spring-JPA-the-gutter-icons-should-not-be-shown-for-query-methods-in-the-generic-base-repositories
    // Could not parse repository method name. Please check that "findById" is using Spring Data method naming conventions
    Optional<T> findById(ID id);


}