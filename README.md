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
    * Run the Feature file again and this time you will see the step defs in the console as mentioned in above
    * Copy the methods names and create a new class under integrationtests package and save the methods there.
    * Run the feature file again and this time there will be failure but different one.
    * New Error will now say, pending steps, this is how cucumber is asking you to implement the test. 
    * You can now write tests which resembles the functinality. In the next step/branch we will implement our test.
    * Those test will again, but still we will implement it. Because we are going BDD but also adopting how TDD is practiced.
    