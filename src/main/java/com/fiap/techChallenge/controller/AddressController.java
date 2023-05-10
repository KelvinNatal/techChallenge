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
import com.fiap.techChallenge.controller.form.AddressForm;
import com.fiap.techChallenge.dominio.Address;
import com.fiap.techChallenge.repositorio.AddressRepository;

import jakarta.validation.Path;

@RestController
@RequestMapping("/v1/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ValidateForm validateForm;

    // @GetMapping()
    // public String mostrarEnderecos(@RequestParam(name="rua") String rua){
    //     Endereco endereco = enderecoRepository.buscar(rua).orElse(new Endereco());

    
    //     return String.format("Rua: %s", endereco.getRua());
    // }
    
    @PostMapping()
    public ResponseEntity addressRegister(@RequestBody AddressForm addressForm){    

        Map<Path, String> violationsToMap = validateForm.validateForm(addressForm);
        if(!violationsToMap.isEmpty()) return ResponseEntity.badRequest().body(violationsToMap);

        Address address = addressForm.toAddress();
        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body("The Address register was successfully!");
    }
}
