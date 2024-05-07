package com.mytests.spring.springjpadifferentrepostyles.repositories;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RepositoryWithQueryAnnotations extends CrudRepository<Contact, Integer> {

    String QUERY1 = "select e from Contact e where e.id = :id";
    String QUERY2 = "select * from Contact where id = ?";

    // https://youtrack.jetbrains.com/issue/IDEA-353137: parameter values can't be provided when running via gutter
    @Query(nativeQuery = true,
            value = """
            select * from Contact e
            where e.firstname = :name and e.lastname = :surname
            """)
    List<Contact> testNativeQueryWithNamedParams1(@Param("name") String name, @Param("surname") String surname);

    // https://youtrack.jetbrains.com/issue/IDEA-353137: parameter values can't be provided when running via gutter
    @Query(nativeQuery = true,
            value = """
            select * from Contact
            where firstname = :name and lastname = :surname
            """)
    List<Contact> testNativeQueryWithNamedParams2(@Param("name") String name, @Param("surname") String surname);

    // the parameters dialog is shown, but it is required to provide the values in quotes, like `'irina'` instead of `irina` that works in JPA console
    @Query(nativeQuery = true,
            value = """
            select * from Contact e
            where e.firstname = ?1 and e.lastname = ?2
            """)
    List<Contact> testNativeQueryWithIndexedParams(String name, String surname);

    @Query(nativeQuery = true,
            value = """
            select * from Contact e
            where e.firstname = 'irina'
            """)
    List<Contact> testNativeQueryWithoutParams();

    @Query("""
            select e from Contact e
            where e.firstname = :name and e.lastname = :surname
            """)
    List<Contact> testJpaQueryWithNamedParams(@Param("name") String name, @Param("surname") String surname);

    // https://youtrack.jetbrains.com/issue/IDEA-309055: common JPA console problem: indexed parameters are not supported
    @Query("""
            select e from Contact e
            where e.firstname = ?1 and e.lastname = ?2
            """)
    List<Contact> testJpaQueryWithIndexedParams(String name, String surname);


    @Query(QUERY1)
    List<Contact> queryAsConstant(@Param("id")int id);

    @Query(nativeQuery = true, value = QUERY2)
    List<Contact> nativeQueryAsConstant(int id);

}
