Feature: As a user, I am able to create, delete, update and get the patient details

  Scenario: As a client, I am able to create a new patient
    Given I have patient details as below
      | Name       | akash                  |
      | Age        | 37                     |
      | ID         | 12345                  |
      | email      | akash@akash.com        |
      | phone      | 123456789              |
      | conditions | i am just plain stupid |
    When I create the patient
    Then a new patient is created


