package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;
    @Before
    public void iniciarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void fecharDriver() {
        driver.quit();
    }
}
