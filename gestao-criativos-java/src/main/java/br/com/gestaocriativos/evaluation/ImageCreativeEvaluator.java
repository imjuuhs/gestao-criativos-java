package br.com.gestaocriativos.evaluation;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;
import br.com.gestaocriativos.domain.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

public class ImageCreativeEvaluator extends KeywordScoreSupport {
    @Override
    public EvaluationResult evaluate(Creative creative) {
        int score = 25;
        List<String> reasons = new ArrayList<>();
        String text = creative.getPrimaryText();

        int promiseSignals = countSignals(text, List.of("passo a passo", "lista", "guia", "plano", "receita", "protocolo"));
        int offerSignals = countSignals(text, List.of("por apenas", "r$", "pix", "recebe primeiro", "paga depois"));
        int genericSignals = countSignals(text, List.of("bom dia", "feliz", "imagem linda", "foto", "paisagem"));

        score += promiseSignals * 15;
        score += offerSignals * 12;
        score -= genericSignals * 10;

        if (text.length() >= 120 && text.length() <= 900) {
            score += 15;
            reasons.add("Texto tem volume suficiente para avaliar uma imagem com copy");
        }

        if (promiseSignals > 0) {
            reasons.add("A copy indica entrega clara ou promessa estruturada");
        }
        if (offerSignals > 0) {
            reasons.add("A copy tem sinal de oferta ou condição comercial");
        }
        if (genericSignals > 0) {
            reasons.add("Há sinais de criativo genérico, então precisa de cuidado");
        }

        int finalScore = clamp(score);
        return new EvaluationResult(finalScore, statusFromScore(finalScore), reasons);
    }

    private CreativeStatus statusFromScore(int score) {
        if (score >= 72) {
            return CreativeStatus.MODELING_QUEUE;
        }
        if (score >= 58) {
            return CreativeStatus.SHORTLISTED;
        }
        if (score >= 35) {
            return CreativeStatus.HUMAN_REVIEW;
        }
        return CreativeStatus.REJECTED;
    }
}
