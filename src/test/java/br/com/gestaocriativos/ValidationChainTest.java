package br.com.gestaocriativos;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeType;
import br.com.gestaocriativos.repository.InMemoryOfferRepository;
import br.com.gestaocriativos.validation.CreativeValidationChainFactory;
import br.com.gestaocriativos.validation.ValidationContext;

public class ValidationChainTest {
    public void deveAcusarErroQuandoOfertaNaoExiste() {
        Creative creative = new Creative(
                "Criativo de teste",
                "Texto com tamanho suficiente para passar pela validação básica do sistema.",
                "https://facebook.com/ad/1",
                CreativeType.VIDEO,
                "oferta-inexistente"
        );

        ValidationContext context = new ValidationContext(creative, new InMemoryOfferRepository());
        new CreativeValidationChainFactory().createDefaultChain().validate(context);

        Assertions.assertTrue(context.hasErrors(), "Deveria existir erro de validação");
        Assertions.assertTrue(
                context.getErrors().contains("A oferta informada não foi encontrada"),
                "Deveria informar que a oferta não existe"
        );
    }

    public void deveGerarAvisoParaTextoMuitoLongo() {
        String longText = "passo a passo ".repeat(100);
        InMemoryOfferRepository offerRepository = new InMemoryOfferRepository();
        br.com.gestaocriativos.domain.Offer offer = offerRepository.save(new br.com.gestaocriativos.domain.Offer(
                "Curso de Produtividade",
                br.com.gestaocriativos.domain.OfferNiche.ESPIRITUALIDADE,
                1000,
                true
        ));

        Creative creative = new Creative(
                "Criativo long copy",
                longText,
                "https://facebook.com/ad/2",
                CreativeType.IMAGE,
                offer.getId()
        );

        ValidationContext context = new ValidationContext(creative, offerRepository);
        new CreativeValidationChainFactory().createDefaultChain().validate(context);

        Assertions.assertTrue(!context.getWarnings().isEmpty(), "Deveria gerar aviso para long copy");
        Assertions.assertTrue(!context.hasErrors(), "Não deveria existir erro quando a oferta existe");
    }
}
