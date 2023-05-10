package com.fiap.techChallenge.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.techChallenge.config.ValidateForm;
import com.fiap.techChallenge.controller.form.ApplianceForm;
import com.fiap.techChallenge.dominio.Appliance;
import com.fiap.techChallenge.repositorio.ApplianceRepository;

import jakarta.validation.Path;

@RestController
@RequestMapping("/v1/appliance")
public class ApplianceController {

    @Autowired
    private ApplianceRepository applianceRepository;

    @Autowired
    private ValidateForm validateForm;

    @PostMapping
    public ResponseEntity applianceResgister(@RequestBody ApplianceForm appliancesForm){

        Map<Path, String> validationsMap = validateForm.validateForm(appliancesForm);

        if(!validationsMap.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationsMap);
        
        Appliance appliance = appliancesForm.toAppliance();
        applianceRepository.save(appliance);
        return ResponseEntity.status(HttpStatus.CREATED).body("The Appliance register was successfully!");
    }
}
