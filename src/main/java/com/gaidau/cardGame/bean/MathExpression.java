package com.gaidau.cardGame.bean;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "expressions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathExpression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String expression;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id")
    private Game game;
}
