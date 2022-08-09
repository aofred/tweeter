package com.aofred.tweeter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post extends AbstractPersistable<Long> {

    private String content;
    private LocalDateTime postDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "commentedPost")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "likedPost")
    private List<Like> likes;
}
