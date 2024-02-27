package com.mytests.spring.springjpadifferentrepostyles.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepositoryGenerics<T, ID> extends Repository<T, ID> {

  // Could not parse repository method name. Please check that "findById" is using Spring Data method naming conventions
  Optional<T> findById(ID id);


}