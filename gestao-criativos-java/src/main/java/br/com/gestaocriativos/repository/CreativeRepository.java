package br.com.gestaocriativos.repository;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;

import java.util.List;
import java.util.Optional;

public interface CreativeRepository {
    Creative save(Creative creative);

    Optional<Creative> findById(String id);

    List<Creative> findAll();

    List<Creative> findByStatus(CreativeStatus status);
}
