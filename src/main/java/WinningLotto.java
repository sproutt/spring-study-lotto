import exception.BonusNumberDuplicatedException;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "이 보너스 번호는 이미 등록된 당첨 번호 입니다.";

    public WinningLotto(List<LottoNumber> winningLotto, BonusNumber bonusNumber) {
        this.lotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
        validateWinningLottoContainsBonusNumber(winningLotto);
    }

    public int getWinningLottoSize() {
        return lotto.getLottoSize();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public void validateWinningLottoContainsBonusNumber(List<LottoNumber> winningLotto) {
        if (winningLotto.contains(bonusNumber.getBonusNumber())) {
            throw new BonusNumberDuplicatedException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
    }
}