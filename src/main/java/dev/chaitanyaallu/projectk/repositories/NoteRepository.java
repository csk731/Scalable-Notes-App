package dev.chaitanyaallu.projectk.repositories;

import dev.chaitanyaallu.projectk.models.Note;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    Note save(Note note);
    List<Note> findAllByAlienIdEquals(UUID alienId);
    Note findByIdEquals(UUID id);
    void deleteByIdEquals(UUID id);
    //Optional<Note> findByIdAndAlienId(UUID noteId, UUID alienId);
    Optional<Note> findById(UUID id);


}
