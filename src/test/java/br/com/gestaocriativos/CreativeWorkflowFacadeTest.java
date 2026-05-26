package br.com.gestaocriativos;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;
import br.com.gestaocriativos.domain.CreativeType;
import br.com.gestaocriativos.domain.Offer;
import br.com.gestaocriativos.domain.OfferNiche;
import br.com.gestaocriativos.evaluation.CreativeEvaluatorFactory;
import br.com.gestaocriativos.repository.InMemoryCreativeRepository;
import br.com.gestaocriativos.repository.InMemoryOfferRepository;
import br.com.gestaocriativos.service.CreativeService;
import br.com.gestaocriativos.service.CreativeWorkflowFacade;
import br.com.gestaocriativos.validation.CreativeValidationChainFactory;

public class CreativeWorkflowFacadeTest {
    public void deveAvaliarCriativoForteEEnviarParaFilaDeModelagem() {
        InMemoryOfferRepository offerRepository = new InMemoryOfferRepository();
        InMemoryCreativeRepository creativeRepository = new InMemoryCreativeRepository();

        Offer offer = offerRepository.save(new Offer("Curso de Produtividade", OfferNiche.ESPIRITUALIDADE, 1000, true));
        CreativeWorkflowFacade workflow = new CreativeWorkflowFacade(
                new CreativeService(creativeRepository),
                offerRepository,
                new CreativeEvaluatorFactory(),
                new CreativeValidationChainFactory()
        );

        Creative creative = new Creative(
                "Vídeo com hook e CTA",
                "Se você vive perdida nas tarefas, pare de tentar organizar tudo de cabeça. Um especialista preparou um método com passo a passo, plano e lista. Receba o material e veja com calma.",
                "https://facebook.com/ad/3",
                CreativeType.VIDEO,
                offer.getId()
        );

        Creative result = workflow.registerAndEvaluate(creative);

        Assertions.assertEquals(CreativeStatus.MODELING_QUEUE, result.getStatus(), "Deveria ir para a fila de modelagem");
        Assertions.assertTrue(result.getScore() >= 75, "Pontuação deveria ser alta");
        Assertions.assertEquals(1, workflow.listModelingQueue().size(), "Fila de modelagem deveria ter um item");
    }

    public void deveRejeitarCriativoFraco() {
        InMemoryOfferRepository offerRepository = new InMemoryOfferRepository();
        InMemoryCreativeRepository creativeRepository = new InMemoryCreativeRepository();

        Offer offer = offerRepository.save(new Offer("Curso de Produtividade", OfferNiche.ESPIRITUALIDADE, 1000, true));
        CreativeWorkflowFacade workflow = new CreativeWorkflowFacade(
                new CreativeService(creativeRepository),
                offerRepository,
                new CreativeEvaluatorFactory(),
                new CreativeValidationChainFactory()
        );

        Creative creative = new Creative(
                "Imagem genérica",
                "Bom dia, imagem linda para compartilhar.",
                "",
                CreativeType.IMAGE,
                offer.getId()
        );

        Creative result = workflow.registerAndEvaluate(creative);

        Assertions.assertEquals(CreativeStatus.REJECTED, result.getStatus(), "Criativo genérico deveria ser rejeitado");
    }
}
