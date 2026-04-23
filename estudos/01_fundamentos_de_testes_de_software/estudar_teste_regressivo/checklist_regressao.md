# ✅ Teste de Regressão

## 📌 O que é um teste de regressão?

Um **teste de regressão** é um tipo de teste de software cujo objetivo é garantir que funcionalidades que **já funcionavam corretamente continuem funcionando** após alguma mudança no sistema.

Em outras palavras, sempre que o sistema sofre uma alteração, existe o risco de algo “quebrar” em partes que **aparentemente não têm relação direta** com a mudança realizada.

👉 O **teste de regressão** existe justamente para detectar esse tipo de **efeito colateral**.

---

## 🔄 Quando testes de regressão são necessários?

Sempre que ocorre, por exemplo:

- 🐞 Correção de um bug  
- ✨ Inclusão de uma nova funcionalidade  
- ♻️ Refatoração de código  
- 🔧 Atualização de dependências  

Mesmo pequenas alterações podem impactar outras funcionalidades do sistema.

---

## 🏦 Exemplo simples

Imagine um **sistema bancário**:

- ✅ O login já funciona corretamente  
- 🔧 Um desenvolvedor altera o código do **cadastro de clientes**

Mesmo sem mexer diretamente no login, essa alteração pode afetar:

- Validações compartilhadas  
- Serviços reutilizados  
- Acesso ao banco de dados  

➡️ O **teste de regressão** vai validar novamente funcionalidades como:
- Login  
- Consulta de saldo  
- Transferências  
- Outras operações críticas  

O objetivo é garantir que **nada foi impactado** negativamente.

---

## 🧪 Principais características do teste de regressão

- 🔁 Reexecuta testes já existentes  
- 🎯 Foca em funcionalidades antigas e estáveis  
- 🧍 Pode ser **manual** ou **automatizado**  
- 🚀 Muito comum em **sprints**, **deploys** e **pipelines CI/CD**

---

## 🤖 Teste de regressão manual vs automatizado

### 🧍 Teste de regressão manual
- Mais comum em sistemas pequenos  
- Usado quando ainda não há automação  
- Exige mais tempo e esforço humano  

### 🤖 Teste de regressão automatizado
- Ideal para sistemas médios e grandes  
- Permite execução rápida após cada mudança  
- Muito utilizado em pipelines de **CI/CD**  
- Reduz risco e aumenta confiabilidade

---

## 🏢 Testes de regressão em projetos reais (QA)

Normalmente entram em uma suíte de regressão:

- 🔐 Fluxos críticos  
  - Login  
  - Pagamento  
  - Cadastro  

- 🔌 APIs principais  
- 📐 Regras de negócio sensíveis  
- 🔁 Bugs corrigidos anteriormente  
  - Para garantir que não voltaram a ocorrer

---

✅ **Resumo**:  
O teste de regressão é essencial para garantir a **estabilidade do sistema ao longo do tempo**, especialmente em ambientes com mudanças frequentes.