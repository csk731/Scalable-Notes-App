package dev.chaitanyaallu.projectk.services;

import dev.chaitanyaallu.projectk.dtos.*;
import dev.chaitanyaallu.projectk.exceptions.AlienNotFoundException;
import dev.chaitanyaallu.projectk.models.Note;

import java.util.List;

public interface NoteService {
    List<NoteResponseDto> getNotes(GetNotesRequestDto request) throws Exception;
    NoteResponseDto getNote(String id);
    NoteResponseDto createNote(CreateNoteRequestDto request);
    NoteResponseDto updateNote(String id, DeleteNoteRequestDto request);
    void deleteNote(String id);
    void shareNote(ShareNoteRequestDto request, String noteId) throws Exception;
    List<Note> searchNotes();
}
