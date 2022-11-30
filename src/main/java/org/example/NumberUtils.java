package org.example;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
    public static int getSum(List<Integer> numbers) {
        int sum = 0;
        for(Integer n : numbers) {
            sum += n;
        }

        return sum;
    }

    public static List<Integer> multiplyOddNumber(List<Integer> numbers) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer n : numbers) {
            if(n % 2 == 0) {
                resultList.add(n * 2);
            }
        }

        return resultList;
    }
}
