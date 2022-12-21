package org.example.StepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void openBrowser()
    {
        ChromeOptions option=new ChromeOptions();
        option.addExtensions(new File("app.crx"));
        driver= new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        ArrayList<String> tab=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
        String main=driver.getWindowHandle();
        for(String child:tab)
        {
            if(!child.equalsIgnoreCase(main))
            {
                driver.switchTo().window(child);
                driver.close();
            }
        }
        driver.switchTo().window(main);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }
    @After
    public static void closeBrowser()
    {

        driver.quit();
    }
}
