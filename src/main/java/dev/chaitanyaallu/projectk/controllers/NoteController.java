package dev.chaitanyaallu.projectk.controllers;

import dev.chaitanyaallu.projectk.dtos.*;
import dev.chaitanyaallu.projectk.models.Note;
import dev.chaitanyaallu.projectk.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public NoteResponseDto createNote(@Valid @RequestBody CreateNoteRequestDto request){
        return noteService.createNote(request);
    }
    @GetMapping("/notes")
    public List<NoteResponseDto> getNotes(@Valid @RequestBody GetNotesRequestDto request) throws Exception{
        return noteService.getNotes(request);
    }
    @GetMapping("/notes/{id}")
    public NoteResponseDto getNote(@PathVariable String id){
        return noteService.getNote(id);
    }
    @PutMapping("/notes/{id}")
    public NoteResponseDto updateNote(@PathVariable String id, @Valid @RequestBody DeleteNoteRequestDto request){
        return noteService.updateNote(id, request);
    }
    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable String id){
        noteService.deleteNote(id);
    }
    @PostMapping("/notes/{id}/share")
    public void shareNote(@RequestBody ShareNoteRequestDto request, @PathVariable("id") String noteId) throws Exception{
        noteService.shareNote(request, noteId);
    }
    @GetMapping("/search")
    public List<Note> searchNotes(){
        return null;
    }

}
