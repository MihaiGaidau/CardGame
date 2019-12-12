package com.gaidau.cardGame.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CARDS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String path;


    @JsonManagedReference
    @ManyToMany(mappedBy = "cards")
    private List<Game> games = new ArrayList<>();


}
