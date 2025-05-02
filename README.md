# Conversor de Moedas 💱

Este projeto implementa um conversor de moedas que permite ao usuário converter valores entre diferentes moedas usando dados de uma API em tempo real. Desenvolvido em Java, o aplicativo oferece uma interface de terminal simples para facilitar a conversão e o armazenamento de um histórico local das operações realizadas.

## Tecnologias Usadas 🧑‍💻

<div>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/Gson-2.10-green?style=for-the-badge">
  <a href="https://www.exchangerate-api.com/" target="_blank">
    <img src="https://img.shields.io/badge/ExchangeRate--API-FF0000?style=for-the-badge&logoColor=white">
  </a>
</div>

## Funcionalidades 💻

- **Conversão de moedas em tempo real**: O usuário pode converter valores entre **BRL, USD, ARS, BOB, CLP e COP**.
- **Histórico de conversões**: Cada operação realizada é armazenada em um arquivo .json.
- **Integração com API externa**: As taxas de câmbio são buscadas em tempo real usando a [ExchangeRate API](https://www.exchangerate-api.com/).
- **Exibição de histórico**: O histórico pode ser visualizado diretamente no terminal.

## Estrutura do Projeto 🗂️

- **Principal.java**: Ponto de entrada da aplicação, que gerencia o menu e a interação com o usuário.
- **ConverterMoedas.java**: Contém a lógica responsável pela conversão de moedas utilizando a API externa.
- **HistoricoConversoes.java**: Gerencia o histórico local de conversões e armazena os dados em um arquivo JSON.
- **Moeda.java**: Representa a estrutura das moedas e suas taxas de conversão.
- **Menu.java**: Interface de usuário do terminal, onde o usuário interage com o programa e escolhe as opções de conversão ou visualiza o histórico.

## Como Usar 📝

1. Execute o projeto com sua IDE Java preferida **ou** via terminal com javac + java.
2. Escolha a opção de conversão no menu exibido.
3. Insira o valor desejado para conversão.
4. O resultado será exibido e armazenado automaticamente no histórico.
5. Você também pode visualizar o histórico diretamente pelo menu.

## Detalhes Técnicos 🛠️

### 1. Chamada da API
- A chamada HTTP é feita usando HttpClient e HttpRequest da biblioteca nativa do Java 11+.
- O JSON de resposta é analisado com JsonParser e JsonObject da biblioteca GSON.

### 2. Cálculo da conversão
- A taxa de conversão (conversion_rate) é multiplicada pelo valor inserido pelo usuário para gerar o resultado.

### 3. Histórico em JSON
- Cada conversão é salva como um objeto dentro de um array JSON no arquivo historico_conversoes.json.
- O arquivo é reescrito a cada nova conversão, com formatação legível (setPrettyPrinting).

## Como Executar 🚀

1. Clone o repositório.

2. Obtenha uma chave de API no [ExchangeRate API](https://www.exchangerate-api.com/) e substitua a variável `apiKey` no código.

3. Compile e execute o código em sua IDE Java ou via terminal.
