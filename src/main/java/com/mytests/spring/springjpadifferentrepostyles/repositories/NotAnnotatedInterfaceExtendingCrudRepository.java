package com.mytests.spring.springjpadifferentrepostyles.repositories;


import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface NotAnnotatedInterfaceExtendingCrudRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByFirstname(String firstname);

    List<Contact> searchAllByLastnameContainingIgnoreCase(String pattern);

    // `JPQL Query can't be extracted from method using "Top" or "First" options` message is shown - fixed
    // actually no gutters are shown https://youtrack.jetbrains.com/issue/IDEA-347613/Spring-JPA-support-console-running-for-the-methods-with-Top-or-First-suffixes
    Contact getFirstByEmailEndingWithIgnoreCase(String pattern);

    // `JPQL Query can't be extracted from method using "Top" or "First" options` message is shown - fixed
    // actually no gutters are shown https://youtrack.jetbrains.com/issue/IDEA-347613/Spring-JPA-support-console-running-for-the-methods-with-Top-or-First-suffixes
    Contact getDistinctTopByEmailContains(String pattern);

    int countByTelephoneIsNotNull();

    boolean existsDistinctByLastname(String lastname);

    List<Contact> searchDistinctByFirstname(String firstname);

    List<Contact> queryContactsByEmailEndingWithOrEmailEndingWithOrderByFirstnameDesc(String pattern1, String pattern2);

    Contact[] findLastnameByFirstname(String name);

    // https://youtrack.jetbrains.com/issue/IDEA-347607/Spring-JPA-the-named-queries-cant-be-run-via-query-method-gutter-icon - fixed
    // ok
    List<Contact> namedQuery1(String lastname);

    List<Contact> findContactsBy();

    // ok
    Stream<Contact> streamByEmail(String email);

    // Could not parse repository method name. Please check that "count" is using Spring Data method naming conventions.
    // https://youtrack.jetbrains.com/issue/IDEA-347609 - fixed
    // ok
    @Override
    long count();

    // ok
    @Override
    void deleteById(Integer id);
    // ok
    void removeByFirstname(String firstname);

    // https://youtrack.jetbrains.com/issue/IDEA-347609 - fixed
    // no gutter - ok
    @Override
    <S extends Contact> S save(S entity);

    // https://youtrack.jetbrains.com/issue/IDEA-347609 - fixed
    // no gutter - ok
    @Override
    <S extends Contact> Iterable<S> saveAll(Iterable<S> entities);

    // select all is performed (select c from Contact c)
    // https://youtrack.jetbrains.com/issue/IDEA-348613/Spring-JPA-for-deleteentity-and-deleteAllentities-the-gutter-icon-should-not-be-shown
    @Override
    void delete(Contact entity);

    // select all is performed (select c from Contact c)
    // https://youtrack.jetbrains.com/issue/IDEA-348613/Spring-JPA-for-deleteentity-and-deleteAllentities-the-gutter-icon-should-not-be-shown
    @Override
    void deleteAll(Iterable<? extends Contact> entities);


}
