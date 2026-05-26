package br.com.gestaocriativos.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Creative {
    private final String id;
    private String title;
    private String primaryText;
    private String sourceUrl;
    private CreativeType type;
    private String offerId;
    private CreativeStatus status;
    private int score;
    private final List<String> notes;
    private final LocalDateTime createdAt;

    public Creative(String title, String primaryText, String sourceUrl, CreativeType type, String offerId) {
        this.id = UUID.randomUUID().toString();
        this.title = normalize(title);
        this.primaryText = normalize(primaryText);
        this.sourceUrl = normalize(sourceUrl);
        this.type = Objects.requireNonNull(type, "O tipo do criativo é obrigatório");
        this.offerId = normalize(offerId);
        this.status = CreativeStatus.DRAFT;
        this.score = 0;
        this.notes = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }

    private String normalize(String value) {
        if (value == null) {
            return "";
        }
        return value.trim();
    }

    public void applyEvaluation(EvaluationResult result) {
        this.score = result.getScore();
        this.status = result.getStatus();
        this.notes.clear();
        this.notes.addAll(result.getReasons());
    }

    public void addNote(String note) {
        if (note != null && !note.trim().isEmpty()) {
            this.notes.add(note.trim());
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrimaryText() {
        return primaryText;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public CreativeType getType() {
        return type;
    }

    public String getOfferId() {
        return offerId;
    }

    public CreativeStatus getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public List<String> getNotes() {
        return Collections.unmodifiableList(notes);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
