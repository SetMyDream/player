package media.player.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class CompositionRequestDto {
    private MultipartFile file;
    private String name;
    private String originName;
    private String singer;
    private String band;
    private String genre;
    private String year;
}
