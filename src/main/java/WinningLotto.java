import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private void validateWinningLottoIsUnique(List<LottoNumber> lotto){
        Set<LottoNumber> WinningLottoNumberSet = new HashSet<>(lotto);

        if (WinningLottoNumberSet.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("중복되는 값이 있습니다.");
        }
    }

    public int getWinningLottoSize() {
        return winningLotto.size();
    }
}