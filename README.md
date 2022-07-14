# patient-springboot-reference-api
This repository is to hold a reference spring boot api and tutorial. This repo is a a sub project under gotocloud-appointment-app project.


---
Step by Step Guide. All the steps are managed in side different Branches.



* We want to develop our API using Behaviour Driven Development methodology.
* Advantages of this approach is quite simple. If you want your API to conform with the requirements given to you by the Business and you want to be absolutly sure that you have impl all the requirement and user journeys which Business asked you to do.
* Is your API Impl "validatable" from Business person perspective.

### Steps to Follow: Keep Checkout the branch to see the changes done. Steps are managed under the branches to easily witness the changes made in each step.
  
* Checkout Branch: ```1_feature_file_cucumber_setup```:
    * Add cucumber related libraries in the pom.xml file. 
        * below cucumber libraries are necessary
            * ```xml
                  <dependency>
                    <groupId>io.cucumber</groupId>
                    <artifactId>cucumber-java</artifactId>
                    <version>${cucumber.version}</version>
                    <scope>test</scope>
                  </dependency>
          
                <dependency>
                  <groupId>io.cucumber</groupId>
                  <artifactId>cucumber-junit</artifactId>
                  <version>${cucumber.version}</version>
                </dependency>
          
                <dependency>
                  <groupId>io.cucumber</groupId>
                  <artifactId>cucumber-spring</artifactId>
                  <version>${cucumber.version}</version>
                  <scope>test</scope>
                </dependency>
          
                <dependency>
                  <groupId>io.cucumber</groupId>
                  <artifactId>cucumber-junit-platform-engine</artifactId>
                  <version>${cucumber.version}</version>
                </dependency>
              ```
    * Now run your Feature file (You need cucumber plugin in your intelliJ/IDE), it will fail and will ask you to add a CucumberSpringConfiguration file. 
    * Add this file: 
      ```java
          import io.cucumber.spring.CucumberContextConfiguration;
          import org.springframework.boot.test.context.SpringBootTest;

          @SpringBootTest
          @CucumberContextConfiguration
          public class CucumberSpringConfiguration {
          }
      ```
    * After adding this file, please run the feature file again.
    * If will fail again, but will fail do to missing implimentation of the cucumber Steps:
        ```java
            
            //Step undefined
            //You can implement this step and 2 other step(s) using the snippet(s) below:
            
            @Given("I have application up and running")
            public void i_have_application_up_and_running() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
            }
      
            ...
        ```
* Checkout Branch: ```2_add_cucumber_stepdef```
    * Run the Feature file again and this time you will see the step defs in the console as mentioned in above code snippet.
    * Copy the methods names and create a new class under integrationtests package and save the methods there.
    * Run the feature file again and this time there will be failure but different kind of error.
    * New Error will now say, pending steps, this is how cucumber is asking you to implement the test.
      * ```text
            
        Step pending
        TODO: implement me
        
        ```
        
    * You can now write tests which resembles the functinality or Behaviour which we created earlier in Gherkin or in our PatientApi.feature file. 
      In the next step/branch we will implement our test.
    * Those test will fail again, but still we will implement it. Because we are going BDD but also adopting how TDD is practiced. i.e. you write the test and then run it and then fix the errors and then run it again. Simple! The same sort of approach is what we are trying to do. 
    * But to highlight, we are not entirely doing a TDD or test driven development at the moment. We are still doing BDD, but TDD style!!
    * So far, our tests are failing but they are not failing due to api's expected functional behaviour or so to say, what this api should do. Lets implement the test in the next steps.

* Checkout Branch: ```3_added_mock_mvc_config_and_steps```
    * Well now in this step we will use Spring's Mock Mvc class to write our test.
    * MockMvc is a class which has all the necessary methods to make an http call and we can set the verb i.e. get/post/put/delete and other relevant information like contentType, Body, headers etc.
    * To make it work, we need two more additional settings, 1. we need to tell Spring to Auto Configure this Bean or Object which is MockMvc and all its dependencies. This we will do in "CucumberSpringConfiguration.class".
    * Secondly, we need to inject this MockMvc object in our StepDefs.class file so that we can use its methods to perform http calls on our "yet to be creatd", api post end point. This we do by using another annotation called  @AutoWired. This annotation is responsible for injecting the bean or object in our Step Def class file. This is also called as Dependency Injection and this concept is at the heart of Spring frameworks."
    * Once, we do this we can then use this object to write our test which is structured with in the cucumber methods.
    * See the StepDef.class under test folder.
    * From feature file, we are sending some data, which is what we are capturing in the Given step using map collection type.
    * We are then converting the data in to a string for our request and in the when step we are performing the post operation.
    * In the last step we are using a assertion statement to validate that the response of the call has status code as '201'. This is the most important step of the test and this detemines what to expect from a user Scenario expressed in Gherkin feature file.
    * And we will do again, what we always do, i.e. we will Run the Feature file. And this time when you will run it, two steps will pass and one fail with the reason that API did not respond with status as "201". Which is obvious because, API is not yet created and localhost server send 404 status code in reply.
        * Error:
           ```text
            Step failed
            java.lang.AssertionError: Response status expected:<201> but was:<404>
          
            ```

* Checkout Branch: ```4_impl_controller_post_end_point```
    * Now enough of tests. Now I need to make this test pass.
    * So, I will start Controller Class. This class is the face of our rest full API.
    * This controller class will receive the request from the client software and it will reroute it to the relevant business logic and pass the sent data to that Business Login Method.
    * Then I will add the controller class.
    * ```java
        @RestController
        @RequestMapping("/")
        public class PatientRestController {
        
            @PostMapping("/patient")
            public String createPatient(){
                return "";
            }
        }
        ```
    * I have added three main annotations here, @RestController, @RequestMapping and @PostMapping. This is returing an empty string.
    * One more important change I have made here in this step. I have added a ```application.yml``` file. This file contains all the necessary Spring configuration settings. Currently, it has just one setting i.e. port number. I have set up as 9096, you can choose valid port.
    * I have also modified, the server name in the test to point to http://localhost:9096
    * And now when I ran my test, the result was better than before; i.e. I am able to get a valid reply from the api i.e. status 200. 
    * But I know this is not correct and I need to implement more things, i.e Model class, DB connections, Service Class etc. All that we will do in next step.
    