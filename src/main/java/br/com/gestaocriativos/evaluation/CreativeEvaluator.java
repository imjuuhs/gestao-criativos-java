package br.com.gestaocriativos.evaluation;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.EvaluationResult;

public interface CreativeEvaluator {
    EvaluationResult evaluate(Creative creative);
}
