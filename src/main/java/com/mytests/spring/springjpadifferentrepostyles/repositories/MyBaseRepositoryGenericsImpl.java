package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;

import java.util.List;


public interface MyBaseRepositoryGenericsImpl extends MyBaseRepositoryGenerics<Contact, Integer> {

    List<Contact> getContactByLastname(String lastname);
}
