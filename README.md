## Sobre o projeto

Aplicação utiliza a API do thecatapi, para exibir uma tela com uma imagem e o ID do gato
e uma segunda tela com a lista de gatos vistos anteriormente.

## Objetivo

- Consumo de uma API;
- Carregar a imagem e informações na tela;
- Persistir dados localmente;
- Mostrar esses dados em uma RecyclerView;
- Montar a estrutura do App utilizando a arquitetura Clean e arquitetura de apresentação Mvvm;

## Ferramentas utilizadas

- Kotlin
- Mvvm + Clean Architecture
- RecyclerView
- API - https://developers.thecatapi.com/view-account/ylX4blBYT9FaoVd6OhvR?report=bOoHBz-8t
- ViewBinding
- Retrofit
- Coil - https://github.com/coil-kt/coil
- Kotlin Serialization
- Koin
- Mockk
- Espresso
- JUnit5
- Coroutines
- Kotlin Flow

## Features

Esta aplicação possui duas telas:

A tela inicial, que exibe uma imagem e o ID do gato, além de dois botões: um para recarregar os dados e outro para exibir a lista de gatos visualizados.

A segunda tela exibe a listagem dos gatos vistos.

## Arquitetura

O projeto está estruturado com arquitetura Clean e na camada de apresentação está utilizando a arquitetura Mvvm, da forma como mostra a imagem. Cada tela segue essa mesma estrtura.

![image](https://github.com/user-attachments/assets/ebd45e1a-012f-4e55-bee2-9fa5bc418b67)


## Injeção de dependência

Neste projeto é utilizado o koin para gerenciar dependências


## Proxímos passos

- Criar e melhorar os testes instrumentados
- Aumentar a cobertura de testes unitários
- Colocar a opção de abrir as informações de um item da lista
- Melhorar o layout das telas

