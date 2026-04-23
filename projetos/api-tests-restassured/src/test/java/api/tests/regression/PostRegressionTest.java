package api.tests.regression;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import api.base.BaseTest;
import api.payload.PostPayload;
import api.service.PostService;

@Tag("regression")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRegressionTest extends BaseTest {

    private final PostService postService = new PostService(spec);

    @Test
    @Order(1)
    @DisplayName("REGRESSÃO: GET /posts/1 mantém contrato básico")
    void deveManterContratoDoGetPost() {
        postService.getPost(1)
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
        postService.createPost(PostPayload.valido())
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
        postService.updatePost(1, PostPayload.atualizado())
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", equalTo("Titulo Atualizado"));
    }

    @Test
    @Order(4)
    @DisplayName("REGRESSÃO: DELETE /posts/1 responde sucesso")
    void deveDeletarPost() {
        postService.deletePost(1)
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }
}