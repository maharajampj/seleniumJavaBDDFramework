#Author: maharaja.mpj@gmail.com
#Keywords Summary : Test Framework
Feature: Verify the landing Page Features

  @Test
  Scenario Outline: Verify the title of landing page
    Given I am on the landing page
    Then I should see the "<title>" title

    Examples: 
      | title                   |
      | WebDriverUniversity.com |

  @Test
  Scenario Outline: Verify the contact Us Page Title
    Given I am on the landing page
    Then I should navigate to contactUs from
    Then I should see the "<title>" title
    #Then I should be able to submit the form with "<sheet>"

    Examples: 
      | title      |  | sheet     |
      | Contact Us |  | contactus |
      
  @Test
  Scenario Outline: Verify the contact Us form submission
    Given I am on the landing page
    Then I should navigate to contactUs from
    Then I should see the "<title>" title
    Then user should be able to submit the form

    Examples: 
      | title      |  | sheet     |
      | Contact Us |  | contactus |
