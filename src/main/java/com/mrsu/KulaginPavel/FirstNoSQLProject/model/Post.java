package com.mrsu.KulaginPavel.FirstNoSQLProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String title;
    private String text;
    private LocalDateTime creationDateTime = LocalDateTime.now();

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
