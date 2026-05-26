package br.com.gestaocriativos.repository;

import br.com.gestaocriativos.domain.Offer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryOfferRepository implements OfferRepository {
    private final Map<String, Offer> offers = new LinkedHashMap<>();

    @Override
    public Offer save(Offer offer) {
        offers.put(offer.getId(), offer);
        return offer;
    }

    @Override
    public Optional<Offer> findById(String id) {
        return Optional.ofNullable(offers.get(id));
    }

    @Override
    public List<Offer> findAll() {
        return new ArrayList<>(offers.values());
    }
}
