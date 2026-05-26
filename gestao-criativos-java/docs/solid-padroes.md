# SOLID e padrões de projeto

## SOLID

### SRP

Cada classe tem uma função principal. Por exemplo, `Offer` representa uma oferta, `Creative` representa um criativo, os repositórios salvam dados e os avaliadores calculam pontuação.

### OCP

A avaliação dos criativos usa a interface `CreativeEvaluator`. Se outro tipo de criativo for criado depois, dá para adicionar uma nova classe sem alterar todo o fluxo principal.

### LSP

As classes `VideoCreativeEvaluator`, `ImageCreativeEvaluator` e `TextCreativeEvaluator` podem ser usadas no lugar da interface `CreativeEvaluator`, porque todas seguem o mesmo contrato.

### ISP

As interfaces ficaram separadas por responsabilidade. `CreativeRepository` trata apenas de criativos e `OfferRepository` trata apenas de ofertas.

### DIP

Os serviços dependem de interfaces, não diretamente das classes de memória. Por exemplo, `CreativeService` depende de `CreativeRepository`.

## Padrões de projeto usados

### Factory Method

Foi usado na classe `CreativeEvaluatorFactory` para escolher qual avaliador será usado conforme o tipo do criativo.

### Strategy

Foi usado na avaliação dos criativos. Cada tipo tem uma estratégia diferente: vídeo, imagem ou texto.

### Chain of Responsibility

Foi usado nas validações. Cada classe valida uma regra e depois passa para a próxima.

Classes usadas:

- `RequiredFieldsValidation`;
- `OfferExistsValidation`;
- `CopyLengthValidation`;
- `SourceUrlValidation`.

### Adapter

Foi usado para transformar um anúncio vindo de fora (`ExternalAdDTO`) em um criativo do sistema (`Creative`).

### Facade

Foi usado na classe `CreativeWorkflowFacade`, que centraliza o fluxo de validar, avaliar e salvar o criativo.

## Por que esses padrões foram usados

Os padrões foram usados para organizar melhor o código e evitar que tudo ficasse em uma única classe grande. Como o sistema tem etapas diferentes, como validação, avaliação e salvamento, a separação ajuda a entender e manter o projeto.
