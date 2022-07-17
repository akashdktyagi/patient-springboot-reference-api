package com.automationfraternity.patientapi.service;


import com.automationfraternity.patientapi.model.Patient;
import com.automationfraternity.patientapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient createNewPatient(Patient patient){
        return patientRepository.save(patient);
    }

}
