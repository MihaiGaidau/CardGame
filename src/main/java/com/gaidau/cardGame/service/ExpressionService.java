package com.gaidau.cardGame.service;

import com.gaidau.cardGame.bean.Card;
import com.gaidau.cardGame.bean.Expression;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExpressionService {

    private final StringPermutations stringPermutations;
    private final NextPermutation nextPermutation;

    public List<Expression> getMatches(List<Card> selectedCards, Integer result) {
        List<Expression> myList = new ArrayList<>();
        List<Integer> selectedCardsValues = new ArrayList<>();
        for (Card selectedCard : selectedCards) {
            selectedCardsValues.add(selectedCard.getValue());
        }

        List<List<Integer>> allPermutations = nextPermutation.allListPermutations(selectedCardsValues);
        List<String> allSymbPermutations = stringPermutations.allSymbolsPermutations(selectedCardsValues.size(), 4);

        for (List<Integer> list : allPermutations) {
            for (String symbols : allSymbPermutations) {
                if (evalExpression(createExpression(list, symbols)).equals((double) result)) {
                    myList.add(new Expression(list, symbols));
                }
            }
        }
        log.info("allPermutations: " + allPermutations.toString());
        log.info("Mihai" + allSymbPermutations.toString());
        log.info("allMatches: " + myList.toString());

        return myList;
    }

    @SneakyThrows
    private Double evalExpression(String expression) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        if (result instanceof Integer) {
            Integer intResult = (Integer) result;
            return intResult.doubleValue();
        }
        if (result instanceof Double)
            return (Double) result;
        log.info("result:" + result.toString());
        return (double) 0;
    }

    private String createExpression(List<Integer> numbers, String symbols) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < numbers.size() - 1; i++) {
            expression.append(numbers.get(i).toString()).append(symbols.charAt(i));
        }
        expression.append(numbers.get(numbers.size() - 1).toString());
        return expression.toString();
    }
}
