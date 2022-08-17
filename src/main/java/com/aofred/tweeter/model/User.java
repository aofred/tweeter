package com.aofred.tweeter.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Usertable") // User & like reserved keywords
public class User extends AbstractPersistable<Long> {

    @NotEmpty
    @Size(min = 5, max = 30)
    private String fullName;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 100)
    private String password;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "followee")
    @ToString.Exclude
    private List<Follow> followers = new ArrayList<>();

    @OneToMany(mappedBy = "follower")
    @ToString.Exclude
    private List<Follow> following = new ArrayList<>();

    @OneToMany(mappedBy = "likeBy")
    @ToString.Exclude
    private List<Like> likes = new ArrayList<>();

}
