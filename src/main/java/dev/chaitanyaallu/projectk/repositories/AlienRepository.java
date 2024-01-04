package dev.chaitanyaallu.projectk.repositories;

import dev.chaitanyaallu.projectk.models.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlienRepository extends JpaRepository<Alien, UUID> {
    Alien save(Alien alien);
    Optional<Alien> findById(UUID id);
}
