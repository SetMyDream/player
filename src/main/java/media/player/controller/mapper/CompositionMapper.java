package media.player.controller.mapper;

import media.player.dto.request.CompositionRequestDto;
import media.player.model.Composition;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CompositionMapper {
    public Composition mapCompositionRequestDtoToComposition(CompositionRequestDto songRequestDto) throws IOException {
        Composition song = new Composition();
        song.setFile(songRequestDto.getFile().getBytes());
        song.setName(songRequestDto.getName());
        song.setSinger(songRequestDto.getSinger());
        song.setBand(songRequestDto.getBand());
        song.setGenre(songRequestDto.getGenre());
        song.setYear(songRequestDto.getYear());

        String originName = StringUtils.cleanPath(songRequestDto.getFile().getOriginalFilename());
        song.setOriginName(originName);
        song.setType(songRequestDto.getFile().getContentType());
        return song;
    }
}
