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

Esta Aplicação possui 2 telas
a tela inicial com uma imagem e ID do gato e 2 botões, um para recaregar os dados e outro para exibir da lista de gatos visualizados
e uma tela que que trás a listagem dos gatos vistos.
 
## Pacotes

O projeto se encontra organizado em uma arquitetura mvvm+clean e cada feature no seu package

- Data
- Domain
- Presentation
- Common
- Di

## Injeção de dependência

Neste projeto é utilizado o koin para fazer as chamadas dos módulos


## Proxímos passos

- Criar e melhorar os testes instrumentados
- Aumentar a cobertura de testes unitários
- Colocar a opção de abrir as informações de um item da lista
- Modularização por features

