package com.fiap.techChallenge.repositorio;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fiap.techChallenge.dominio.Appliance;

@Repository
public class ApplianceRepository {
    
    private Set<Appliance> appliances;

    public ApplianceRepository(){
        appliances = new HashSet<>();
    }

    public void save(Appliance appliance){
        appliances.add(appliance);
    }
}
