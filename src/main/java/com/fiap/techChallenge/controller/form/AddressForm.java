package com.fiap.techChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.dominio.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AddressForm {
    
    @JsonProperty
    @NotBlank(message = "The street field is required and must not be blank.")
    private String street;

    @JsonProperty
    @Positive(message = "The number field is required and must not be blank.")
    private int number;

    @JsonProperty
    @NotBlank(message = "The neighborhood field is required and must not be blank.")
    private String neighborhood;

    @JsonProperty
    @NotBlank(message = "The city field is required and must not be blank.")
    private String city;

    @JsonProperty
    @NotBlank(message = "The state field is required and must not be blank.")
    private String state;

    public Address toAddress(){
        return new Address(street, number, neighborhood, city, state);
    }

}
