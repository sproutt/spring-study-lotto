package util;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamGenerator {
    public static IntStream stringToIntStream(String[] strings) {
        return Arrays.stream(strings).mapToInt(num -> Integer.parseInt(num));
    }
}
