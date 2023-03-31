# Imersão Java 2

Repositório contendo os projetos realizados na 2a edição da Imersão Java da Alura.

## Cronograma
Aula 1 - Consumindo uma API de filmes com Java.
Aula 2 - Gerando figurinhas para WhatsApp.
Aula 3 - Ligando as pontas, refatoração e orientação a objetos.
Aula 4 - Criando nossa própria API com Spring.
Aula 5 - Publicando nossa API na Cloud.



### Aula 1 -> imdb-api

Nessa aula foi utilizada a API pública do site IMDB com o endpoint `top250movies`.
<br>
Com o pacote `java.net.http` foram realizados:
1. A conexão com a API.
2. A extração dos dados com uma classe própria disponibilizada em aula.
3. A impressão em tela dos seguintes dados do sfilmes: título, imagem, pontuação.
4. Com o desafio proposto pelos mentores foi refatorada a pontuação de modo a possuir um melhor layout com cores e emojis.

### Aula 2 -> Gerando stickers

Nessa aula foi desenvolvida uma nova classe para gerar stickers (para whatsapp, telegram etc) a partir dos pôsters dos filmes recuperados via api da Aula 1.
<br>
Foram realizados:
1. A importação de imagens(arquivo local ou url), as transformando em uma nova imagem .png com um texto em fundo transparente.
2. Gerador de Stickers - Classe geradora de Stickers para WhatsApp.

### Aula 3 -> Ligando as pontas, refatoração e orientação a objetos

O código foi refatorado com o objetivo de simplificar e ampliar a utilidade da aplicação utilizando os pilares da programação orientada a objetos como o polimorfismo.
<br>
* Para isso foram implementadas ferramentas do Java como as `Interfaces`, `Record's` e os `Generics`.  
* No fluxo da aplicação temos a classe `App` que requisita a url da API por meio de uma chave String para a classe `ApiProperties`; com a url em mãos é possível solicitar a interface `Model` a lista de conteúdos, onde é feito a requisição do JSON a classe `ClientHttp` e a própria interface realiza a desserialização e retorna uma lista de conteúdos. Por fim, a classe `App` utiliza os métodos da classe `StickGenerator` passando o conteúdo e que retorna a figurinha com a menssagem desejada.

<p align="center">
  <img src="https://github.com/Pedro-Hc-Reis/Imersao_Java_2_Alura/blob/main/Resultados/fluxo.png?raw=true" alt="Fluxo Aplicação" width="750" height="300">
</p>

* Dessa forma foi possível flexibilizar e reutilizar o código na geração de figurinhas de API's diferentes das que foram utilizadas nos dias anteriores. Como exemplo a API da Nasa que fornece diferentes imagens relacionadas a astronomia.


### Aula 4 -> Criando nossa própria API com Spring.

* Nas atividades do quarto dia foi desenvolvida uma API com `Spring Boot` e `MongoDB` contendo logos de linguagens de programação, podendo ser acessada no repositório [Imersão Alura Java_: API de Langs](https://github.com/Lukasveiga/ImersaoAluraLangApi).
* E por fim foram geradas figurinhas com as imagens extraídas da API seguindo o mesmo modelo dos exemplos anteriores.
