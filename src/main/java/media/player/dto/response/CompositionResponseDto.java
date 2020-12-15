package media.player.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompositionResponseDto {
    private Long id;
    private String name;
    private String originName;
    private String singer;
    private String band;
    private String genre;
    private String year;
    private String type;
    private double size;
    private String url;
}
