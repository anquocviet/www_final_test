package fit.se.de_03.repositories;

import fit.se.de_03.models.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
}