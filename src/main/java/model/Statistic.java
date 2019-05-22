package model;

import java.util.SortedMap;
import java.util.TreeMap;

public class Statistic {

    private SortedMap<Rank, Integer> statistic;

    public Statistic() {
        statistic = new TreeMap<>();
        statistic.put(Rank.MISS, 0);
        statistic.put(Rank.FIRST, 0);
        statistic.put(Rank.SECOND, 0);
        statistic.put(Rank.THIRD, 0);
        statistic.put(Rank.FOURTH, 0);
        statistic.put(Rank.FIFTH, 0);
    }

    public void pushStatistic(Rank rank) {
        statistic.put(rank, statistic.get(rank) + 1);
    }

    public SortedMap<Rank, Integer> getStatistic() {
        return statistic;
    }
}
