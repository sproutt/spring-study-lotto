package lotto2.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        if (countOfMatch < 3) {
            return MISS;
        }
        return (Rank) Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch).toArray()[0];
    }

    public static Rank setSecond(boolean matchBonusNumber) {
        if(matchBonusNumber){
            return SECOND;
        }
        return THIRD;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.countOfMatch);
        stringBuilder.append("개 일치");
        if (this.winningMoney == Rank.SECOND.winningMoney) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(");
        stringBuilder.append(this.winningMoney);
        stringBuilder.append(")-");
        return stringBuilder.toString();
    }
}