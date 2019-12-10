package com.gaidau.cardGame.service;

import com.gaidau.cardGame.bean.Expression;
import com.gaidau.cardGame.service.StringPermutations;
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

    public List<Expression> getMatches(List<Integer> selectedCards, Integer result){
        List<Expression>  myList= new ArrayList<>();
        List<Integer> reverseSortedList = new ArrayList<>(selectedCards);
        reverseSortedList.sort(Collections.reverseOrder());
        List<Integer> list = selectedCards.stream().sorted().collect(Collectors.toList());
        log.info("myArray: "+Arrays.toString(new List[]{list}));
        while (!reverseSortedList.equals(list)){
            list = findNextPermutation(list);
            log.info("myArray: "+Arrays.toString(new List[]{list}));

        }

//        if (!findNextPermutation(selectedCards))
//            log.info("There is no higher"
//                    + " order permutation "
//                    + "for the given data.");
//        else {
//           log.info("myArray: "+Arrays.toString(new List[]{selectedCards}));
//        }
            log.info("Mihai" + stringPermutations.allSymbolsPermutations(selectedCards.size(),4).toString());
            log.info("evaluare exprssion" + "2+(2*2)-3="+  evalExpression("2+(2*2)-3").toString());
        return  myList;
    }
    @SneakyThrows
    private Integer evalExpression(String expression){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (Integer) engine.eval(expression);
    }


}
