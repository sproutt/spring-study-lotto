package lotto;

import lotto.utils.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitterTest {
    @Test
    public void 문자나누기() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> list = Arrays.asList(array);
        assertThat(Splitter.splitNumber("1,2,3,4,5,6"), is(list));
    }
}
