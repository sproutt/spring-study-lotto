import java.util.*;

public class LottoGame {

    public int inputMoney(int price) {
        return price / Lotto.LOTTO_PRICE;
    }

    public String calculateEarningRatio(Map<Rank, Integer> lottoGameResult, int money) {
        double earning = 0;

        for (Rank rank : lottoGameResult.keySet()){
            int matchCount = lottoGameResult.get(rank);
            int reward = rank.getReward();
            earning += matchCount * reward;
        }

        return String.format("%.1f", (earning / money) * 100);
    }
}