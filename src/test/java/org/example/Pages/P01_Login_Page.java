package org.example.Pages;

import org.openqa.selenium.By;

public class P01_Login_Page {
    private static final By user_name=By.name("uid");
    public By getUser_name()
    {

        return user_name;
    }
    private static final By password=By.name("password");
    public By getPassword()
    {

        return password;
    }
    private static final By login_button=By.name("btnLogin");
    public By getLogin_button()
    {

        return login_button;
    }
    private static final By login_message=By.cssSelector("td[style=\"color: green\"]");
    public By getLogin_message()
    {

        return login_message;
    }

}
