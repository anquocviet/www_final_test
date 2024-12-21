package fit.se.de_03.repositories;

import fit.se.de_03.models.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Long> {
}