package com.automationfraternity.patientapi.service;


import com.automationfraternity.patientapi.model.Patient;
import com.automationfraternity.patientapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient createNewPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getPatient() {
        return patientRepository.findAll();
    }

    public List<Patient> getPatient(String email) {
        return patientRepository.findByEmail(email);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> deletePatient(String email) {
        List<Patient> patient = patientRepository.findByEmail(email);
        patientRepository.deleteByEmail(email);
        return patient;
    }
}
