package Pages;

import org.openqa.selenium.By;

import static Pages.Driver.driver;

public class Metodos extends Utilitarios {

    public String valorTelaProduto;
    public String valorProdutoCarrinho;
    public By componenteDePesquisa = By.xpath("//input[@id='headerSearch']");
    public By lupaPesquisa = By.xpath("//input[@id='headerSearch']//following-sibling::ptz-icon");
    public By valorProdutoTela = By.xpath("//p[@class='text-ptz-md font-bold']");
    public By valorProdutoTelaCarrinho = By.xpath("//div[@data-testid='ptz-bag-resume-amount']");

    public By textoTela(String texto) {
        return By.xpath("//p[contains(text(),'"+texto+"')]");
    }

    public By botao(String nomeBotao) {
        return By.xpath("//button[not(@disabled)]//span[@data-testid='ptz-button-" + nomeBotao.trim() + "-span']");
    }

    public void abrirURL(String url) {
        driver.get(url);
    }

    public void pesquisaProduto(String produto) {
        aguardarElementoEstarPresente(componenteDePesquisa, 30);
        clicar(componenteDePesquisa, 30);
        enviarDadosCampo(componenteDePesquisa, produto, 15);
        clicar(lupaPesquisa, 30);
    }

    public void acessarProdutoPesquisa(String produto) {
        aguardarElementoEstarPresente(textoTela(produto), 30);
        clicar(textoTela(produto), 30);
    }

    public void armazenarValorProdutoEClicarBotao(String nomeBotao) {
        aguardarElementoEstarPresente(valorProdutoTela, 30);
        valorTelaProduto = armazenarTextoElemento(valorProdutoTela, 30);
        System.out.println("Valor do produto: " + valorTelaProduto);
        clicar(botao(nomeBotao), 30);
    }

    public void acessarCarrinho(String nomeBotao) {
        aguardarElementoEstarPresente(botao(nomeBotao), 30);
        clicar(botao(nomeBotao), 30);
    }

    public void armazenarValorProdutoCarrinho() {
        aguardarElementoEstarPresente(valorProdutoTelaCarrinho, 30);
        valorProdutoCarrinho = armazenarTextoElemento(valorProdutoTelaCarrinho, 30);
        System.out.println("Valor do produto: " + valorProdutoCarrinho);
    }

    public void compararValores() {
        if (valorProdutoTelaCarrinho == valorProdutoTela) {
            System.out.println("Os valores são iguais");
        } else {
            System.out.println("Os valores são diferentes");
        }
    }
}
