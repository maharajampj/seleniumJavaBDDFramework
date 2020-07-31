#Author: maharaja.mpj@gmail.com
#Keywords Summary : Test Framework

Feature: Verify the landing Page
  

  @Test
  Scenario Outline: Verify the title of landing page
    Given I am on the landing page
    Then  I should see the <title> title
    
    Examples:
    |title|
    |WebDriverUniversity.com|


