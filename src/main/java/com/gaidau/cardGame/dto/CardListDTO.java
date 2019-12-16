package com.gaidau.cardGame.dto;

import com.gaidau.cardGame.bean.Card;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CardListDTO {
    private ArrayList<Card> cardList;
    private Integer value;


}
