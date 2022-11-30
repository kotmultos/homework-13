package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @MethodSource("getSum_arguments")
    void getSum(List<Integer> numbers) {
        assertEquals(numbers.stream().mapToInt(Integer::intValue).sum(), NumberUtils.getSum(numbers));
    }

    private static Stream<Arguments> getSum_arguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 20, 40, -113, 123, 34, 45, 0, 0, 123)),
                Arguments.of(Arrays.asList(58, 345, 132423423, 12, 0, -12, -1, 6)),
                Arguments.of(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 12))
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyOddNumber_ordinary_arguments")
    void multiplyOddNumber_ordinary(List<Integer> numbers) {
        assertEquals(numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2).toList(), NumberUtils.multiplyOddNumber(numbers));
    }

    private static Stream<Arguments> multiplyOddNumber_ordinary_arguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(2, 4, 1, 5, 6, 8, 10)),
                Arguments.of(Arrays.asList(4, 6, 10, 4, 4, 31, 6)),
                Arguments.of(Arrays.asList(6, 8, 12, 56, 1342341)),
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9))
        );
    }
}