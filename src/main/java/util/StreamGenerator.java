package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamGenerator {
    public static IntStream toIntStream(String[] strings) {
        return Arrays.stream(strings).mapToInt(num -> Integer.parseInt(num));
    }

    public static List<Integer> toIntList(String[] strings){
        return Arrays.stream(strings).map((n)->Integer.parseInt(n))
                .collect(Collectors.toList());
    }
}
