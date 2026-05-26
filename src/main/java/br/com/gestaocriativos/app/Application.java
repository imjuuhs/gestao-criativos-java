package br.com.gestaocriativos.app;

import br.com.gestaocriativos.adapter.ExternalAdDTO;
import br.com.gestaocriativos.adapter.ExternalAdAdapter;
import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeType;
import br.com.gestaocriativos.domain.Offer;
import br.com.gestaocriativos.domain.OfferNiche;
import br.com.gestaocriativos.evaluation.CreativeEvaluatorFactory;
import br.com.gestaocriativos.repository.CreativeRepository;
import br.com.gestaocriativos.repository.InMemoryCreativeRepository;
import br.com.gestaocriativos.repository.InMemoryOfferRepository;
import br.com.gestaocriativos.repository.OfferRepository;
import br.com.gestaocriativos.service.CreativeService;
import br.com.gestaocriativos.service.CreativeWorkflowFacade;
import br.com.gestaocriativos.service.OfferService;
import br.com.gestaocriativos.validation.CreativeValidationChainFactory;

public class Application {
    public static void main(String[] args) {
        OfferRepository offerRepository = new InMemoryOfferRepository();
        CreativeRepository creativeRepository = new InMemoryCreativeRepository();

        OfferService offerService = new OfferService(offerRepository);
        CreativeService creativeService = new CreativeService(creativeRepository);
        CreativeWorkflowFacade workflow = new CreativeWorkflowFacade(
                creativeService,
                offerRepository,
                new CreativeEvaluatorFactory(),
                new CreativeValidationChainFactory()
        );

        Offer cursoProdutividade = offerService.createOffer(
                "Curso de Produtividade",
                OfferNiche.ESPIRITUALIDADE,
                1000,
                true
        );

        ExternalAdDTO externalAd = new ExternalAdDTO(
                "Criativo sobre organização de rotina",
                "Se você perde muito tempo tentando organizar sua rotina, esse material mostra um passo a passo simples para planejar estudos, tarefas e prioridades. Receba o conteúdo e veja com calma.",
                "https://facebook.com/ads/example",
                CreativeType.VIDEO,
                cursoProdutividade.getId()
        );

        ExternalAdAdapter adapter = new ExternalAdAdapter();
        Creative creative = adapter.toCreative(externalAd);
        Creative evaluatedCreative = workflow.registerAndEvaluate(creative);

        System.out.println("Sistema: Sistema de Gestão de Criativos para Campanhas Digitais");
        System.out.println("Oferta cadastrada: " + cursoProdutividade.getName());
        System.out.println("Criativo avaliado: " + evaluatedCreative.getTitle());
        System.out.println("Pontuação: " + evaluatedCreative.getScore());
        System.out.println("Status: " + evaluatedCreative.getStatus());
        System.out.println("Motivos: " + evaluatedCreative.getNotes());
        System.out.println("Total na fila de modelagem: " + workflow.listModelingQueue().size());
    }
}
