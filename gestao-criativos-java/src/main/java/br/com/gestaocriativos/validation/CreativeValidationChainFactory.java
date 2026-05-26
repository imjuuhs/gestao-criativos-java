package br.com.gestaocriativos.validation;

public class CreativeValidationChainFactory {
    public CreativeValidationHandler createDefaultChain() {
        CreativeValidationHandler required = new RequiredFieldsValidation();
        CreativeValidationHandler offerExists = new OfferExistsValidation();
        CreativeValidationHandler copyLength = new CopyLengthValidation();
        CreativeValidationHandler sourceUrl = new SourceUrlValidation();

        required.setNext(offerExists).setNext(copyLength).setNext(sourceUrl);
        return required;
    }
}
