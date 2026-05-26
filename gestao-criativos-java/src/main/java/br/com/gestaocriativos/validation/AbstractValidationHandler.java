package br.com.gestaocriativos.validation;

public abstract class AbstractValidationHandler implements CreativeValidationHandler {
    private CreativeValidationHandler next;

    @Override
    public CreativeValidationHandler setNext(CreativeValidationHandler next) {
        this.next = next;
        return next;
    }

    @Override
    public void validate(ValidationContext context) {
        handle(context);
        if (next != null) {
            next.validate(context);
        }
    }

    protected abstract void handle(ValidationContext context);
}
