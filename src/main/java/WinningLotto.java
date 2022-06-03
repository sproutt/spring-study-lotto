import exception.LottoIsNotUniqueException;
import exception.LottoSizeMismatchException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    public static final String WINNING_LOTTO_SIZE = "당첨 로또 크기가 6이 아닙니다.";
    public static final String LOTTO_IS_UNIQUE = "중복된 당첨 번호가 있습니다";
    private List<LottoNumber> winningLotto;

    public WinningLotto(List<LottoNumber> winningLotto) {
        validateWinningLottoSize(winningLotto);
        validateWinningLottoIsUnique(winningLotto);
        this.winningLotto = winningLotto;
    }

    private void validateWinningLottoSize(List<LottoNumber> winningLotto) {
        if (!(winningLotto.size() == Lotto.LOTTO_SIZE)) {
            throw new LottoSizeMismatchException(WINNING_LOTTO_SIZE);
        }
    }

    private void validateWinningLottoIsUnique(List<LottoNumber> lotto){
        Set<LottoNumber> WinningLottoNumberSet = new HashSet<>(lotto);

        if (WinningLottoNumberSet.size() != Lotto.LOTTO_SIZE) {
            throw new LottoIsNotUniqueException(LOTTO_IS_UNIQUE);
        }
    }

    public int getWinningLottoSize() {
        return winningLotto.size();
    }

    public List<LottoNumber> getWinningLotto() {
        return winningLotto;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }
}