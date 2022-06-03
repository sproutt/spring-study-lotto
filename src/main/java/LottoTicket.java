import java.util.List;

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
}