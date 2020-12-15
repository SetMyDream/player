package media.player.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "compositions")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Lob
    private byte[] file;
    private String name;
    private String originName;
    private String singer;
    private String band;
    private String genre;
    private String year;
    private String type;
}
