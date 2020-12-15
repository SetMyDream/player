package media.player.service;

import media.player.model.Composition;

import java.io.IOException;

public interface CompositionService {
    Composition save(Composition composition) throws IOException;

    Composition findById(String id);

    List<Composition> findAll();
}
