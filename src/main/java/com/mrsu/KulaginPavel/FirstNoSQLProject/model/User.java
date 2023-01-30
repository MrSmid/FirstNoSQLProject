package com.mrsu.KulaginPavel.FirstNoSQLProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    @Indexed
    private String username;
    private LocalDateTime registrationDateTime = LocalDateTime.now();
    private List<Post> posts;

    public User(String username, List<Post> posts) {
        this.username = username;
        this.posts = posts;
    }
}
