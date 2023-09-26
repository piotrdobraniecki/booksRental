package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
