package com.example.notesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesapi.service.NoteService;
import com.example.notesapi.dto.NoteResponse;
import com.example.notesapi.dto.UpdateNoteRequest;
import com.example.notesapi.dto.CreateNoteRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/notes")

public class NoteController {
    private final NoteService noteService;
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    
    @PostMapping
    public NoteResponse createNote(
            @RequestBody CreateNoteRequest request
    ){
        return noteService.createNote(request);
    }

    @GetMapping
    public List<NoteResponse> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public NoteResponse getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/{id}")
    public NoteResponse uNoteResponse(
        @PathVariable Long id,
        @RequestBody UpdateNoteRequest request
    ){
        return noteService.updateNote(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }
    
    
}
