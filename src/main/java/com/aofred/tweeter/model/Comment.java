package com.aofred.tweeter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment extends AbstractPersistable<Long> {

    @ManyToOne
    @JoinColumn(name = "commented_post_id")
    private Post commentedPost;
}
