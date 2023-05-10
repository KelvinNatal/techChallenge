package com.fiap.techChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.dominio.Appliance;

import jakarta.validation.constraints.NotBlank;

public class ApplianceForm {
    
    @JsonProperty
    @NotBlank(message = "The name field is required and must not be blank.")
    private String name;

    @JsonProperty
    @NotBlank(message = "The model field is required and must not be blank.")
    private String model;

    @JsonProperty
    @NotBlank(message = "The power field is required and must not be blank.")
    private String power;

    public Appliance toAppliance(){
        return new Appliance(this.name, this.model, this.power);
    }
}
