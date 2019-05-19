package LottoTDD.model;

import java.util.ArrayList;
import java.util.List;

public class MatchLotto {
    private List<Integer> winnerNumsList = new ArrayList<>();
    private int[] rankArray = new int[4];
    private int numberOfWinNum = 0;

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private int prizeMoney = 0;

    public List<Integer> generateWinnerNum(int[] winnerNums) {
        for (int number : winnerNums) {
            winnerNumsList.add(number);
        }
        return winnerNumsList;
    }

    public int[] calculateResult(List<List<Integer>> lottoss) {
        for (List<Integer> lotto : lottoss) {
            calculateStatistic(calculateRank(lotto));
            numberOfWinNum = 0;
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

    private int calculateRank(List<Integer> lotto) {
        for (int winnerNum : winnerNumsList) {
            checkMatchNum(winnerNum, lotto);
        }
        return numberOfWinNum;
    }

    private void checkMatchNum(int winnerNum, List<Integer> lotto) {
        if (lotto.contains(winnerNum)) numberOfWinNum++;
    }
}
