package media.player.service;

import media.player.model.Composition;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface CompositionService {
    Composition save(Composition composition) throws IOException;

    Composition findById(String id);

    List<Composition> findAll();
}
