package util;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator {
    public static List<Integer> getNumbersInRange(int range){
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=range; i++){
            numbers.add(i);
        }
        return numbers;
    }
}
