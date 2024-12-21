package fit.se.de_03.services;

import fit.se.de_03.models.Experience;
import fit.se.de_03.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @description
 * @author: vie
 * @date: 21/12/24
 */
@Service
public class ExperienceService {
   private final ExperienceRepository experienceRepository;

   public ExperienceService(ExperienceRepository experienceRepository) {
      this.experienceRepository = experienceRepository;
   }

   public List<Experience> findAll() {
      return (List<Experience>) experienceRepository.findAll();
   }

   public Experience findById(Long id) {
      return experienceRepository.findById(id).orElseThrow(
            () -> new NoSuchElementException("Experience with id " + id + " not found")
      );
   }

   public Experience save(Experience candidate) {

      return experienceRepository.save(candidate);
   }

   public Experience update(Experience experience) {
      if (!experienceRepository.existsById(experience.getId())) {
         throw new NoSuchElementException("Experience with id " + experience.getId() + " not found");
      }
      return experienceRepository.save(experience);
   }

   public boolean delete(Long id) {
      if (!experienceRepository.existsById(id)) {
         throw new NoSuchElementException("Experience with id " + id + " not found");
      }
      experienceRepository.deleteById(id);
      return true;
   }
}
