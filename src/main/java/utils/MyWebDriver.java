package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {

    public static WebDriver driver;

    public static WebDriver inUrl(String url){
        WebDriverManager.chromedriver().driverVersion("121.0.6167.85").setup();
        driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }
}
