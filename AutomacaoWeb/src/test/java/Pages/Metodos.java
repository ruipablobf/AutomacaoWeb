package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static Pages.Driver.driver;

public class Metodos extends Utilitarios {

    public String valorTelaProduto;
    public String valorProdutoCarrinho;
    public By componenteDePesquisa = By.xpath("//input[@id='headerSearch']");
    public By lupaPesquisa = By.xpath("//input[@id='headerSearch']//following-sibling::ptz-icon");
    public By valorProdutoTela = By.xpath("//p[@class='text-ptz-md font-bold']");
    public By valorProdutoTelaCarrinho = By.xpath("//div[@data-testid='ptz-bag-resume-amount']");
    public By botaoCookies = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    public By textoTela(String texto) {
        return By.xpath("//p[contains(text(),'" + texto + "')]");
    }

    public By botao(String nomeBotao) {
        return By.xpath("//button[not(@disabled)]//span[@data-testid='ptz-button-" + nomeBotao.trim() + "-span']");
    }

    public void abrirURL(String url) {
        driver.get(url);
    }

    public void fecharCookies() {
        if (elementoEstaPresente(botaoCookies, 30)) {
            clicar(botaoCookies, 30);
        }
    }

    public void pesquisaProduto(String produto) throws InterruptedException {
        try {
            Thread.sleep(3000);
            aguardarElementoEstarPresente(componenteDePesquisa, 30);
            clicar(componenteDePesquisa, 30);
            enviarDadosCampo(componenteDePesquisa, produto, 15);
            clicar(lupaPesquisa, 30);
        } catch (Exception e) {
            Assertions.fail("Não foi possível pesquisar o produto");
        }

    }

    public void acessarProdutoPesquisa(String produto) throws InterruptedException {
        try {
            aguardarElementoEstarPresente(textoTela(produto), 30);
            Thread.sleep(3000);
            clicar(textoTela(produto), 30);
        } catch (Exception e) {
            Assertions.fail("Não foi possível acessar o produto");
        }
    }

    public void armazenarValorProdutoEClicarBotao(String nomeBotao) {
        try {
            aguardarElementoEstarPresente(valorProdutoTela, 30);
            valorTelaProduto = armazenarTextoElemento(valorProdutoTela, 30).replace("\u00A0", " ").replaceAll("\\s+", " ").trim();
            System.out.println("Valor do produto: " + valorTelaProduto);
            clicar(botao(nomeBotao), 30);
        } catch (Exception e) {
            Assertions.fail("Não foi possível armazenar o valor do produto e clicar no botão");
        }
    }

    public void acessarCarrinho(String nomeBotao) {
        try {
            aguardarElementoEstarPresente(botao(nomeBotao), 30);
            clicar(botao(nomeBotao), 30);
        } catch (Exception e) {
            Assertions.fail("Não foi possível acessar o carrinho");
        }

    }

    public void armazenarValorProdutoCarrinho() {
        try {
            aguardarElementoEstarPresente(valorProdutoTelaCarrinho, 30);
            valorProdutoCarrinho = armazenarTextoElemento(valorProdutoTelaCarrinho, 30).replace("\u00A0", " ").replaceAll("\\s+", " ").trim();
            System.out.println("Valor do produto no carrinho: " + valorProdutoCarrinho);
        } catch (Exception e) {
            Assertions.fail("Não foi possível armazenar o valor do produto no carrinho");
        }

    }

    public void compararValores() {
        if (valorProdutoCarrinho.equals(valorTelaProduto)) {
            Assertions.assertEquals(valorProdutoCarrinho, valorTelaProduto);
            System.out.println("Os valores são iguais");
        } else {
            Assertions.fail("Os valores são diferentes");
        }
    }
}
