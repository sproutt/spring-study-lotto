import java.util.Map;

public class LottoGame {

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