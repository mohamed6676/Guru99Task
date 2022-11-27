package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P02_Add_New_Customer_Page;
import org.testng.asserts.SoftAssert;

import static org.example.StepDefinition.Hooks.driver;

public class D02_Add_New_Customer_StepDef {
    P02_Add_New_Customer_Page a=new P02_Add_New_Customer_Page();
    @Given("user navigated to add customer page")
    public void addCustomerPage()
    {

        driver.findElement(a.getAddCustomerButton()).click();
    }
    @And("enter valid customer name{string}, gender{string}, date of birth{string} ,enter address{string}, city{string}, enter state{string}, enter pin{string}, enter mobile number{string}")
    public void enterValidData(String name,String gender,String date, String address,String city,String state,String pin,String mobile)
    {
        driver.findElement(a.getCustomer_name()).sendKeys(name);
        driver.findElement(P02_Add_New_Customer_Page.getGender(gender)).click();
//        driver.findElement(a.getGender(gender)).click();
        driver.findElement(a.getDateOfBirth()).sendKeys(date);
        driver.findElement(a.getAddress()).sendKeys(address);
        driver.findElement(a.getCity()).sendKeys(city);
        driver.findElement(a.getState()).sendKeys(state);
        driver.findElement(a.getPin()).sendKeys(pin);
        driver.findElement(a.getMobilePhone()).sendKeys(mobile);
    }
    @And("enter email{string},enter password{string}")
    public void enterEmailAndPass(String email,String pass)
    {
        driver.findElement(a.getEmail()).sendKeys(email);
        driver.findElement(a.getPassword()).sendKeys(pass);
    }
    @Then("message telling blank name is not allowed")
    public void validateNoBlankName()
    {
        String expected="Customer name must not be blank";
        String actual=driver.findElement(a.getMsgBlankName()).getText();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actual.contains(expected));
    }
    @Then("message telling blank address is not allowed")
    public void validateNoBlankAddress()
    {
        String expected="Address Field must not be blank";
        String actual=driver.findElement(a.getMsgBlankAddress()).getText();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actual.contains(expected));
    }
    @Then("message telling PIN must be 6 digits")
    public void validPinLength()
    {
        String expected="PIN Code must have 6 Digits";
        String actual=driver.findElement(a.getMsgInvalidPin()).getText();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actual.contains(expected));
    }
    @And("click submit")
    public void clickSubmit()
    {

        driver.findElement(a.getSubmit()).click();
    }
    @Then("new customer is added")
    public void addedCustomer()
    {
        SoftAssert soft=new SoftAssert();
        String expected="Customer added";
        String actual=driver.switchTo().alert().getText();
        soft.assertTrue(actual.contains(expected),"The customer was not added !");
    }
    @Then("new customer is not added")
    public void customerNotAdded()
    {
        SoftAssert soft=new SoftAssert();
        String expected="please fill all fields";
        String actual=driver.switchTo().alert().getText();
        soft.assertTrue(actual.contains(expected));
    }
}
