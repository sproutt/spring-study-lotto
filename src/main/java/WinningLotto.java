import java.util.List;

public class WinningLotto {
    private Lotto lotto;

    public WinningLotto(List<LottoNumber> winningLotto) {
        this.lotto = new Lotto(winningLotto);
    }

    public int getWinningLottoSize() {
        return lotto.getLottoSize();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
}