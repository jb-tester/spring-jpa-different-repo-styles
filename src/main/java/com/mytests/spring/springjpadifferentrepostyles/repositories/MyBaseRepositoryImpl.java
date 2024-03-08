package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;

import java.util.List;


public interface MyBaseRepositoryImpl extends MyBaseRepository {

    List<Contact> findContactsBy();

    boolean existsByTelephoneContains(String phone);
}
