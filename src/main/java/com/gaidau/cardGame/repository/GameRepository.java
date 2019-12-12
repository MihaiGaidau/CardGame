package com.gaidau.cardGame.repository;

import com.gaidau.cardGame.bean.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
