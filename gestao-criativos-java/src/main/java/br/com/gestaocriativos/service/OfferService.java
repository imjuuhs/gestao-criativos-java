package br.com.gestaocriativos.service;

import br.com.gestaocriativos.domain.Offer;
import br.com.gestaocriativos.domain.OfferNiche;
import br.com.gestaocriativos.repository.OfferRepository;

import java.util.List;

public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer createOffer(String name, OfferNiche niche, int priceInCents, boolean whatsappSale) {
        Offer offer = new Offer(name, niche, priceInCents, whatsappSale);
        return offerRepository.save(offer);
    }

    public Offer findById(String id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Oferta não encontrada"));
    }

    public List<Offer> listAll() {
        return offerRepository.findAll();
    }
}
