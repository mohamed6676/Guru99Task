@Runner
  Feature: Login Functionality
    Scenario: User could login with valid credentials
      Given User navigated to home page
      And User enter valid user"mngr464465" and password"ypuzupa"
      And User click Login
      Then User could login successfully

    Scenario: User could not login with invalid user and valid password
      Given User navigated to home page
      And User enter invalid user"dfd" and valid password"ypuzupa"
      And User click Login
      Then User could not login

    Scenario: User could not login with invalid password and valid user
      Given User navigated to home page
      And User enter valid user"mngr464465" and invalid password"fdfd"
      And User click Login
      Then User could not login