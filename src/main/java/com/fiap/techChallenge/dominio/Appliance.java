package com.fiap.techChallenge.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Appliance {
    
    @JsonProperty
    private String name;

    @JsonProperty
    private String model;

    @JsonProperty
    private String power;
   
}
