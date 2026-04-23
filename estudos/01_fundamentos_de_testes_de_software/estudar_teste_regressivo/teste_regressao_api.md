Teste de regressão no contexto de API + automação com RestAssured
✅ O que é regressão em API
Em API, teste de regressão significa reexecutar testes de endpoints que já funcionavam, para garantir que nenhuma mudança quebrou contratos, regras ou comportamentos existentes.
Mudanças comuns que geram regressão:

Ajuste em regra de negócio
Alteração de payload
Inclusão de novos campos
Mudança de status code
Mudança no schema de resposta
Correção de bug em outro endpoint

Mesmo que o endpoint testado não tenha sido alterado diretamente, ele pode ser impactado.

Exemplo real (bem comum)
Você tem esse endpoint:

POST /posts

Funciona assim:

Retorna 201
Cria um post
Responde com id, title, body, userId

Depois alguém:

mexe numa validação global
altera um interceptor
muda algo no backend

👉 O endpoint continua subindo, mas:

muda status para 200
remove campo userId
altera tipo de dado
quebra contrato

➡️ Teste de regressão em API pega isso automaticamente.

✅ Em RestAssured, regressão normalmente valida:

Status Code
Estrutura do JSON (schema)
Campos obrigatórios
Tipos de dados
Regras de negócio básicas
Mensagens de erro

Exemplo simples de teste de regressão com RestAssured


@Test
void deveManterContratoDoPost() {
    given()
        .spec(spec)
        .body(PostPayload.valido())
    .when()
        .post("/posts")
    .then()
        .statusCode(201)
        .body("id", notNullValue())
        .body("title", equalTo("Teste"))
        .body("userId", equalTo(1));
}


Esse teste não valida novidade, ele valida:

“Aquilo que sempre funcionou continua funcionando?”

Isso é regressão.
