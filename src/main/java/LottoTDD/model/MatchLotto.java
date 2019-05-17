package LottoTDD.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchLotto {
    public List<Integer> generateWinnerNum(int[] winnerNums) {
        List<Integer> winnerNumsList = new ArrayList<>();
        for (int number: winnerNums) {
            winnerNumsList.add(number);
        }
        return winnerNumsList;
    }
}
