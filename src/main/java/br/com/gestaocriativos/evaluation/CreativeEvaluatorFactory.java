package br.com.gestaocriativos.evaluation;

import br.com.gestaocriativos.domain.CreativeType;

public class CreativeEvaluatorFactory {
    public CreativeEvaluator create(CreativeType type) {
        return switch (type) {
            case VIDEO -> new VideoCreativeEvaluator();
            case IMAGE -> new ImageCreativeEvaluator();
            case TEXT -> new TextCreativeEvaluator();
        };
    }
}
