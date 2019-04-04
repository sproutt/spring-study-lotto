package lotto.domain;

public class WinningLotto extends Lotto {
    private Lotto lotto;
    private Rank rank;

    public WinningLotto(Lotto lotto, Rank rank) {
        super();
        this.lotto = lotto;
        this.rank = rank;
    }
    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }
}