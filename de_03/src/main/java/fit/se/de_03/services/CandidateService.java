package fit.se.de_03.services;

import fit.se.de_03.models.Candidate;
import fit.se.de_03.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @description
 * @author: vie
 * @date: 21/12/24
 */
@Service
public class CandidateService {
   private final CandidateRepository candidateRepository;

   public CandidateService(CandidateRepository candidateRepository) {
      this.candidateRepository = candidateRepository;
   }

   public List<Candidate> findAll() {
      return (List<Candidate>) candidateRepository.findAll();
   }

   public Candidate findById(Long id) {
      return candidateRepository.findById(id).orElseThrow(
            () -> new NoSuchElementException("Candidate with id " + id + " not found")
      );
   }

   public Candidate save(Candidate candidate) {

      return candidateRepository.save(candidate);
   }

   public Candidate update(Candidate candidate) {
      if (!candidateRepository.existsById(candidate.getId())) {
         throw new NoSuchElementException("Candidate with id " + candidate.getId() + " not found");
      }
      return candidateRepository.save(candidate);
   }

   public boolean delete(Long id) {
      if (!candidateRepository.existsById(id)) {
         throw new NoSuchElementException("Candidate with id " + id + " not found");
      }
      candidateRepository.deleteById(id);
      return true;
   }
}
