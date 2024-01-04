package dev.chaitanyaallu.projectk.services;

import dev.chaitanyaallu.projectk.dtos.*;
import dev.chaitanyaallu.projectk.exceptions.AlienNotFoundException;
import dev.chaitanyaallu.projectk.exceptions.SharingToSelfException;
import dev.chaitanyaallu.projectk.models.Alien;
import dev.chaitanyaallu.projectk.models.Note;
import dev.chaitanyaallu.projectk.repositories.AlienRepository;
import dev.chaitanyaallu.projectk.repositories.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepository;
    private AlienRepository alienRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, AlienRepository alienRepository) {
        this.noteRepository = noteRepository;
        this.alienRepository = alienRepository;
    }

    @Override
    public NoteResponseDto createNote(CreateNoteRequestDto request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setAlien(alienRepository.findById(UUID.fromString(request.getAlienId())).get());

        Note savedNote = noteRepository.save(note);

        NoteResponseDto responseNoteDto = new NoteResponseDto();
        responseNoteDto.setTitle(savedNote.getTitle());
        responseNoteDto.setContent(savedNote.getContent());
        responseNoteDto.setId(savedNote.getId().toString());

        return responseNoteDto;

    }
    @Override
    public List<NoteResponseDto> getNotes(GetNotesRequestDto request) throws Exception {
        Optional<Alien> optionalAlien = alienRepository.findById(UUID.fromString(request.getAlienId()));
        if(optionalAlien.isEmpty()){
            throw new AlienNotFoundException("Alien not found with id: " + request.getAlienId() + "!");
        }
        List<Note> notes = noteRepository.findAllByAlienIdEquals(UUID.fromString(request.getAlienId()));

        List<NoteResponseDto> noteResponseDtos =  new ArrayList<>();

        for(Note note: notes){
            NoteResponseDto noteResponseDto = new NoteResponseDto();
            noteResponseDto.setTitle(note.getTitle());
            noteResponseDto.setId(note.getId().toString());
            noteResponseDto.setContent(note.getContent());
            noteResponseDtos.add(noteResponseDto);
        }
        return noteResponseDtos;

    }

    @Override
    public NoteResponseDto getNote(String id) {
        Note note = noteRepository.findByIdEquals(UUID.fromString(id));
        NoteResponseDto noteResponseDto = new NoteResponseDto();
        noteResponseDto.setId(note.getId().toString());
        noteResponseDto.setTitle(note.getTitle());
        noteResponseDto.setContent(note.getContent());
        return noteResponseDto;
    }

    @Override
    public NoteResponseDto updateNote(String id, DeleteNoteRequestDto request) {
        Note note = new Note();
        note.setId(UUID.fromString(id));
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        Note updatedNote = noteRepository.save(note);
        NoteResponseDto noteResponseDto = new NoteResponseDto();
        noteResponseDto.setId(updatedNote.getId().toString());
        noteResponseDto.setTitle(updatedNote.getTitle());
        noteResponseDto.setContent(updatedNote.getContent());
        return noteResponseDto;
    }

    @Override
    @Transactional
    public void deleteNote(String id) {
        noteRepository.deleteByIdEquals(UUID.fromString(id));
    }

    @Override
    public void shareNote(ShareNoteRequestDto request, String noteId) throws Exception{
        if(!alienRepository.findById(UUID.fromString(request.getAlienId())).isPresent()){
            throw new AlienNotFoundException("Alien not found with id: " + request.getAlienId() + "!");
        }
        if(request.getAlienId().equals(request.getToAlienId())){
            throw new SharingToSelfException("Cannot share note to self!");
        }

        if(!alienRepository.findById(UUID.fromString(request.getToAlienId())).isPresent()){
            throw new AlienNotFoundException("To-Alien not found with id: " + request.getToAlienId() + "!");
        }
        //if(!noteRepository.findByNoteIdAndAlienId(UUID.fromString(request.getNoteId()), UUID.fromString(request.getAlienId())).isPresent()){
            // throw exception
        //}

        Optional<Note> optionalNote = noteRepository.findById(UUID.fromString(noteId));

        CreateNoteRequestDto createNoteRequestDto = new CreateNoteRequestDto();
        createNoteRequestDto.setAlienId(request.getToAlienId());
        createNoteRequestDto.setTitle(optionalNote.get().getTitle());
        createNoteRequestDto.setContent(optionalNote.get().getContent());
        this.createNote(createNoteRequestDto);
    }

    @Override
    public List<Note> searchNotes() {
        return null;
    }
}
