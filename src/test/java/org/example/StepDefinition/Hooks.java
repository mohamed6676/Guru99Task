package org.example.StepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        String path=System.getProperty("user.dir");
        Map<String,Object>prefs=new HashMap<String,Object>();
        prefs.put("download.default_directory",path+"\\src\\main\\resources");
        ChromeOptions option=new ChromeOptions();
        option.setExperimentalOption("prefs",prefs);
        option.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        option.addExtensions(new File("app.crx"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
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
