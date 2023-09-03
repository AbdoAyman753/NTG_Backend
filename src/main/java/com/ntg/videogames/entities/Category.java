package com.ntg.videogames.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category {
//    public Category (String name){
//        this.name = name;
//    }
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    Long id;
    @Column(nullable = false,unique = true)
    String name;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
//    @JsonBackReference
    @JsonIgnore
    private Set<Game> games;
}
