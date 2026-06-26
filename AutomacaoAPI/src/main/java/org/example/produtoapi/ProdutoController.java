package org.example.produtoapi;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ProdutoController {
    private static final String produto = "https://dummyjson.com/products/";
    String responseBody;
    JSONObject jsonObject;

    public void adicionarProduto(String nomeProduto){
        try{
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body("{\"title\": \"" + nomeProduto + "\"}")
                    .when()
                    .post(produto + "add")
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();
            responseBody = response.getBody().asString();
            jsonObject = new JSONObject(responseBody);

            System.out.println("Produto adicionado com sucesso");
            System.out.println("ID: " + jsonObject.get("id") +
                    "\nTitle: " + jsonObject.get("title"));
        } catch (Exception e) {
            Assertions.fail("Não foi possível apresentar os dados de retorno da api");
        }
    }

    public void buscarProduto(String idProduto){
        try{
            Response response = given()
                    .header("Content-Type", "application/json")
                    .when()
                    .get(produto + idProduto)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
            responseBody = response.getBody().asString();
            jsonObject = new JSONObject(responseBody);

            System.out.println("Produto retornado com sucesso");
            System.out.println("ID: " + jsonObject.get("id") +
                    "\nTitle: " + jsonObject.get("title") +
                    "\nDescription: " + jsonObject.get("description"));
        } catch (Exception e) {
            Assertions.fail("Não foi possível apresentar os dados de retorno da api");
        }
    }
}
