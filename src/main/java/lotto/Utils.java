package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++) {
            randomNumbers.add(number);
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, 6);
    }

    public static int purchase(int totalPrice) {
        return totalPrice / 1000;
    }
}
