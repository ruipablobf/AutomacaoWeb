package org.example.produtoapi;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ProdutoController {
    private static final String produto = "https://dummyjson.com/products/";

    public void adicionarProduto(String nomeProduto){
        try{
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body("{title: '"+nomeProduto+"'}")
                    .when()
                    .post(produto + "add")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
            if (response.getStatusCode() == 200) {
                System.out.println("Produto adicionado com sucesso");
            }
        } catch (Exception e) {
            Assertions.fail("Não foi possível adicionar o produto");
        }
    }

    public void buscarProduto(String idProduto){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(produto + idProduto)
                .then()
                .statusCode(200)
                .extract()
                .response();
        if (response.getStatusCode() == 200) {
            System.out.println("Produto localizado com sucesso");
        }

        String responseBody = response.getBody().asString();

        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray jsonArrayProduto = jsonObject.getJSONArray("produtos");
    }
}
