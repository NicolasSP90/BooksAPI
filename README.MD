# LiterAlura

## Objetivo 
Desenvolver um Catálogo de Livros que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 5 opções de interação. Os livros serão buscados através de uma API específica as informações salvas em banco de dados. 

## API
A [API Gutendex](https://gutendex.com) é um catálogo com informações sobre os mais de 70 mil livros presentes no [Project Gutenberg](https://www.gutenberg.org) (biblioteca online gratuita).

## Banco PostreSQL
Os livros pesquisados na API serão salvos em banco local utilizando JPA.

## Ambiente, Configurações e Dependências
* Java 23 SDK
* IntelliJ
* VM Option: -Duser.countr=US, -Duser.language=en
* PostgreSQL Driver
* Spring Data JPA
* Jackson
* Langchain (Ainda não utilizado - Futuramente será para integrar com a API do Gemini)

## Menu de Interações

1- Adicionar Livro ao Banco de Dados

2- Listar Livros Armazenados

3- Listar Autores Armazenados

4- Listar Livros em um Idioma

5- Top 5 Livros mais Baixados

6- Top 5 Autores com mais Livros Baixados

0- Encerrar
