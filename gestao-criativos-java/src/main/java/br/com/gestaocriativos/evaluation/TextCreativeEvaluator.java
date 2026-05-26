package br.com.gestaocriativos.evaluation;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;
import br.com.gestaocriativos.domain.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

public class TextCreativeEvaluator extends KeywordScoreSupport {
    @Override
    public EvaluationResult evaluate(Creative creative) {
        int score = 20;
        List<String> reasons = new ArrayList<>();
        String text = creative.getPrimaryText();

        int storySignals = countSignals(text, List.of("eu", "minha", "quando", "antes", "depois", "aconteceu"));
        int painSignals = countSignals(text, List.of("sofria", "problema", "dificuldade", "não conseguia", "nao conseguia", "medo"));
        int transformationSignals = countSignals(text, List.of("mudou", "resultado", "aprendi", "consegui", "transformou", "clareza"));
        int ctaSignals = countSignals(text, List.of("clique", "acesse", "receba", "me chama", "whatsapp", "comente"));

        score += storySignals * 8;
        score += painSignals * 9;
        score += transformationSignals * 10;
        score += ctaSignals * 8;

        if (text.length() >= 200) {
            score += 12;
            reasons.add("Texto possui desenvolvimento suficiente para análise de copy");
        }
        if (storySignals > 0) {
            reasons.add("Tem estrutura de história ou relato");
        }
        if (transformationSignals > 0) {
            reasons.add("Tem sinal de transformação ou benefício");
        }
        if (ctaSignals > 0) {
            reasons.add("Tem chamada para ação");
        }

        int finalScore = clamp(score);
        return new EvaluationResult(finalScore, statusFromScore(finalScore), reasons);
    }

    private CreativeStatus statusFromScore(int score) {
        if (score >= 70) {
            return CreativeStatus.MODELING_QUEUE;
        }
        if (score >= 55) {
            return CreativeStatus.SHORTLISTED;
        }
        if (score >= 35) {
            return CreativeStatus.HUMAN_REVIEW;
        }
        return CreativeStatus.REJECTED;
    }
}
