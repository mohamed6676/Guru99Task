package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_Login_Page;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import static org.example.StepDefinition.Hooks.driver;

public class D01_Login_StepDef {
    P01_Login_Page p=new P01_Login_Page();
    @Given("User navigated to home page")
    public void get_home_page()
    {
        driver.get("https://www.demo.guru99.com/V4/index.php");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }
    @And("User enter valid user{string} and password{string}")
    public void valid_credentials(String user,String pass)
    {
        driver.findElement(p.getUser_name()).sendKeys(user);
        driver.findElement(p.getPassword()).sendKeys(pass);
    }
    @And("User click Login")
    public void click_login() throws InterruptedException {
        driver.findElement(p.getLogin_button()).click();
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    }
    @Then("User could login successfully")
    public void login_success()
    {
        SoftAssert soft=new SoftAssert();
        String actual=driver.findElement(p.getLogin_message()).getText();
        String expected="Manger Id : mngr456686";
        soft.assertTrue(actual.contains(expected),"User couldn't login");
//        Assert.assertTrue(actual.contains(expected),"User couldn't login");
    }
    @And("User enter invalid user{string} and valid password{string}")
    public void invalidUser(String user,String pass)
    {
        driver.findElement(p.getUser_name()).sendKeys(user);
        driver.findElement(p.getPassword()).sendKeys(pass);
    }
    @Then("User could not login")
    public void login_fail()
    {
        SoftAssert soft=new SoftAssert();
        String actual=driver.switchTo().alert().getText();
        String expected="User or Password is not valid";
        soft.assertTrue(actual.contains(expected));
//        Assert.assertTrue(actual.contains(expected));
    }
    @And("User enter valid user{string} and invalid password{string}")
    public void invalidPass(String user,String pass)
    {
        driver.findElement(p.getUser_name()).sendKeys(user);
        driver.findElement(p.getPassword()).sendKeys(pass);
    }
}
