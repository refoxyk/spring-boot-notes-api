 package com.example.notesapi.dto;

import java.time.LocalDateTime;

public class NoteResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatetAt;

    public NoteResponse(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatetAt ){
            this.id = id;
            this.title = title;
            this.content = content;
            this.createdAt = createdAt;
            this.updatetAt = updatetAt;
    }
    

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public LocalDateTime getCreatedDateTime(){
        return createdAt;
    }
    public LocalDateTime getUpdateDateTime(){
        return updatetAt;
    }


}