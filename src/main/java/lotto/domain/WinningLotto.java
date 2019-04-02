package lotto.domain;

public class WinningLotto extends Lotto {
    private Rank rank;

    public WinningLotto(Lotto lotto, Rank rank) {
        super(lotto.getLotto());
        this.rank = rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getReward() {
        return this.rank.getWinningMoney();
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }
}