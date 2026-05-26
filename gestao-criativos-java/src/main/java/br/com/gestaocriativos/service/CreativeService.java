package br.com.gestaocriativos.service;

import br.com.gestaocriativos.domain.Creative;
import br.com.gestaocriativos.domain.CreativeStatus;
import br.com.gestaocriativos.repository.CreativeRepository;

import java.util.Comparator;
import java.util.List;

public class CreativeService {
    private final CreativeRepository creativeRepository;

    public CreativeService(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    public Creative save(Creative creative) {
        return creativeRepository.save(creative);
    }

    public Creative findById(String id) {
        return creativeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Criativo não encontrado"));
    }

    public List<Creative> listAll() {
        return creativeRepository.findAll();
    }

    public List<Creative> listModelingQueue() {
        return creativeRepository.findByStatus(CreativeStatus.MODELING_QUEUE)
                .stream()
                .sorted(Comparator.comparing(Creative::getScore).reversed())
                .toList();
    }
}
