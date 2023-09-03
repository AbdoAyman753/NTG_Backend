package com.ntg.videogames.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Game {
    @Id
    @SequenceGenerator(name = "game_seq", sequenceName = "GAME_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    Long id;
    @Column(nullable = false, unique = true)
    String title;
    String description;
    @Column(nullable = false)
    Double price;
    String coverImage;
    Date releaseDate = new Date();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "GAME_CATEGORIES",
            joinColumns = {
                    @JoinColumn(name = "game_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "id")
            }
    )
    Set<Category> categories;

    @ManyToMany(mappedBy = "library", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<User> users;
}
