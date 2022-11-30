package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @NullSource
    void getShortestWord_null(List<String> list) {
        Exception exception = assertThrows(Exception.class, () -> {
            StringUtils.getShortestWord(list);
        });

        String expectedMessage = "must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @EmptySource
    void getShortestWord_emptyList(List<String> list) {
        assertNull(StringUtils.getShortestWord(list));
    }

    @ParameterizedTest
    @MethodSource("getShortestWord_oneWord_arguments")
    void getShortestWord_oneWord(List<String> list) {
        assertEquals(list.get(0), StringUtils.getShortestWord(list));
    }

    private static Stream<Arguments> getShortestWord_oneWord_arguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("hello")),
                Arguments.of(Arrays.asList("test")),
                Arguments.of(Arrays.asList("another"))
        );
    }

    @ParameterizedTest
    @MethodSource("getShortestWord_ordinaryCase_arguments")
    void getShortestWord_ordinaryCase(List<String> list) {
        assertEquals("a", StringUtils.getShortestWord(list));
    }

    private static Stream<Arguments> getShortestWord_ordinaryCase_arguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("hello", "a", "some", "more")),
                Arguments.of(Arrays.asList("a", "test", "is", "introduced")),
                Arguments.of(Arrays.asList("another", "or", "one", "more", "a"))
        );
    }

    @ParameterizedTest
    @MethodSource("getShortestWord_sameLengthWords_arguments")
    void getShortestWord_sameLengthWords(List<String> list) {
        assertEquals("min", StringUtils.getShortestWord(list));
    }

    private static Stream<Arguments> getShortestWord_sameLengthWords_arguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("min", "min", "max", "min")),
                Arguments.of(Arrays.asList("test", "hello", "min", "another", "min")),
                Arguments.of(Arrays.asList("another", "min", "min", "max"))
        );
    }
}
