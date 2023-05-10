package com.fiap.techChallenge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.techChallenge.config.ValidateForm;
import com.fiap.techChallenge.controller.form.PersonForm;
import com.fiap.techChallenge.dominio.Person;
import com.fiap.techChallenge.repositorio.PersonRepository;

import jakarta.validation.Path;


@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ValidateForm validateForm;
    
    @PostMapping
    public ResponseEntity personResgister(@RequestBody PersonForm personsForm){

        Map<Path, String> violationsToMap = validateForm.validateForm(personsForm);
        if(!violationsToMap.isEmpty()) return ResponseEntity.badRequest().body(violationsToMap);

        Person person = personsForm.toPersons();
        personRepository.save(person);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Person register was successfully!");
    }
}
