package media.player.mapper;

import media.player.dto.response.CompositionResponseDto;
import media.player.model.Composition;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class CompositionResponseMapper {
    public CompositionResponseDto mapCompositionToResponseDto(Composition song) {
        String name = song.getName().isEmpty() ? song.getOriginName() : song.getName();
        String url = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/songs/")
                .path(String.valueOf(song.getId()))
                .toUriString();

        return CompositionResponseDto.builder()
                .id(song.getId())
                .name(name)
                .singer(song.getSinger())
                .band(song.getBand())
                .genre(song.getGenre())
                .year(song.getYear())
                .type(song.getType())
                .size(song.getFile().length)
                .url(url)
                .build();
    }
}
