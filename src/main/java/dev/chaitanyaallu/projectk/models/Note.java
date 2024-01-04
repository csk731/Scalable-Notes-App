package dev.chaitanyaallu.projectk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "alien_id")
    private Alien alien;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    @Lob
    private String content;
}
