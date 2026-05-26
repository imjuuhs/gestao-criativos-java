package br.com.gestaocriativos.service;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.EvaluationResult;
import br.com.gestaocriativos.evaluation.CreativeEvaluator;
import br.com.gestaocriativos.evaluation.CreativeEvaluatorFactory;
import br.com.gestaocriativos.repository.OfferRepository;
import br.com.gestaocriativos.validation.CreativeValidationChainFactory;
import br.com.gestaocriativos.validation.CreativeValidationHandler;
import br.com.gestaocriativos.validation.ValidationContext;

import java.util.List;

public class CreativeWorkflowFacade {
    private final CreativeService creativeService;
    private final OfferRepository offerRepository;
    private final CreativeEvaluatorFactory evaluatorFactory;
    private final CreativeValidationChainFactory validationChainFactory;

    public CreativeWorkflowFacade(
            CreativeService creativeService,
            OfferRepository offerRepository,
            CreativeEvaluatorFactory evaluatorFactory,
            CreativeValidationChainFactory validationChainFactory
    ) {
        this.creativeService = creativeService;
        this.offerRepository = offerRepository;
        this.evaluatorFactory = evaluatorFactory;
        this.validationChainFactory = validationChainFactory;
    }

    public Creative registerAndEvaluate(Creative creative) {
        validate(creative);

        CreativeEvaluator evaluator = evaluatorFactory.create(creative.getType());
        EvaluationResult result = evaluator.evaluate(creative);
        creative.applyEvaluation(result);

        return creativeService.save(creative);
    }

    public Creative reevaluate(String creativeId) {
        Creative creative = creativeService.findById(creativeId);
        return registerAndEvaluate(creative);
    }

    public List<Creative> listModelingQueue() {
        return creativeService.listModelingQueue();
    }

    private void validate(Creative creative) {
        CreativeValidationHandler chain = validationChainFactory.createDefaultChain();
        ValidationContext context = new ValidationContext(creative, offerRepository);
        chain.validate(context);

        for (String warning : context.getWarnings()) {
            creative.addNote(warning);
        }

        if (context.hasErrors()) {
            throw new ValidationException(context.getErrors());
        }
    }
}
