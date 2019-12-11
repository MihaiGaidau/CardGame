package com.gaidau.cardGame.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GAMES")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Game {
    private String selectedCards;
    private Integer value;


}
