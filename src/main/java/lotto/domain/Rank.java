package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private static final int PRIZE_MIN_NUMBER = 3;

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

    public static Rank lookUpRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount < PRIZE_MIN_NUMBER) {
            return MISS;
        }

        if (SECOND.isRightCount(matchCount) && hasBonusNumber) {
            return SECOND;
        }

        if (THIRD.isRightCount(matchCount)) {
            return THIRD;
        }

        return (Rank) Arrays.stream(values()).filter(rank -> rank.isRightCount(matchCount)).toArray()[0];
    }

    public boolean isRightCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int plusReward(int income) {
        return income + winningPrice;
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