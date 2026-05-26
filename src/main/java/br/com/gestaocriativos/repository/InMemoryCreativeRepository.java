package br.com.gestaocriativos.repository;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryCreativeRepository implements CreativeRepository {
    private final Map<String, Creative> creatives = new LinkedHashMap<>();

    @Override
    public Creative save(Creative creative) {
        creatives.put(creative.getId(), creative);
        return creative;
    }

    @Override
    public Optional<Creative> findById(String id) {
        return Optional.ofNullable(creatives.get(id));
    }

    @Override
    public List<Creative> findAll() {
        return new ArrayList<>(creatives.values());
    }

    @Override
    public List<Creative> findByStatus(CreativeStatus status) {
        return creatives.values()
                .stream()
                .filter(creative -> creative.getStatus() == status)
                .toList();
    }
}
