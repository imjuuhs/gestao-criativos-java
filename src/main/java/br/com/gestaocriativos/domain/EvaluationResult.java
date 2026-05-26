package br.com.gestaocriativos.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvaluationResult {
    private final int score;
    private final CreativeStatus status;
    private final List<String> reasons;

    public EvaluationResult(int score, CreativeStatus status, List<String> reasons) {
        this.score = Math.max(0, Math.min(100, score));
        this.status = status;
        this.reasons = new ArrayList<>(reasons);
    }

    public int getScore() {
        return score;
    }

    public CreativeStatus getStatus() {
        return status;
    }

    public List<String> getReasons() {
        return Collections.unmodifiableList(reasons);
    }
}
