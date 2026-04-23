Exemplo de regressão em Gherkin (BDD)
Em BDD, regressão é representada por cenários que validam comportamentos já conhecidos, geralmente críticos.

Feature focada em regressão


Feature: Regressão - Criação de Posts
  Como sistema
  Quero garantir que a criação de posts continue funcionando
  Mesmo após mudanças no backend

Cenário de regressão clássico


Scenario: Criar post com dados válidos
  Given que possuo um payload válido de post
  When envio a requisição POST para "/posts"
  Then o sistema deve responder com status 201
  And o response deve conter id, title, body e userId


Esse cenário não é “novo”.
Ele existe para garantir estabilidade.

Step Definitions (simulado, mas realista)

@Given("que possuo um payload válido de post")
public void payloadValido() {
    payload = PostPayload.valido();
}

@When("envio a requisição POST para {string}")
public void envioPost(String endpoint) {
    response = given()
        .spec(spec)
        .body(payload)
    .when()
        .post(endpoint);
}

@Then("o sistema deve responder com status {int}")
public void validaStatus(int statusCode) {
    response.then().statusCode(statusCode);
}

@And("o response deve conter id, title, body e userId")
public void validaCamposObrigatorios() {
    response.then()
        .body("id", notNullValue())
        .body("title", notNullValue())
        .body("body", notNullValue())
        .body("userId", notNullValue());
}

Isso é BDD + regressão:

Linguagem clara
Foco no comportamento estável
Fácil leitura por QA, Dev, PO




