package com.mytests.spring.springjpadifferentrepostyles.repositories;


import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotAnnotatedInterfaceExtendingCrudRepository extends CrudRepository<Contact,Integer> {

    List<Contact> findByFirstname(String firstname);
    List<Contact> searchAllByLastnameContainingIgnoreCase(String pattern);

    // `JPQL Query can't be extracted from method using "Top" or "First" options` message is shown
    Contact getFirstByEmailEndingWithIgnoreCase(String pattern);
    // `JPQL Query can't be extracted from method using "Top" or "First" options` message is shown
    Contact getDistinctTopByEmailContains(String pattern);

    int countByTelephoneIsNotNull();
    boolean existsDistinctByLastname(String lastname);
    List<Contact> queryContactsByEmailEndingWithOrEmailEndingWithOrderByFirstnameDesc(String pattern1, String pattern2);
    Contact[] findLastnameByFirstname(String name);


    List<Contact> namedQuery1(String lastname);

    List<Contact> findContactsBy();

    // Could not parse repository method name. Please check that "count" is using Spring Data method naming conventions.
    @Override
    long count();


}
