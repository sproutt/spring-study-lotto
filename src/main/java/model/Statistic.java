package model;

import java.util.HashMap;

public class Statistic {

    private HashMap<Rank, Integer> statistic;

    public Statistic(){
        statistic = new HashMap<>();
        statistic.put(Rank.MISS, 0);
        statistic.put(Rank.FIRST, 0);
        statistic.put(Rank.SECOND, 0);
        statistic.put(Rank.THIRD, 0);
        statistic.put(Rank.FOURTH, 0);
        statistic.put(Rank.FIFTH, 0);
    }

    public void pushStatistic(Rank rank){
        statistic.put(rank, statistic.get(rank)+1);
    }

    public HashMap<Rank, Integer> getStatistic(){
        return statistic;
    }
}
