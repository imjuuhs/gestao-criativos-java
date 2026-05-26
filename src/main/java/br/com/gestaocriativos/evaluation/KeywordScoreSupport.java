package br.com.gestaocriativos.evaluation;

import java.text.Normalizer;
import java.util.List;

public abstract class KeywordScoreSupport implements CreativeEvaluator {
    protected int countSignals(String text, List<String> signals) {
        String normalizedText = normalize(text);
        int count = 0;

        for (String signal : signals) {
            if (normalizedText.contains(normalize(signal))) {
                count++;
            }
        }

        return count;
    }

    protected String normalize(String text) {
        if (text == null) {
            return "";
        }
        String normalized = Normalizer.normalize(text.toLowerCase(), Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }

    protected int clamp(int score) {
        return Math.max(0, Math.min(100, score));
    }
}
