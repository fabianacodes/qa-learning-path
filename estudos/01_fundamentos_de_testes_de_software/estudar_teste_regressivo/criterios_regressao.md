# ✅ Critérios: O que entra em uma Suíte de Regressão

Esta é uma das partes **mais importantes da estratégia de testes**.  
É aqui que o QA demonstra **maturidade técnica**, visão de risco e entendimento do negócio.

***

## 🎯 Regra de Ouro da Regressão

> **Nem tudo entra em regressão.**  
> **Entra o que não pode quebrar.**

Uma suíte de regressão eficiente é **enxuta, estratégica e focada em risco**, não em volume.

***

## ✅ Critérios Objetivos para Entrar na Regressão

### 🔹 1. Fluxos Críticos do Negócio

Entram **sempre** os fluxos que, se quebrarem, **param o sistema**.

**Exemplos:**

*   Login / Autenticação
*   Cadastro de usuários
*   Criação, alteração e exclusão de dados principais
*   Transferências
*   Pagamentos
*   APIs core do sistema

👉 **Impacto alto no negócio = entra na regressão**

***

### 🔹 2. Endpoints Compartilhados

APIs reutilizadas por vários fluxos ou sistemas.

**Exemplos:**

*   APIs usadas por múltiplos frontends
*   APIs base (auth, config, user, profile)
*   Serviços reutilizados em diferentes jornadas

👉 Um erro aqui gera **efeito cascata**

***

### 🔹 3. Bugs Corrigidos (Bug Regression)

**Todo bug corrigido deve virar teste de regressão.** Sem exceção.

**Exemplo:**

*   🐞 Bug: `POST /posts` aceitava título vazio
*   ✅ Corrigido
*   ➡️ Entra teste garantindo que **continua não aceitando**

👉 Isso evita **bug reincidente**, um dos maiores sinais de baixa qualidade.

***

### 🔹 4. Contratos de API (Schema)

Entram **sempre**, pois afetam diretamente integrações.

**Inclui:**

*   Campos obrigatórios
*   Tipos de dados
*   Estrutura do JSON (request e response)

⚠️ **Schema quebrado = Frontend quebrado**

***

### 🔹 5. Regras de Negócio Estáveis

Regras consolidadas e sensíveis a erro.

**Exemplos:**

*   Idade mínima
*   Limites de valor
*   Obrigatoriedade de campos
*   Permissões por perfil de usuário

👉 Costumam quebrar em refactor ou evolução de código.

***

## 🚫 O que Normalmente **NÃO** Entra em Regressão

Nem tudo precisa (ou deve) entrar.

*   Cenários muito específicos e pouco usados
*   POCs
*   Testes exploratórios
*   Funcionalidades temporárias
*   Casos de borda muito raros *(dependendo do projeto)*

👉 Avaliação sempre baseada em **risco x impacto**

***

# ✅ Exemplo – Lista de Testes de Regressão

Uma boa suíte de regressão é organizada por **camadas de risco**.

***

## 🔐 1. Autenticação e Segurança (CRÍTICO)

Esses testes **SEMPRE** entram.

*   ✅ Login com credenciais válidas
*   ✅ Login com credenciais inválidas
*   ✅ Token inválido ou expirado
*   ✅ Acesso sem token
*   ✅ Token de outro usuário
*   ✅ Status code correto (401 / 403)
*   ✅ Headers obrigatórios (Authorization, Content-Type)

> 💡 Qualquer falha aqui **compromete todo o sistema**

***

## 📦 2. Fluxo Principal (Happy Path)

Fluxos mais utilizados pelo usuário final.

**Exemplo – API de cadastro:**

*   ✅ Criar recurso com payload válido (POST)
*   ✅ Consultar recurso criado (GET)
*   ✅ Atualizar recurso (PUT / PATCH)
*   ✅ Deletar recurso (DELETE)
*   ✅ Validar status (200 / 201 / 204)

***

## ❗ 3. Validações de Negócio

Regras que **não podem quebrar**.

*   ✅ Campo obrigatório ausente
*   ✅ Formato inválido
*   ✅ Valor fora do limite permitido
*   ✅ Regra de unicidade (CPF, email)
*   ✅ Tentativa de duplicidade
*   ✅ Mensagem de erro correta

***

## 🔁 4. Regressão de Bugs Corrigidos

Essencial para qualidade contínua.

*   ✅ Reexecutar cenários de bugs corrigidos
*   ✅ Garantir que o bug não voltou
*   ✅ Validar impacto em outros fluxos

🚨 *Bug que volta = alerta vermelho*

***

## ⚠️ 5. Testes Negativos Essenciais

Somente os **mais críticos**.

*   ✅ Payload vazio
*   ✅ JSON inválido
*   ✅ Tipo de dado incorreto
*   ✅ Campo não esperado
*   ✅ Endpoint inexistente

***

## 🔄 6. Integrações Críticas

Quando a API depende de outros sistemas.

*   ✅ Integração funcionando
*   ✅ Erro em serviço externo
*   ✅ Timeout / indisponibilidade
*   ✅ Tratamento correto da mensagem de erro

***

## 📊 7. Testes Não Funcionais Essenciais

*(Normalmente na regressão completa)*

*   ✅ Tempo de resposta aceitável
*   ✅ Volume mínimo de requisições
*   ✅ Logs corretos
*   ✅ Retry (se aplicável)

***

## 🧠 Tipos de Suíte de Regressão

### 🔹 Regressão Rápida (Smoke / Sanity)

*   Autenticação
*   Happy path
*   1 ou 2 validações críticas

### 🔹 Regressão Completa

*   Todos os cenários críticos
*   Bugs antigos
*   Validações de negócio
*   Integrações

***

## ✅ Checklist Resumido (Pronto para uso)

```text
[ ] Login válido
[ ] Login inválido
[ ] Token expirado
[ ] POST payload válido
[ ] GET recurso criado
[ ] PUT recurso
[ ] DELETE recurso
[ ] Campo obrigatório ausente
[ ] Valor inválido
[ ] Bug #123 – cadastro duplicado
[ ] Bug #145 – erro 500 inesperado
```

***

## 📘 Conceito (ISTQB)

> O teste regressivo tem como objetivo garantir que **alterações não causem efeitos colaterais em funcionalidades existentes**.


