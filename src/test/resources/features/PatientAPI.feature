Feature: As a user, I am able to create, delete, update and get the patient details

  Scenario: As a client, I am able to create a new patient
    Given I have application up and running
    When I create the patient with below details
      | Name       | akash                  |
      | Age        | 37                     |
      | ID         | 12345                  |
      | email      | akash@akash.com        |
      | phone      | 123456789              |
      | conditions | i am just plain stupid |
    Then a new patient is being created


