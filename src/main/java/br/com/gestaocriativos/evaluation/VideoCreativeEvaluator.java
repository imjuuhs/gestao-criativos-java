package br.com.gestaocriativos.evaluation;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;
import br.com.gestaocriativos.domain.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

public class VideoCreativeEvaluator extends KeywordScoreSupport {
    @Override
    public EvaluationResult evaluate(Creative creative) {
        int score = 30;
        List<String> reasons = new ArrayList<>();
        String text = creative.getPrimaryText();

        int hookSignals = countSignals(text, List.of("voce sabia", "pare de", "se voce", "descobri", "segredo", "erro"));
        int painSignals = countSignals(text, List.of("cansada", "travado", "dificuldade", "problema", "nao consigo", "culpa"));
        int ctaSignals = countSignals(text, List.of("clique", "chama", "comenta", "receba", "envie", "acesse"));
        int authoritySignals = countSignals(text, List.of("especialista", "metodo", "passo a passo", "aula", "plano", "lista"));

        score += hookSignals * 12;
        score += painSignals * 8;
        score += ctaSignals * 10;
        score += authoritySignals * 8;

        if (text.length() >= 80 && text.length() <= 500) {
            score += 12;
            reasons.add("Texto tem tamanho bom para análise de criativo em vídeo");
        }

        if (!creative.getSourceUrl().isBlank()) {
            score += 5;
            reasons.add("Possui URL de origem para conferência manual");
        }

        if (hookSignals > 0) {
            reasons.add("Tem sinal de hook inicial");
        }
        if (ctaSignals > 0) {
            reasons.add("Tem chamada para ação");
        }
        if (authoritySignals > 0) {
            reasons.add("Tem sinal de autoridade ou estrutura de método");
        }

        int finalScore = clamp(score);
        return new EvaluationResult(finalScore, statusFromScore(finalScore), reasons);
    }

    private CreativeStatus statusFromScore(int score) {
        if (score >= 75) {
            return CreativeStatus.MODELING_QUEUE;
        }
        if (score >= 60) {
            return CreativeStatus.SHORTLISTED;
        }
        if (score >= 40) {
            return CreativeStatus.HUMAN_REVIEW;
        }
        return CreativeStatus.REJECTED;
    }
}
