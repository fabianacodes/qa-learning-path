package api.tests;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import api.base.BaseTest;
import api.payload.PostPayload;
import api.service.PostService;

@Tag("smoke")
public class PostTests extends BaseTest {

    private final PostService postService = new PostService(spec);

    @Test
    @DisplayName("SMOKE: GET /posts/1 responde 200")
    void smokeGetPost() {
        postService.getPost(1)
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    @DisplayName("SMOKE: POST /posts responde 201 e retorna id")
    void smokeCreatePost() {
        postService.createPost(PostPayload.valido())
                .then()
                .statusCode(201)
                .body("id", notNullValue());
    }
}