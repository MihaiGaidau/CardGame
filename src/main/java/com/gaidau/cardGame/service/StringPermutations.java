package com.gaidau.cardGame.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringPermutations {

    public List<String> allSymbolsPermutations(Integer len,Integer base){
        List<String> list = new ArrayList<>();
        List<Integer> number = new ArrayList<Integer>(Collections.nCopies(len-1, 0));
        list.add(convertNumberToSymbols(number));
        while (!isMax(number,base)){
//            plusOne(number, base);
            list.add(convertNumberToSymbols(plusOne(number,base)));
        }

        return list;
    }
    private List<Integer> plusOne(List<Integer> number, Integer base){
        number.set(number.size()-1, number.get(number.size()-1) + 1);
        int mindValue = 0;
        for (int i = number.size()-1; i>=0; i--){
            number.set(i,number.get(i)+mindValue);
            if (number.get(i).equals(base)){
                number.set(i,0);
                mindValue = 1;
            }
            else
                mindValue = 0;
        }
        return number;
    }
    private String convertNumberToSymbols(List<Integer> number){

//        return number.stream().map(x -> {
//
//            return "";
//        }).toString();
        StringBuilder symbols = new StringBuilder();
        for(Integer digit:number){
            if (digit == 0)
                symbols.append('+');
            if (digit == 1)
                symbols.append('-');
            if (digit == 2)
                symbols.append('*');
            if (digit == 3)
                symbols.append('/');

        }
        return symbols.toString();
    }

    private boolean isMax(List<Integer>number, Integer base){
        for (Integer digit : number)
            if (digit != (base - 1))
                return false;
        return true;
    }

}
