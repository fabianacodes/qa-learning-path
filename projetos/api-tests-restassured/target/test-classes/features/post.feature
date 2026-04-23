@regression
Feature: Regressão - Posts

  Scenario: GET /posts/1 mantém contrato básico
    Given que a API está disponível
    When eu faço GET em "/posts/1"
    Then a resposta deve ter status 200
    And o contrato do post deve ser válido

  Scenario: POST /posts cria post e retorna id
    Given que possuo um payload válido de post
    When eu faço POST em "/posts"
    Then a resposta deve ter status 201
    And deve retornar um id