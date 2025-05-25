# Conversor de Moedas

![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Gson](https://img.shields.io/badge/Gson-2.8.9-green.svg)
![HttpClient](https://img.shields.io/badge/HttpClient-Java11+-brightgreen.svg)
![MIT License](https://img.shields.io/badge/License-MIT-yellow.svg)

---

## Descrição

Projeto desenvolvido em **Java** para realizar conversão de moedas via terminal. Utiliza a API pública [ExchangeRate API](https://www.exchangerate-api.com) para buscar cotações atuais entre moedas, com interface simples baseada em menu.

Ideal para quem está estudando backend e quer entender integração via HTTP, manipulação JSON e tratamento de dados.

---

## Funcionalidades

- Conversão entre 6 pares de moedas:
  - Dólar (USD) ↔ Real (BRL)
  - Real (BRL) ↔ Won Sul Coreano (KRW)
  - Real (BRL) ↔ Iene Japonês (JPY)
- Menu interativo via terminal com 7 opções (6 conversões + sair).
- Validação robusta de entradas e tratamento de exceções.
- Resultados formatados com duas casas decimais.
- Uso de Java Records para modelagem de dados.
- Comunicação com API externa usando `HttpClient` do Java 11+.
- Desserialização de JSON com Gson.

---

## Tecnologias utilizadas

| Tecnologia           | Versão/Recurso          | Descrição                                    |
|---------------------|------------------------|----------------------------------------------|
| ![Java](https://img.shields.io/badge/Java-17+-blue.svg)          | Java 16+ / 17+           | Linguagem principal, uso de Records e HttpClient.  |
| ![Gson](https://img.shields.io/badge/Gson-2.8.9-green.svg)         | Gson 2.8.9+              | Biblioteca para serialização e desserialização JSON. |
| ![HttpClient](https://img.shields.io/badge/HttpClient-Java11+-brightgreen.svg) | Java 11+ HttpClient       | Cliente HTTP nativo para requisições REST.            |
| Terminal / Console   | Scanner e System.out    | Interface CLI simples e interativa.           |

---

## Estrutura do projeto

- `Main`  
  Controla o fluxo da aplicação, apresenta menu e faz a interface com o usuário.

- `SetCurrencyCode`  
  Define pares de moedas para conversão com base na opção escolhida.

- `ConverteMoeda`  
  Realiza a requisição HTTP para a API ExchangeRate e desserializa a resposta.

- `DadosDeCambio`  
  Java Record que representa o modelo dos dados retornados pela API.

---
## Demonstração do funcionamento

[Demonstração no terminal]





https://github.com/user-attachments/assets/c8745b5e-72db-4198-bc66-c6de91f2d952

## Como usar


1. Clone o repositório:
   ```bash
    https://github.com/ViveirosCathe/ConversorDeMoedas.git
