Feature: Manipulation of clients

  Scenario: 01 - Adding a client
    Given I have no clients in database
    When I receive the request to add a client with the body
      | firstName | lastName | middleName | dateOfBirth | placeOfBirth | email             |
      | ysf       | jmr      | none       | 1995-11-04  | bg           | ysf.jmr@email.com |
    Then Response should be ok
    And Database should contain
      | firstName | lastName | middleName | dateOfBirth | placeOfBirth | email             | enrollmentDate |
      | ysf       | jmr      | none       | 1995-11-04  | bg           | ysf.jmr@email.com | CURRENT_DATE   |