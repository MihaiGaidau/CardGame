package com.gaidau.cardGame.service;

import com.gaidau.cardGame.bean.Card;
import com.gaidau.cardGame.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
