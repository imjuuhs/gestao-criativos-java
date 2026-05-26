package br.com.gestaocriativos.validation;

public interface CreativeValidationHandler {
    CreativeValidationHandler setNext(CreativeValidationHandler next);

    void validate(ValidationContext context);
}
