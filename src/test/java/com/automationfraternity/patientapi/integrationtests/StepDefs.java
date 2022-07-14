package com.automationfraternity.patientapi.integrationtests;

import com.automationfraternity.patientapi.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Map;

public class StepDefs {

    String server = "http://localhost:9096";
    String postEndPoint = "/patient";
    String body = "";
    ResultActions resultsAction;

    @Autowired
    MockMvc mockMvc;

    @Given("I have patient details as below")
    public void i_have_patient_details_as_below(Map<String,String> data) throws JsonProcessingException {
        String name = data.get("name");
        String age = data.get("age");
        String email = data.get("email");
        String phone = data.get("phone");
        String medicalConditions = data.get("medicalConditions");

        Product product = Product.builder()
                .withName(name)
                .withAge(age)
                .withEmail(email)
                .withPhone(phone)
                .withMedicalConditions(medicalConditions)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        body = objectMapper.writeValueAsString(product);

//        body = "{\"name\": "+name+",\n" +
//                "\"age\": "+age+",\n" +
//                "\"email\": "+email+",\n" +
//                "\"phone\": "+phone+",\n" +
//                "\"medicalConditions\": "+medicalConditions+"\n" +
//                "},";
    }

    @When("I create the patient")
    public void i_create_the_patient() throws Exception {
        resultsAction = mockMvc.perform(
                            post(URI.create(server + postEndPoint))
                            .contentType("application/json")
                            .content(body)
                        );
    }
    @Then("a new patient is created")
    public void a_new_patient_is_created() throws Exception {
        resultsAction.andExpect(status().is(201));
        resultsAction.andExpect(content().string("akash"));
    }
}
