import java.util.*;

public class LottoGame {
    private int lottoCount;
    private LottoTicket lottoTicket;
    private Map<Rank, Integer> statistics;

    public LottoGame() {
        statistics = new TreeMap<>();
    }

    public int calculateLottoCount(int money) {
        return lottoCount = money / Lotto.LOTTO_PRICE;
    }

    public LottoTicket generateLottoTicket(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            lottos.add(ManualLottoGenerator.generate(i, manualLottoCount));
        }

        for(int i = manualLottoCount; i < lottoCount; i++) {
            lottos.add(AutoLottoGenerator.generate());
        }
        return makeLottoTicket(lottos);
    }

    private LottoTicket makeLottoTicket(List<Lotto> lottos) {
        return lottoTicket = new LottoTicket(lottos);
    }

    public Map<Rank, Integer> calculateRankStatistics(WinningLotto winningLotto){
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