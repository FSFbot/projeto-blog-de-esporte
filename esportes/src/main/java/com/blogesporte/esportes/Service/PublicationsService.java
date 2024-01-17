package com.blogesporte.esportes.Service;

import com.blogesporte.esportes.Repository.PublicationRepository;
import com.blogesporte.esportes.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublicationsService {
    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationsService(PublicationRepository publicationRepository){
        this.publicationRepository = publicationRepository;
    }
    @Transactional(readOnly = true)
    public Publication findById(Long id){
        return publicationRepository.findById(id).orElseThrow(() -> new PublicationNotFoundException(id));
    }
    @Transactional
    public Publication savePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Transactional
    public void deletePublication(Long id) {
        Publication publication = findById(id);
        publicationRepository.delete(publication);
    }

    @Transactional(readOnly = true)
    public List<Publication> findAllPublications() {
        return publicationRepository.findAll();
    }
    static class PublicationNotFoundException extends RuntimeException {
        PublicationNotFoundException(Long id) {
            super("Could not find publication " + id);
        }
}
};
