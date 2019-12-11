package com.gaidau.cardGame.service;

// Java program to implement
// the next_permutation method

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class NextPermutation {

    // Function to swap the data
    // present in the left and right indices
    public static List<Integer> swap(List<Integer> data, int left, int right)
    {

        // Swap the data
        int temp = data.get(left);
        data.set(left, data.get(right));
        data.set(right, temp);

        // Return the updated array
        return data;
    }

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    public static List<Integer> reverse(List<Integer> data, int left, int right)
    {

        // Reverse the sub-array
        while (left < right) {
            int temp = data.get(left);
            data.set(left++, data.get(right));
            data.set(right--, temp);
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
    // of the given integer array
    public static List<Integer> findNextPermutation(List<Integer> data)
    {

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.size() <= 1)
            return data;

        int last = data.size() - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data.get(last) < data.get(last + 1)) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return data;

        int nextGreater = data.size() - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.size() - 1; i > last; i--) {
            if (data.get(i) > data.get(last)) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        swap(data, nextGreater, last);

        // Reverse the suffix
        reverse(data, last + 1, data.size() - 1);

        // Return true as the next_permutation is done
        return data;
    }

    public List<List<Integer>> allListPermutations(List<Integer> selectedNumbers){
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> reverseSortedList = new ArrayList<>(selectedNumbers);
        reverseSortedList.sort(Collections.reverseOrder());
        List<Integer> list = selectedNumbers.stream().sorted().collect(Collectors.toList());
        permutations.add(new ArrayList<>(list));
        log.info("myArray: "+ Arrays.toString(new List[]{list}));
        while (!reverseSortedList.equals(list)){
            findNextPermutation(list);
            permutations.add(new ArrayList<>(list));
//            log.info("myArray: "+Arrays.toString(new List[]{list}));
        }


        return permutations;
    }

    // Driver Code
//    public static void main(String args[])
//    {
//        int data[] = { 1, 2, 3 };
//        if (!findNextPermutation(data))
//            System.out.println("There is no higher"
//                    + " order permutation "
//                    + "for the given data.");
//        else {
//            System.out.println(Arrays.toString(data));
//        }
//    }
}

