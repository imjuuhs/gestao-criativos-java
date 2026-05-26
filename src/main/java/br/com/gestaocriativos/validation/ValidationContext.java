package br.com.gestaocriativos.validation;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.repository.OfferRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationContext {
    private final Creative creative;
    private final OfferRepository offerRepository;
    private final List<String> errors = new ArrayList<>();
    private final List<String> warnings = new ArrayList<>();

    public ValidationContext(Creative creative, OfferRepository offerRepository) {
        this.creative = creative;
        this.offerRepository = offerRepository;
    }

    public Creative getCreative() {
        return creative;
    }

    public OfferRepository getOfferRepository() {
        return offerRepository;
    }

    public void addError(String error) {
        errors.add(error);
    }

    public void addWarning(String warning) {
        warnings.add(warning);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public List<String> getWarnings() {
        return Collections.unmodifiableList(warnings);
    }
}
