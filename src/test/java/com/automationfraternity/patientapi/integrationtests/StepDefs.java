package com.automationfraternity.patientapi.integrationtests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class StepDefs {

    @Autowired
    MockMvc mockMvc;

    @Given("I have patient details as below")
    public void i_have_patient_details_as_below() {

    }
    @When("I create the patient")
    public void i_create_the_patient(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("a new patient is created")
    public void a_new_patient_is_created() {

    }
}
