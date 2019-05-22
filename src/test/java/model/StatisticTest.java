package model;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;

import static org.assertj.core.api.Assertions.*;

public class StatisticTest {

    Statistic statistic;

    @Before
    public void setUp(){
        statistic = new Statistic();
    }

    @Test
    public void pushStatisticTest(){
        int before = statistic.getStatistic().get(Rank.FIRST);
        statistic.pushStatistic(Rank.FIRST);
        int after = statistic.getStatistic().get(Rank.FIRST);

        assertThat(after-before).isEqualTo(1);
    }
}