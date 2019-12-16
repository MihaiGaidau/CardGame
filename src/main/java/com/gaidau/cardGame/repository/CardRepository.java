package com.gaidau.cardGame.repository;

import com.gaidau.cardGame.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
