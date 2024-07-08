package com.mytests.spring.springjpadifferentrepostyles;

import com.mytests.spring.springjpadifferentrepostyles.data.Contact;
import com.mytests.spring.springjpadifferentrepostyles.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaDifferentRepoStylesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDifferentRepoStylesApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AnnotatedAsRepositoryDefinitionInterface repo1, NotAnnotatedInterfaceExtendingCrudRepository repo2, ContactProjectionRepository repo3, RepositoryWithQueryAnnotations repositoryWithQueryAnnotations) {
        return args -> {
            System.out.println("--------------------------------------");
            for (Contact s : repo2.findLastnameByFirstname("vera")) {
                System.out.println(s);
            }
            System.out.println("--------------------------------------");
            for (Contact s : repo2.queryContactsByEmailEndingWithOrEmailEndingWithOrderByFirstnameDesc("borland.com", "jetbrains.com")) {
                System.out.println(s);
            }
            System.out.println("--------------------------------------");
            for (Contact s : repo2.namedQuery1("ivanova")) {
                System.out.println(s);
            }
            System.out.println("--------------------------------------");
            System.out.println(repo2.count());
            System.out.println("--------------------------------------");
            for (Contact s : repo2.findContactsBy()) {
                System.out.println(s);
            }
           /* System.out.println("--------------------------------------");
            for (Contact s : repo2.findByFirstnameMatchesRegex("ir???")) {
                System.out.println(s);
            }*/

            System.out.println("--------------------------------------");
            for (ContactProjection cp : repo3.findByFirstname("irina")) {
                System.out.println(cp.getFirstname() + " " + cp.getLastname() + " " + cp.getContacts());
            }
            System.out.println("--------------------------------------");

            for (Contact cp : repositoryWithQueryAnnotations.testNativeQueryWithNamedParams1("irina", "petrovskaya")) {
                System.out.println(cp);
            }
            for (Contact cp : repositoryWithQueryAnnotations.testNativeQueryWithNamedParams2("irina", "petrovskaya")) {
                System.out.println(cp);
            }
            for (Contact cp : repositoryWithQueryAnnotations.testNativeQueryWithIndexedParams("irina", "petrovskaya")) {
                System.out.println(cp);
            }
            for (Contact cp : repositoryWithQueryAnnotations.testNativeQueryWithoutParams()) {
                System.out.println(cp);
            }
            System.out.println("--------------------------------------");
        };
    }
}
