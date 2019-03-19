package lotto;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTest {
    Lotto lotto;
    List<Integer> list;

    @Before
    public void setUp() {
        lotto = new Lotto();
        lotto.setTickets(14);
        list = new ArrayList<>();
        Integer[] integer = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        list = Arrays.asList(integer);
    }

    @Test
    public void 포함() {
        assertThat(lotto.isExist(5, list), is(true));
    }

    @Test
    public void 카운트() {
        Integer[] integer = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        List<Integer> list2 = new ArrayList<>();
        list2 = Arrays.asList(integer);
        assertThat(lotto.countSelectedTicket(list, list2), is(7));
    }

    @Test
    public void 당첨_계산() {
        Integer[] integer = new Integer[]{3, 3, 3, 3};
        List<Integer> list2 = new ArrayList<>();
        list2 = Arrays.asList(integer);
        assertThat(lotto.seekIncome(list2), is(20000));
    }

    @Test
    public void 수익률() {
        int income = 8000;
        assertThat(lotto.seekEarningsRate(income), is(37.5));
    }

    @Test
    public void 몇장() {
        assertThat(lotto.purchase(14000), is(14));
    }

}
