package util;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator {
    public static List<String> getNumbersInRange(int range) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= range; i++)
            numbers.add(Integer.toString(i));
        return numbers;
    }
}
