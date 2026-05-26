package br.com.gestaocriativos.repository;

import br.com.gestaocriativos.domain.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {
    Offer save(Offer offer);

    Optional<Offer> findById(String id);

    List<Offer> findAll();
}
