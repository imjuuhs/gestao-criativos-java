# gestao-criativos-java

Trabalho prático da disciplina de Modelos, Métodos e Técnicas de Engenharia de Software.

## Sobre o projeto

O projeto é um back-end em Java para ajudar na organização de criativos de campanhas digitais.

A ideia veio de um processo que pode ficar muito manual: separar anúncios encontrados, avaliar se eles servem como referência, marcar o que deve ser descartado e deixar uma fila com os criativos que podem ser modelados depois.

O sistema não tenta fazer uma plataforma completa. O escopo ficou limitado ao cadastro de ofertas, cadastro de criativos, validação dos dados, avaliação por pontuação e consulta dos criativos que entraram na fila de modelagem.

## O que foi implementado

- Cadastro de ofertas.
- Cadastro de criativos.
- Validação de dados obrigatórios.
- Avaliação de criativos de vídeo, imagem e texto.
- Classificação do criativo em status.
- Listagem dos criativos aprovados para modelagem.
- Testes unitários simples em Java.
- Diagramas e documentação do projeto.

## Tecnologias usadas

- Java 17.
- Projeto sem framework.
- Armazenamento em memória.
- Testes feitos com classes Java próprias, sem biblioteca externa.

Escolhi deixar sem Spring Boot e sem banco de dados porque o enunciado permite usar ferramentas livremente, e assim o projeto fica mais simples de executar e focado na lógica principal.

## Estrutura

```text
gestao-criativos-java/
├── docs/
│   ├── integrantes.md
│   ├── problema.md
│   ├── requisitos.md
│   ├── modelagem.md
│   ├── solid-padroes.md
│   └── diagramas/
├── src/main/java/
├── src/test/java/
├── .gitignore
└── README.md
```

## Como executar a aplicação

Na pasta do projeto, rode:

```bash
mkdir -p out/main
find src/main/java -name "*.java" > sources.txt
javac -encoding UTF-8 -d out/main @sources.txt
java -cp out/main br.com.gestaocriativos.app.Application
```

No Windows PowerShell, pode usar:

```powershell
New-Item -ItemType Directory -Force out/main
Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -encoding UTF-8 -d out/main @sources.txt
java -cp out/main br.com.gestaocriativos.app.Application
```

## Como rodar os testes

No Linux/macOS:

```bash
mkdir -p out/main out/test
find src/main/java -name "*.java" > sources.txt
javac -encoding UTF-8 -d out/main @sources.txt
find src/test/java -name "*.java" > test-sources.txt
javac -encoding UTF-8 -cp out/main -d out/test @test-sources.txt
java -cp out/main:out/test br.com.gestaocriativos.TestRunner
```

No Windows PowerShell:

```powershell
New-Item -ItemType Directory -Force out/main
New-Item -ItemType Directory -Force out/test
Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -encoding UTF-8 -d out/main @sources.txt
Get-ChildItem -Recurse src/test/java -Filter *.java | ForEach-Object { $_.FullName } > test-sources.txt
javac -encoding UTF-8 -cp out/main -d out/test @test-sources.txt
java -cp "out/main;out/test" br.com.gestaocriativos.TestRunner
```

## Documentação

A documentação principal está na pasta `docs`.

- `docs/problema.md`: descrição do problema.
- `docs/requisitos.md`: requisitos e histórias de usuário.
- `docs/modelagem.md`: explicação da modelagem.
- `docs/solid-padroes.md`: SOLID e padrões usados.
- `docs/diagramas/`: diagramas em Mermaid.
