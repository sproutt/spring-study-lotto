package LottoTDD.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchLotto {
    private List<Integer> winnerNumsList = new ArrayList<>();
    private int[] rankArray = new int[4];
    private int numberOfMatch = 0;
    private int prizeMoney = 0;

    public List<Integer> generateWinnerNum(int[] winnerNums) {
        for (int number : winnerNums) {
            winnerNumsList.add(number);
        }
        return winnerNumsList;
    }

    private int[] calculateResult(List<Lotto> lottoss) {
        for (Lotto lotto : lottoss) {
            calculateStatistic(calculateRank((List) lotto));
        }
        return rankArray;
    }

    private void calculateStatistic(int rank) {
        if (rank == 3) {
            rankArray[0]++;
            prizeMoney += 5000;
        }
        if (rank == 4) {
            rankArray[1]++;
            prizeMoney += 50000;
        }
        if (rank == 5) {
            rankArray[2]++;
            prizeMoney += 1500000;
        }
        if (rank == 6) {
            rankArray[3]++;
            prizeMoney += 2000000000;
        }

    }

    private int calculateRank(List lotto) {
        for (int winnerNum : winnerNumsList) {
            checkMatchNum(winnerNum, lotto);
        }
        return numberOfMatch;
    }

    private void checkMatchNum(int winnerNum, List lotto) {
        if (lotto.contains(winnerNum)) numberOfMatch++;
    }
}
