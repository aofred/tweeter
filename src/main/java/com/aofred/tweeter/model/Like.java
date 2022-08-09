package com.aofred.tweeter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Liketable")
public class Like extends AbstractPersistable<Long> {
    @ManyToOne
    @JoinColumn(name = "liked_post_id")
    private Post likedPost;

    @ManyToOne
    @JoinColumn(name = "like_by_id")
    private User likeBy;
}

