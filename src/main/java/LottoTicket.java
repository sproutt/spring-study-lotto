import java.util.List;
import java.util.Map;

public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Map<Rank, Integer> compareWithWinningLotto(Map<Rank, Integer> statistics, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningLotto);
            Rank rank = Rank.of(matchCount);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
        return statistics;
    }
}