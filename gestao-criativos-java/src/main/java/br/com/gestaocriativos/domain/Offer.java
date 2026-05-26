package br.com.gestaocriativos.domain;

import java.util.Objects;
import java.util.UUID;

public class Offer {
    private final String id;
    private final String name;
    private final OfferNiche niche;
    private final int priceInCents;
    private final boolean whatsappSale;
    private boolean active;

    public Offer(String name, OfferNiche niche, int priceInCents, boolean whatsappSale) {
        this.id = UUID.randomUUID().toString();
        this.name = requireText(name, "O nome da oferta é obrigatório");
        this.niche = Objects.requireNonNull(niche, "O nicho é obrigatório");
        if (priceInCents <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero");
        }
        this.priceInCents = priceInCents;
        this.whatsappSale = whatsappSale;
        this.active = true;
    }

    private String requireText(String value, String message) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return value.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OfferNiche getNiche() {
        return niche;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public boolean isWhatsappSale() {
        return whatsappSale;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }
}
