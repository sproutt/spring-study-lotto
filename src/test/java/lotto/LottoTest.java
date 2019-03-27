package lotto;

import lotto.domain.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoTest {
    Lotto lotto;

    @Before
    public void setUp() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> list = Arrays.asList(array);
        lotto = new Lotto(list);
    }

    @Test
    public void 로또출력형식() {
        assertThat(lotto.toString(), is("[1, 2, 3, 4, 5, 6]"));
    }

    @Test
    public void 포함되어있나(){
        assertThat(lotto.isContain(4),is(true));
    }
}
