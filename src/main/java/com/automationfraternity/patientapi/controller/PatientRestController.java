package com.automationfraternity.patientapi.controller;

import com.automationfraternity.patientapi.model.Product;
import com.automationfraternity.patientapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class PatientRestController {

    @Autowired
    PatientService patientService;

    @PostMapping("/patient")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product createPatient(@RequestBody Product product){
        return patientService.createNewPatient(product);

    }
}
