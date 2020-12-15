package media.player.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/music")
public class CompositionController {
    private final CompositionService soongService;
    private final CompositionMapper compositionMapper;
    private final CompositionResponseMapper compositionResponseMapper;

    public CompositionController(CompositionService compositionService,
                          CompositionMapper compositionMapper,
                          CompositionResponseMapper compositionResponseMapper) {
        this.compositionService = compositionService;
        this.compositionMapper = compositionMapper;
        this.compositionResponseMapper = compositionResponseMapper;
    }

    @GetMapping
    public ResponseEntity<List<CompositionResponseDto>> getAll() {
        List<CompositionResponseDto> compositionResponseDtos = compositionService.findAll().stream()
                .map(compositionResponseMapper::mapCompositionToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(compositionResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> findById(@PathVariable("id") Long id) {
        Composition composition = compositionService.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + composition.getName() + "\"")
                .body(composition.getFile());
    }

    @PostMapping
    public ResponseEntity<MessageResponseDto> upload(@RequestParam("file") MultipartFile file,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("singer") String singer,
                                                     @RequestParam("squad") String group,
                                                     @RequestParam("genre") String genre,
                                                     @RequestParam("country") String country,
                                                     @RequestParam("year") String year) {
        CompositionRequestDto compositionRequestDto = CompositionRequestDto.builder()
                .file(file)
                .name(name)
                .singer(singer)
                .squad(group)
                .gender(genre)
                .country(country)
                .year(year)
                .build();
        String responseMessage = "";
        try {
            Composition composition = compositionMapper.mapCompositionRequestDtoToComposition(compositionRequestDto);
            compositionService.save(composition);
            responseMessage = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new MessageResponseDto(responseMessage));
        } catch (Exception e) {
            responseMessage = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new MessageResponseDto(responseMessage));
        }
    }

}
