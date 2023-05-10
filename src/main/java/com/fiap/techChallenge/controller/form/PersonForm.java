package com.fiap.techChallenge.controller.form;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.dominio.Person;

import jakarta.validation.constraints.NotBlank;


public class PersonForm {
    
    @JsonProperty
    @NotBlank(message = "The name field is required and must not be blank.")
    private String name;

    @JsonProperty
    @NotBlank(message = "The birthDate field is required and must not be blank.")
    private String birthDate;

    @JsonProperty
    @NotBlank(message = "The gender field is required and must not be blank.")
    private String gender;

    @JsonProperty
    @NotBlank(message = "The relative field is required and must not be blank.")
    private String relative;
    
    public Person toPersons(){
        return new Person(this.name, this.birthDate, this.gender, this.relative);
    }
}
