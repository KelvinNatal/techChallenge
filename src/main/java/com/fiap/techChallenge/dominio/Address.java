package com.fiap.techChallenge.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@AllArgsConstructor
@EqualsAndHashCode
public class Address {
    
    @JsonProperty
    private String street;

    @JsonProperty
    private int number;

    @JsonProperty
    private String neighborhood;

    @JsonProperty
    private String city;

    @JsonProperty
    private String state;

    public boolean identifiedBy(String street){
        return this.street.equals(street);
    }
}
