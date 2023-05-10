package com.fiap.techChallenge.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@AllArgsConstructor
@EqualsAndHashCode
public class Person {

    @JsonProperty
    private String name;

    @JsonProperty
    private String birthDate;

    @JsonProperty
    private String gender;

    @JsonProperty
    private String relative;
    
}
