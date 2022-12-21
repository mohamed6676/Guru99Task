@Runner
  Feature: Adding new Customer Functionality
    Background: User previously logged in
      Given User navigated to home page
      And User enter valid user"mngr464465" and password"ypuzupa"
      And User click Login
      Then User could login successfully

    Scenario: Adding new Customer with valid data
      Given user navigated to add customer page
      And enter valid customer name"moh", gender"m", date of birth"03032011" ,enter address"cairo", city"cairo", enter state"Egypt", enter pin"001098", enter mobile number"0133332"
      And enter email"mngr456686",enter password"vYmUpem"
      And click submit
      Then new customer is added

    Scenario: Adding new Customer leaving name field empty
      Given user navigated to add customer page
      And enter valid customer name"", gender"f", date of birth"03032011" ,enter address"cairo", city"cairo", enter state"Egypt", enter pin"001", enter mobile number"0133332"
      And enter email"mngr456686",enter password"vYmUpem"
      Then message telling blank name is not allowed
      And click submit
      Then new customer is not added

    Scenario:  Adding new Customer leaving address field empty
      Given user navigated to add customer page
      And enter valid customer name"moh", gender"m", date of birth"03032011" ,enter address"", city"cairo", enter state"Egypt", enter pin"001", enter mobile number"0133332"
      And enter email"mngr456686",enter password"vYmUpem"
      Then message telling blank address is not allowed
      And click submit
      Then new customer is added

    Scenario: Adding new Customeer entering pin less than 6 digits
      Given user navigated to add customer page
      And enter valid customer name"moh", gender"m", date of birth"03032011" ,enter address"cairo", city"cairo", enter state"Egypt", enter pin"001", enter mobile number"0133332"
      And enter email"mngr456686",enter password"vYmUpem"
      Then message telling PIN must be 6 digits
      And click submit
      Then new customer is added