package com.automationfraternity.patientapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PatientRestController {

    @PostMapping("/patient")
    public String createPatient(){
        return "";
    }
}
