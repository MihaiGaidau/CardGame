package com.gaidau.cardGame.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="EXPRESSIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MathExpression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String expression;

    @ManyToOne(optional=false)
    @JoinColumn(name="game_id")
    private Game game;
}
