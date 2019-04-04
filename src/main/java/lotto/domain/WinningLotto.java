package lotto.domain;

public class WinningLotto extends Lotto {
    private Lotto lotto;
    private int matchCount;
    private boolean hasbonusNumber;

    public WinningLotto(Lotto lotto, int matchCount, LottoNumber bonusNumber) {
        this.hasbonusNumber = lotto.hasThisNumber(bonusNumber);
        this.lotto = lotto;
        this.matchCount = matchCount;
    }

    public Rank findRank(){
        return Rank.lookUpRank(matchCount,hasbonusNumber);
    }
}