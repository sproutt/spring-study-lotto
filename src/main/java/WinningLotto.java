import java.util.List;

public class WinningLotto {
    private List<LottoNumber> winningLotto;

    public WinningLotto(List<LottoNumber> winningLotto) {
        validateWinningLottoSize(winningLotto);
        this.winningLotto = winningLotto;
    }

    private void validateWinningLottoSize(List<LottoNumber> winningLotto) {
        if (!(winningLotto.size() == Lotto.LOTTO_SIZE)){
            throw new IllegalArgumentException();
        }
    }
}