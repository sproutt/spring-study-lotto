import java.util.*;

public class LottoGame {
    private int lottoCount;
    private LottoTicket lottoTicket;
    private Map<Rank, Integer> statistics;

    public int inputMoney(int price) {
        return lottoCount = price / Lotto.LOTTO_PRICE;
    }

    public LottoTicket generateLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(AutoLottoGenerator.generate());
        }
        return lottoTicket = new LottoTicket(lottos);
    }

    public Map<Rank, Integer> calculateRankStatistics(WinningLotto winningLotto){
        statistics = new TreeMap<>();
        initRankStatistics();
        statistics = lottoTicket.compareWithWinningLotto(statistics, winningLotto);
        return statistics;
    }

    private void initRankStatistics() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }

    public String calculateEarningRatio() {
        double earning = 0;
        int money = lottoCount * Lotto.LOTTO_PRICE;

        for (Rank rank : statistics.keySet()){
            int matchCount = statistics.get(rank);
            int reward = rank.getReward();
            earning += matchCount * reward;
        }

        return String.format("%.1f", (earning / money) * 100);
    }
}