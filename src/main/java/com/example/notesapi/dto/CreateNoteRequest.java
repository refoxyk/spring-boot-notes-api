package com.example.notesapi.dto;

public class CreateNoteRequest {
    private String title;
    private String content;
    
    public CreateNoteRequest(){
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
     
}
