package com.automationfraternity.patientapi.service;


import com.automationfraternity.patientapi.model.Product;
import com.automationfraternity.patientapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Product createNewPatient(Product product){
        patientRepository.save(product);
        return null;
    }

}
