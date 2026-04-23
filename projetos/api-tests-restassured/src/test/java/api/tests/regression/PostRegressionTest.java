package api.tests.regression;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

@Tag("regression")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRegressionTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @Order(1)
    @DisplayName("REGRESSÃO: GET /posts/1 mantém contrato básico")
    void deveManterContratoDoGetPost() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("userId", instanceOf(Integer.class))
            .body("id", instanceOf(Integer.class))
            .body("title", not(isEmptyOrNullString()))
            .body("body", not(isEmptyOrNullString()));
    }

    @Test
    @Order(2)
    @DisplayName("REGRESSÃO: POST /posts cria post e retorna id")
    void deveCriarPostERetornarId() {

        String payload = """
            {
              "title": "Teste Regressao",
              "body": "Conteudo do post",
              "userId": 1
            }
            """;

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("Teste Regressao"))
            .body("userId", equalTo(1));
    }

    @Test
    @Order(3)
    @DisplayName("REGRESSÃO: PUT /posts/1 atualiza post com sucesso")
    void deveAtualizarPost() {

        String payload = """
            {
              "id": 1,
              "title": "Titulo Atualizado",
              "body": "Body Atualizado",
              "userId": 1
            }
            """;

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .put("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", equalTo("Titulo Atualizado"));
    }

    @Test
    @Order(4)
    @DisplayName("REGRESSÃO: DELETE /posts/1 responde sucesso")
    void deveDeletarPost() {
        given()
            .accept(ContentType.JSON)
        .when()
            .delete("/posts/1")
        .then()
            .statusCode(anyOf(is(200), is(204)));
    }
}
