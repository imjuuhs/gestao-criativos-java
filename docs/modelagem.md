# Modelagem

## Visão geral

O sistema foi separado em algumas partes principais:

- domínio: classes principais do problema, como `Offer` e `Creative`;
- repositório: classes responsáveis por salvar e buscar dados;
- serviço: regras de cadastro e fluxo principal;
- avaliação: regras de pontuação dos criativos;
- validação: regras que verificam se o criativo pode ser avaliado;
- adapter: conversão de um anúncio externo para o modelo interno do sistema.

## Classes principais

| Classe | Função |
|---|---|
| `Offer` | Representa uma oferta ou campanha |
| `Creative` | Representa um criativo encontrado |
| `EvaluationResult` | Guarda a pontuação, status e motivos da avaliação |
| `OfferService` | Cadastra ofertas |
| `CreativeService` | Salva e consulta criativos |
| `CreativeWorkflowFacade` | Junta validação, avaliação e salvamento |
| `CreativeEvaluatorFactory` | Escolhe o avaliador correto |
| `VideoCreativeEvaluator` | Avalia criativos de vídeo |
| `ImageCreativeEvaluator` | Avalia criativos de imagem |
| `TextCreativeEvaluator` | Avalia criativos de texto |

## Fluxo principal

1. Uma oferta é cadastrada.
2. Um criativo é criado e ligado a essa oferta.
3. O sistema valida os dados do criativo.
4. A factory escolhe o avaliador de acordo com o tipo do criativo.
5. O avaliador calcula uma pontuação.
6. O criativo recebe um status.
7. O criativo é salvo no repositório.
8. Se for aprovado, pode aparecer na fila de modelagem.

## Diagramas

Os diagramas estão na pasta `docs/diagramas`.

Arquivos:

- `diagrama-classes.mmd`;
- `diagrama-casos-uso.mmd`;
- `fluxo-avaliacao.mmd`.

O diagrama de classes é o principal, porque mostra a estrutura do sistema implementado.
