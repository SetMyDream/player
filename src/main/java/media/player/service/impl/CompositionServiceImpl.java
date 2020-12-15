package media.player.service.impl;

import media.player.model.Composition;
import media.player.repository.CompositionRepository;
import media.player.service.CompositionService;

import java.io.IOException;
import java.util.List;

public class CompositionServiceImpl implements CompositionService {
    private final CompositionRepository compositionRepository;

    public CompositionServiceImpl(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }

    @Override
    public Composition save(Composition composition) throws IOException {
        return compositionRepository.save(composition);
    }

    @Override
    public Composition findById(String id) {
        return compositionRepository.findById(id).get();
    }

    @Override
    public List<Composition> findAll() {
        return compositionRepository.findAll();
    }
}
