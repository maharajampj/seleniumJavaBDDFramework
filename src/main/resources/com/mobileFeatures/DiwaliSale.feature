#Author: maharaja.mpj@gmail.com
#Keywords Summary : Test Framework
Feature: Verify the landing Page Features

  @Test1
  Scenario: Verify the App is loaded
    Given I am on the device
    Then I should see app loaded

  @Test
  Scenario Outline: Verify the App is loaded
    Given I am on the device
    Then I should see app loaded
    Then I should move to Register Page
    Then I should fill "<name>" and "<email>" and "<password>" and "<phonenumber>"

    Examples: 
      | name |  | email            |  | password    |  | phonenumber |
      | Maha |  | maha@yopmail.com |  | Maha!@#1234 |  |  9876543210 |
