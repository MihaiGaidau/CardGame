package com.gaidau.cardGame.service;

import com.gaidau.cardGame.bean.Expression;
import com.gaidau.cardGame.service.StringPermutations;
import com.sun.security.jgss.InquireSecContextPermission;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import static com.gaidau.cardGame.service.NextPermutation.findNextPermutation;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExpressionService {

    private final StringPermutations stringPermutations;
    private final NextPermutation nextPermutation;

    public List<Expression> getMatches(List<Integer> selectedCards, Integer result){
        List<Expression>  myList= new ArrayList<>();


//        if (!findNextPermutation(selectedCards))
//            log.info("There is no higher"
//                    + " order permutation "
//                    + "for the given data.");
//        else {
//           log.info("myArray: "+Arrays.toString(new List[]{selectedCards}));
//        }
        List<List<Integer>> allPermutations = nextPermutation.allListPermutations(selectedCards);
        List<String> allSymbPermutations = stringPermutations.allSymbolsPermutations(selectedCards.size(),4);

        for (List<Integer> list : allPermutations){
            for (String symbols : allSymbPermutations){
                if (evalExpression(createExpression(list, symbols)).equals((double)result)){
                  myList.add(new Expression(list,symbols));
                }
            }
        }


            log.info("allPermutations: "+allPermutations.toString());
            log.info("Mihai" + allSymbPermutations.toString());
            log.info("allMatches: "+ myList.toString());


        return  myList;
    }
    @SneakyThrows
    private Double evalExpression(String expression){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = engine.eval(expression);
        if (result instanceof Integer){
             Integer intResult = (Integer) result;
             return intResult.doubleValue();
        }
        if (result instanceof Double)
            return (Double) result;
        log.info("result:"+result.toString());
        return (double) 0;
    }

    private String createExpression(List<Integer> numbers, String symbols){
        StringBuilder expression = new StringBuilder();
        for (int i=0; i<numbers.size()-1;i++){
            expression.append(numbers.get(i).toString()).append(symbols.charAt(i));


        }
        expression.append(numbers.get(numbers.size()-1).toString());
        return expression.toString();
    }


}
