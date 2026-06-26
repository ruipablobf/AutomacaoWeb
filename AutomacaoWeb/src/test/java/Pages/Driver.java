package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Driver {
    public static WebDriver driver;
    @Before
    public void iniciarDriver() {
        driver = new ChromeDriver(chromeOptions());

    }

    @After
    public void fecharDriver() {
        driver.quit();
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        return options;
    }
}
