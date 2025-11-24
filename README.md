# 🎬 Spotlight API - Estudo de Caso de Cinema

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

## Sobre o Projeto

O **Spotlight** é uma API RESTful desenvolvida com o objetivo de aprofundar conhecimentos em **Spring Boot** e **Modelagem de Domínio**.

O projeto simula o backend de uma rede de cinemas, onde o desafio principal é orquestrar regras de negócio interdependentes, como gestão de horários, alocação física de assentos e integridade de transações financeiras.

O foco do desenvolvimento foi a aplicação de boas práticas de engenharia de software, incluindo **Clean Code**, **SOLID** e separação estrita de responsabilidades entre camadas.

---

## Domínio do Sistema

O sistema foi modelado para refletir o funcionamento real de um cinema, cobrindo três pilares principais:

1.  **Gestão de Espaço (Salas e Assentos):**
    O sistema mapeia salas. A lógica permite identificar cada assento individualmente, garantindo que não existam vendas duplicadas para o mesmo lugar físico.

2.  **Gestão de Tempo (Sessões e Conflitos):**
    Foi implementada uma lógica de validação temporal que impede que filmes sejam agendados na mesma sala em horários sobrepostos, considerando inclusive o tempo de limpeza necessário entre as sessões.

3.  **Processamento de Vendas (Ingressos):**
    A compra de ingressos trata a concorrência de múltiplos usuários. O sistema valida a disponibilidade, bloqueia o assento e gera o registro da venda de forma atômica (tudo ou nada), garantindo a consistência do banco de dados.

---

## Stack Tecnológica

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.5.7 (Web, Data JPA, Validation)
* **Banco de Dados:** H2 (Ambiente de Testes) / MySQL (Produção)
* **Ferramentas:** Maven, Postman, Git

---

## Como Executar

Pré-requisitos: Java 21 e Maven instalados.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/spotlight-api.git](https://github.com/seu-usuario/spotlight-api.git)
    ```

2.  **Configure o Banco de Dados (Opcional):**
    O projeto está configurado por padrão para usar um banco em memória (H2). Se desejar usar MySQL, edite o arquivo `src/main/resources/application.properties`.

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

---

## Objetivos de Aprendizado

Com este projeto, os principais conceitos exercitados foram:
- Mapeamento Objeto-Relacional (ORM) avançado com JPA.
- Gerenciamento de Transações (`@Transactional`) e rollback.
- Injeção de Dependências e Inversão de Controle.

---

## 📝 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usá-lo para estudos.
