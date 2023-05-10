package com.fiap.techChallenge.repositorio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fiap.techChallenge.dominio.Address;

@Repository
public class AddressRepository {

    private Set<Address> adresses;

    public AddressRepository(){
        adresses = new HashSet<>();
    }

    // public Set<Endereco> mostrar(){
    //     return enderecos;
    // }

    public Optional<Address> find(String street){
        return adresses.stream().filter(address -> address.identifiedBy(street)).findFirst();
    }

    public void save(Address address){
        adresses.add(address);
    }
    
}
