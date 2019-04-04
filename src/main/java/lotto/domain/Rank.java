package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningPrice;

    private Rank(int countOfMatch, int winningPrice) {
        this.countOfMatch = countOfMatch;
        this.winningPrice = winningPrice;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static Rank matchRank(int countOfMatch) {
        if (countOfMatch < 3) {
            return MISS;
        }
        return (Rank) Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch).toArray()[0];
    }

    public static Rank selectSecond(boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.countOfMatch);
        stringBuilder.append("개 일치");
        if (this.winningPrice == Rank.SECOND.winningPrice) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(");
        stringBuilder.append(this.winningPrice);
        stringBuilder.append(")-");
        return stringBuilder.toString();
    }
}