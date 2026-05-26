# Definição do problema

## Contexto

O projeto foi baseado em um processo de organização de criativos para campanhas digitais. Nesse tipo de trabalho, é comum encontrar vários anúncios, textos, imagens e vídeos que podem servir como referência para novas campanhas.

O problema é que, quando isso é feito de forma manual, as informações acabam ficando espalhadas em anotações, pastas, prints e arquivos diferentes. Com o tempo, fica difícil lembrar o que já foi analisado, o que foi rejeitado e o que realmente vale a pena usar como referência.

## Problema identificado

O problema principal é a falta de um controle simples para registrar e avaliar criativos.

Sem um sistema, o processo fica mais sujeito a:

- perda de referências boas;
- análise repetida do mesmo criativo;
- dificuldade para saber qual criativo foi aprovado;
- falta de um critério padrão para avaliar vídeo, imagem e texto;
- mistura de criativos bons com criativos incompletos ou fracos.

## Usuários envolvidos

| Usuário | Papel |
|---|---|
| Pessoa que analisa criativos | Cadastra e avalia os criativos encontrados |
| Pessoa que cria textos/copies | Consulta referências aprovadas |
| Pessoa que edita vídeos ou imagens | Usa a fila de modelagem como base para produzir novos materiais |
| Gestor do processo | Acompanha o que foi aprovado, rejeitado ou deixado para revisão |

## Como o processo acontece hoje

De forma resumida, o processo atual funciona assim:

1. A pessoa encontra um criativo que parece interessante.
2. Salva o link, texto ou referência em algum lugar.
3. Analisa manualmente se aquele criativo tem potencial.
4. Decide se descarta, revisa depois ou usa como base.
5. Se for bom, separa para modelagem.

A parte mais problemática está entre salvar e decidir o destino do criativo, porque essa decisão pode ficar sem registro claro.

## Solução proposta

A solução proposta é um back-end em Java para registrar ofertas e criativos, validar se os dados principais foram preenchidos e classificar cada criativo com base em uma pontuação simples.

O sistema gera um status para o criativo, como rejeitado, revisão humana, selecionado ou fila de modelagem. Assim, fica mais fácil organizar o fluxo e evitar que tudo dependa apenas de anotações soltas.

## Escopo do trabalho

Foi implementada apenas uma parte do sistema, porque o objetivo do trabalho não é criar uma plataforma completa.

Faz parte do escopo:

- cadastrar oferta;
- cadastrar criativo;
- validar dados mínimos;
- avaliar criativo por tipo;
- definir status;
- listar criativos aprovados para modelagem.

Não faz parte do escopo:

- tela gráfica;
- login;
- banco de dados real;
- integração com redes sociais;
- criação automática de anúncios.
