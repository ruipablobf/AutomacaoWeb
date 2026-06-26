package org.example.produtoapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.example.produtoapi.Driver.driver;

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
        return driver.findElement(elemento).getAttribute("textContent");
    }

    public boolean elementoEstaPresente(By elemento, int tempo) {
        aguardarElementoEstarPresente(elemento, tempo);
        return driver.findElement(elemento).isDisplayed();
    }
}
