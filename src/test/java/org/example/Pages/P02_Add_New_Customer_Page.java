package org.example.Pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

public class P02_Add_New_Customer_Page {
    private static final By addCustomerButton=By.cssSelector("a[href=\"addcustomerpage.php\"]");
    public By getAddCustomerButton()
    {

        return addCustomerButton;
    }
    private static final By customer_name=By.cssSelector("input[name=\"name\"]");
    public By getCustomer_name()
    {

        return customer_name;
    }
    private static By  gender(@NotNull String letter)
    {
        By gen=null;
        if(letter.equalsIgnoreCase("m"))
        {
            gen=By.cssSelector("input[value=\"m\"]");
        }
        else if (letter.equalsIgnoreCase("f"))
        {
            gen=By.cssSelector("input[value=\"f\"]");
        }
        return gen;
    }
    public static By getGender(String letter)
    {

        return gender(letter);
    }
    private static final By dateOfBirth=By.id("dob");
    public By getDateOfBirth()
    {

        return dateOfBirth;
    }
    private static final By address=By.name("addr");
    public By getAddress()
    {

        return address;
    }
    private static final By city=By.name("city");
    public By getCity()
    {

        return city;
    }
    private static final By state=By.name("state");
    public By getState()
    {

        return state;
    }
    private static final By pin=By.name("pinno");
    public By getPin()
    {

        return pin;
    }
    private static final By mobilePhone=By.name("telephoneno");
    public By getMobilePhone()
    {

        return mobilePhone;
    }
    private static final By email=By.name("emailid");
    public By getEmail()
    {

        return email;
    }
    private static final By password=By.name("password");
    public By getPassword()
    {

        return password;
    }
    private static final By submit=By.name("sub");
    public By getSubmit()
    {

        return submit;
    }
    private static final By msgBlankName=By.id("message");
    public By getMsgBlankName()
    {

        return msgBlankName;
    }
    private static final By msgBlankAddress=By.id("message3");
    public By getMsgBlankAddress()
    {

        return msgBlankAddress;
    }
    private static final By msgInvalidPin=By.id("message6");
    public By getMsgInvalidPin()
    {

        return msgInvalidPin;
    }

}
