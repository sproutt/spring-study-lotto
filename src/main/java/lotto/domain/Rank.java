package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int winningPrice;

    private Rank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static Rank matchRank(int matchCount) {
        if (matchCount < 3) {
            return MISS;
        }
        return (Rank) Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount).toArray()[0];
    }

    public static Rank selectSecond(boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.matchCount)
                .append("개 일치");
        if (this.winningPrice == Rank.SECOND.winningPrice) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(")
                .append(this.winningPrice)
                .append(")-");
        return stringBuilder.toString();
    }
}