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

### Aula 2 -> imdb-api

Nessa aula foi utilizada a API pública do site IMDB com o endpoint localizados no arquivo `Links.txt`.
<br>
Foram realizados:
1. A importação de imagens(arquivo local ou url), as transformando em uma nova imagem .png com um texto em fundo transparente.
2. Gerador de Stickers - Classe geradora de Stickers para WhatsApp.
