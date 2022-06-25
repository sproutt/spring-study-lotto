import java.util.Arrays;

public enum Rank {
    FIRST(6, 0,2000000000),
    SECOND(5, 1,30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0,50000),
    FIFTH(3, 0,5000),
    NO_RANK(0, 0,0);

    private final int matchCount;
    private final int bonusMatchCount;
    private final int reward;


    Rank(int matchCount, int bonusMatchCount, int reward) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }


    public int getBonusMatchCount() {
        return bonusMatchCount;
    }

    public static Rank of(int matchCount, int bonusMatchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusMatchCount == bonusMatchCount)
                .findFirst()
                .orElse(NO_RANK);
    }
}