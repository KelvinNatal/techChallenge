package com.fiap.techChallenge.repositorio;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fiap.techChallenge.dominio.Person;

@Repository
public class PersonRepository {

    private Set<Person> persons;

    public PersonRepository(){
        persons =  new HashSet<>();
    }

    public void save(Person person){
        persons.add(person);
    }
    
}
