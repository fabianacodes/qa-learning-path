package api.payload;

public class PostPayload {

    private Integer id;
    private String title;
    private String body;
    private Integer userId;

    public PostPayload() {}

    public PostPayload(Integer id, String title, String body, Integer userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public static PostPayload valido() {
        return new PostPayload(null, "Teste Regressao", "Conteudo do post", 1);
    }

    public static PostPayload atualizado() {
        return new PostPayload(1, "Titulo Atualizado", "Body Atualizado", 1);
    }

    // Getters/Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
}
