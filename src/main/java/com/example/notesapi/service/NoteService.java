package com.example.notesapi.service;
import com.example.notesapi.dto.CreateNoteRequest;
import com.example.notesapi.dto.NoteResponse;
import com.example.notesapi.dto.UpdateNoteRequest;
import com.example.notesapi.repository.NoteRepository;
import com.example.notesapi.entity.Note;

import java.util.List;

import org.springframework.core.retry.RetryException;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;   
    
    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    public NoteResponse createNote(CreateNoteRequest request){
        Note note = new Note(request.getTitle(),request.getContent());
        Note savedNote = noteRepository.save(note);
        return new NoteResponse(
            savedNote.getId(),
            savedNote.getTitle(),
            savedNote.getContent(),
            savedNote.getCreatedAt(),
            savedNote.getUpdatedAt()
        );
    }


    public List<NoteResponse> getAllNotes(){

        return noteRepository.findAll()
        .stream()
        .map(note -> new NoteResponse(
            note.getId(),
            note.getTitle(), 
            note.getContent(),
            note.getCreatedAt(), 
            note.getUpdatedAt()
        )).toList();
        
    }

    public NoteResponse getNoteById(Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));

        return new NoteResponse(
            note.getId(),
            note.getTitle(),
            note.getContent(),
            note.getCreatedAt(),
            note.getUpdatedAt()
        );
    }

    public NoteResponse updateNote(Long id, UpdateNoteRequest request){
        Note note = noteRepository.findById(id)
                  .orElseThrow( ()-> new RuntimeException("Note not found"));
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        Note updatedNote = noteRepository.save(note);

        return new NoteResponse(
            updatedNote.getId(),
            updatedNote.getTitle(),
            updatedNote.getContent(),
            updatedNote.getCreatedAt(),
            updatedNote.getUpdatedAt()
        );
    }

    public void deleteNote(Long id){
        if(!noteRepository.existsById(id)){
            throw new RuntimeException("Note not found");
        }
            noteRepository.deleteById(id);
        
        
    }
}
