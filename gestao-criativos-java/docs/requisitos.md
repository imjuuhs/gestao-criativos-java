# Requisitos

## Como os requisitos foram levantados

Os requisitos foram levantados observando o processo manual de organização de criativos. A partir disso, foram separados os problemas mais comuns e as funcionalidades mínimas que fariam sentido para uma primeira versão do sistema.

A abordagem usada foi ágil, com histórias de usuário e critérios de aceitação.

## Atores

| Ator | Descrição |
|---|---|
| Analista de criativos | Pessoa que cadastra e avalia criativos |
| Criador de conteúdo | Pessoa que usa as referências aprovadas |
| Editor | Pessoa que recebe os criativos que vão para modelagem |
| Sistema | Faz validações e classificações automáticas |

## Requisitos funcionais

| Código | Requisito | Prioridade |
|---|---|---|
| RF01 | Cadastrar uma oferta | Alta |
| RF02 | Cadastrar um criativo relacionado a uma oferta | Alta |
| RF03 | Validar se o criativo tem título, texto, tipo e oferta | Alta |
| RF04 | Verificar se a oferta informada existe | Alta |
| RF05 | Avaliar criativo de vídeo, imagem ou texto | Alta |
| RF06 | Gerar uma pontuação para o criativo | Alta |
| RF07 | Definir o status do criativo depois da avaliação | Alta |
| RF08 | Listar os criativos que entraram na fila de modelagem | Média |

## Requisitos não funcionais

| Código | Requisito |
|---|---|
| RNF01 | O sistema deve ser desenvolvido em Java |
| RNF02 | O projeto deve ser organizado em camadas simples |
| RNF03 | O código deve ter testes unitários |
| RNF04 | A solução deve aplicar conceitos de orientação a objetos |
| RNF05 | A aplicação deve rodar sem depender de serviços externos |

## Histórias de usuário

### História 1

Como pessoa que analisa criativos, quero cadastrar uma oferta para relacionar os criativos a um produto ou campanha.

Critérios de aceitação:

- a oferta deve ter nome;
- a oferta deve ter nicho;
- a oferta deve ter preço maior que zero.

### História 2

Como pessoa que analisa criativos, quero cadastrar um criativo para registrar uma referência encontrada.

Critérios de aceitação:

- o criativo deve ter título;
- o criativo deve ter texto principal;
- o criativo deve ter tipo;
- o criativo deve estar ligado a uma oferta existente.

### História 3

Como pessoa que organiza a produção, quero que o sistema classifique o criativo para saber se ele deve ser rejeitado, revisado ou enviado para modelagem.

Critérios de aceitação:

- o sistema deve calcular uma pontuação;
- o sistema deve definir um status;
- o sistema deve salvar os motivos da avaliação.

### História 4

Como editor ou criador de conteúdo, quero consultar a fila de modelagem para saber quais criativos foram aprovados.

Critérios de aceitação:

- a lista deve mostrar apenas criativos com status de fila de modelagem;
- criativos rejeitados não devem aparecer nessa lista.

## Backlog resumido

| Item | Descrição | Situação |
|---|---|---|
| 1 | Cadastro de oferta | Implementado |
| 2 | Cadastro de criativo | Implementado |
| 3 | Validação em cadeia | Implementado |
| 4 | Avaliação por tipo de criativo | Implementado |
| 5 | Fila de modelagem | Implementado |
| 6 | Banco de dados | Fora do escopo |
| 7 | Interface gráfica | Fora do escopo |
