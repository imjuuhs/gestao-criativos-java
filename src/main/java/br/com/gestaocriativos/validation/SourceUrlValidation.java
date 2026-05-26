package br.com.gestaocriativos.validation;

public class SourceUrlValidation extends AbstractValidationHandler {
    @Override
    protected void handle(ValidationContext context) {
        String sourceUrl = context.getCreative().getSourceUrl();
        if (sourceUrl == null || sourceUrl.trim().isEmpty()) {
            context.addWarning("O criativo foi cadastrado sem URL de origem");
            return;
        }

        String normalized = sourceUrl.toLowerCase();
        if (normalized.contains("wa.me") || normalized.contains("whatsapp")) {
            context.addWarning("O destino parece ser WhatsApp direto; pode faltar contexto para analisar a oferta");
        }
    }
}
