package br.com.gestaocriativos.validation;

public class CopyLengthValidation extends AbstractValidationHandler {
    private static final int MINIMUM_TEXT_SIZE = 30;
    private static final int LONG_COPY_LIMIT = 900;

    @Override
    protected void handle(ValidationContext context) {
        String text = context.getCreative().getPrimaryText();
        int length = text == null ? 0 : text.length();

        if (length > 0 && length < MINIMUM_TEXT_SIZE) {
            context.addWarning("O texto está curto demais para avaliar a estrutura de venda");
        }

        if (length > LONG_COPY_LIMIT) {
            context.addWarning("O texto parece long copy e deve passar por revisão manual antes da modelagem");
        }
    }
}
