package br.com.gestaocriativos.validation;

import br.com.gestaocriativos.domain.Creative;

public class RequiredFieldsValidation extends AbstractValidationHandler {
    @Override
    protected void handle(ValidationContext context) {
        Creative creative = context.getCreative();

        if (isBlank(creative.getTitle())) {
            context.addError("O título do criativo é obrigatório");
        }
        if (isBlank(creative.getPrimaryText())) {
            context.addError("O texto principal do criativo é obrigatório");
        }
        if (isBlank(creative.getOfferId())) {
            context.addError("O criativo precisa estar ligado a uma oferta");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
