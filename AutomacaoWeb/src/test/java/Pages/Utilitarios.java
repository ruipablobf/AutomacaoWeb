package Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Pages.Driver.driver;

public class Utilitarios {


    WebDriverWait espera;
    WebElement element;

    public void aguardarElementoSerClicavel(By elemento, int tempo) {
        espera = new WebDriverWait(driver, Duration.ofSeconds(tempo));
        element = espera.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public void aguardarElementoEstarPresente(By elemento, int tempo) {
        espera = new WebDriverWait(driver, Duration.ofSeconds(tempo));
        element = espera.until(ExpectedConditions.presenceOfElementLocated(elemento));
    }

    public void clicar(By elemento, int tempo) {
        aguardarElementoSerClicavel(elemento, tempo);
        driver.findElement(elemento).click();
    }

    public void enviarDadosCampo(By elemento, String valor, int tempo) {
        aguardarElementoEstarPresente(elemento, tempo);
        driver.findElement(elemento).sendKeys(valor);
    }

    public String armazenarTextoElemento(By elemento, int tempo) {
        aguardarElementoEstarPresente(elemento, tempo);
        return driver.findElement(elemento).getText();
    }

}
