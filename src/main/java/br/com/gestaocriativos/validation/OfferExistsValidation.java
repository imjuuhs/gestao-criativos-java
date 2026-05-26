package br.com.gestaocriativos.validation;

public class OfferExistsValidation extends AbstractValidationHandler {
    @Override
    protected void handle(ValidationContext context) {
        String offerId = context.getCreative().getOfferId();
        if (offerId == null || offerId.trim().isEmpty()) {
            return;
        }

        boolean exists = context.getOfferRepository().findById(offerId).isPresent();
        if (!exists) {
            context.addError("A oferta informada não foi encontrada");
        }
    }
}
