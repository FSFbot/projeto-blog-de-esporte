package com.blogesporte.esportes.Controllers;
import com.blogesporte.esportes.DTO.PublicationDTO;
import com.blogesporte.esportes.Service.PublicationsService;
import com.blogesporte.esportes.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationsService publicationService;

    @Autowired
    public PublicationController(PublicationsService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublication(@PathVariable Long id) {
        Publication publication = publicationService.findById(id);
        PublicationDTO publicationDTO = new PublicationDTO();
        return ResponseEntity.ok(publicationDTO);
    }

    @PostMapping
    public ResponseEntity<PublicationDTO> createPublication(@RequestBody PublicationDTO publicationDTO) {
        Publication publication = new Publication();
                Publication savedPublication = publicationService.savePublication(publication);
        PublicationDTO savedPublicationDTO = new PublicationDTO();
        return new ResponseEntity<>(savedPublicationDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublication(@PathVariable Long id, @RequestBody PublicationDTO publicationDTO) {
        Publication publication = new Publication();
                publication.setId(id);
        Publication updatedPublication = publicationService.savePublication(publication);
        PublicationDTO updatedPublicationDTO = new PublicationDTO();
        return ResponseEntity.ok(updatedPublicationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }

}
