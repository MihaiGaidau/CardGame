package com.gaidau.cardGame.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    public List<String> findAll(){
        List<String> allCards = new ArrayList<>();
        allCards = Arrays.asList("A", "2", "3", "4", "5","6","7","8","9","10","J","Q","K");
        return allCards;

    }
}
